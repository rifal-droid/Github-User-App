package com.rifal.myapplication.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rifal.myapplication.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel: ViewModel(){

    val listFollower = MutableLiveData<ArrayList<User>>()

    fun setListFollowers(username : String){
        RetrofitClient.apiInstance
            .getFollowers(username)
            .enqueue(object  : Callback<ArrayList<User>>{
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    if (response.isSuccessful){
                        listFollower.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    Log.d("Gagal", t.message.toString())
                }

            })
    }

    fun getListFollowers(): LiveData<ArrayList<User>>{
        return listFollower
    }
}