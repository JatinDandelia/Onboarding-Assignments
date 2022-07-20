package com.example.firstapplication

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.model.Atoms.getCurrentUrl
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.*
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.urlopener.MainActivity
import com.example.urlopener.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.Matcher
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner:: class)
class MainActivityTest {
    @Test
    fun test_allElementsPresent() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
        //onView(withId(R.id.tvAppName)).check(matches(isDisplayed()))
        onView(withId(R.id.tvURL)).check(matches(isDisplayed()))
        onView(withId(R.id.btnOpen)).check(matches(isDisplayed()))
    }

    @Test
    fun test_navigation() {
        val expectedUrl = "https://browserstack.com"
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.tvURL)).check(matches(isDisplayed()))
        onView(withId(R.id.tvURL)).perform(click())
        onView(withId(R.id.tvURL)).perform(typeText(expectedUrl))
        onView(withId(R.id.btnOpen)).perform(click())
        pressBack()
        Thread.sleep(350)

        onWebView().forceJavascriptEnabled()
        onWebView().withElement(findElement(Locator.XPATH, "//*[@id=\"header-habitat\"]/div[1]/div/div/button[1]"))
            .perform(webClick())
            .withElement(findElement(Locator.XPATH, "/html/body/div[1]/header/div[2]/nav/div/div/div/div/form/input[1]"))
            .perform(webClick())
            .perform(webKeys("app automate"))
            .perform(webClick())

    }

}