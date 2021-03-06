public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.

    private boolean isEmpty() {
        return this.head == null;
    }

    public findAt(int x){
        for(int i=0; i <x; i++){
            this.head = head.next
        }
        return head.value;
    }

    public int remove() {
        this.head = null;
    }

    public void printValues(){
        while(this.head != null){
            System.out.println(head.value);
            head = head.next;
        }
        
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }    
}
