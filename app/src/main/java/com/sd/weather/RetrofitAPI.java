package com.sd.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {

    //This is class is used to send requests to an API and Specify the URL that has the data.
    private static Retrofit retrofit = null;

    public static Retrofit getRetro(){
        if(retrofit == null){
            retrofit  = new Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
