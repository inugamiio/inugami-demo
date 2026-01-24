open module com.my.project.api {
    requires lombok;
    requires jdk.compiler;
    requires org.jspecify;
    requires io.inugami.framework.interfaces;

    exports com.my.project.api.domain.user;
    exports com.my.project.api.domain.user.dto;
    exports com.my.project.api.domain.user.exception;
    exports com.my.project.api.domain.weather;
    exports com.my.project.api.domain.weather.dto;
    exports com.my.project.api.domain.weather.exception;
}
