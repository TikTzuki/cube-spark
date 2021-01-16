package org.hamsterbox.product.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Attribute
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Attributes {
  @Id
  private String id;
  @NonNull
  @Field(name = "short_description")
  private String shortDescription;
  @NonNull
  private String name;
  @NonNull
  private String description;
  @NonNull
  private String brand;

  public void test() {
    Attributes att = new Attributes("description", "name", "description", "brand");
  }

  public static void main(String[] args) {
    Attributes attr = new Attributes("shortDescription", "name", "description", "brand");

  }
}
