package com.ponxu.test;

/**
 * @author ponxu
 * @date 2018-08-01
 */
public class Greeting {
    private int port;
    private String message;

    public Greeting() {
    }

    public Greeting(int port, String message) {
        this.port = port;
        this.message = message;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
