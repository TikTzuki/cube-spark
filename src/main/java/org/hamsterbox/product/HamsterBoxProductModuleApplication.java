package org.hamsterbox.product;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.mongodb.client.MongoClients;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamsterbox.product.model.Attributes;
import org.hamsterbox.product.model.Category;
import org.hamsterbox.product.model.Product;
import org.hamsterbox.product.model.Sku;
import org.hamsterbox.product.repository.AttributesRepository;
import org.hamsterbox.product.repository.CategoryRepository;
import org.hamsterbox.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@SpringBootApplication
@EnableConfigurationProperties
public class HamsterBoxProductModuleApplication implements CommandLineRunner {
  private static final Log log = LogFactory.getLog(HamsterBoxProductModuleApplication.class);
  @Autowired
  AttributesRepository attributesRepository;
  @Autowired
  CategoryRepository categoryRepository;
  @Autowired
  ProductRepository productRepository;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(HamsterBoxProductModuleApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss Z");
    Attributes attributes = new Attributes("this is short description", "Product name", "this description", "No Brand");
    Category category = new Category("category name");
    Sku sku1 = new Sku("shop sku", "", 10, 10, "color family", "10", "10", "30", "20", "20", new BigDecimal(20000),
        new BigDecimal(19000), formater.parse("2020-02-02 00-00-00 +0700"), formater.parse("2020-01-01 00-00-00 +0700"),
        "status");
    Sku sku2 = new Sku("shop sku", "", 10, 10, "color family", "10", "10", "30", "20", "20", new BigDecimal(20000),
        new BigDecimal(19000), formater.parse("2021-02-02 00-00-00 +0700"), formater.parse("2021-01-01 00-00-00 +0700"),
        "status");
    Product pro = new Product(category, attributes, new ArrayList<Sku>(Arrays.asList(sku1, sku2)));

    System.out.println(pro);
    System.out.println(
        "---------------------" + formater.format(pro.getSkus().get(1).getSpecialToTime()) + "-----------------------");
    // productRepository.findAll().forEach(System.out::println);
    // Attributes te = new Attributes("short", "name", "des", "brand");
    // System.out.println(te.toString());
    // MongoOperations mongoOps = new MongoTemplate(new
    // SimpleMongoClientDatabaseFactory(MongoClients.create(), "todo"));

    // mongoOps.findAll(Product.class).forEach((product) -> {
    // log.info(product);
    // });
  }

}
