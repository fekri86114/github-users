package info.fekri.githubusers.di

import info.fekri.githubusers.model.net.createApiService
import info.fekri.githubusers.model.repository.MainRepository
import info.fekri.githubusers.model.repository.MainRepositoryImpl
import info.fekri.githubusers.ui.features.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// app modules -->
val myModules = module {
    single { createApiService() }

    single<MainRepository>{ MainRepositoryImpl(get()) }

    viewModel { MainViewModel(get()) }
}