package com.nixsolutions.study.laba10;
import junit.framework.TestSuite;

public class Main {
    public static void main(String[] args) {
        TestSuite suite = new JunitTesterImpl().suite();
        System.out.println(suite.testCount());
        System.out.println(suite.countTestCases());


        //        JunitTester junitTester = new JunitTesterImpl();
//        TestSuite suite = junitTester.suite();
//        TestResult result = new TestResult();
//        suite.run(result);
    }
}
