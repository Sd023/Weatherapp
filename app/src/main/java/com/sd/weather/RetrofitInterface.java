package com.sd.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    //Sending get request. Interface is used to point the endpoint where the info is stored.

    @GET("weather?&appid=90fa9575a441a703aa12f665783543b0&units=metric")
    Call<Weather> getWeather(@Query("q") String name);
    //Call<Weather> object used to return the information that we obtained.
}