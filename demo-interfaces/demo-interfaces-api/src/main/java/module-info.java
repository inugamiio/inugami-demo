open module com.my.project.interfaces.api {
    requires com.fasterxml.jackson.annotation;
    requires io.inugami.framework.interfaces;
    requires io.swagger.v3.oas.annotations;
    requires lombok;
    requires org.slf4j;
    requires spring.web;

    exports com.my.project.interfaces.api.domain.user;
    exports com.my.project.interfaces.api.domain.user.dto;
}
