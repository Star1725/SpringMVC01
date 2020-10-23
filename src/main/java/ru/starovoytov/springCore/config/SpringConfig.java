package ru.starovoytov.springCore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("ru.starovoytov.springCore")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {//этот интерфейс реализуется, когда настраиваем по себя SpringMVC(хотим вместо default шаблонизатора использовать Thymeleaf)

    private final ApplicationContext context;
    @Autowired//c помощью аннотации внедряем context
    public SpringConfig(ApplicationContext context) {
        this.context = context;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){//метод для настройки Thymeleaf
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(context);
        templateResolver.setPrefix("/WEB-INF/views/");//здесь будут лежать наши представления
        templateResolver.setSuffix(".html");//формат наших представлений
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){//метод конфигурирования наших представлений
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {//d этом методе задаём шаблонизатор и говорим Spring, что хотим использовать его
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        registry.viewResolver(viewResolver);
    }
}
