package com.mytaxi.android_demo

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.azimolabs.conditionwatcher.ConditionWatcher
import com.mytaxi.android_demo.activities.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.rules.RuleChain
import org.junit.rules.Timeout
import org.junit.runner.RunWith
import qa.rule.ScreenshotRule
import qa.screen.login.LoginScreen
import java.io.File

@RunWith(AndroidJUnit4::class)
abstract class BaseTest {

    private val conditionWatcherTimeout = 10000
    private val testTimeout = 90

    private val appContext: Context = ApplicationProvider.getApplicationContext()

    private var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
            MainActivity::class.java, false, false
    )

    private val testTimeoutRule: Timeout = Timeout.seconds(testTimeout.toLong())

    private val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
            android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    @get:Rule
    val ruleChain: RuleChain = RuleChain
            .outerRule(ScreenshotRule())
            .around(permissionRule)
            .around(testTimeoutRule)
            .around(mActivityRule)

    @Before
    fun setUp() {

        // Condition Watcher config
        ConditionWatcher.setTimeoutLimit(conditionWatcherTimeout)

        // Clean storage
        cleanStorage()

        // Launch App and wait for Login Screen
        val restartIntent = Intent(appContext, MainActivity::class.java)
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        restartIntent.addCategory(Intent.CATEGORY_DEFAULT)

        mActivityRule.launchActivity(restartIntent)
        LoginScreen.shouldBeOpened()
    }

    private fun cleanStorage() {

        // Get file
        val appSettings = File(appContext.filesDir.parentFile, "shared_prefs").list()

        // If there is any settings stored, then clear it.
        if (appSettings != null) {
            appSettings.forEach { file ->
                appContext
                        .getSharedPreferences(file.replace(".xml", ""), Context.MODE_PRIVATE)
                        .edit()
                        .clear()
                        .commit()
            }
        }
    }
}