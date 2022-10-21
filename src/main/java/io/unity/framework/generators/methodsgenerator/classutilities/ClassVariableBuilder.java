package io.unity.framework.generators.methodsgenerator.classutilities;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import org.tinylog.Logger;

public class ClassVariableBuilder {

    JavaClassSource javaClass;

    public ClassVariableBuilder(JavaClassSource javaClass) {
        this.javaClass = javaClass;
    }


    public void create_driver_class_variable() {
        Logger.info("Adding WebDriver Class variable");
        javaClass.addField()
                .setName("driver")
                .setType("WebDriver")
                .setLiteralInitializer("null");
    }

    public void create_element_class_variable() {
        Logger.info("Adding Element Class variable");
        javaClass.addField()
                .setName("element")
                .setType("Element")
                .setLiteralInitializer("null");
    }

    public void create_verify_class_variable() {
        Logger.info("Adding Verify Class variable");
        javaClass.addField()
                .setName("verify")
                .setType("Verify")
                .setLiteralInitializer("null");
    }



}
