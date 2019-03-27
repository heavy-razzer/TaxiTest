package qa.screen

import com.qautomatron.kopi.library.element.Element

/*
/ Basic screen structure
 */
@Suppress("UNCHECKED_CAST")
interface Screen<T> {

    val rootElement: Element

    /**
     * Will check that screen is opened.
     * Required to override rootElement
     */
    fun shouldBeOpened(): Screen<T> {
        rootElement.waitForVisibility()
        return this
    }

    operator fun invoke(function: T.() -> Unit) = function.invoke(this as T)
}