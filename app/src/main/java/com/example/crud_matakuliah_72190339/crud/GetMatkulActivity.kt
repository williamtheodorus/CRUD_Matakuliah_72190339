package com.example.crud_matakuliah_72190339.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_matakuliah_72190339.R
import com.example.crud_matakuliah_72190339.adapter.ResponseMatkulAdapter
import com.example.crud_matakuliah_72190339.model.ResponseMatkul
import com.example.crud_matakuliah_72190339.network.NetworkConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetMatkulActivity : AppCompatActivity() {
    lateinit var rvGetMatkul : RecyclerView
    lateinit var fAddMatkul : FloatingActionButton

    override fun onRestart() {
        super.onRestart()

        lateinit var rvGetMatkul : RecyclerView
        lateinit var fAddMatkul : FloatingActionButton

        NetworkConfig().getService()
            .getMatkulAll()
            .enqueue(object : Callback<ResponseMatkul?> {
                override fun onFailure(call: Call<ResponseMatkul?>, t: Throwable) {
                    Toast.makeText(this@GetMatkulActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<ResponseMatkul?>,
                    response: Response<ResponseMatkul?>
                ) {
                    rvGetMatkul.apply{
                        layoutManager = LinearLayoutManager(this@GetMatkulActivity)
                        adapter = ResponseMatkulAdapter(response.body()?.data as List<ResponseMatkul>?)
                    }
                }
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_matkul)

        lateinit var rvGetMatkul : RecyclerView
        lateinit var fAddMatkul : FloatingActionButton

        NetworkConfig().getService()
            .getMatkulAll()
            .enqueue(object : Callback<ResponseMatkul?> {
                override fun onFailure(call: Call<ResponseMatkul?>, t: Throwable) {
                    Toast.makeText(this@GetMatkulActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(
                    call: Call<ResponseMatkul?>,
                    response: Response<ResponseMatkul?>
                ) {
                    rvGetMatkul.apply{
                        layoutManager = LinearLayoutManager(this@GetMatkulActivity)
                        adapter = ResponseMatkulAdapter(response.body()?.data as List<ResponseMatkul>?)
                    }
                }
            })
        fAddMatkul.setOnClickListener(View.OnClickListener { view ->
            var intent = Intent(this@GetMatkulActivity, AddMatkulActivity::class.java)
            startActivity(intent)
        })
    }
}