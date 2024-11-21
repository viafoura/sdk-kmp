package viafoura.sdk.demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import viafourademo.composeapp.generated.resources.Res
import viafourademo.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isLoggedIn by remember { mutableStateOf(false) }

        getLoggedInState {  loggedInStatus ->
            isLoggedIn = loggedInStatus
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoggedIn) {
                Text("Welcome!", modifier = Modifier.padding(16.dp))
                Button(
                    onClick = {
                        logout()
                        isLoggedIn = false
                              },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Log-out")
                }
            } else {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail") },
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                )
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    visualTransformation = PasswordVisualTransformation()
                )
                Button(
                    onClick = {
                        login(email, password) { success ->
                            if (success) {
                                isLoggedIn = true
                            }
                        }
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Log-in")
                }
            }
        }
    }
}