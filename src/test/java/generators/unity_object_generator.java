package generators;


import io.unity.framework.generators.methodsgenerator.init.EntryPoint;

public class unity_object_generator {

    public static void main(String[] args) {
        EntryPoint class_object = new EntryPoint();
        class_object.generate("web");
    }


}
