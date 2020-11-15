package tik.test.cubespark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import tik.test.cubespark.repository.Product.SkuRepository;

@SpringBootApplication
public class Application {
		public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		//SkuRepository skuRepos = context.getBean(SkuRepository.class);
	}
}