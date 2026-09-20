package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

import java.lang.reflect.Array;
import java.util.*;


@Slf4j
public class P49 implements LeetCodeProblemRun {

    @Override
    public void run() {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = new String[]{"", ""};
//        String[] strs = new String[]{"ad", "bc", "cb"};

        log.info("request:{}", strs);

        log.info("result:{}", groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String anagramKey = getAnagramKey(str);
            if (!map.containsKey(anagramKey)) {
                map.put(anagramKey,new ArrayList<>());
            }
            map.get(anagramKey).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String getAnagramKey(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String anagramKey = getAnagramKey2(str, map.keySet());
            if (anagramKey != null) {
                map.get(anagramKey).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                map.put(str, group);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String getAnagramKey2(String str, Set<String> keySets) {
        String anagrameKey = null;
        for (String key : keySets) {
            if (isAnagrams2(str, key)) {
                anagrameKey = key;
                break;
            }
        }
        return anagrameKey;
    }

    private boolean isAnagrams2(String str, String key) {
        char[] charArray = str.toCharArray();
        char[] keyArray = key.toCharArray();
        if (charArray.length != keyArray.length) {
            return false;
        }

        int[] ints = new int[26];

        for (int i = 0; i < charArray.length; i++) {
            ints[charArray[i] - 'a']++;
            ints[keyArray[i] - 'a']--;
        }

        for (int anInt : ints) {
            if (anInt != 0) {
                return false;
            }
        }
        return true;
    }
}
