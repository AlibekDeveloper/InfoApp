package com.example.infoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.infoapp.ui.theme.InfoAppTheme
import com.example.infoapp.ui_components.DrawerMenu
import com.example.infoapp.ui_components.MainTopBar
import com.example.infoapp.utils.DrawerEvents
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val topBarTitle = remember {
                mutableStateOf("")
            }
            val coroutineScope = rememberCoroutineScope()
            InfoAppTheme {
                Scaffold(
                    topBar = {
                        MainTopBar(title = topBarTitle.value)
                    },

                    )
                {

                }
                DrawerMenu() { event ->
                    when (event) {
                        is DrawerEvents.onItemClick -> {
                            topBarTitle.value = event.title
                        }
                    }
                    coroutineScope.launch {
                        
                    }
                }
            }
        }
    }
}

