package com.model.user;

public class User {
    private String uname;
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uname != null ? !uname.equals(user.uname) : user.uname != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;

    }

    @Override
    public int hashCode() {
        int result = uname != null ? uname.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public User() {
    }
    //判断是否为空 为空返回ture 不为空返回false
    public boolean isEmpty(){
        if(this.getUname() == null || this.getPwd() == null)
            return true;
        else return false;
    }
}
