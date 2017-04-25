package com.hucet.batch.code.download

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface StockService {
    @FormUrlEncoded
    @POST("corpgeneral/corpList.do")
    fun downloadCodes(@Field("method") method: String): Call<ResponseBody>
}