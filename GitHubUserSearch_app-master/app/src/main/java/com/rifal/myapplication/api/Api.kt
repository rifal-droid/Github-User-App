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
    @Headers("Authorization: token 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")

    fun getSearchUsers(
        @Query("q") query:String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")

    fun getDetailUsers(
        @Path("username") username : String
    ):Call<UserDetailResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")

    fun getFollowers(
        @Path("username") username : String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")

    fun getFollowing(
        @Path("username") username : String
    ):Call<ArrayList<User>>
}