package org.ricardogarfe.java;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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

  public Optional<Dish> maxCaloriesDish(List<Dish> menu) {

    Comparator<Dish> dishCaloriesComparator =
        Comparator.comparingInt(Dish::getCalories);
    Optional<Dish> mostCalorieDish =
        menu.stream()
            .collect(maxBy(dishCaloriesComparator));

    return mostCalorieDish;
  }

  public Optional<Dish> reduceMaxCaloriesDish(List<Dish> menu) {

    Optional<Dish> mostCalorieDish =
        menu.stream().collect(reducing(
            (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

    return mostCalorieDish;
  }

  public Integer totalCalories(List<Dish> menu) {
    int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
    return totalCalories;
  }

  public Integer reduceTotalCalories(List<Dish> menu) {

    int totalCalories = menu.stream().collect(reducing(
        0, Dish::getCalories, (i, j) -> i + j));
    return totalCalories;
  }

  public Double averageCalories(List<Dish> menu) {
    double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
    return avgCalories;
  }

  public IntSummaryStatistics summarizeMenu(List<Dish> menu) {

    IntSummaryStatistics menuStatistics =
        menu.stream().collect(summarizingInt(Dish::getCalories));
    return menuStatistics;
  }

  public String retrieveMenuNames(List<Dish> menu) {

    String menuNames = menu.stream().map(Dish::getName).collect(joining(", "));
    return menuNames;
  }

}