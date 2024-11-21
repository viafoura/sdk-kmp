package viafoura.sdk.demo

expect fun login(email: String, password: String, resultCallback: (Boolean) -> Unit);
expect fun cookieLogin(token: String, resultCallback: (Boolean) -> Unit);
expect fun logout();
expect fun getLoggedInState(resultCallback: (Boolean) -> Unit);