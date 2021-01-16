package org.hamsterbox.product.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Sku
 */
@Document(collection = "sku")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Sku {
  @Id
  private String id;
  @NonNull
  @Field(name = "shop_sku")
  private String shopSku;
  @Field(name = "product_id")
  @NonNull
  private String productId;
  @NonNull
  private int available;
  @NonNull
  private int quantity;
  @Field(name = "color_family")
  @NonNull
  private String colorFamily;
  @NonNull
  private String size;
  @NonNull
  private String height;
  @NonNull
  private String width;
  @NonNull
  private String length;
  @NonNull
  private String weight;
  @NonNull
  private BigDecimal price;
  @Field(name = "special_price")
  @NonNull
  private BigDecimal specialPrice;
  @Field(name = "special_from_time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z", timezone = JsonFormat.DEFAULT_TIMEZONE)
  @NonNull
  private Date specialFromTime;
  @Field(name = "special_to_time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd HH:mm:ss Z", timezone = JsonFormat.DEFAULT_TIMEZONE)
  @NonNull
  private Date specialToTime;
  @NonNull
  private String status;

}
