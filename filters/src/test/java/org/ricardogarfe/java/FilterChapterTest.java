package org.ricardogarfe.java;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FilterChapterTest {

  private final FilterChapter filterChapter = new FilterChapter();
  private final DishesUtil dishesUtil = new DishesUtil();

  @Test
  public void testCheckMenuVeganFriendy() throws Exception {
    Boolean isVegan = filterChapter.checkMenuVeganFriendly(dishesUtil.getMenu());
    assertTrue("The menu is not (somewhat) vegetarian friendly!!", isVegan);
  }
}
