package com.kingwag.sqlitereview;

/**
 * Created by kingwag on 2016/11/24.
 */

public class Student {
    private int id;
    private String name;

    public Student( String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
