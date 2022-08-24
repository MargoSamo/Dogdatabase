package com.mariia.homestuff;

public class Chair implements HomeStuff {

    private String name;
    private int usageRate;

    public Chair(int usageRate, String name) {
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
