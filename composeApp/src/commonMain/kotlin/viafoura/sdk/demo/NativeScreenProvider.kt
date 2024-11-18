package viafoura.sdk.demo

expect class NativeScreenProvider {
    fun getCommentsContainer(containerId: String, loginCallback: () -> Unit): Any
}