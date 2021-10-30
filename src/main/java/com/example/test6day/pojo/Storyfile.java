package com.example.test6day.pojo;

import java.util.Arrays;

public class Storyfile {
    private Story story;
    private String[] answer;

    public Storyfile(Story story, String[] answer) {
        this.story = story;
        this.answer = answer;
    }

    public Storyfile() {
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Storyfile{" +
                "story=" + story +
                ", answer=" + Arrays.toString(answer) +
                '}';
    }
}
