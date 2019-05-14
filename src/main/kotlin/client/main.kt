package client

import kotlinx.html.dom.append
import kotlinx.html.js.h1
import vaadin.vaadin_button
import vaadin.vaadin_text_field
import kotlin.browser.document
import kotlin.browser.window

external fun require(module:String):dynamic

/**
 * The main entry point.
 * This function is called by default if `main = "call"` in compileKotlin2Js (see build.gradle.kts)
 */
fun main() {
    require("@vaadin/vaadin-button")
    require("@vaadin/vaadin-text-field")

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