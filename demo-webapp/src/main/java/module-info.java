open module com.my.project.webapp {
    requires com.my.project.api;
    requires com.my.project.core;
    requires com.my.project.infrastructure;
    requires com.my.project.interfaces.api;
    requires com.my.project.interfaces.core;
    requires io.inugami.framework.api;
    requires io.inugami.framework.commons.spring.data;
    requires io.inugami.framework.commons.spring;
    requires io.inugami.framework.commons;
    requires io.inugami.framework.interfaces;
    requires io.inugami.monitoring.springboot;
    requires io.inugami.monitoring.sensors.defaults;
    requires io.inugami.monitoring.providers.logs;
    requires lombok;
    requires org.mapstruct;
    requires org.slf4j;
    requires org.springdoc.openapi.ui;
    requires org.springdoc.openapi.webmvc.core;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter.actuator;
    requires spring.boot.starter.tomcat;
    requires spring.boot;
    requires spring.context;
    requires org.jspecify;
    requires spring.tx;

}
