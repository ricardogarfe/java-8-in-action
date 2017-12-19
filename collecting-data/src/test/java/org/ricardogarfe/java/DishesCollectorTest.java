package org.ricardogarfe.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.Optional;

public class DishesCollectorTest {

    private final DishesUtil dishesUtil = new DishesUtil();
    private DishesCollector dishesCollector = new DishesCollector();


    @Test
    public void testCountDishes() {

        long howManyDishesCollectors = dishesUtil.getMenu().stream().count();
        long howManyDishes = dishesUtil.getMenu().stream().count();

        Assert.assertEquals("Dishes result size different.", howManyDishesCollectors, howManyDishes);
    }

    @Test
    public void testMaxCaloriesDish() {

        Optional<Dish> maxCaloriesDish = dishesCollector.maxCaloriesDish(dishesUtil.getMenu());
        Assert.assertTrue("There is no Dish on menu.", maxCaloriesDish.isPresent());
    }

    @Test
    public void testTotalCalories() {

        Integer totalMenuCalories = dishesCollector.totalCalories(dishesUtil.getMenu());
        Assert.assertTrue("It's a menu without calories !", totalMenuCalories > 0);
    }

    @Test
    public void testAverageCalories() {

        Double avgMenuCalories = dishesCollector.averageCalories(dishesUtil.getMenu());
        Assert.assertTrue("It's a menu without calories !", avgMenuCalories > 0);
    }

    @Test
    public void testSummarizeMenu() {

        IntSummaryStatistics menuStatistics = dishesCollector.summarizeMenu(dishesUtil.getMenu());
        Assert.assertTrue("There aren't statistics on menu !", menuStatistics.getAverage() != 0);

        System.out.println("Menu stats:\t" + menuStatistics.toString());
    }

    @Test
    public void testRetrieveMenuNames() {

        String menuNamesJoined = dishesCollector.retrieveMenuNames(dishesUtil.getMenu());
        Assert.assertTrue("Empty menu names! ", !menuNamesJoined.isEmpty());
    }
}
