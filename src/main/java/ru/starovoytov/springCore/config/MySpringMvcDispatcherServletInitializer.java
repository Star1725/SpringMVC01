package ru.starovoytov.springCore.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {//этот метод не используется(возвращаем null)
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//метод задаёт нахождение Spring-кофигурации
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//все запросы от пользователя передаём на DispatcherServlet
    }
}
