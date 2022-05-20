package generators;

import io.unity.EntryPoint;

public class unity_locator_generator {
    public static void main(String[] args) {
        EntryPoint class_object = new EntryPoint();
        class_object.generate_locators();
    }
}
