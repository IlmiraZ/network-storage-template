package ru.gb.storage.client;

public class NetworkProperties {
    private static String host;
    private static int port;

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        NetworkProperties.host = host;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        NetworkProperties.port = port;
    }
}
