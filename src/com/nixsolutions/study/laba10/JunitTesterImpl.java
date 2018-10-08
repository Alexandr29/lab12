package com.nixsolutions.study.laba10;

import interfaces.junit.JunitTester;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;

public class JunitTesterImpl implements JunitTester {
    public TestSuite suite() {
        TestSuite testSuite = new TestSuite();
        testSuite.addTest(new JUnit4TestAdapter(ArrayCollectionImpl.class));
        testSuite.addTestSuite(ArrayCollectionIteratorTest.class);
        return testSuite;
    }

}
