package qa.steps

import qa.data.TestUser
import qa.screen.home.HomeScreen
import qa.screen.login.LoginScreen

/*
/ Authorization and other possible functions, performed before testing
 */
object LoginSteps {

    fun loginAs(user: TestUser = TestUser()) {

        // Login screen opened
        LoginScreen.shouldBeOpened()

        // Fill in credentials
        LoginScreen.Edits.userName.type(user.username)
        LoginScreen.Edits.password.type(user.password)

        // Tap Login button
        LoginScreen.Buttons.login.tap()

        // Home screen opened
        HomeScreen.shouldBeOpened()
    }
}