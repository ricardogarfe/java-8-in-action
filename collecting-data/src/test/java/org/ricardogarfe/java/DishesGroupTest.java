package org.ricardogarfe.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DishesGroupTest {

    private final DishesUtil dishesUtil = new DishesUtil();
    private DishesGroup dishesGroup = new DishesGroup();

    @Test
    public void testGroupDishesByType() {

        Map<Dish.Type, List<Dish>> dishesByType = dishesGroup.groupDishesByType(dishesUtil.getMenu());
        Assert.assertTrue("Types are not correct", !dishesByType.isEmpty());
    }

    @Test
    public void testGroupDishesByCaloricLevel() {
        Map<DishesGroup.CaloricLevel, List<Dish>> dishesByCaloricLevel = dishesGroup.groupDishesByCaloricLevel(dishesUtil.getMenu());
        Assert.assertTrue("Caloric levels are not correct", !dishesByCaloricLevel.isEmpty());

        dishesByCaloricLevel.forEach((level, list) -> {
            System.out.println(level);
            list.stream().map(Dish::getName).forEach(System.out::println);
        });
    }

    @Test
    public void testGroupByMostCaloricByType() {

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = dishesGroup.groupByMostCaloricByType(dishesUtil.getMenu());
        Assert.assertTrue("Most caloric types don't exist", !mostCaloricByType.isEmpty());
        mostCaloricByType.forEach((type, optional) -> {
            System.out.println("Type:\t" + type);
            System.out.println("Name:\t" + optional.get().getName());
        });
    }
}