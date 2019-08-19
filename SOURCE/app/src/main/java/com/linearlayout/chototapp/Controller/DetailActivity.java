package com.linearlayout.chototapp.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.linearlayout.chototapp.APIChotot.ChototService;
import com.linearlayout.chototapp.Adapter.DetailAdapter;
import com.linearlayout.chototapp.Model.Category;
import com.linearlayout.chototapp.Model.Data;
import com.linearlayout.chototapp.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    RecyclerView rvSuggest;
    Data data;

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


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://choviet247.vn/api/")
                .build();
        retrofit.create(ChototService.class).getListCategory().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                String strJson = null;
                try {
                    strJson = response.body().string();
                    Gson gson = new Gson();
                    data = gson.fromJson(strJson,Data.class);
                    LinearLayoutManager linearLayoutManager;
                    linearLayoutManager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.HORIZONTAL,false);
                    rvSuggest.setLayoutManager(linearLayoutManager);
                    DetailAdapter detailAdapter = new DetailAdapter();
                    detailAdapter.setContext(getBaseContext());
                    detailAdapter.setDataListChildCate(data.listChildCate);
                    rvSuggest.setAdapter(detailAdapter);

                    Toast.makeText(DetailActivity.this, "Lấy dữ liệu thành công", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(DetailActivity.this, "Lấy dữ liệu không thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
