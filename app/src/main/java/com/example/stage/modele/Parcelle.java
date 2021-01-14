package com.example.stage.modele;

public class Parcelle {

    private float surface;
    private String typeSol;
    private String culture;
    private String travailSol;
    private String Semis;
    private String compost;
    private String engrais;
    private String phytos;
    private Integer IFT;
    private Integer coupe1, coupe2, coupe3, coupe4;
    private Integer botteT;
    private float poidsBotte;
    private float kgTotal;
    private float tauxMS;
    private float MSR;
    private float RMS;


    /*public Parcelle(float surface, String typeSol, String culture, String travailSol, String semis, String compost, String engrais, String phytos, Integer IFT, Integer coupe1, Integer coupe2, Integer coupe3, Integer botteT, float poidsBotte, float kgTotal, float tauxMS, float MSR, float RMS) {
        this.surface = surface;
        this.typeSol = typeSol;
        this.culture = culture;
        this.travailSol = travailSol;
        this.Semis = semis;
        this.compost = compost;
        this.engrais = engrais;
        this.phytos = phytos;
        this.IFT = IFT;
        this.coupe1 = coupe1;
        this.coupe2 = coupe2;
        this.coupe3 = coupe3;
        this.botteT = botteT;
        this.poidsBotte = poidsBotte;
        this.kgTotal = kgTotal;
        this.tauxMS = tauxMS;
        this.MSR = MSR;
        this.RMS = RMS;
    }*/

    public float getSurface() {
        return surface;
    }

    public String getTypeSol() {
        return typeSol;
    }

    public String getCulture() {
        return culture;
    }

    public String getTravailSol() {
        return travailSol;
    }

    public String getSemis() {
        return Semis;
    }

    public String getCompost() {
        return compost;
    }

    public String getEngrais() {
        return engrais;
    }

    public String getPhytos() {
        return phytos;
    }

    public Integer getIFT() {
        return IFT;
    }

    public Integer getCoupe1() {
        return coupe1;
    }

    public Integer getCoupe2() {
        return coupe2;
    }

    public Integer getCoupe3() {
        return coupe3;
    }

    public Integer getBotteT() {
        return botteT;
    }

    public float getPoidsBotte() {
        return poidsBotte;
    }

    public float getKgTotal() {
        return kgTotal;
    }

    public float getTauxMS() {
        return tauxMS;
    }

    public float getMSR() {
        return MSR;
    }

    public float getRMS() {
        return RMS;
    }



    /*public void setBotteT(Integer botteT) {
        this.botteT = botteT;
    }*/

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

