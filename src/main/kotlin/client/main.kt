package client

import kotlinx.html.dom.append
import kotlinx.html.js.h1
import org.w3c.dom.HTMLElement
import vaadin.vaadin_button
import kotlin.browser.document

@JsModule("@vaadin/vaadin-button")
@JsNonModule
external val vbutton: HTMLElement? = definedExternally

/**
 * The main entry point.
 * This function is called by default if `main = "call"` in compileKotlin2Js (see build.gradle.kts)
 */
fun main() {

    //console.log(vbutton?.toString())

    val mainDiv = document.getElementById("main")

    mainDiv?.append {
        h1 {
            +"Hello World"
        }

        vaadin_button {
            attributes["id"] = "hello"
            +"Hello"
        }
    }

}