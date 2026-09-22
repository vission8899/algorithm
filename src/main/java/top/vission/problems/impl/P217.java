package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.util.HashMap;
import java.util.HashSet;


@Slf4j
public class P217 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[] nums = new int[]{1, 2, 3, 1};
        log.info("request:{}", nums);
        log.info("result:{}", containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map.values().stream().anyMatch(t -> t > 1);
    }

    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashSet.contains(num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int size = hashSet.size();

            int num = nums[i];
            hashSet.add(num);
            if (size + 1 != hashSet.size()) {
                return true;
            }
        }
        return false;
    }

}
