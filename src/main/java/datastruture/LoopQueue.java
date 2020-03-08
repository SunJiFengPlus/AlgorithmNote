package datastruture;

/**
 *  数组优点: 支持快速查询, 链表优点: 动态 
 *  
 *  对外 capacity = data.length - 1; 
 */
public class LoopQueue<E> {
    private E[] data;
    private int front;
    private int tail;
    /**
     * 队列中元素个数
     */
    private int size;

    /**
     * capacity 主动浪费掉一个空间方便判断队列为空还是满
     * front == tail 时队列为空, (tail + 1) % data.length == front 时队列为满
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    
    public LoopQueue() {
        this(10);
    }
    
    public int getCapacity() {
        return data.length - 1;
    }
    
    public boolean isEmpty() {
        return front == tail;
    }
    
    public int getSize() {
        return size;
    }
    
    /**
     * 入队 O(1) 扩容缩容均摊
     */
    public void enqueue(E e) {
        // (tail + 1) % data.length == front 时队列为满
        if((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队 O(1) 扩容缩容均摊
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        // 出队
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        
        // 判断缩小容量
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        
        return res;
    }
    
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }
    
    private void resize(int newCapacity) {
        //noinspection unchecked
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 数组拷贝, 将 front 复位回 0
        System.arraycopy(data, front, newData, 0, size);
        data = newData;
        front = 0;
        // 扩容没有影响元素个数, 没有元素入队出队
        tail = size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue size:" + size + " capacity:" + getCapacity() + " front [");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length] + ", ");
        }
        return sb.toString().substring(0, sb.length() - 2) + "] tail";
    }
    
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
