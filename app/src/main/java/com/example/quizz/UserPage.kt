package com.example.quizz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.quizz.databinding.ActivityUserPageBinding

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class UserPage : AppCompatActivity() {


//    private lateinit var dataStorage: DataStore<Preferences>
//    private val Context.dataStore by preferencesDataStore("app_preferences")

    val dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)

        var msg = ""

        val btn1 = findViewById<Button>(R.id.button)

        lateinit var re: String

        btn1.setOnClickListener {
            lifecycleScope.launch {
                saveToDataStore("NAME", "Filip")
                var re = readFromDataStore("NAME")




            }
//            var re= abc("ddfs")

            Toast.makeText(
                this,
                "msg: $msg", Toast.LENGTH_LONG
            ).show()


        }


    }

    fun abc(key: String):String{
        return key+"zzzzzzzz"
    }
    suspend fun readFromDataStore(key: String): String? {


        val dataStoreKey = stringPreferencesKey(key)
        val preferences = dataStore.data.first()
        Log.i("Daaaata", "Daaaata ${preferences[dataStoreKey]}")

        return preferences[dataStoreKey]
//        return "dfsfsf"


    }

    suspend fun saveToDataStore(key: String, value: String) {

        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { settings ->
            run {
                settings[dataStoreKey] = value
            }
        }


    }
}