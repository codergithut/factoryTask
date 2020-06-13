package com.tianjian.factory.data.user;

public class DepartMentPo {

    /**
     * id
     */
    private String id;

    /**
     * 部门id
     */
    private String departMentName;

    /**
     * 部门描述
     */
    private String departDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartMentName() {
        return departMentName;
    }

    public void setDepartMentName(String departMentName) {
        this.departMentName = departMentName;
    }

    public String getDepartDesc() {
        return departDesc;
    }

    public void setDepartDesc(String departDesc) {
        this.departDesc = departDesc;
    }
}
