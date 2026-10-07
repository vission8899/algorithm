# algorithm

LeetCode 题解仓库。基于一个反射驱动的题目执行框架，`main` 方法按题号批量运行题解并输出题目信息。

## 项目结构

```
src/main/java/top/vission/
├── Main.java                       # 入口：指定题号，批量执行
├── problems/
│   ├── LeetCodeProblemRun.java     # 题目接口，只有一个 run() 方法
│   ├── enums/
│   │   └── LeetCodeProblemEnum.java    # 题目元数据（题号/名称/描述）
│   └── impl/
│       └── P1.java                 # 题解实现，类名必须为 P + 题号
└── utils/
    └── LeetCodeProblemUtils.java   # 扫描 impl 包，构建 题号 → 题解 的映射
src/main/resources/
└── logback.xml                     # 日志输出格式
```

`src/main/archive` 下是历史归档代码，不参与编译。

## 运行方式

执行 `top.vission.Main` 的 main 方法即可。要跑哪些题，改 `Main.java` 里的题号列表：

```java
List<String> problemIds = new ArrayList<>();
problemIds.add("1");      // 按需增删
problemRunTemplate(problemIds);
```

单个题目的执行流程：

1. `LeetCodeProblemUtils` 扫描 `top.vission.problems.impl` 包，把每个题解类实例化，按「类名去掉 P 前缀」登记为题号
2. 对每个要执行的题号，从枚举 `LeetCodeProblemEnum.getById()` 取题目元数据（名称、描述），打印题头
3. 反射调用对应题解类的 `run()` 方法

## 添加新题解

以 LeetCode 217「存在重复元素」为例，需要改 **3 个地方**：

**1. 枚举里登记题目信息**（`LeetCodeProblemEnum.java`）

```java
P217("217", "存在重复元素", "Contains Duplicate", "题目描述..."),
```

字段依次是：题号（字符串）、中文题名、英文题名、题目描述。

**2. 新建题解类**（`top/vission/problems/impl/`）

类名必须是 `P + 题号`，实现 `LeetCodeProblemRun`：

```java
package top.vission.problems.impl;

import lombok.extern.slf4j.Slf4j;
import top.vission.problems.LeetCodeProblemRun;

@Slf4j
public class P217 implements LeetCodeProblemRun {

    @Override
    public void run() {
        int[] nums = {1, 2, 3, 1};
        log.info("结果:{}", containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        // 解法
        return false;
    }
}
```

**3. 在 Main 里加题号**

```java
problemIds.add("217");
```

然后运行 main 方法。

## 约定

- **类名 = `P` + 题号**：框架靠这个约定做反射关联（`P1` ↔ 题号 `"1"`），类名和枚举常量名、题号三者必须一致，否则运行时找不到题
- **一个类可以有多个解法**：如 `P1` 里同时保留了暴力 O(n²) 和哈希表 O(n) 两个版本，`run()` 里决定调用哪个（或都跑）
- **日志用 `@Slf4j` + `log.info("...{}...", arg)`**，不要用 `System.out.println`
- 枚举常量名（如 `P217`）只是 Java 标识符，真正参与查找的是构造参数里的题号 `"217"`

## 环境

- JDK 8+
- Maven（依赖：Lombok、Hutool、Logback）
