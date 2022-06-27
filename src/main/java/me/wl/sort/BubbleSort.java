package me.wl.sort;

import java.util.List;

/**
 * @author wanglei
 **/
public class BubbleSort implements Sort {

    public static void main(String[] args) {
        BaseSort.execute(new BubbleSort());
    }

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
    }
}
