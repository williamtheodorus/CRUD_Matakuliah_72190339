package com.example.crud_matakuliah_72190339.network

import com.example.crud_matakuliah_72190339.model.ResponseMatkulItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class NetworkConfig {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }

    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.134/slim_petani/public/api/progmob/matkul/72190339")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @GET("api/progmob/matkul/72190339")
    fun getMatkulAll(): Call<ResponseMatkulItem>

    /*@POST("petani/")
    fun addPetani(@Body req : DataItem): Call<ResponseAddPetani>

    @PUT("petani/{id}")
    fun updatePetani(@Path("id") id : Int, @Body req : DataItem): Call<ResponseAddPetani>

    @DELETE("petani/{id}")
    fun deletePetani(@Path("id") id : Int): Call<ResponseAddPetani>*/
}