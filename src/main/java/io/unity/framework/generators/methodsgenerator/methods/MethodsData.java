package io.unity.framework.generators.methodsgenerator.methods;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MethodsData {
    String method_id();
}
