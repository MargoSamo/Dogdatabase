package com.mariia.homestuff;

public class Toothbrush implements HomeStuff {

    private String name;
    private int usageRate;

    public Toothbrush (int usageRate, String name) {
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
