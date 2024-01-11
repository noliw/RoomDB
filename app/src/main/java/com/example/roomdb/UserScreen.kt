package com.example.roomdb

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.w4storage.day2Room.database.User
import com.example.w4storage.day2Room.database.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    userViewModel: UserViewModel = hiltViewModel()
) {
    val user by remember { userViewModel.user}.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "User Screen") })
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                val user = User(
                    userId = 123,
                    username = "noli",
                    email = "noli@test.com",
                    phoneNumber = "123456789"
                )
                userViewModel.insertUser(user = user) }) {
                Text(text = "Insert User")
            }

            Button(onClick = {
                userViewModel.getUser(123) }) {
                Text(text = "Get User")
            }

            user?.let {user ->
                Text(text = user.userId.toString())
                Text(text = user.username)
            }
        }
    }
}

