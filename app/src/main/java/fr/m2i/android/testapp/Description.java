package fr.m2i.android.testapp;

import com.google.gson.annotations.SerializedName;

public class Description {
    @SerializedName("Ville")
    String ville;
    @SerializedName("Pays")
    String pays;
    @SerializedName("Formation")
    String formation;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

}

