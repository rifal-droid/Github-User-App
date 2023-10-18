package com.rifal.myapplication.data.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.rifal.myapplication.data.local.FavUser
import com.rifal.myapplication.data.local.FavUserDao
import com.rifal.myapplication.data.local.UserDatabase

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    private var userDao: FavUserDao?
    private var userDb: UserDatabase?

    init {
        userDb = UserDatabase.getDatabase(application)
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavUser(): LiveData<List<FavUser>>?{
        return userDao?.getFavoriteUser()
    }
}