package info.fekri.githubusers.ui.features.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.fekri.githubusers.model.data.PopularUser
import info.fekri.githubusers.model.repository.MainRepository
import info.fekri.githubusers.util.coroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {
    val dataPopularUsers = mutableStateOf<List<PopularUser>>(listOf())
    val showProgress = mutableStateOf(false)

    init {
        refreshDataFromServer()
    }

    private fun refreshDataFromServer() {
        viewModelScope.launch(coroutineExceptionHandler) {
            showProgress.value = true
            delay(1000)

            val dataToShowPopularUsers = mainRepository.getPopularUser()
            updateData(dataToShowPopularUsers)

            showProgress.value = false
        }
    }

    private fun updateData(dataPops: ArrayList<PopularUser>) {
        dataPopularUsers.value = dataPops
    }

}