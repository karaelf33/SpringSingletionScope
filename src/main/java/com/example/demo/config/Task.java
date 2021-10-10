package com.example.demo.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Task implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet()
            throws Exception {
        System.out.println(
                "Bean SecondMethod has been "
                        + "instantiated and I'm the "
                        + "init() method");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println(
                "Container has been closed "
                        + "and I'm the destroy() method");
    }

    private String title;
    private String description;
    private String assign;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }
}
