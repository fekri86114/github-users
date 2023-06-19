package info.fekri.githubusers.model.repository

import info.fekri.githubusers.model.data.PopularUser

interface MainRepository {

    suspend fun getPopularUser(): ArrayList<PopularUser>

}