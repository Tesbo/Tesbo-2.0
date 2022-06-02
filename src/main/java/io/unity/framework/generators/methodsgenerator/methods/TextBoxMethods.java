package io.unity.framework.generators.methodsgenerator.methods;


import org.jboss.forge.roaster.model.source.JavaClassSource;

public class TextBoxMethods {


    JavaClassSource java_class;
    String key_name;

    public TextBoxMethods(JavaClassSource java_class, String key_name) {
        this.java_class = java_class;
        this.key_name = key_name;
    }

    @MethodsData(method_id = "text_box_1")
    public void enter_text() {
        java_class.addMethod().
                setName("enter_text_at_" + key_name).
                setBody("element.enter_text(\"" + key_name + "\",text_to_enter);").
                setParameters("String text_to_enter").
                setPublic().
                addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "text_box_1");
    }

    @MethodsData(method_id = "text_box_2")
    public void clear_text_box() {
        java_class.addMethod().setName("clear_text_from_" + key_name).setBody("element.clear_text_field(\"" + key_name + "\");\n").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "text_box_2");

    }

    @MethodsData(method_id = "text_box_3")
    public void clear_and_enter_text_box() {
        java_class.addMethod().setName("clear_text_and_enter_text_in_" + key_name).setBody("element.clear_and_enter_in_text_field(\"" + key_name + "\",text_to_enter);").setParameters("String text_to_enter").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "text_box_3");
    }


    @MethodsData(method_id = "text_box_4")
    public void verify_text_box_is_present() {
        java_class.addMethod().setName("verify_" + key_name + "_is_present_on_page").setBody("verify.element_is_present(\"" + key_name + "\");").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "text_box_4");
    }


}
