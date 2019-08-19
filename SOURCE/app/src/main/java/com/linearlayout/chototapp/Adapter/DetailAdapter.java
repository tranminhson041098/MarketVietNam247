package com.linearlayout.chototapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.linearlayout.chototapp.Model.ListChildCate;
import com.linearlayout.chototapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.SuggestViewHolder> {


    public Context context;
    public List<ListChildCate> dataListChildCate;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDataListChildCate(List<ListChildCate> dataListChildCate) {
        this.dataListChildCate = dataListChildCate;
    }


    @NonNull
    @Override
    public SuggestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.suggest_item_layout,viewGroup,false);
        return new SuggestViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SuggestViewHolder viewHolder, int position) {
        ListChildCate listChildCate = dataListChildCate.get(position);
        viewHolder.tvSuggest.setText(listChildCate.getCateName());
        Picasso.get().load(listChildCate.getUrlImage()).into(viewHolder.imvSuggest);





    }

    @Override
    public int getItemCount() {
        return dataListChildCate.size();
    }

    public class SuggestViewHolder extends RecyclerView.ViewHolder {

        ImageView imvSuggest;
        TextView tvSuggest;

        public SuggestViewHolder(@NonNull View itemView) {
            super(itemView);
            imvSuggest = itemView.findViewById(R.id.imv_suggest);
            tvSuggest = itemView.findViewById(R.id.tv_title_suggest);
        }
    }
}
