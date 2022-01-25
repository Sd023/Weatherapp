package com.sd.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView weatherOut;
    EditText countryInput;
    Button search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherOut = findViewById(R.id.weatherOut);
        countryInput = findViewById(R.id.countryInput);
        search = findViewById(R.id.searchButton);

        search.setOnClickListener(v -> {

            getWeatherData(countryInput.getText().toString().trim());

        });
    }

    private void getWeatherData(String location){

      RetrofitInterface inter = RetrofitAPI.getRetro().create(RetrofitInterface.class);

        Call<Weather> weatherData = inter.getWeather(location);
        weatherData.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {

                weatherOut.setText(response.body().getMain().getTemp());

            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Cannot Fetch Location", Toast.LENGTH_SHORT).show();


            }
        });

    }
}