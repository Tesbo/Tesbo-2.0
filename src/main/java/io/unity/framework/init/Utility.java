package io.unity.framework.init;

import java.util.Random;

public class Utility {
    private static final int MIN_PORT = 3501;  // minimum port number
    private static final int MAX_PORT = 10000; // maximum port number

    public int generateRandomPort() {
        Random rand = new Random();
        int port = rand.nextInt(MAX_PORT - MIN_PORT + 1) + MIN_PORT;
        System.out.println("************************"+port);
        return port;
    }
}
