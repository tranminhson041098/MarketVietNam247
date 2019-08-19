package com.linearlayout.chototapp.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filter {

@SerializedName("propertyid")
@Expose
public Integer propertyid;
@SerializedName("name")
@Expose
public String name;
@SerializedName("type")
@Expose
public String type;
@SerializedName("option")
@Expose
public List<Option> option = null;

}