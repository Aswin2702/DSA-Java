package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;
    public Heap() {
        this.heap = new ArrayList<>();
    }
    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    private int parent(int index) {
        return (index - 1) / 2;
    }
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    public boolean insert(int value) {
        heap.add(value);
        int curr = heap.size() - 1;
        int parent = parent(curr);
        while (curr > 0 && heap.get(curr) > heap.get(parent)) {
            swap(curr, parent);
            curr = parent;
            parent = parent(curr);
        }
        return true;
    }
    private void sinkDown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if(leftIndex < heap.size() && heap.get(maxIndex) < heap.get(leftIndex)) {
                maxIndex = leftIndex;
            }
            if(rightIndex < heap.size() && heap.get(maxIndex) < heap.get(rightIndex)) {
                maxIndex = rightIndex;
            }
            if(index != maxIndex) {
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }
        }
    }
    public Integer remove() {
        if (heap.isEmpty()) return null;
        if(heap.size() == 1) return heap.remove(0);

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }
}
