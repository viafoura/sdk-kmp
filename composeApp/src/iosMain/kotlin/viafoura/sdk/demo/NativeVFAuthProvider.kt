package viafoura.sdk.demo

import platform.UIKit.*
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
fun performLogin(email: String, password: String, resultCallback: (Boolean) -> Unit){
    

}

fun getLoggedInStatus(resultCallback: (Boolean) -> Unit){

}


fun performCookieLogin(token: String, resultCallback: (Boolean) -> Unit){

}

fun performLogout(){

}


actual fun getLoggedInState(resultCallback: (Boolean) -> Unit) = getLoggedInStatus(resultCallback)
actual fun login(email: String, password: String, resultCallback: (Boolean) -> Unit) = performLogin(email, password, resultCallback);
actual fun cookieLogin(token: String, resultCallback: (Boolean) -> Unit) = performCookieLogin(token, resultCallback);
actual fun logout() = performLogout()
