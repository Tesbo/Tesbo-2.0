package io.unity.framework.generators.methodsgenerator.methods;


import org.jboss.forge.roaster.model.source.JavaClassSource;

public class LinkMethods
{
    JavaClassSource java_class;
    String key_name;
    final static int total_button_methods = 4;

    
    
    
    public LinkMethods(JavaClassSource java_class, String key_name) {
        this.java_class = java_class;
        this.key_name = key_name;
    }

    @MethodsData(method_id = "link_1")
    public void verify_link_is_present() {
        java_class.addMethod().setName("verify_" + key_name + "_is_present_on_page").setBody(" verify.element_is_present(\"" + key_name + "\");").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id","link_1");
    }

    @MethodsData(method_id = "link_2")
    public void verify_link_text() {
        java_class.addMethod().setName("Verify_" + key_name + "_text_is_equal_to").setBody("verify.element_text_is_equal_to(\"" + key_name + "\",button_text);").setParameters("String button_text").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id","link_2");
    }

    @MethodsData(method_id = "link_3")
    public void verify_link_is_clickable() {
        java_class.addMethod().setName("verify_" + key_name + "_is_clickable").setBody("verify.element_is_enable(\"" + key_name + "\");").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id","link_3");
    }

    @MethodsData(method_id = "link_4")
    public void click_on_link() {
        java_class.addMethod().setName("click_on_" + key_name).setBody("element.click(\"" + key_name + "\");").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id","link_4");
    }




}
