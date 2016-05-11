package org.ricardogarfe.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
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
  }

  @Test
  public void testFindFirsThreeMultiple() throws Exception {
    Integer expectedFirstSquare = new Integer(9);
    List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    Optional<Integer> firstSquareDivisibleByThree = filterChapter.firstSquareDivisibleByThree(someNumbers);

    assertTrue("There is no square number divisible by three", firstSquareDivisibleByThree.isPresent());
    assertEquals("Is not correctly the first square number divisible by three", expectedFirstSquare, firstSquareDivisibleByThree.get());
  }
}