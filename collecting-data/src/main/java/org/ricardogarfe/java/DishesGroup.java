package org.ricardogarfe.java;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class DishesGroup {

  public Map<Dish.Type, List<Dish>> groupDishesByType(List<Dish> menu) {
    Map<Dish.Type, List<Dish>> dishesByType =
        menu.stream().collect(groupingBy(Dish::getType));

    return dishesByType;
  }
}
