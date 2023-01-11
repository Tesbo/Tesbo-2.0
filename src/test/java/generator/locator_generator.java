package generator;


import io.unity.framework.generators.locatorgenerator.EntryPoint;

public class locator_generator {
    public static void main(String[] args) {
        EntryPoint generator = new EntryPoint();
        generator.generate_locators("web");
    }
}
