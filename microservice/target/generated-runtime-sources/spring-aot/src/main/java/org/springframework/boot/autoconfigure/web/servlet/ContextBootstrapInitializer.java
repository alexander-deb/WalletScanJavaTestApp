package org.springframework.boot.autoconfigure.web.servlet;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.web.servlet.DispatcherServlet;

public final class ContextBootstrapInitializer {
  public static void registerServletWebServerFactoryConfiguration_EmbeddedTomcat(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat", ServletWebServerFactoryConfiguration.EmbeddedTomcat.class)
        .instanceSupplier(ServletWebServerFactoryConfiguration.EmbeddedTomcat::new).register(beanFactory);
  }

  public static void registerEmbeddedTomcat_tomcatServletWebServerFactory(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("tomcatServletWebServerFactory", TomcatServletWebServerFactory.class).withFactoryMethod(ServletWebServerFactoryConfiguration.EmbeddedTomcat.class, "tomcatServletWebServerFactory", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ServletWebServerFactoryConfiguration.EmbeddedTomcat.class).tomcatServletWebServerFactory(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }

  public static void registerDispatcherServletAutoConfiguration_DispatcherServletConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration", DispatcherServletAutoConfiguration.DispatcherServletConfiguration.class)
        .instanceSupplier(DispatcherServletAutoConfiguration.DispatcherServletConfiguration::new).register(beanFactory);
  }

  public static void registerDispatcherServletConfiguration_dispatcherServlet(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("dispatcherServlet", DispatcherServlet.class).withFactoryMethod(DispatcherServletAutoConfiguration.DispatcherServletConfiguration.class, "dispatcherServlet", WebMvcProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(DispatcherServletAutoConfiguration.DispatcherServletConfiguration.class).dispatcherServlet(attributes.get(0)))).register(beanFactory);
  }

  public static void registerDispatcherServletAutoConfiguration_DispatcherServletRegistrationConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration", DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration.class)
        .instanceSupplier(DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration::new).register(beanFactory);
  }

  public static void registerDispatcherServletRegistrationConfiguration_dispatcherServletRegistration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("dispatcherServletRegistration", DispatcherServletRegistrationBean.class).withFactoryMethod(DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration.class, "dispatcherServletRegistration", DispatcherServlet.class, WebMvcProperties.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(DispatcherServletAutoConfiguration.DispatcherServletRegistrationConfiguration.class).dispatcherServletRegistration(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }

  public static void registerHttpEncodingAutoConfiguration_localeCharsetMappingsCustomizer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("localeCharsetMappingsCustomizer", HttpEncodingAutoConfiguration.LocaleCharsetMappingsCustomizer.class).withFactoryMethod(HttpEncodingAutoConfiguration.class, "localeCharsetMappingsCustomizer")
        .instanceSupplier(() -> beanFactory.getBean(HttpEncodingAutoConfiguration.class).localeCharsetMappingsCustomizer()).register(beanFactory);
  }
}
