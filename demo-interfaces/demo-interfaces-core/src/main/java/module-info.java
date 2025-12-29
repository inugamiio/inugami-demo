open module com.my.project.interfaces.core {
    requires io.inugami.framework.interfaces;
    requires lombok;
    requires org.mapstruct;
    requires org.slf4j;
    requires spring.context;
    requires spring.web;
    //
    requires com.my.project.api;
    requires com.my.project.interfaces.api;

    exports com.my.project.interfaces.core.domain.user;
    exports com.my.project.interfaces.core.domain.user.mapper;
}
