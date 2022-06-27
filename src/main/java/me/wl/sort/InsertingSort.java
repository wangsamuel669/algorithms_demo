package me.wl.sort;

import java.util.List;

/**
 * @author wanglei
 **/
public class InsertingSort implements Sort {

    public static void main(String[] args) {
        BaseSort.execute(new InsertingSort());
    }

    @Override
    public void sort(List<Integer> nums) {
        int pointIndex = 0;
        while (pointIndex != nums.size()) {
            Integer pointNum = nums.get(pointIndex);

            int leftFromIndex = pointIndex;
            for (int i = leftFromIndex - 1; i >= 0; i--) {
                Integer leftNum = nums.get(i);
                if (pointNum < leftNum) {
                    nums.set(i, pointNum);
                    nums.set(leftFromIndex, leftNum);
                    leftFromIndex = i;
                }
            }
            pointIndex++;
        }
    }
}
