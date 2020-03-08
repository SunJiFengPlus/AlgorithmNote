package examination.tiger.autumn;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并 n 个有序链表
 *
 * @author 孙继峰
 * @date 2019/08/23
 */
public class Main {

    public Node merge(Node[] heads) {
        int length = heads.length;
        Node[] currentNode = heads;
        Node dHead = new Node(Integer.MIN_VALUE, null);
        Node dFixedHead = dHead;
        Node min = new Node(Integer.MAX_VALUE, null);

        int numOfNullNode = 0;
        while (numOfNullNode != length) {
            numOfNullNode = 0;
            for (int i = 0; i < length; i++) {
                if (currentNode[i] != null) {
                    if (currentNode[i].value < min.value) {
                        min = currentNode[i];
                        currentNode[i] = currentNode[i].next;
                    }
                } else {
                    numOfNullNode++;
                }
            }
            dHead.next = min;
            dHead = dHead.next;
        }
        return dFixedHead.next;
    }

    class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

/**
 * 全排列
 */
class Main2 {
    public List<String> permutations(String s) {
        List<String> result = new ArrayList<>();
        


        return result;
    }
}