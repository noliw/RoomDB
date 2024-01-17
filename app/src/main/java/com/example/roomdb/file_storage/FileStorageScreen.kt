package com.example.roomdb.file_storage

import android.widget.Toast
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FileStorageScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "FileStorageScreen") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    writeToCacheDirectory(
                        context = context,
                        content = " This is the file content for INTERNAL cached " +
                                "directory ",
                        cacheDirectoryType = CacheDirectoryType.INTERNAL
                    )
                }) {
                Text(text = " Write To Internal Cache Directory")
            }

            Button(
                onClick = {
                    writeToCacheDirectory(
                        context = context,
                        content = " This is the file content for EXTERNAL cached " +
                                "directory ",
                        cacheDirectoryType = CacheDirectoryType.EXTERNAL
                    )

                    Toast.makeText(context, "External clicked", Toast.LENGTH_SHORT).show()
                }) {
                Text(text = " Write To External Cache Directory")

            }
        }
    }
}