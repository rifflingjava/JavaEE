package org.j2eetest.bean;


public class DatabaseManager {

    private final static DatabaseManager instance = new DatabaseManager();

    public final static DatabaseManager getInstance() {

        return instance;
    }

    public final static Database getDatabase(DatabaseType dbType) {

        Database database = null;
        switch (dbType) {
            case ORACLE:
                database = new OracleDatabase();
                break;

        }

        return database;
    }

}
