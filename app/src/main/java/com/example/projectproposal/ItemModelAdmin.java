package com.example.projectproposal;

import java.io.Serializable;

public class ItemModelAdmin implements Serializable {

    String name;
    String objId;


    public ItemModelAdmin(String name, String objId) {
        this.name = name;
        this.objId = objId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

