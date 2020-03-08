package datastruture;

/**
 * 优先队列
 * @author 孙继峰
 * @date 2019/04/08
 */
public class PriorityQueue <E extends Comparable<E>> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    public int getSize(){
        return maxHeap.size();
    }

    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    public E getFront(){
        return maxHeap.findMax();
    }

    public void enqueue(E e){
        maxHeap.add(e);
    }

    public E dequeue(){
        return maxHeap.extractMax();
    }
}
