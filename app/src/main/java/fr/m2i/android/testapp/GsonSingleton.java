package fr.m2i.android.testapp;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import fr.m2i.android.testapp.service.RetroFitClient;
import retrofit2.Call;

public class GsonSingleton extends AsyncTask<String, Void, Description> {
    private static GsonSingleton instance = null;
    private Description description;

    public  Description getDescription() {
        return description;
    }

    private GsonSingleton() {

    }

    @Override
    protected Description doInBackground(String... strings) {
        Call<Description> information = RetroFitClient.getRetroFit().getInformation();

        try {
            return information.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final static GsonSingleton getInstance() {
        if (instance == null) {
            instance = new GsonSingleton();
            

        }
        return instance;
    }
    public void setDescriptionValues() {
        instance.execute();
        try {
            description = new Description();
            Description desc = instance.get();
            if(desc != null){
                description.setVille(desc.getVille());
                description.setPays(desc.getPays());
                description.setFormation(desc.getFormation());
                
            };
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
    }
}
