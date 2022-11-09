package com.company;
import java.util.*;


public class Main {
public static void sortByName(List<City> cityList){
    Collections.sort(cityList,
            (City c1, City c2) -> {
                return c1.name.compareTo(c2.name);
            });}
public static void sortByDistrictAndName(List<City> cityList){
    Collections.sort(cityList, Comparator.comparing(City::getDistrict).thenComparing(City::getName));
}

public static int findMax(List<City> cityList){
    City[] cityArray = cityList.toArray(new City[0]);
    int max = 0;
    int idx = -1;
    for (int i = 0; i < cityArray.length; i++){
        if (cityArray[i].population > max){
            idx = i;
            max = cityArray[i].population;
        }
    }
   return  idx;
}

public static Map<String, Integer> getCut(List<City> cityList){
    Map<String, Integer> cut = new HashMap<>();
    for (City c : cityList){
        if (!cut.containsKey(c.region))
            cut.put(c.region, 0);
        cut.put(c.region, cut.get(c.region)+1);
    }
    return cut;
}
    public static void main(String[] args) {
        List<City> cityList;
        cityList = CityUtils.parse();
        Map<String, Integer> cut = getCut(cityList);
        for (String key : cut.keySet()){
            System.out.println(key + " : " + cut.get(key));
        }
    }
}
