class NodeList {
    int data;
    NodeList next;

    NodeList(int data) {
        this.data = data;
    }
}

public class insertatbeg {
    static NodeList delete(NodeList head, int key) {
        if (head == null)
            return null;
        if (head.data == key)
            return head.next;
        NodeList temp = head;
        while (temp.next != null && temp.next.data != key)
            temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
        return head;
    }

    static void display(NodeList head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeList head = new NodeList(10);
        head.next = new NodeList(20);
        head.next.next = new NodeList(30);
        System.out.print("Before delete: ");
        display(head);
        head = delete(head, 20);
        System.out.print("After delete 20: ");
        display(head);
    }
}