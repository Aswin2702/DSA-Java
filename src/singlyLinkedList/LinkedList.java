package singlyLinkedList;

class Node {
    int value;
    Node next;

    Node(int value){
        this.value = value;
    }
}
public class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;


    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    public void getHead(){
        System.out.println("Head: " + this.head.value);
    }
    public void getTail(){
        System.out.println("Tail: " + this.tail.value);
    }
    public void getLength(){
        System.out.println("Length: " + this.length);
    }
    public void printList(){
        Node ptr = this.head;
        for (int i = 0; i < this.length; i++) {
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
    }
    public void append(int value){
        Node newNode = new Node(value);
        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        } else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }
    public Node removeLast(){
        if(this.length == 0) return null;

        Node temp = this.head;
        Node pre = this.head;
        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        this.tail = pre;
        this.tail.next = null;

        length--;

        if(this.length == 0){
            this.head = null;
            this.tail = null;
        }

        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else{
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeFirst(){
        if(this.length == 0) return null;

        Node temp = this.head;
        this.head = temp.next;
        temp.next = null;

        length--;
        if (length == 0) this.tail = null;

        return temp;
    }

    public Node get(int index){
        if (index < 0 || index >= this.length) return null;

        Node temp = this.head;
        for (int i = 0; i < index ; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > this.length) return false;
        if(index == 0){
            prepend(value);
            return true;
        }
        if (index == this.length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= this.length) return null;
        if(index == 0) return removeFirst();
        if (index == this.length - 1) return removeLast();

        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void reverse(){
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
