package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val textFieldShape = RoundedCornerShape(16.dp)

    var login by remember {mutableStateOf ("")}
    var password by remember {mutableStateOf ("")}
    var passwordIsVisible by remember {mutableStateOf (false)}

    val CustomBlue = colorResource(id =R.color.Blue)

    Surface {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
            ){
            val imageURL = "https://img.freepik.com/free-photo/computer-security-with-login-password-padlock_107791-16191.jpg?t=st=1708356344~exp=1708356944~hmac=1167a9834aca1f59ad54a8994f5e945af93c0cc9da49986c32422aa4d1a206fc"
            Image(painter = rememberImagePainter(data = imageURL),
                contentDescription = "Login preview image",
                modifier = Modifier.size(200.dp)
            )
            Text(text = "Вход",
                fontSize = 24.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = login,
                onValueChange = {login = it},
                label = {Text(text = "Ваш логин")},
                modifier = Modifier
                    .fillMaxWidth(),
                shape = textFieldShape)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = password,
                onValueChange = {password = it},
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = if (passwordIsVisible) {
                    VisualTransformation.None
                } else PasswordVisualTransformation(),
                shape = textFieldShape,
                trailingIcon = {
                    IconButton(onClick = { passwordIsVisible = !passwordIsVisible }) {
                        Icon(imageVector = if (passwordIsVisible)
                            Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = "Toggle Icon"
                        )
                    }
                })
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(modifier = Modifier.weight(1f))
                Text("Другое",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f))
                Divider(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(modifier = Modifier
                .fillMaxWidth(),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(2.dp, Color.Red),
                onClick = {}
            )
            {
                Text("Google",
                    fontSize = 20.sp,
                    color = Color.Red
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(modifier = Modifier
                .fillMaxWidth(),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(2.dp, CustomBlue),
                onClick = {}
            )
            {
                Text("Facebook",
                    fontSize = 20.sp,
                    color = CustomBlue)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(modifier = Modifier
                .fillMaxWidth(),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(2.dp, Color.DarkGray),
                onClick = {}
            )
            {
                Text("Custom mode",
                    fontSize = 20.sp,
                    color = Color.DarkGray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposeApplicationTheme {
        LoginScreen()
    }
}