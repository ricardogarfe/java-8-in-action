package org.ricardogarfe.java;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class DishesGroup {

    public Map<Dish.Type, List<Dish>> groupDishesByType(List<Dish> menu) {
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        return dishesByType;
    }

    public Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel(List<Dish> menu) {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
                menu.stream().collect(groupingBy(
                        dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }
                ));

        return dishesByCaloricLevel;
    }

    public Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupByTypeAndCaloricLevel(List<Dish> menu) {

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeAndCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(
                                        dish -> {
                                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                            else return CaloricLevel.FAT;
                                        }
                                )
                        ));

        return dishesByTypeAndCaloricLevel;
    }

    public Map<Dish.Type, Optional<Dish>> groupByMostCaloricByType(List<Dish> menu) {

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));

        return mostCaloricByType;
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}
}
