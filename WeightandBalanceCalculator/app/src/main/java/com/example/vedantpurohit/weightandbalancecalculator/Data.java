package com.example.vedantpurohit.weightandbalancecalculator;


public class Data {
    private String subTitle;
    private int weight;
    private int arm;
    private int moment;

    Data (String fTitle, int fWeight, int fArm, int fMoment){
        this.subTitle = fTitle;
        this.weight = fWeight;
        this.arm = fArm;
        this.moment = fMoment;
    }

    public String getSubTitle(){
        return subTitle;
    }

    public void setSubTitle(String newTitle){
        subTitle = newTitle;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int newWeight){
        weight = newWeight;
    }

    public int getArm(){
        return arm;
    }

    public void setArm(int newArm){
        arm = newArm;
    }

    public int getMoment(){
        return moment;
    }

    public void setMoment(int newMoment){
        moment = newMoment;
    }
}
