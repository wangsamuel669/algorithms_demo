package me.wl.sort;

import java.util.List;

/**
 * @author wanglei
 **/
public class HeapSort implements Sort {

    public static void main(String[] args) {
        BaseSort.execute(new HeapSort());
    }

    @Override
    public void sort(List<Integer> nums) {
        int[] heap = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            heap[i] = nums.get(i);
            add(heap, i);
        }

        for (int i = nums.size() - 1; i >= 0; i--) {
            nums.set(i, remove(heap, i));
        }
    }

    private void add(int[] heap, int lastIndex) {
        int val = heap[lastIndex];
        for (; ; ) {
            int reduction = lastIndex % 2 == 0 ? 2 : 1;
            int parentIndex = (lastIndex - reduction) / 2;
            if (parentIndex >= 0 && heap[parentIndex] < val) {
                heap[lastIndex] = heap[parentIndex];
                heap[parentIndex] = val;
                lastIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private int remove(int[] heap, int lastIndex) {
        int min = heap[0];
        heap[0] = heap[lastIndex];
        int parentIndex = 0;
        for (; ; ) {
            int childIndex = 0;
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;
            if (leftChildIndex >= lastIndex) {
                break;
            } else if (rightChildIndex >= lastIndex) {
                childIndex = leftChildIndex;
            }else {
                childIndex = heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex;
            }

            int parent = heap[parentIndex];
            if (heap[childIndex] > parent) {
                heap[parentIndex] = heap[childIndex];
                heap[childIndex] = parent;
                parentIndex = childIndex;
            } else {
                break;
            }
        }
        return min;
    }
}
