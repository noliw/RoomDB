package com.example.roomdb

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.roomdb.database.UserAndPetScreen
import com.example.roomdb.database.UserScreen
import com.example.roomdb.ui.theme.RoomDBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDBTheme {
                UserScreen()
//                UserAndPetScreen()
            }

        }
    }
}

