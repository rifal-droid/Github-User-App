package com.rifal.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rifal.myapplication.api.RetrofitClient
import com.rifal.myapplication.data.model.User
import com.rifal.myapplication.data.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserViewModel : ViewModel() {

    val userList = MutableLiveData<ArrayList<User>>()

    fun setUserSearch(query: String){
        RetrofitClient.apiInstance
            .getSearchUsers(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful){
                        userList.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                }
            })
    }

    fun getUsersearch(): LiveData<ArrayList<User>>{
        return userList
    }

}