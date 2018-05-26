package com.example.darkdans.apiweather.API;
import com.example.darkdans.apiweather.API.Deserializers.MyDeserializer;
import com.example.darkdans.apiweather.Models.City;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class API {

    public static final String BASE_URL =
            "http://api.openweathermap.org/data/2.5/";
    public static final String BASE_ICONS =
            "http://openweathermap.org/img/w/";
    public static final String EXTENSION_ICONS =
            ".png";

    private static Retrofit retrofit = null;

    public static final String APPKEY = "59de380560e354b59a6b5655c8e1a01d";



    public static Retrofit getApi(){
        if (retrofit == null) {

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(City.class,
                    new MyDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory
                            .create(builder.create()))
                    .build();
        }
        return retrofit;
    }

}
