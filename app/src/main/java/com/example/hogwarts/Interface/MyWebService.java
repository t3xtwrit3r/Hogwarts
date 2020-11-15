package com.example.hogwarts.Interface;

import com.example.hogwarts.Model.Characters;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MyWebService {
    String BASE_URL = "https://hp-api.herokuapp.com/";
    String FEED = "api/characters";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(FEED)
    Call<List<Characters>> getCharacters();
}
