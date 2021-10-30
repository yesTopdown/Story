package com.example.test6day.pojo;

public class Member {
    private Integer id;
    private String username;
    private String profession;
    private String time;

    public Member() {
    }

    public Member(Integer id, String username, String profession, String time) {
        this.id = id;
        this.username = username;
        this.profession = profession;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", profession='" + profession + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
