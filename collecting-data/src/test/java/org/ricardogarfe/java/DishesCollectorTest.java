package org.ricardogarfe.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class DishesCollectorTest {

  private final DishesUtil dishesUtil = new DishesUtil();
  private DishesCollector dishesCollector = new DishesCollector();


  @Test
  public void testCountDishes() throws Exception {

    long howManyDishesCollectors = dishesUtil.getMenu().stream().collect(counting());
    long howManyDishes = dishesUtil.getMenu().stream().count();

    Assert.assertEquals("Dishes result size different.", howManyDishesCollectors, howManyDishes);
  }

  @Test
  public void testMaxCaloriesDish() throws Exception {

    Optional<Dish> maxCaloriesDish = dishesCollector.maxCaloriesDish(dishesUtil.getMenu());
    Assert.assertTrue("There is no Dish on menu.", maxCaloriesDish.isPresent());
  }

  @Test
  public void testTotalCalories() throws Exception {

    Integer totalMenuCalories = dishesCollector.totalCalories(dishesUtil.getMenu());
    Assert.assertTrue("It's a menu without calories !", totalMenuCalories > 0);
  }

  @Test
  public void testAverageCalories() throws Exception {

    Double avgMenuCalories = dishesCollector.averageCalories(dishesUtil.getMenu());
    Assert.assertTrue("It's a menu without calories !", avgMenuCalories > 0);
  }

  @Test
  public void testSummarizeMenu() throws Exception {

    IntSummaryStatistics menuStatistics = dishesCollector.summarizeMenu(dishesUtil.getMenu());
    Assert.assertTrue("There aren't statistics on menu !", menuStatistics.getAverage() != 0);

    System.out.println("Menu stats:\t" + menuStatistics.toString());
  }

  @Test
  public void testRetrieveMenuNames() throws Exception {

    String menuNamesJoined = dishesCollector.retrieveMenuNames(dishesUtil.getMenu());
    Assert.assertTrue("Empty menu names! ", !menuNamesJoined.isEmpty());
  }
}
