package com.qa.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// @RunWith(Suite.class)
@RunWith(Categories.class)
// @IncludeCategory(BadCategoryTest.class)
@Categories.ExcludeCategory(BadCategoryTest.class)
@Suite.SuiteClasses({
        Test05.class,
        Test04.class,
        Test03.class,
        Test02.class,
        Test01.class
})
public class ProteinTrackerSuite {
    
}
