package edu.miu.cs544.programmingtest2.service;


public class FileLogger implements Logger {

    public void log(String message) {
        System.out.println("File : "+message);
    }
}
