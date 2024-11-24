package viafoura.sdk.demo

import platform.UIKit.UIApplicationDelegateProtocol;
import platform.UIKit.UIApplication;
import kotlinx.cinterop.ExperimentalForeignApi
import viafouraBridge.VFAuthManager

@OptIn(ExperimentalForeignApi::class)
class AuthService {
    private val authManager = VFAuthManager();

    fun performLogin(email: String, password: String, resultCallback: (Boolean) -> Unit) {
        authManager.loginWithEmail(email, password) { success: Boolean ->
            resultCallback(success)
        }
    }

    fun getLoggedInStatus(resultCallback: (Boolean) -> Unit) {
        authManager.getLoggedInStatus() { isLoggedIn: Boolean ->
            resultCallback(isLoggedIn);
        }
    }

    fun performCookieLogin(token: String, resultCallback: (Boolean) -> Unit) {
        authManager.cookieLoginWithToken(token) { success: Boolean ->
            resultCallback(success)
        }
    }

    fun performLogout() {
        authManager.logout()
    }
}

actual fun getLoggedInState(resultCallback: (Boolean) -> Unit) = AuthService().getLoggedInStatus(resultCallback)
actual fun login(email: String, password: String, resultCallback: (Boolean) -> Unit) = AuthService().performLogin(email, password, resultCallback)
actual fun cookieLogin(token: String, resultCallback: (Boolean) -> Unit) = AuthService().performCookieLogin(token, resultCallback)
actual fun logout() = AuthService().performLogout()

