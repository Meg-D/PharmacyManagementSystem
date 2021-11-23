package com.iiitb.pharmacy.dto;

public class Password {
    private String username;
    private String old;
    private String newp;
    private String newp2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getNewp() {
        return newp;
    }

    public void setNewp(String newp) {
        this.newp = newp;
    }

    public String getNewp2() {
        return newp2;
    }

    public void setNewp2(String newp2) {
        this.newp2 = newp2;
    }
}
