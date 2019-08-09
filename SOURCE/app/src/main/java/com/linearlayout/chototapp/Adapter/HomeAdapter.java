package com.linearlayout.chototapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linearlayout.chototapp.Model.Category;
import com.linearlayout.chototapp.Model.Data;
import com.linearlayout.chototapp.Model.ListChildCate;
import com.linearlayout.chototapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    public List<Data> datahome;
    public Context context;

    public void setDatahome( List<Data> datahome ) {
        this.datahome = datahome;
    }

    public void setContext( Context context ) {
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_layout,viewGroup,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder viewHolder, int position) {
        /*News news = data.get(i);
        newsViewHolder.tvTitle.setText(news.getTitle());
        Picasso.get().load(news.getUrlImage()).into(newsViewHolder.imgBg);*/
        Data data=datahome.get( position );
        viewHolder.tvHomeTitle.setText( data.getCateName() );
        Picasso.get().load( data.getUrlImage() ).into( viewHolder.imgHome );
    }

    @Override
    public int getItemCount() {
        return datahome.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgHome;
        TextView tvHomeTitle;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHome = itemView.findViewById(R.id.img_category);
            tvHomeTitle=itemView.findViewById(R.id.tv_category);


        }
    }
}
