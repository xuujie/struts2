package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

public class FilterConfig {

    @Bean
    @Order(1)
    public FilterRegistrationBean<FilterDispatcher> dispatcherFilterRegistrationBean() {
        FilterRegistrationBean<FilterDispatcher> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new FilterDispatcher());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean<ActionContextCleanUp> cleanUpFilterRegistrationBean() {
        FilterRegistrationBean<ActionContextCleanUp> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new ActionContextCleanUp());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean
    @Order(3)
    public FilterRegistrationBean<PageFilter> pageFilterRegistrationBean() {
        FilterRegistrationBean<PageFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new PageFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
