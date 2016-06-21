package com.example.ksha0005.sample;

import org.junit.Test;
import android.test.ActivityInstrumentationTestCase2;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import android.widget.Button;
import android.widget.EditText;
/**
 * Main activity unit tests.
 */
public class MainActivityUnitTests {

    MainActivity mainActivity = new MainActivity();

    @Test
    public void testAttempts() {
        assertEquals(3, mainActivity.updateAttempt(4));
        assertFalse(mainActivity.checkAttempt(1));
    }

    @Test
    public void testLogin() {
        assertTrue(mainActivity.checkLogin("admin", "Admin"));
        assertFalse(mainActivity.checkLogin("admin", "admin"));
    }



}
