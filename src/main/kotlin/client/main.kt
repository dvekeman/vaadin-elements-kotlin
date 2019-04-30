package client

import kotlinx.html.dom.append
import kotlinx.html.js.h1
import org.w3c.dom.HTMLElement
import vaadin.vaadin_button
import vaadin.vaadin_text_field
import kotlin.browser.document
import kotlin.browser.window

@JsModule("@vaadin/vaadin-button")
@JsNonModule
external val vbutton: HTMLElement? = definedExternally

@JsModule("@vaadin/vaadin-text-field")
@JsNonModule
external val vtextfield: HTMLElement? = definedExternally


/**
 * The main entry point.
 * This function is called by default if `main = "call"` in compileKotlin2Js (see build.gradle.kts)
 */
fun main() {

    console.log(vbutton?.toString())
    console.log(vtextfield?.toString())

    val mainDiv = document.getElementById("main")

    mainDiv?.append {
        h1 {
            +"Hello World"
        }

        val nameLabel = vaadin_text_field{
            attributes["name"]
            attributes["label"] = "Name"
            attributes["placeholder"] = "World"
        }

        val helloButton = vaadin_button {
            attributes["id"] = "hello-button"
            +"Hello"
        }
        helloButton.addEventListener("click", {
            window.alert("Hello " + nameLabel.asDynamic().value + "!")
        })
    }


}