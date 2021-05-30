package com.brieflee.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@ComponentScan(
        basePackages = {"com.brieflee"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.brieflee\\..*launcher\\..*")
        }
)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class })
public class BriefleeLauncher {

    public static final String APP_ROOT = "/brieflee";

    public static void main(String[] args) {
        SpringApplication.run(BriefleeLauncher.class, args);
    }

    @Bean
    public ServletRegistrationBean configApi() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(BriefleeConfig.class);
        dispatcherServlet.setApplicationContext(applicationContext);
        ServletRegistrationBean<?> servletRegistrationBean = new ServletRegistrationBean<>(
                dispatcherServlet,
                APP_ROOT + "/u/*");
        servletRegistrationBean.setName("BriefLee");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;

    }
}
