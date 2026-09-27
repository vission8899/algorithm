package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.*;


@Slf4j
public class P349 implements LeetCodeProblemRun {

    @Override
    public void run() {
//        nums1 = [1,2,2,1], nums2 = [2,2]
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        log.info("request:{},{}", nums1, nums2);
        log.info("result:{}", intersection(nums1, nums2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();

        HashSet<Integer> result = new HashSet<>();

        for (int i : nums1) {
            hashSet.add(i);
        }

        for (int i : nums2) {
            if (hashSet.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
