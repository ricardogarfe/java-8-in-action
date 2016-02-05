package org.ricardogarfe.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DishesCollector {

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
}