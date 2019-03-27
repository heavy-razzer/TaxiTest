package com.mytaxi.android_demo.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.mytaxi.android_demo.BaseTest
import org.junit.Test
import org.junit.runner.RunWith
import qa.data.TestUser
import qa.screen.home.HomeScreen
import qa.screen.login.LoginScreen

/*
/ Tests for Login screen
 */
@RunWith(AndroidJUnit4::class)
class LoginTest : BaseTest() {

    @Test
    @SmallTest
    fun should_sign_in_when_enter_correct_credentials() {

        // Define test user
        val user = TestUser()

        LoginScreen {

            // Enter username
            LoginScreen.Edits.userName.type(user.username)

            // Enter password
            LoginScreen.Edits.password.type(user.password)

            // Tap Login button
            LoginScreen.Buttons.login.tap()
        }

        HomeScreen {

            // Check Home screen opened
            shouldBeOpened()
        }
    }
}