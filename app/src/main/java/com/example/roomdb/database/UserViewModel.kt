package com.example.roomdb.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.database.User
import com.example.roomdb.database.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user: MutableStateFlow<User?> = MutableStateFlow(value = null)
    val user: StateFlow<User?> get() = _user.asStateFlow()

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> get() = _users.asStateFlow()

    private val _usersAndPets = MutableStateFlow<List<UserAndPet>>(emptyList())
    val usersAndPets: StateFlow<List<UserAndPet>> get() = _usersAndPets.asStateFlow()

    val flowUsers: Flow<List<User>> = userRepository.getAllObsUsers()
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

    fun getAllUsers() {
        viewModelScope.launch {
            val retrievedUsers = userRepository.getAllUsers()
            _users.value = retrievedUsers
        }
    }

    fun getAllUsersObservable() {
        viewModelScope.launch {
            userRepository.getAllObsUsers().collect { retrievedUsers ->
                _users.value = retrievedUsers
            }
        }
    }

    fun insertPet(pet: Pet) {
        viewModelScope.launch {
            userRepository.insertPet(pet = pet)
        }
    }

    fun insertUserAndPet(user: User, petName: String) {
        viewModelScope.launch {
            val userId = userRepository.insertUser(user = user)
            val pet = Pet(name = petName, userOwnerId = userId)
            userRepository.insertPet(pet)
        }
    }

    fun getUserAndPet() {
        viewModelScope.launch {
            val retreivedUserAndPet = userRepository.getUserAndPet()
            _usersAndPets.value = retreivedUserAndPet
        }

    }


}


