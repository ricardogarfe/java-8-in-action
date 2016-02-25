package org.ricardogarfe.java;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamChapter {

    public List<String> filterDishesMenuByCaloriesJDK7(List<Dish> menu) {

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() > 300) {
                lowCaloricDishes.add(d);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();

        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }

        return lowCaloricDishesName;
    }


    public List<String> filterDishesMenuByCalories(List<Dish> menu) {

        List<String> lowCaloricDishesName = menu.stream()
                .filter(d -> {
                    System.out.println("filtering: " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping: " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(toList());

        return lowCaloricDishesName;
    }

    public List<Dish> filterVeganDishes(List<Dish> menu) {
        List<Dish> veganDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .distinct().collect(toList());

        return veganDishes;
    }

    public void consumeTwiceStreamThrowsException() {

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

    public List<String> filterUniqueCharsFromList(List<String> words) {

        return words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
    }
}
