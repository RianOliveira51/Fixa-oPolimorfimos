package com.example.fixacaopolimorfismo.entities;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UsedProduct extends  Product{
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufactureDate;

    public UsedProduct(String name, double price, Date manufactureDate){
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate(){
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate){
        this.manufactureDate = manufactureDate;
    }


    @Override
    public String priceTag(){
        return name + " (Used)" + "- $ " + price + " (Manufacture date: " + sdf.format(manufactureDate) + ")";
    }
}
