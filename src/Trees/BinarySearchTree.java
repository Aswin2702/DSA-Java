package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
    }
}
public class BinarySearchTree {
    protected Node root;

    // Recursive Insert Method for rBST
    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if(currentNode.value > value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if(currentNode.value < value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        else rInsert(root, value);
    }

    // Default Insert Method
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if(temp.value == newNode.value) return false;
            if(newNode.value < temp.value){
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
    // Recursive Contains Method for rBST
    public boolean rContains(int value) {
        return rContains(root, value);
    }
    private boolean rContains(Node currentNode, int value) {
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if(currentNode.value > value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }
    // Default Contains Method
    public boolean contains(int value){
        if(root == null) return false;
        Node temp = root;
        while (temp != null){
            if (temp.value > value){
                temp = temp.left;
            } else if (temp.value < value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
    private Node deleteNode(Node currentNode, int value) {
        if(currentNode == null) return null;
        if(currentNode.value > value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (currentNode.value < value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }
    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    public List<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            res.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return res;
    }
    public List<Integer> preOrderDFS() {
        ArrayList<Integer> res = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                res.add(currentNode.value);
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return res;
    }
    public List<Integer> postOrderDFS() {
        ArrayList<Integer> res = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                res.add(currentNode.value);
            }
        }
        new Traverse(root);
        return res;
    }

    public List<Integer> inOrderDFS() {
        ArrayList<Integer> res = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if(currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                res.add(currentNode.value);
                if(currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return res;
    }
}
