package com.mytaxi.android_demo.home

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.mytaxi.android_demo.BaseTest
import org.junit.Test
import org.junit.runner.RunWith
import qa.screen.driverProfile.DriverProfileScreen
import qa.screen.home.HomeScreen
import qa.steps.LoginSteps

/*
/ Tests for Home screen
 */
@RunWith(AndroidJUnit4::class)
class HomeTest : BaseTest() {

    @Test
    @MediumTest
    fun should_call_driver_when_search_for_it_and_select_one() {

        LoginSteps.loginAs()

        HomeScreen {

            // Type some chars to Search field
            val charsToSearch = "sa"
            HomeScreen.Edits.search.tap().type(charsToSearch)

            // Tap second suggestion, driver with defined name
            val driverName = "Sarah Scott"
            HomeScreen.SearchResults.driverName(driverName).waitForVisibility().tap()
        }

        DriverProfileScreen {

            // Driver profile shown
            shouldBeOpened()

            // Tap Call button
            DriverProfileScreen.Buttons.call.tap()

            // TODO: Add check for verifying that call activity shown (depends from device)
        }
    }
}