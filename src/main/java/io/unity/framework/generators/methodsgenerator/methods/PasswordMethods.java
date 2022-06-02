package io.unity.framework.generators.methodsgenerator.methods;


import org.jboss.forge.roaster.model.source.JavaClassSource;

public class PasswordMethods
{
    JavaClassSource java_class;
    String key_name;
    final static int total_password_methods = 4;

    public PasswordMethods(JavaClassSource java_class, String key_name) {
        this.java_class = java_class;
        this.key_name = key_name;
    }

    @MethodsData(method_id = "password_1")
    public void enter_password() {
        java_class.addMethod().
                setName("enter_password_at_" + key_name).
                setBody("element.enter_password(\"" + key_name + "\",password_to_enter);").
                setParameters("String password_to_enter").
                setPublic().
                addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "password_1");
    }

    @MethodsData(method_id = "password_2")
    public void clear_password() {
        java_class.addMethod().setName("clear_password_from_" + key_name).setBody("element.clear_password_field(\"" + key_name + "\");\n").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "password_2");

    }

    @MethodsData(method_id = "password_3")
    public void clear_and_enter_password() {
        java_class.addMethod().setName("clear_text_and_enter_password_in_" + key_name).setBody("element.clear_and_enter_in_password_field(\"" + key_name + "\",text_to_enter);").setParameters("String text_to_enter").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "password_3");
    }


    @MethodsData(method_id = "password_4")
    public void verify_password_is_present() {
        java_class.addMethod().setName("verify_" + key_name + "_is_present_on_page").setBody("verify.element_is_present(\"" + key_name + "\");").setPublic().addAnnotation(ButtonMethods.annotation_class).setStringValue("method_id", "password_4");
    }

}
