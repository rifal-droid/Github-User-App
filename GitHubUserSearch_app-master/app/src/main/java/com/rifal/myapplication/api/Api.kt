package com.rifal.myapplication.api

import com.rifal.myapplication.data.model.User
import com.rifal.myapplication.data.model.UserDetailResponse
import com.rifal.myapplication.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token [token github] ")

    fun getSearchUsers(
        @Query("q") query:String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token [token github]")

    fun getDetailUsers(
        @Path("username") username : String
    ):Call<UserDetailResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token [token github]")

    fun getFollowers(
        @Path("username") username : String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token [token github]")

    fun getFollowing(
        @Path("username") username : String
    ):Call<ArrayList<User>>
}
