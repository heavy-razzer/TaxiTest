package qa.screen.login

import android.support.test.espresso.matcher.ViewMatchers.withId
import com.mytaxi.android_demo.R
import com.qautomatron.kopi.library.element.Element
import qa.screen.Screen

/*
/ Login screen for authorization
 */
object LoginScreen : Screen<LoginScreen> {

    override val rootElement = Buttons.login

    object Edits {
        val userName = Element(withId(R.id.edt_username))
        val password = Element(withId(R.id.edt_password))
    }

    object Buttons {
        val login = Element(withId(R.id.btn_login))
    }
}