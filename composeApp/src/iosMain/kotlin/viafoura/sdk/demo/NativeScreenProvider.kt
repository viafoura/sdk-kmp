package viafoura.sdk.demo

import platform.UIKit.*

actual class NativeScreenProvider {
    actual fun getCommentsContainer(containerId: String, loginCallback: () -> Unit): Any {
        return UIViewController()
    }
}
