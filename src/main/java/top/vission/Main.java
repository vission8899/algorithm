package top.vission;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;
import top.vission.problems.enums.LeetCodeProblemEnum;
import top.vission.utils.LeetCodeProblemUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {

        List<String> problemIds = new ArrayList<>();
//        for (LeetCodeProblemEnum value : LeetCodeProblemEnum.values()) {
//            problemIds.add(value.getId());
//        }
        problemIds.add("217");
        problemRunTemplate(problemIds);
    }

    private static void problemRunTemplate(List<String> problemIds) {
        LeetCodeProblemUtils problemUtils = new LeetCodeProblemUtils();

        for (String problemId : problemIds) {
            LeetCodeProblemRun problem = problemUtils.getProblemById(problemId);
            if (problem == null) {
                log.error("缺失题号:LeetCode{}", problemId);
                continue;
            }
            LeetCodeProblemEnum problemEnum = LeetCodeProblemEnum.getById(problemId);
            log.info("==============================================================================================================");
            log.info("-----当前执行题号：LeetCode{},题名:{},English Name:{}-----", problemEnum.getId(), problemEnum.getName(), problemEnum.getEnglishName());
            problem.run();
        }
        log.info("==============================================================================================================");
    }


}
