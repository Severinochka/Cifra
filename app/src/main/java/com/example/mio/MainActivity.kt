package com.example.mio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mio.SplashScreen
import com.example.mio.ui.theme.MIOTheme
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MIOTheme {
                // Создаем NavController для управления навигацией
                val navController = rememberNavController()

                // Surface контейнер для всего приложения
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Устанавливаем NavHost для управления навигацией
                    AppNavigation(navController)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            // Показываем NavigationBar только на страницах "expenses", "tips", и "education"
            if (navController.currentBackStackEntryAsState().value?.destination?.route in listOf("expenses", "tips", "education")) {
                NavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(innerPadding) // Для учета отступов навигации
        ) {
            composable("splash") { SplashScreen(navController) }
            composable("registration") {

                RegistrationScreen(navController = navController, context = LocalContext.current)
            }
            composable("expenses") { ExpensesScreen(navController) }
            composable("tips") { TipsScreen() }
            composable("education") { EducationScreen() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MIOTheme {
        val navController = rememberNavController()
        AppNavigation(navController)
    }
}

