package info.fekri.githubusers.model.net

import info.fekri.githubusers.model.data.PopularUsersResponse
import info.fekri.githubusers.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users")
    suspend fun getPopularUsers(
        @Path("sort=") sortMode: String = "popular"
    ): PopularUsersResponse

}

fun createApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}