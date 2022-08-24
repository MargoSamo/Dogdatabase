package com.mariia.homestuff;

//Cup
//chair
//Toothbrush
//laptop
//fridge

public class Cup implements HomeStuff {

    private String name;
    private int usageRate;

    public Cup(int usageRate, String name) {
        this.name = name;
        this.usageRate = usageRate;
    }

    public String getName()
    {
        return this.name;
    }

    public int getUsageRate()
    {
        return this.usageRate;
    }

}
