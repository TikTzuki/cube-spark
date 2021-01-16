package org.hamsterbox.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Category
 */
@Document(collection = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Category {
  @Id
  private String id;
  @NonNull
  @Field(name = "category_name")
  private String categoryName;
}
