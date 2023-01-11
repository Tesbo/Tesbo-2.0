package generator;

import io.unity.framework.generators.methodsgenerator.init.EntryPoint;

public class method_generator {
    public static void main(String[] args) {
        EntryPoint generator = new EntryPoint();
        generator.generate("web");

    }
}
