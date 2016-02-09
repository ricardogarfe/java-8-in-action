package org.ricardogarfe.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DishesGroupTest {

  private DishesGroup dishesGroup = new DishesGroup();
  private final DishesUtil dishesUtil = new DishesUtil();

  @Test
  public void testGroupDishesByType() throws Exception {

    Map<Dish.Type, List<Dish>> dishesByType = dishesGroup.groupDishesByType(dishesUtil.getMenu());
    Assert.assertTrue("Types are not correct", !dishesByType.isEmpty());
  }
}