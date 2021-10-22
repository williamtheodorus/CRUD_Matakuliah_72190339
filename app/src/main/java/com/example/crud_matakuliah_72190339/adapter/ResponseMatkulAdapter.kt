package com.example.crud_matakuliah_72190339.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_matakuliah_72190339.R
import com.example.crud_matakuliah_72190339.model.ResponseMatkulItem

class ResponseMatkulAdapter(val matkul : List<ResponseMatkulItem>?): RecyclerView.Adapter<ResponseMatkulAdapter.MatkulHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseMatkulAdapter.MatkulHolder {
        return MatkulHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_matkul, parent, false))
    }

    override fun onBindViewHolder(holder: ResponseMatkulAdapter.MatkulHolder, position: Int) {
        holder.bindUsers(matkul?.get(position))
    }

    override fun getItemCount(): Int {
        return matkul?.size ?: 0
    }

    class MatkulHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtkodeApi: TextView
        lateinit var txtnamaApi : TextView
        lateinit var txthariApi : TextView
        lateinit var txtsesiAPI: TextView
        lateinit var txtsksAPI: TextView
        fun bindUsers(matkul : ResponseMatkulItem?) {
            itemView.apply {
                txtkodeApi = findViewById(R.id.kode)
                txtnamaApi = findViewById(R.id.nama)
                txthariApi = findViewById(R.id.hari)
                txtsesiAPI = findViewById(R.id.sesi)
                txtsksAPI = findViewById(R.id.sks)
                txtkodeApi.text = matkul?.kode
                txtnamaApi.text = matkul?.nama
                txthariApi.text = matkul?.hari
                txtsesiAPI.text = matkul?.sesi
                txtsksAPI.text = matkul?.sks

            }
        }
    }
}