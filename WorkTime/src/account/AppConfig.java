package account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("account")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	// add css to project
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/style/**")
				.addResourceLocations("/style/");
		registry.addResourceHandler("/fonts/**")
				.addResourceLocations("/fonts/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	@Bean
	public EntityManager entityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("AccountingJPA");
		return emf.createEntityManager();
	}

	@Bean
	public AccountDAO accDAO() {
		return new AccountDAOImpl();
	}

	@Bean
	public Map<String, Object> registerMap() {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("roles", new ArrayList<Role>());
		res.put("errors", "");

		return res;
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
}
