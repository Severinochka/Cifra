package com.example.mio

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mio.R

// Определение пунктов меню
sealed class BottomNavItem(val route: String, val icon: Int, val title: String) {
    object Expenses : BottomNavItem("expenses", R.drawable.expenses, "Расходы")
    object Tips : BottomNavItem("tips", R.drawable.tips, "Советы")
    object Education : BottomNavItem("education", R.drawable.education, "Обучение")
}

@Composable
fun NavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Expenses,
        BottomNavItem.Tips,
        BottomNavItem.Education
    )
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White,
        elevation = 10.dp
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = item.title, modifier = Modifier.size(60.dp))
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

