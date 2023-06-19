package info.fekri.githubusers.model.repository

import info.fekri.githubusers.model.net.ApiService
import info.fekri.githubusers.model.data.PopularUser

class MainRepositoryImpl(private val apiService: ApiService): MainRepository {
    override suspend fun getPopularUser(): ArrayList<PopularUser> {
        return apiService.getPopularUsers()
    }
}