package com.kingwag.review2;

import java.util.List;

/**
 * Created by kingwag on 2016/11/20.
 */

public class MyGroup {
    String name;
    List<MyChild> childList;

    public MyGroup(List<MyChild> childList, String name) {
        this.childList = childList;
        this.name = name;
    }

    public List<MyChild> getChildList() {
        return childList;
    }

    public void setChildList(List<MyChild> childList) {
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
