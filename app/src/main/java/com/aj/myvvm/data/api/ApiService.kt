package com.aj.myvvm.data.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<UsersResponse>

}