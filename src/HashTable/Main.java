package HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.set("nails", 100);
        hashTable.set("tile", 50);
        hashTable.set("lumber", 200);

        hashTable.set("bolts", 500);
        hashTable.set("screws", 140);

        System.out.println(hashTable.keys());
    }
}
