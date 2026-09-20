package top.vission.problems.enums;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public enum LeetCodeProblemEnum {
    P1("1", "两数之和", "Two Sum"),
    P20("20", "有效的括号", "Valid Parentheses"),
    P21("21", "合并两个有序链表", "Merge Two Sorted Lists"),
    P26("26", "删除有序数组中的重复项", "Remove Duplicates From Sorted Array"),
    P48("48", "旋转图像", "Rotate Image"),
    P49("49", "字母异位词分组", "Group Anagrams"),
    P54("54", "螺旋矩阵", "Spiral Matrix"),
    P73("73", "矩阵置零", "Set Matrix Zeroes"),
    P88("88", "合并两个有序数组", "Merge Sorted Array"),
    P125("125", "验证回文串", "Valid Palindrome"),
    P141("141", "环形链表", "Linked List Cycle"),
    P150("150", "逆波兰表达式求值", "Evaluate Reverse Polish Notation"),
    P155("155", "最小栈", "Min Stack"),
    P206("206", "反转链表", "Reverse Linked List"),
    P232("232", "用栈实现队列", "Implement Queue Using Stacks"),
    P242("242", "有效的字母异位词", "Valid Anagram"),
    P344("344", "反转字符串", "Reverse String"),
    P622("622", "设计循环队列", "Design Circular Queue");

    private final String id;
    private final String name;
    private final String englishName;

    LeetCodeProblemEnum(String id, String name, String englishName) {
        this.id = id;
        this.name = name;
        this.englishName = englishName;
    }

    public static LeetCodeProblemEnum getById(String id) {
        for (LeetCodeProblemEnum problem : values()) {
            if (problem.id.equals(id)) {
                return problem;
            }
        }
        throw new IllegalArgumentException("未找到题目：" + id);
    }
}
