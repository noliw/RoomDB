package com.example.roomdb.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.database.User
import com.example.roomdb.database.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _user = MutableStateFlow<User?>(value = null)
    val user: StateFlow<User?> get() = _user
    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user = user)
        }
    }

    fun getUser(userId: Long){
        viewModelScope.launch {
            val retrievedUser =  userRepository.getUser(userId = userId)
            _user.value = retrievedUser
        }
    }
}


