package doublyLinkedList;

class Node {
    int value;
    Node next;
    Node prev;
    Node(int value){
        this.value = value;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length = 0;

    public DoublyLinkedList(int value){
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
        while (ptr != null){
            System.out.print(ptr.value + " ");
            ptr = ptr.next;
        }
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(this.length == 0) return null;

        Node temp = this.tail;
        if(this.length == 1){
            this.head = null;
            this.tail = null;
        } else {
            this.tail = temp.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;

        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if (this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0) return null;

        Node temp = this.head;
        if(length == 1){
            this.head = null;
            this.tail = null;
        } else {
            this.head = temp.next;
            this.head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= this.length) return null;

        Node temp = null;
        if(index < this.length/2){
             temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else{
            temp = this.tail;
            for (int i = this.length-1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = this.get(index);
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
        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;

        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= this.length) return null;
        if(index == 0){
            return removeFirst();
        }
        if (index == this.length - 1){
            return removeLast();
        }

        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;

        before.next = after;
        after.prev = before;
        temp.prev = null;
        temp.next = null;
        length--;

        return temp;
    }
}
