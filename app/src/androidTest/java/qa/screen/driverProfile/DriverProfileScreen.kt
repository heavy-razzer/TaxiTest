package qa.screen.driverProfile

import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.mytaxi.android_demo.R
import com.qautomatron.kopi.library.element.Element
import qa.screen.Screen

/*
/ Screen with selected driver info
 */
object DriverProfileScreen : Screen<DriverProfileScreen> {

    override val rootElement = Texts.caption

    object Texts {
        val caption = Element(withText(R.string.title_activity_driver_profile))
    }

    object Buttons {
        val call = Element(withId(R.id.fab))
    }
}