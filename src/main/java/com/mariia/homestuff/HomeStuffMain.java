package com.mariia.homestuff;

import java.util.*;

/*
Создать 5 классов предметов реализующих интерфейс homeStaff
Создать 5 списков и положить в них эти элементы
Пройтись по каждому списку при помощи циклов for(;;), for(:), forEach, Iterator, stream
И передать каждый элемент в метод logUsage
И в конце вызвать reportUsage
 */

public class HomeStuffMain {

    private static final Map<Integer, Set<String>> homeStaffMap = new TreeMap<>();

    public static void main(String[] args) {


        // Create 10 lists of home stuff
        // iterate through them using 4 approaches (getIterator())
        // and logUsage
        // at the end reportUsage to show rating

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
