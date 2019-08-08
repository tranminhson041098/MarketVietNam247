package com.linearlayout.chototapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linearlayout.chototapp.Model.Data;
import com.linearlayout.chototapp.Model.ListChildCate;
import com.linearlayout.chototapp.R;
import com.squareup.picasso.Picasso;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    public Context context;
    public Data data;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_layout,viewGroup,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder viewHolder, int position) {

        final ListChildCate listChildCate = data.getListChildCate().get(position);
        Picasso.get().load(listChildCate.getUrlImage()).into(viewHolder.imgHome);
        viewHolder.tvHomeTitle.setText(listChildCate.getCateName());





    }

    @Override
    public int getItemCount() {
        return data.getListChildCate().size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgHome;
        TextView tvHomeTitle,tvSell;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHome = itemView.findViewById(R.id.img_category);
            tvHomeTitle=itemView.findViewById(R.id.tv_category);


        }
    }
}
