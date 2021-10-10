package com.example.demo;

import com.example.demo.config.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ExtendWith(MockitoExtension.class)
class TaskProcessTest {

/*
    @Test
    public void taskWithDestroy(){
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        ctx.register(TaskConfig.class);
        ctx.refresh();

        Task task=ctx.getBean(Task.class);
        System.out.println(task.hashCode());

        Task task2=ctx.getBean(Task.class);
        System.out.println(task2.hashCode());

        ctx.close();
    }*/


    @Test
    public void createTask() {
        ConfigurableApplicationContext ctx  = new ClassPathXmlApplicationContext("taskbean.xml");

        Task task = (Task) ctx.getBean("taskId");
        task.setTitle("Spring Scope");
        task.setDescription("create a singleton scope");
        task.setAssign("Yusuf Beştaş");

        System.out.println("Task hascode=> " + task.hashCode() +
                " Task title=> " + task.getTitle() +
                " Task Description => " + task.getDescription() + " Assigned who =>" + task.getAssign());
        ctx.close();

    }

    @Test
    public void updateTask() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("taskbean.xml");

        Task task = (Task) ctx.getBean("taskId");
        System.out.println("Task hascode => " + task.hashCode());
        task.setTitle("Spring Scope task updated");
        task.setDescription("create a singleton scope updated");
        task.setAssign("Again Yusuf Beştaş");

        System.out.println( "Task hascode=> " + task.hashCode() +
                " Task title=> " + task.getTitle() +
                " Task Description => " + task.getDescription() + " Assigned who =>" + task.getAssign());

    }

}