package com.example.unittestsample;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.os.Trace.isEnabled;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;
    EditText et;
    TextView tv;
    String etText = "Hello";

    @Before
    public void set() throws Exception {
        // call this method before start actual test
        // get context of MainActivity
        mActivity = mainActivityActivityTestRule.getActivity();
        this.et = mActivity.findViewById(R.id.et);
        this.tv=mActivity.findViewById(R.id.tv);
    }

//    @Test
//    public void test_EditText_checkInput() {
//        // check if view's string is equal to defined string
//        // then return True : Test Passed
//        assertEquals("test", et.getText().toString());
//    }
//
//    @Test
//    public void test_EditText_checkEmpty() {
//        // check if view's string is not null
//        // then return True : Test Passed
//        assertNotEquals(null, et.getText().toString());
//    }

//    @Test
//    public void check_clickable() {
//        onView(withId(R.id.btn))
//                .perform(click());
//    }

    @Test
    public void whenButtonIsClickedTheUseCaseTextIsShown() {
        onView(withId(R.id.et)).perform(ViewActions.typeText(etText),closeSoftKeyboard());
        onView(withId(R.id.btn)).perform(click());
        assertEquals(etText,tv.getText().toString().trim());
        onView(withId(R.id.btn)).check(ViewAssertions.matches(not(isEnabled())));
//        onView(withId(R.id.tv)).check(ViewAssertions.matches(equalTo(onView(withText(R.id.et)))));
    }

//    @Test
//    public void whenButtonIsClickedItIsDisabled() {
//        onView(withId(R.id.btn)).perform(click());
//        onView(withId(R.id.btn)).check(ViewAssertions.matches(not(isEnabled())));
//    }

//    @Test
//    public void activity_state_test() {
////        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
////            scenario.onActivity(activity -> {
//////                assertThat(activity.getSomething(), null);
////            });
////        }
//        try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
//            scenario.moveToState(Lifecycle.State.RESUMED);    // Moves the activity state to State.RESUMED.
//            scenario.moveToState(Lifecycle.State.STARTED);    // Moves the activity state to State.STARTED.
//            scenario.moveToState(Lifecycle.State.CREATED);    // Moves the activity state to State.CREATED.
////            scenario.moveToState(Lifecycle.State.DESTROYED);  // Moves the activity state to State.DESTROYED.
//        }
//    }

    @After
    public void tear() throws Exception {
        // call this method after end all test cases
        mActivity = null;
    }
}