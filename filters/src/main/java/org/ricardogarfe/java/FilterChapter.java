package org.ricardogarfe.java;

import java.util.List;

public class FilterChapter {

  public boolean checkMenuVeganFriendly(List<Dish> menu) {
    return menu.stream().anyMatch(Dish::isVegetarian);
  }

  public Boolean checkHealthyMenu(List<Dish> menu) {
    return menu.stream()
        .allMatch(d -> d.getCalories() < 1000);
  }
}
