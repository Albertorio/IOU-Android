package com.chamas.luis.iou;

public class items{
    private String name;
    private String price;

    public items(String name, String price){
        super();
        this.name = name;
        this.price = price;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setPrice(String newPrice){
        price = newPrice;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }
}