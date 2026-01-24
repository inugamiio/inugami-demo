open module com.my.project.core {
    requires com.fasterxml.jackson.annotation;
    requires io.inugami.framework.commons.spring;
    requires io.inugami.framework.commons;
    requires io.inugami.framework.configurations.configuration;
    requires io.inugami.framework.api;
    requires io.inugami.framework.interfaces;
    requires io.inugami.monitoring.core;
    requires jakarta.annotation;
    requires jdk.compiler;
    requires lombok;
    requires org.jspecify;
    requires org.slf4j;
    requires spring.beans;
    requires spring.boot;
    requires spring.context;
    requires spring.tx;
    //
    requires com.my.project.api;
    requires annotations;
    requires org.apache.commons.text;
    //
    exports com.my.project.core.domain.user;
}
