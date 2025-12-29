open module com.my.project.interfaces.feign {
    requires com.my.project.interfaces.api;
    requires feign.core;
    requires feign.jackson;
    requires feign.okhttp;
    requires io.inugami.framework.commons.spring;
    requires io.inugami.framework.interfaces;
    requires io.inugami.monitoring.springboot;
    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires spring.cloud.openfeign.core;
    requires spring.context;

    exports com.my.project.interfaces.feign;
}
