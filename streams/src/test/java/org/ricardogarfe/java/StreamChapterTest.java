package org.ricardogarfe.java;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StreamChapterTest {

    private StreamChapter streamChapter = new StreamChapter();

    private List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

/*    @Test
    public void testConsumeStream() {

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);

        assertTrue(true);
    }*/

    @Test
    public void testFilterDishesMenuByCaloriesJDK7() throws Exception {

        List<String> filterDishesResult = streamChapter.filterDishesMenuByCaloriesJDK7(menu);
        assertTrue("There aren't Caloric Dishes on the menu.", !filterDishesResult.isEmpty());

    }

    @Test
    public void testFilterDishesMenuByCalories() throws Exception {

        List<String> filterDishesResult = streamChapter.filterDishesMenuByCalories(menu);
        assertTrue("There aren't Caloric Dishes on the menu.", !filterDishesResult.isEmpty());

    }


    @Test
    public void testFilterVeganDishes() throws Exception {

        List<Dish> veganDishes = streamChapter.filterVeganDishes(menu);

        assertTrue("There aren't Vegan Dishes on the menu.", !veganDishes.isEmpty());

        veganDishes.forEach(dish -> System.out.println(dish.getName()));
    }


}