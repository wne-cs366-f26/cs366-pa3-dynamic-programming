# CS366 — PA03: Dynamic Programming

Starter project for Programming Assignment 03. Implement bottom-up dynamic-programming algorithms for minimum coin change and simplified 0/1 knapsack, including traceback of an actual solution.

The complete assignment handout and due date are posted on Kodiak. Kodiak is authoritative if this README and the handout ever differ.

## Work in a Codespace

Open this repository on GitHub, choose **Code**, select **Codespaces**, and create a Codespace. The included dev-container configuration supplies Java 21. A GitHub account and Codespaces are optional.

## Work locally

Clone the repository, or use GitHub's **Download ZIP** option and extract it. Install a Java 21 JDK, then run:

```bash
./gradlew test
./gradlew run
```

On Windows, use `gradlew.bat test` and `gradlew.bat run`.

## Files to complete

- `src/main/java/edu/wne/cs366/DynamicProgramming.java` — implement both required algorithms.
- `src/test/java/edu/wne/cs366/StudentDynamicProgrammingTest.java` — add at least eight focused tests.
- `REPORT.md` — record your tests and answer the analysis prompts, then export it as `REPORT.pdf`.

Do not change the package, class name, public method signatures, result-record definitions, Gradle configuration, or supplied tests. The supplied tests cover representative behavior but are not a complete specification.

Both algorithms must use the required two-dimensional bottom-up tables and a separate traceback. A greedy algorithm, exhaustive subset search, recursion, or a one-dimensional optimized table does not meet the assignment requirements.

## Download your work from Codespaces

You do not need to commit or push your work. Export `REPORT.md` to `REPORT.pdf`, then run this command at the project root:

```bash
zip -r submission.zip . -x 'submission.zip' '.git/*' '.gradle/*' 'build/*' '.idea/*' '.vscode/*'
```

Locate `submission.zip` in the Explorer, right-click it, and select **Download...**. Open the ZIP and confirm that it contains your completed source, tests, `REPORT.md`, `REPORT.pdf`, and Gradle wrapper files, then submit it through Kodiak.
