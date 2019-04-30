import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("kotlin2js") version "1.3.21"
    id("org.jetbrains.kotlin.frontend") version "0.0.45"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.0-alpha")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.2.0-alpha")
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.10")
}

kotlinFrontend {
    npm {
        dependency("style-loader")
        devDependency("karma")

        // Vaadin Elements
        dependency("@vaadin/vaadin-upload")
        dependency("@vaadin/vaadin-button")
        dependency("@vaadin/vaadin-grid")
        dependency("@vaadin/vaadin-text-field")
    }

    bundle<WebPackExtension>("webpack") {
        this as WebPackExtension
        bundleName = "hello"
        sourceMapEnabled = true
        contentPath = file("./")
        mode = "development"

    }
}

tasks {

    "compileKotlin2Js"(Kotlin2JsCompile::class) {
        kotlinOptions {
            languageVersion = "1.3"
            moduleKind = "umd"
            sourceMap = true
            metaInfo = true
            main = "call"
        }
    }

}

