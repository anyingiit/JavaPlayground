[English](README.md) · **简体中文**

> 英文版是规范版本。本页与 [README.md](README.md) 不一致时，以英文版为准。

<!-- translation-of: README.md sha256:cfed99d6cc0291c5 -->

<!-- Source: Best-README-Template BLANK_README (Unlicense) — https://github.com/othneildrew/Best-README-Template -->
<a id="readme-top"></a>

# JavaPlayground

一个 Java 学习练习场，收录了手写的数据结构与算法练习——一个可扩容的泛型数组、一个二叉最大堆、堆排序与归并排序，均配有 JUnit 5 测试——外加一个探索 Java 核心语言特性的独立小片段文件夹。

[![CI](https://github.com/anyingiit/JavaPlayground/actions/workflows/ci.yml/badge.svg)](https://github.com/anyingiit/JavaPlayground/actions/workflows/ci.yml)
[![License](https://img.shields.io/github/license/anyingiit/JavaPlayground)](LICENSE)

[报告问题](https://github.com/anyingiit/JavaPlayground/issues/new?template=bug_report.yml) · [提出需求](https://github.com/anyingiit/JavaPlayground/issues/new?template=feature_request.yml)

<details>
  <summary>目录</summary>
  <ol>
    <li><a href="#about-the-project">关于本项目</a></li>
    <li><a href="#getting-started">开始使用</a></li>
    <li><a href="#usage">用法</a></li>
    <li><a href="#contributing">参与贡献</a></li>
    <li><a href="#license">许可证</a></li>
    <li><a href="#contact">联系方式</a></li>
  </ol>
</details>

## 关于本项目

`src/Array/Array.java` 是一个从零手写的泛型数组（`Array<E>`），提供常见的增删查改操作；`src/MaxHeap/MaxHeap.java` 在它之上构建了一个二叉最大堆。`src/HeapSort/`（升序与降序）与 `src/MergeSort/SortByDESC.java` 是两个互不共享代码的独立排序实现，`src/OrderArray/OrderArray.java` 用于检查一个数组是否已经是升序或降序。除了 `MaxHeap` 之外，上述每一个都在旁边配有一个 JUnit 5 测试类，排序测试还会用 `src/Random/Random.java` 生成的一百万个随机整数进行验证。

`src/Play_22_6_12/` 是另一个互不相关的文件夹：十六个小文件（`P1.java` 到 `P16.java`），每个都是一小段独立的练习，探索某个 Java 语言特性——接口、抽象类、方法重载、`try`/`finally` 的返回语义、自动装箱、匿名类。它们是练习笔记，并非上述数据结构的一部分。

计划中的功能与已知问题，见 [open issues](https://github.com/anyingiit/JavaPlayground/issues)。

## 开始使用

### 环境要求

- 一个 JDK（任意较新版本均可；源码未使用特定版本才有的语言特性）
- 无需额外拉取依赖：测试所需的全部 JUnit 5 jar 包已经收录在 `libs/JUnit5/` 下，因为本项目没有构建工具（没有 `pom.xml`，也没有 `build.gradle`）

### 安装

```sh
git clone https://github.com/anyingiit/JavaPlayground.git
cd JavaPlayground
javac -d out -cp "libs/JUnit5/*" $(find src -name '*.java')
```

## 用法

这里没有可运行的应用程序——源码是一组类及其 JUnit 5 测试。编译全部代码（包括 `ci/` 下随本次 README 一同添加的小型测试运行器，因为收录的 jar 包中不含独立的控制台启动器），然后运行测试套件：

```sh
javac -d out -cp "libs/JUnit5/*" $(find src ci -name '*.java')
java -cp "out:libs/JUnit5/*" RunTests
```

这会发现并运行 `src/` 下的每一个 `@Test` 方法——目前是 `OrderArray`、`HeapSort` 与 `MergeSort` 这几组测试——只要有测试失败或者一个测试都没发现，就会以非零状态退出。

## 参与贡献

欢迎参与。[CONTRIBUTING.md](CONTRIBUTING.md) 说明如何提交 issue 或 pull request，[CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) 说明对所有参与者的行为要求。

请不要在公开的 issue 或 pull request 中报告安全问题。[SECURITY.md](SECURITY.md) 说明了私下报告的方式。

## 许可证

以 MIT 许可证分发。详见 [LICENSE](LICENSE)。

## 联系方式

项目地址：[https://github.com/anyingiit/JavaPlayground](https://github.com/anyingiit/JavaPlayground)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
