package com.mariia.homestuff;

public class Laptop implements HomeStuff {

    private String name;
    private int usageRate;

    public Laptop (int usageRate, String name) {
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
