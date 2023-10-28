package nc.linked.list;

import java.util.HashMap;
import java.util.Map;

class Solution138 {

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            nodeMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        Node result = new Node(0);
        curr = result;

        for (int n = 0; n < nodeMap.size(); n++) {
            curr.next = nodeMap.get(head);
            curr = curr.next;
            curr.random = nodeMap.get(head.random);
            head = head.next;
        }

        return result.next;
    }
}
