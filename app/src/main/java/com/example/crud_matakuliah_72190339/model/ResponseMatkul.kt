package com.example.crud_matakuliah_72190339.model

import com.google.gson.annotations.SerializedName

data class ResponseMatkul(

	@field:SerializedName("ResponseMatkul")
	val responseMatkul: List<ResponseMatkulItem?>? = null
)

data class ResponseMatkulItem(

	@field:SerializedName("hari")
	val hari: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("kode")
	val kode: String? = null,

	@field:SerializedName("sks")
	val sks: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("sesi")
	val sesi: String? = null
)
