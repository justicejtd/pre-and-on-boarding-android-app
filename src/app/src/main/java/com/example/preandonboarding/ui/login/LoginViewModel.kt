package com.example.preandonboarding.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.preandonboarding.data.api.service.authentication.AuthRepo
import com.example.preandonboarding.data.api.service.authentication.LoginResponse
import com.example.preandonboarding.data.api.utils.Resource
import com.example.preandonboarding.data.api.utils.StatusCode
import com.example.preandonboarding.data.model.user.User
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Error message when something goes wrong the network connection.
 */
const val NETWORK_ERROR_MSG = "Check your connection or contact your administrator."
private const val INVALID_CREDENTIALS = "Invalid email and/or password."

/**
 * ViewModel for the login page, it handles the presenter logic of the login page.
 */
class LoginViewModel(private val authRepo: AuthRepo) : ViewModel() {
    private val _loginResponse = MutableLiveData<Resource<LoginResponse>>()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _loginResponse.postValue(Resource.error(NETWORK_ERROR_MSG, null))
    }

    init {
        val accessToken = authRepo.getAccessToken()

        // Set access token and user state
        handleLoginState(accessToken = accessToken, isUserLoggedIn = isUserLoggedIn())
    }

    /**
     * Used to keep track of the login response states.
     * These states could be Loading, Error or Success.
     */
    val loginResponse: LiveData<Resource<LoginResponse>> = _loginResponse

    /**
     * Check if user is logged in or not.
     * @return Boolean
     */
    fun isUserLoggedIn(): Boolean {
        return authRepo.getIsUserLoggedIn()
    }

    /**
     * Handles to login response and any network errors.
     * @param email user email
     * @param password user password
     */
    fun login(email: String, password: String, deviceName: String) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            // Indicate that the request is loading
            _loginResponse.postValue(Resource.loading(null))

            // Attempt to authenticate user
            val response = authRepo.login(email.trim(), password, deviceName)

            if (response.isSuccessful) {
                val loginResponse = response.body()

                // Handle login response
                loginResponse?.let {
                    // Set access token and user login state
                    handleLoginState(accessToken = it.token, isUserLoggedIn = true)
                }

                // Indicate that the request was successfully
                _loginResponse.postValue(Resource.success(response.body()))

            } else if (response.code() == StatusCode.UNAUTHORIZED.code) {
                // Indicate that the request was unsuccessfully
                _loginResponse.postValue(Resource.error(INVALID_CREDENTIALS, null))
            }
        }
    }

    /**
     * Handles the process of saving the access token and user logged-in state
     */
    private fun handleLoginState(accessToken: String, isUserLoggedIn: Boolean) {

        // Save user access token in shared preferences
        authRepo.saveAccessToken(token = accessToken)

        // Save user user login state in shared preferences
        authRepo.saveIsUserLoggedIn(isUserLoggedIn = isUserLoggedIn)

        User.isUserLoggedIn = isUserLoggedIn
    }
}