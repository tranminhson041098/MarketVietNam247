package com.linearlayout.chototapp.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.linearlayout.chototapp.APIChotot.ChototService;
import com.linearlayout.chototapp.APIChotot.RetrofitClient;
import com.linearlayout.chototapp.Adapter.DetailAdapter;
import com.linearlayout.chototapp.Model.Category;
import com.linearlayout.chototapp.Model.GetCateByIDResponse;
import com.linearlayout.chototapp.Model.GetCateResponse;
import com.linearlayout.chototapp.R;

import java.io.IOException;
import java.lang.reflect.Array;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    TextView tvTitle;
    RecyclerView rvSuggest;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
        getData();
    }

    void init() {
        tvTitle = findViewById(R.id.tv_title);
        rvSuggest = findViewById(R.id.rv_suggest);
    }

    void getData() {
        Category category = (Category) getIntent().getSerializableExtra("Category");
        int id = category.getCateID();

        RetrofitClient.getRetrofitClient().create(ChototService.class)
                .getPostByCategoryID(id, "[]", 1, 50)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String strJson = null;
                        try {
                            strJson = response.body().string();
                            Gson gson = new Gson();
                            GetCateByIDResponse getCateResponse = gson.fromJson(strJson, GetCateByIDResponse.class);
                            Log.d("", "onResponse: ");

                            //


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("", "onResponse: ");
                    }
                });

    }
}
