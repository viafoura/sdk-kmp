package viafoura.sdk.demo

import com.viafourasdk.src.ViafouraSDK
import com.viafourasdk.src.model.network.authentication.cookieLogin.CookieLoginResponse
import com.viafourasdk.src.model.network.authentication.login.LoginResponse
import com.viafourasdk.src.model.network.error.NetworkError
import com.viafourasdk.src.services.auth.AuthService.CookieLoginCallback
import com.viafourasdk.src.services.auth.AuthService.LoginCallback
import com.viafourasdk.src.services.auth.AuthService.UserLoginStatusCallback
import kotlin.math.log

val auth = ViafouraSDK.auth();

fun getLoggedInStatus(resultCallback: (Boolean) -> Unit){
    auth.getUserLoginStatus(object : UserLoginStatusCallback {
        override fun onSuccess(userIsLoggedIn: Boolean, userUUID: String?) {
            resultCallback(userIsLoggedIn);
        }
    })
}

fun performLogin(email: String, password: String, resultCallback: (Boolean) -> Unit){
    auth.login(email, password, object : LoginCallback {
        override fun onSuccess(loginResponse: LoginResponse?) {
            resultCallback(true);
        }

        override fun onError(err: NetworkError?) {
            resultCallback(false);
        }
    })
}

fun performCookieLogin(token: String, resultCallback: (Boolean) -> Unit){
    auth.cookieLogin(token, object : CookieLoginCallback {
        override fun onSuccess(loginResponse: CookieLoginResponse?) {
            resultCallback(true);
        }

        override fun onError(err: NetworkError?) {
            resultCallback(false);
        }
    })
}

fun performLogout(){
    auth.logout();
}

actual fun getLoggedInState(resultCallback: (Boolean) -> Unit) = getLoggedInStatus(resultCallback);
actual fun login(email: String, password: String, resultCallback: (Boolean) -> Unit) = performLogin(email, password, resultCallback);
actual fun cookieLogin(token: String, resultCallback: (Boolean) -> Unit) = performCookieLogin(token, resultCallback);
actual fun logout() = performLogout();