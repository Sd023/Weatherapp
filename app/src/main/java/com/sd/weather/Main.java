package com.sd.weather;

import com.google.gson.annotations.SerializedName;

public class Main {

    //fetching data from the

    @SerializedName("temp")
    String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
