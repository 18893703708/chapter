package com.huyun.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

public class MapTreeDate implements Serializable {
    private static final long serialVersionUID = 1L;

    public String id;
    public String pid;

    public String name;
    public String state;
    public Attributes attributes;
    @JsonBackReference
    public List<MapTreeDate> children;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public List<MapTreeDate> getChildren() {
        return children;
    }

    public void setChildren(List<MapTreeDate> children) {
        this.children = children;
    }
}
