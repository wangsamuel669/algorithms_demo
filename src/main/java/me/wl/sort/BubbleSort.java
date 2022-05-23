package me.wl.sort;

import com.google.common.base.Joiner;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wanglei
 **/
public class BubbleSort {

    public void sort(List<Integer> nums) {
        for (; ; ) {
            boolean asc = true;
            for (int i = nums.size() - 1; i > 0; i--) {
                int cur = nums.get(i);
                int prev = nums.get(i - 1);
                if (cur < prev) {
                    asc = false;
                    nums.set(i - 1, cur);
                    nums.set(i, prev);
                }
            }
            if (asc) {
                break;
            }
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        SecureRandom secureRandom = new SecureRandom();
        List<Integer> nums = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        for (int i = 0; i < 10000; i++) {
            int fromIndex = secureRandom.nextInt(100);
            int toIndex = secureRandom.nextInt(100);
            Integer from = nums.get(fromIndex);
            Integer to = nums.get(toIndex);
            nums.set(toIndex, from);
            nums.set(fromIndex, to);
        }
        System.out.println(Joiner.on(",").join(nums));
        bubbleSort.sort(nums);
        System.out.println(Joiner.on(",").join(nums));
    }
}
