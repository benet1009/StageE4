package com.example.stage.modele;

public class Parcelle {


    private Integer botteT;
    private float kgTotal;
    private float MSR;
    private float RMS;


    public Integer getBotteT() {
        return botteT;
    }

    public float getKgTotal() {
        return kgTotal;
    }

    public float getMSR() {
        return MSR;
    }

    public float getRMS() {
        return RMS;
    }



    public void resultat1(Integer coupe1,Integer coupe2,Integer coupe3,Integer coupe4){
        this.botteT = coupe1 + coupe2 + coupe3 + coupe4;
    }

    public void resultat2(float poidsBotte){
        this.kgTotal = this.getBotteT() * poidsBotte;
    }

    public void resultat3(float tauxMS) {
        this.MSR = this.getKgTotal() * (tauxMS/100);
    }

    public void resultat4(float surface) {
        this.RMS = this.getMSR() / surface;
    }

}

