package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.*;
import java.util.stream.Collectors;


@Slf4j
public class P347 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        log.info("request:{},{}", nums, k);
        log.info("result:{}", topKFrequent(nums, k));
    }


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int[] topK = new int[k];
        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
        Collections.reverse(collect);
        collect = collect.subList(0, k);

        int p1 = 0;
        for (Integer i : map.keySet()) {
            if (collect.contains(map.get(i))) {
                topK[p1++] = i;
            }
        }


        return topK;
    }
}
