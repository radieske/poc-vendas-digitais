package com.acerta.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.acerta.domain.category.CategoryDomain;

public class CategoryDomainTest {
  
  @Test
  public void testCreate() {
    String expectedName = "Category 1";

    CategoryDomain category = CategoryDomain.create(expectedName);

    assertNotNull(category);
    assertEquals(expectedName, category.getName());
    assertNotNull(category.getId());
    assertNotNull(category.getCreatedAt());
    assertNotNull(category.getUpdatedAt());
    assertNotEquals(category.getId(), "");
  }

  @Test
  public void testChangeName() {
    String expectedName = "Category 1";
    String expectedNewName = "Category 2";

    CategoryDomain category = CategoryDomain.create(expectedName);

    assertNotNull(category);
    assertEquals(expectedName, category.getName());
    assertNotNull(category.getId());
    assertNotNull(category.getCreatedAt());
    assertNotNull(category.getUpdatedAt());
    assertNotEquals(category.getId(), "");

    CategoryDomain category2 = CategoryDomain.with(category.getId(), category.getName(), category.getCreatedAt(), category.getUpdatedAt());
    category2.changeName(expectedNewName);

    assertEquals(expectedNewName, category2.getName());
    assertNotNull(category2.getId());
    assertNotNull(category2.getCreatedAt());
    assertNotNull(category2.getUpdatedAt());
    assertNotEquals(category2.getId(), "");
    assertEquals(category.getCreatedAt(), category2.getCreatedAt());
    assertNotEquals(category.getUpdatedAt(), category2.getUpdatedAt());
  }

  @Test
  public void testValidate() {
    String expectedName = "";

    CategoryDomain category = CategoryDomain.create(expectedName);

    assertNotNull(category);
    assertEquals("", category.getName());
    assertNotNull(category.getId());
    assertNotNull(category.getCreatedAt());
    assertNotNull(category.getUpdatedAt());
    assertNotEquals(category.getId(), "");

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ( ) -> category.validate());
    assertNotNull(exception);
    assertEquals("Name is required", exception.getMessage());

  }
}
