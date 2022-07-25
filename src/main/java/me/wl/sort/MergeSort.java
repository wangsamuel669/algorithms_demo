package me.wl.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglei
 **/
public class MergeSort implements Sort {

    public static void main(String[] args) {
        BaseSort.execute(new MergeSort());
    }

    @Override
    public void sort(List<Integer> nums) {
        List<Integer> src = nums;
        int level = 1;
        while (level < src.size()) {
            src = test(src, level);
            level *= 2;
        }
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, src.get(i));
        }
    }

    private List<Integer> test(List<Integer> nums, int level) {
        List<Integer> result = new ArrayList<>(nums.size());
        int leftOffset = 0;
        while (leftOffset < nums.size()) {
            int rightOffset = leftOffset + level;
            if (rightOffset >= nums.size()) {
                for (int i = leftOffset; i < nums.size(); i++) {
                    result.add(nums.get(i));
                }
                break;
            }

            int leftMax = rightOffset - 1;
            int rightMax = Math.min(rightOffset + level - 1, nums.size() - 1);
            while (leftOffset <= leftMax || rightOffset <= rightMax) {
                int left = leftOffset <= leftMax ? nums.get(leftOffset) : Integer.MAX_VALUE;
                int right = rightOffset <= rightMax ? nums.get(rightOffset) : Integer.MAX_VALUE;

                if (left < right) {
                    result.add(left);
                    leftOffset++;
                } else {
                    result.add(right);
                    rightOffset++;
                }
            }
            leftOffset = rightOffset;
        }
        return result;
    }
}
