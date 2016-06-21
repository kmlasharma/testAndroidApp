package com.example.ksha0005.sample;

import android.test.suitebuilder.annotation.SmallTest;
import junit.framework.TestCase;

/**
 * Created by ksha0005 on 21/06/2016.
 */
public class MainActivityUnitTests extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void checker() {
        MainActivity ma = new MainActivity();
        ma.setupVariables();
        System.out.println(ma.username);
        assertNotNull(ma.username);
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
