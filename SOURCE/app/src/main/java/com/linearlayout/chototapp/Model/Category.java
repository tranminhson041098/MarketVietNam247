package com.linearlayout.chototapp.Model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Serializable {

    @SerializedName("CateID")
    @Expose
    public Integer cateID;
    @SerializedName("CateName")
    @Expose
    public String cateName;
    @SerializedName("urlImage")
    @Expose
    public String urlImage;
    @SerializedName("ListChildCate")
    @Expose
    public List<ListChildCate> listChildCate = null;

    @SerializedName("ListPost")
    @Expose
    public List<Object> listPost = null;
    @SerializedName("ListFilter")
    @Expose
    public List<Filter> listFilter = null;

    public Integer getCateID() {
        return cateID;
    }

    public void setCateID(Integer cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public List<ListChildCate> getListChildCate() {
        return listChildCate;
    }

    public void setListChildCate(List<ListChildCate> listChildCate) {
        this.listChildCate = listChildCate;
    }
}