package com.okres.library.entities;

/**
 * Created by Alex on 10.07.2017.
 */
public class Vote {
    private long id;
    private int value;
    private String userName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (value != vote.value) return false;
        if (userName != null ? !userName.equals(vote.userName) : vote.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + value;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
