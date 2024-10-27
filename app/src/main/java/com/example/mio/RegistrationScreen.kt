package com.example.mio

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(navController: NavController, context: Context) {
    val phoneNumber = remember { mutableStateOf("+7") }
    val password = remember { mutableStateOf("") }
    val db = AppDatabase.getDatabase(context) // Инициализация базы данных
    val coroutineScope = rememberCoroutineScope()
    var registrationMessage by remember { mutableStateOf("") } // Сообщение для подтверждения регистрации

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Регистрация",
                fontSize = 24.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = phoneNumber.value,
                onValueChange = {
                    if (it.length <= 12) {
                        phoneNumber.value = it
                    }
                },
                label = { Text(text = "Номер телефона", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Пароль", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    coroutineScope.launch {
                        // Сохраняем данные пользователя в базу данных
                        val user = User(phoneNumber = phoneNumber.value, password = password.value)
                        db.userDao().insertUser(user)
                        registrationMessage = "Пользователь успешно зарегистрирован"

                        // Можно перейти на главный экран после регистрации
                        navController.navigate("expenses")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Зарегистрироваться")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Отображение сообщения о регистрации
            Text(text = registrationMessage, color = Color.Green, fontSize = 16.sp)
        }

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .size(148.dp)
        )
    }
}



