package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class CityUtils {
    public static List<City> parse(){
        List<City> cityList = new ArrayList<>();
        File file = new File("city_ru.csv");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNext()){
                cityList.add(parse(in.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cityList;
    }
    public static City parse(String s){
        Scanner in = new Scanner(s);
        in.useDelimiter(";");
        in.skip("\\d*");
        String name = in.next();
        String region = in.next();
        String district = in.next();
        int population = in.nextInt();
        String foundation = null;
        if (in.hasNext())
            foundation = in.next();
        City city = new City(name, region, district, population, foundation);
        return city;
    }
}
