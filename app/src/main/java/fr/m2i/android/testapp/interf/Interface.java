package fr.m2i.android.testapp.interf;


import fr.m2i.android.testapp.Description;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Interface {
    String url = "https://api.npoint.io/";

    @GET("f16e35efd7973ed20708")
    Call<Description> getInformation();
}