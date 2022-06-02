package io.unity.framework.generators.methodsgenerator.methods;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public class TextAreaMethods {

    JavaClassSource java_class;
    String key_name;

    public TextAreaMethods(JavaClassSource java_class, String key_name) {
        this.java_class = java_class;
        this.key_name = key_name;
    }

    @MethodsData(method_id = "text_area_1")
    public void verify_text()
    {
        java_class.addMethod().setName("verify_" + key_name + "_text_is_equal_to").setBody("verify.element_text_is_equal_to(\""+key_name+"\",button_text);").setParameters("String button_text").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id","text_area_1");
    }





}
