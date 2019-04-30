package client

import kotlin.browser.document

/**
 * The main entry point.
 * This function is called by default if `main = "call"` in compileKotlin2Js (see build.gradle.kts)
 */
fun main() {

    val mainDiv = document.getElementById("main")
    mainDiv?.innerHTML = "Hello World"

}