package org.ricardogarfe.java;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class FilterChapterTest {

  private final FilterChapter filterChapter = new FilterChapter();
  private final DishesUtil dishesUtil = new DishesUtil();

  @Test
  public void testCheckMenuVeganFriendy() throws Exception {
    Boolean isVegan = filterChapter.checkMenuVeganFriendly(dishesUtil.getMenu());
    assertTrue("The menu is not (somewhat) vegetarian friendly!!", isVegan);
  }

  @Test
  public void testCheckIsHealthyMenu() throws Exception {
    Boolean isHealthy = filterChapter.checkHealthyMenu(dishesUtil.getMenu());
    assertTrue("The menu is not Healthy !", isHealthy);
  }

  @Test
  public void testFindAnyVegetarianDish() throws Exception {
    Optional<Dish> anyVegetarian = filterChapter.findAnyVegetarianDish(dishesUtil.getMenu());
    assertTrue("There is not any vegetarian dish on menu", anyVegetarian.isPresent());
    anyVegetarian.ifPresent(dish -> System.out.println(dish.getName()));
  }

}