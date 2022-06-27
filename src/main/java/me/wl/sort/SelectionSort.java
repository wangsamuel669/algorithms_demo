package me.wl.sort;

import java.util.List;

/**
 * @author wanglei
 **/
public class SelectionSort implements Sort {

    public static void main(String[] args) {
        BaseSort.execute(new SelectionSort());
    }

    public void sort(List<Integer> nums) {
        int headIndex = 0;
        while (headIndex != nums.size() - 1) {
            int minIndex = -1;
            Integer min = null;
            for (int i = headIndex; i < nums.size(); i++) {
                Integer num = nums.get(i);
                if (min == null || min > num) {
                    min = num;
                    minIndex = i;
                }
            }
            Integer headVal = nums.get(headIndex);
            nums.set(headIndex, min);
            nums.set(minIndex, headVal);
            headIndex++;
        }
    }
}
