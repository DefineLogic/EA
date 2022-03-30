package edu.miu.cs544.programmingtest2.service;

public class DbLogger implements Logger{

    public void log(String message) {
        System.out.println("Database : "+message);
    }
}
