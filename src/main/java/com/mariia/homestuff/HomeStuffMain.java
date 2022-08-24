package com.mariia.homestuff;

import java.util.*;

public class HomeStuffMain {

    private static final Map<Integer, Set<String>> homeStaffMap = new TreeMap<>();

    public static void main(String[] args) {
        Cup cup = new Cup(5, "Cup");
        List<Cup> cups = new ArrayList<Cup>();
        cups.add(cup);
        for (int i = 0; i < cups.size(); i++) {
            Cup cupsPrint = cups.get(i);
            System.out.println(cupsPrint);
            logUsage(cupsPrint);
        }

        Chair chair = new Chair(10, "Chair");
        List<Chair> chairs = new ArrayList<>();
        chairs.add(chair);
        for (Chair ch: chairs) {
            System.out.println(ch);
            logUsage(ch);
        }

        Toothbrush toothbrush = new Toothbrush(2, "Toothbrush");
        List<Toothbrush> toothbrushes = new ArrayList<>();
        toothbrushes.add(toothbrush);
        toothbrushes.forEach((s) -> {
            logUsage(s);
        });

        Laptop laptop = new Laptop(20, "Lenovo Laptop");
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop);
        Iterator<Laptop> itr = laptops.iterator();
        while (itr.hasNext()) {
            Laptop laptopPrint = itr.next();
            logUsage(laptopPrint);
        }

        reportUsage();

        // Create 10 lists of home stuff
        // iterate through them using 4 approaches (getIterator())
        // and logUsage
        // at the end reportUsage to show rating

        for (Map.Entry<Integer, Set<String>> entry : homeStaffMap.entrySet()) {
            System.out.println("Key - UsageRate =  " + entry.getKey() + " Name = " + entry.getValue());
        }
        System.out.println();

        Iterator<Map.Entry<Integer, Set<String>>> entries = homeStaffMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Set<String>> entry = entries.next();
            System.out.println("Key - UsageRate = " + entry.getKey() + " Name = " + entry.getValue());
        }
        System.out.println();

        for (Integer key : homeStaffMap.keySet()) {
            System.out.println("Key = " + key + ", Name = " +  homeStaffMap.get(key));
        }
        System.out.println();

        homeStaffMap.forEach((key, value) -> {
            System.out.println("Hi" + key + " " + value);
        });

    }

    private static void logUsage(HomeStuff homeStuff) {
        Set<String> staffList = homeStaffMap.get(homeStuff.getUsageRate());
        if (staffList != null) {
            staffList.add(homeStuff.getName());
        } else {
            Set<String> newSet = new HashSet<String>();
            newSet.add(homeStuff.getName());
            homeStaffMap.put(homeStuff.getUsageRate(), newSet);
        }
    }
    private static void reportUsage() {
        System.out.println(homeStaffMap);
    }
}
