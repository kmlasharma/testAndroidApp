package com.example.ksha0005.sample;

import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    // Activity of the Target application
    private MainActivity mainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Getting a reference to the MainActivity of the target application
        mainActivity = getActivity();
    }


    @SmallTest
    public void testEditText() {
        final EditText et = (EditText) mainActivity.findViewById(R.id.usernameET);
        assertNotNull(et);
    }

    @SmallTest
    public void testButton() {
        final Button bt = (Button) mainActivity.findViewById(R.id.loginBtn);
        assertNotNull(bt);
    }

}
