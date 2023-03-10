package com.acerta.domain.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CategoryDomainTest {
  
  @Test
  public void testCreate() {
    String expectedName = "Category 1";

    CategoryDomain category = CategoryDomain.create(expectedName);

    assertNotNull(category);
    assertNotNull(category.getName());
    assertNotEquals(category.getName(), "");
    assertEquals(expectedName, category.getName());
    assertNotNull(category.getId());
    assertNotNull(category.getCreatedAt());
    assertNull(category.getUpdatedAt());
    assertNotEquals(category.getId(), "");
  }

  @Test
  public void testChangeName() {
    String expectedName = "Category 1";
    String expectedNewName = "Category 2";

    CategoryDomain category = CategoryDomain.create(expectedName);

    assertNotNull(category);
    assertNotNull(category.getName());
    assertNotEquals(category.getName(), "");
    assertEquals(expectedName, category.getName());
    assertNotNull(category.getId());
    assertNotNull(category.getCreatedAt());
    assertNull(category.getUpdatedAt());
    assertNotEquals(category.getId(), "");

    CategoryDomain category2 = CategoryDomain.with(category.getId(), category.getName(), category.getCreatedAt(), category.getUpdatedAt());
    category2.changeName(expectedNewName);

    assertNotNull(category.getName());
    assertNotEquals(category.getName(), "");
    assertEquals(expectedNewName, category2.getName());
    assertNotNull(category2.getId());
    assertNotNull(category2.getCreatedAt());
    assertNotNull(category2.getUpdatedAt());
    assertNotEquals(category2.getId(), "");
    assertEquals(category.getCreatedAt(), category2.getCreatedAt(), "CreatedAt should be the same");
    assertNotEquals(category.getUpdatedAt(), category2.getUpdatedAt(), "UpdatedAt should be different. " + category.getUpdatedAt() + " - " + category2.getUpdatedAt());
  }

  @Test
  public void testValidateNull() {
    String expectedName = null;

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> CategoryDomain.create(expectedName));
    assertNotNull(exception);
    assertEquals("Name is required", exception.getMessage());
  }

  @Test
  public void testValidateEmpty() {
    String expectedName = "";

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> CategoryDomain.create(expectedName));
    assertNotNull(exception);
    assertEquals("Name is required", exception.getMessage());
  }

}
