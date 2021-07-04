package com.example.jokesjsonapp.model;

public class Jokes {

    private String jokesText;
    private Boolean jokesShare;

    public Jokes(String jokesText, boolean jokestext) {
        this.jokesText = jokesText;
        this.jokesShare = jokestext;
    }

    public String getJokesText() {
        return jokesText;
    }

    public void setJokesText(String jokesText) {
        this.jokesText = jokesText;
    }

    public Boolean getJokesShare() {
        return jokesShare;
    }

    public void setJokesShare(Boolean jokesShare) {
        this.jokesShare = jokesShare;
    }
}
