package com.example.unittestsample;

import android.widget.Button;
import android.widget.EditText;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;
    EditText et;


    @Before
    public void set() throws Exception {
        // call this method before start actual test
        // get context of MainActivity
        mActivity = mainActivityActivityTestRule.getActivity();
        this.et = mActivity.findViewById(R.id.et);
    }

    @Test
    public void test_EditText_checkInput() {
        // check if view's string is equal to defined string
        // then return True : Test Passed
        assertEquals("test", et.getText().toString());
    }

    @Test
    public void test_EditText_checkEmpty() {
        // check if view's string is not null
        // then return True : Test Passed
        assertNotEquals(null, et.getText().toString());
    }

    @After
    public void tear() throws Exception {
        // call this method after end all test cases
        mActivity = null;
    }
}