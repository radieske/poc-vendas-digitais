package com.acerta.domain.category;

import java.time.LocalDateTime;
import java.util.UUID;

public class CategoryDomain {
  
  private String id;
  private String name;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private CategoryDomain(String id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public static CategoryDomain create(String name) {
    String id = UUID.randomUUID().toString();
    LocalDateTime now = LocalDateTime.now();

    return new CategoryDomain(id, name, now, now);
  }

  public static CategoryDomain with(String id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
    return new CategoryDomain(id, name, createdAt, updatedAt);
  }

  public void changeName(String name) {
    this.name = name;
    this.updatedAt = LocalDateTime.now();
  }

  public void validate() {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name is required");
    }
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

}
