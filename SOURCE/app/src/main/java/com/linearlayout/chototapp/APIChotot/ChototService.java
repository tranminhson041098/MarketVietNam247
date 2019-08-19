package com.linearlayout.chototapp.APIChotot;

import java.lang.reflect.Array;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ChototService {
    // khai báo tên API , kiểu , dữ liệu truyền lên, dữ liệu trả về

    @GET("GetCategory")
    Call<ResponseBody> getListCategory();

    @GET("GetPostByCategoryID")
    Call<ResponseBody> getPostByCategoryID(@Query("id") int id,
                                           @Query("ListFilter") String array,
                                           @Query("page") int page,
                                           @Query("perPage") int perPage

    );
}
