package com.linearlayout.chototapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.linearlayout.chototapp.APIChotot.ChototService;
import com.linearlayout.chototapp.Adapter.HomeAdapter;
import com.linearlayout.chototapp.Model.Category;
import com.linearlayout.chototapp.Model.Data;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    View vRoot;
    RecyclerView rvHomeFragment;

    public HomeFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRoot = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        getdata();
        return vRoot;
    }

    void init() {
        rvHomeFragment = vRoot.findViewById(R.id.rv_news);
    }

    void getdata() {
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
                    Data data = gson.fromJson(strJson, Data.class);
                    rvHomeFragment.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    HomeAdapter adapter = new HomeAdapter();
                    adapter.setContext(getContext());
                    adapter.setData(data);
                    rvHomeFragment.setAdapter(adapter);
                    Toast.makeText(getContext(), "Everything is done", Toast.LENGTH_SHORT).show();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Không thể kết nối dữ liệu", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
