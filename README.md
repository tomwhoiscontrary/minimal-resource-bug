Steps to reproduce
------------------

1. Clone this repository: https://github.com/tomwhoiscontrary/minimal-resource-bug

2. In the shell, navigate to the clone

3. Run ./gradlew test

4. Run ./gradlew bug

5. In IDEA, do File > Open, and select the clone

6. In the Import Project from Gradle dialog which appears, ensure that the path to the build.gradle is correct, and that the 'use default gradle wrapper' option is selected

7. Do File > Project Structure and ensure an SDK is selected

8. Note that in the Project view, and in the Project Structure dialog, both src/test/resources and src/bug/resources are marked as test resource folders

9. Open the src/test/java directory, open the context menu for the LoadTestResource class, and select Run (run it as a plain TestNG test if you have a choice)

10. Open the src/bug/java directory, open the context menu for the LoadBugResource class, and select Run (run it as a plain TestNG test if you have a choice)

Behaviour
---------

* Expected: all tests pass in Gradle, all tests pass in IDEA

* Actual: all tests pass in Gradle, the test in src/test passes in IDEA, the test in src/bug fails in IDEA

Analysis
--------

Doing a rebuild or a clean make of the project in IDEA produces the following files in the build directory:

* build/classes/test/LoadBugResource.class
* build/classes/test/LoadTestResource.class
* build/resources/test/test.txt

Some debugging reveals that during execution of the test in src/bug, the classloader has the following build output directories on its classpath:

* build/classes/test
* build/resources/test
* build/resources/main

It appears that IDEA is simply not processing resources in the src/bug/resources directory.
