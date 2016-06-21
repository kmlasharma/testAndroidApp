package com.example.ksha0005.sample;

import android.widget.*;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.EditText;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest(Class <MainActivity> activityClass) {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    @SmallTest
    public void testEditText() {
        EditText et = (EditText)getActivity().findViewById(R.id.usernameET);
        assertNotNull(et);
    }

    @SmallTest
    public void testbutton() {
        Button bt = (Button)getActivity().findViewById(R.id.loginBtn);
        assertNotNull(bt);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}