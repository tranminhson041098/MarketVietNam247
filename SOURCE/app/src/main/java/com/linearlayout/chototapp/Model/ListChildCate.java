package com.linearlayout.chototapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListChildCate {

@SerializedName("CateID")
@Expose
public String cateID;
@SerializedName("CateName")
@Expose
public String cateName;
@SerializedName("urlImage")
@Expose
public String urlImage;
@SerializedName("parent_id")
@Expose
public String parentId;
@SerializedName("tid")
@Expose
public Object tid;

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Object getTid() {
        return tid;
    }

    public void setTid(Object tid) {
        this.tid = tid;
    }
}