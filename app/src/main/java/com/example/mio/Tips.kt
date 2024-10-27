package com.example.mio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mio.R

@Composable
fun TipsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Устанавливаем черный фон для всего экрана
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Логотип наверху экрана
            item {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(bottom = 16.dp)
                        .size(148.dp)
                )
            }

            // Раздел: Начинайте с малого
            item {
                Text("Начинайте с малого, двигайтесь постепенно", fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Не нужно пытаться все контролировать сразу. Начните с отслеживания основных расходов.", color = Color.White, fontSize = 18.sp)
                Text("• Поставьте себе маленькую, достижимую цель, например, отслеживание трат на кофе в течение недели.", color = Color.White, fontSize = 18.sp)
                Text("• Каждая маленькая победа - это шаг к большим результатам.", color = Color.White, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Раздел: Визуализация и вовлечение
            item {
                Text("Визуализация и вовлечение", fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Используйте диаграммы и графики, чтобы увидеть свои финансы в наглядной форме.", color = Color.White, fontSize = 18.sp)
                Text("• Установите напоминания, чтобы не забывать отслеживать расходы.", color = Color.White, fontSize = 18.sp)
                Text("• Попробуйте создавать бюджетные категории, которые соответствуют вашим целям.", color = Color.White, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Раздел: Вдохновение и награды
            item {
                Text("Вдохновение и награды", fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Отслеживайте прогресс и отмечайте свои достижения.", color = Color.White, fontSize = 18.sp)
                Text("• Установите себе награды за успешное следование бюджету.", color = Color.White, fontSize = 18.sp)
                Text("• Вспомните о том, чего вы хотите достичь, и как управление финансами поможет вам в этом.", color = Color.White, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Раздел: Полезные привычки
            item {
                Text("Полезные привычки", fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Делайте ежедневный обзор своих трат и анализируйте их.", color = Color.White, fontSize = 18.sp)
                Text("• Планируйте бюджет наперед и придерживайтесь его.", color = Color.White, fontSize = 18.sp)
                Text("• Используйте приложение, чтобы найти способы сэкономить деньги.", color = Color.White, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Раздел: Позитивный настрой
            item {
                Text("Позитивный настрой", fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Не расстраивайтесь, если вы не можете сразу достичь всех своих целей.", color = Color.White, fontSize = 18.sp)
                Text("• Относитесь к финансовому планированию как к игре, в которой вы можете победить.", color = Color.White, fontSize = 18.sp)
                Text("• Помните, что вы контролируете свои финансы, а не наоборот.", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}
