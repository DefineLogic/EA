package edu.miu.cs544.kamal.service;

public class DatabaseConnection {

    private String dbUrl;

    public DatabaseConnection(){
    }

    public void connect(){
        System.out.println("Connected to "+ dbUrl);
        disconnect();
    }

    public void disconnect(){
        System.out.println("Disconnecting ............");
    }
    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }
}
