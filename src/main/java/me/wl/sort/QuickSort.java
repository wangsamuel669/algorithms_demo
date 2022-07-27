package me.wl.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglei
 **/
public class QuickSort implements Sort {

    public static void main(String[] args) {
        BaseSort.execute(new QuickSort());
    }

    @Override
    public void sort(List<Integer> nums) {
        List<Integer> part = part(nums);
        for (int i = 0; i < part.size(); i++) {
            nums.set(i, part.get(i));
        }
    }

    private List<Integer> part(List<Integer> nums) {
        if (nums.size() <= 1) {
            return nums;
        }
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();

        double random = Math.random();
        int index = (int) Math.round(random * (nums.size() - 1));
        Integer baseVal = nums.get(index);
        for (Integer val : nums) {
            if (val < baseVal) {
                leftNums.add(val);
            } else if (val > baseVal) {
                rightNums.add(val);
            }
        }
        List<Integer> part = part(leftNums);
        part.add(baseVal);
        part.addAll(part(rightNums));
        return part;
    }
}
