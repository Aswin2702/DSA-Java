package Trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

         myBST.insert(47);
         myBST.insert(21);
         myBST.insert(76);
         myBST.insert(18);
         myBST.insert(27);
         myBST.insert(52);
         myBST.insert(82);
//        myBST.rInsert(2);
//        myBST.rInsert(1);
//        myBST.rInsert(3);

        System.out.println(myBST.inOrderDFS());

//        System.out.println("Before Delete");
//        System.out.println(myBST.root.value);
//        System.out.println(myBST.root.left.value);
//        System.out.println(myBST.root.right.value);
//
//        myBST.deleteNode(2);
//
//        System.out.println("After Delete");
//        System.out.println(myBST.root.value);
//        System.out.println(myBST.root.left.value);
//        System.out.println(myBST.root.right);

        /* System.out.println("BST Contains 3:");
        System.out.println(myBST.rContains(3));

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.rContains(17)); */

    }
}
