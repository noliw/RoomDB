package com.example.roomdb.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.example.roomdb.database.User
import com.example.roomdb.database.UserViewModel
import java.time.Instant

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    userViewModel: UserViewModel = hiltViewModel()
) {
    val user by remember { userViewModel.user }.collectAsState()
//    val users by remember { userViewModel.users }.collectAsState()
    val users by remember { userViewModel.flowUsers }.collectAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "User Screen") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                userViewModel.insertUser(user = dummyUser)
            }) {
                Text(text = "Insert User")
            }

            Button(onClick = {
                userViewModel.getUser(123)
            }) {
                Text(text = "Get User")
            }
            Button(onClick = {
                userViewModel.getAllUsersObservable()
            }) {
                Text(text = "Get All User")
            }

            Button(onClick = {
                userViewModel.insertUserAndPet(user = dummyUser, petName = "Comet")
            }) {
                Text(text = "Insert User And Pet")
            }

            user?.let { user ->
                Text(text = user.userId.toString())
                Text(text = user.username)
            }

            users.forEach { user ->
                Text(text = user.userId.toString())
                Text(text = user.username)
                Text(text = user.createdAt.toString())
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
val dummyUser = User(
    username = "nolawi",
    email = "hadiyarajesh@test.com",
    phoneNumber = "+91 1234567890",
    createdAt = Instant.now(),
    address = Address(addressId = 123, city = "Concord")
)

