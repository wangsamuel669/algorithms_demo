package me.wl.sort;

import com.google.common.base.Joiner;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wanglei
 **/
public class BaseSort {

    public static void execute(Sort sort) {
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
        sort.sort(nums);
        System.out.println(Joiner.on(",").join(nums));
    }
}
