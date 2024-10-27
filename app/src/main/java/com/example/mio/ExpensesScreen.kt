package com.example.mio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ExpensesScreen(navController: NavController) {
    // Состояния для хранения введенных данных
    var amount by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Выберите категорию") }
    val categories = listOf("Еда", "Транспорт", "Развлечения", "Здоровье", "Другое") // Пример списка категорий

    // Определение текущего месяца
    val currentMonth = SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(Date())

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
                text = "Учёт расходов",
                fontSize = 24.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Поле для ввода суммы
            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text(text = "Сумма", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray),
                singleLine = true,
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Выпадающий список для выбора категории
            var expanded by remember { mutableStateOf(false) }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .clickable { expanded = true }
                    .padding(16.dp)
            ) {
                Text(text = selectedCategory, color = Color.White, modifier = Modifier.fillMaxWidth())
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                categories.forEach { category ->
                    DropdownMenuItem(onClick = {
                        selectedCategory = category
                        expanded = false
                    }) {
                        Text(text = category)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Текущий месяц
            Text(
                text = "Месяц: $currentMonth",
                fontSize = 16.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Кнопка для сохранения расхода
            Button(
                onClick = {
                    // Пока выводим данные в лог для проверки
                    println("Сохранено: Сумма - $amount, Категория - $selectedCategory, Месяц - $currentMonth")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Сохранить")
            }
        }

        // Логотип внизу по центру
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 16.dp)
                .size(148.dp)
        )
    }
}
