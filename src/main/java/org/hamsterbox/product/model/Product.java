package org.hamsterbox.product.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Product
 */
@Document(collection = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
  @Id
  private String id;
  @DBRef
  @NonNull
  private Category category;
  @DBRef
  @NonNull
  private Attributes attributes;
  @DBRef
  @NonNull
  private List<Sku> skus;
}
