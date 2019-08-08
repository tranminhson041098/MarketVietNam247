package com.linearlayout.chototapp.APIChotot;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ChototService  {
    // khai báo tên API , kiểu , dữ liệu truyền lên, dữ liệu trả về

    @GET("GetCategory")
    Call<ResponseBody> getListCategory();
}
