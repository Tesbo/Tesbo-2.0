package io.unity.framework.server;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.unity.framework.runner.TestRunner;

public class Starter {
    public static final String run_test = "/run/{config_name}";

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7070);
        app.post(run_test, handleLoginPost);
    }


    public static Handler handleLoginPost = ctx -> {

        String currentConfig = ctx.pathParam("config_name");
        System.out.println("current Config" + currentConfig);
        String[] args = {"--config" , currentConfig};

        TestRunner runner = new TestRunner();
        runner.start(args);

    };

}
