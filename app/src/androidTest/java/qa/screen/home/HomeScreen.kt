package qa.screen.home

import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import com.mytaxi.android_demo.R
import com.qautomatron.kopi.library.element.Element
import qa.screen.Screen

/*
/ Main app screen with map
 */
object HomeScreen : Screen<HomeScreen> {

    override val rootElement = Edits.search

    object Edits {
        val search = Element(withId(R.id.textSearch))
    }

    object SearchResults{
        fun driverName(name: String) = Element(withText(name), isPlatformPopup())
    }
}