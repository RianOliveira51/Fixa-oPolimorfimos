package com.example.fixacaopolimorfismo.entities;

public class ImportedProduct extends Product{
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee){
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee(){
        return customsFee;
    }

    public void setCustomsFee(double customsFee){
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag(){
        return name + " - $ " + totalPrice(customsFee) +  " (Customs fee: $ " + customsFee + ")";
    }

    public double totalPrice(double customsFee){
        return price + customsFee;
    }


}
