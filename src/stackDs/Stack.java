package stackDs;

class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
}

public class Stack {
    private Node top;
    private int height;
    public Stack(int value){
        Node newNode = new Node(value);
        this.top = newNode;
        this.height = 1;
    }

    public void getTop(){
        System.out.println("Top: " + this.top.value);
    }
    public void getHeight(){
        System.out.println("Height: " + this.height);
    }
    public void printStack(){
        Node temp = this.top;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public boolean push(int value){
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        height++;
        return true;
    }
    public Node pop(){
        if(top == null) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
