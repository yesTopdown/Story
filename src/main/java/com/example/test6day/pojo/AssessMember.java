package com.example.test6day.pojo;

public class AssessMember {
    private Member member;
    private Float score=0.0f;

    public AssessMember() {
    }

    public AssessMember(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "AssessMember{" +
                "member=" + member +
                ", score=" + score +
                '}';
    }
}
