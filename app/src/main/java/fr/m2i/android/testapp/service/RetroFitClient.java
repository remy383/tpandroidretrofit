package fr.m2i.android.testapp.service;

import fr.m2i.android.testapp.interf.Interface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static Interface getRetroFit() {
        return getClient(Interface.url).create(Interface.class);
    }
}
