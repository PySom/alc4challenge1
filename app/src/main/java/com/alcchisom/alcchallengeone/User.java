package com.alcchisom.alcchallengeone;

import androidx.annotation.NonNull;

class User {
    private static String name, slack, teamId, userId, country, email, phone, track;

    public User(String name, String slack, String country, String email, String phone, String teamId, String track, String userId){
        this.name = name;
        this.slack = slack;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.track = track;
        this.teamId = teamId;
        this.userId = userId;
    }

    public String getName() {return name;}

    public String getSlack() {return slack;}

    public String getCountry() {return country;}

    public String getEmail() {return email;}

    public String getPhone() {return phone;}

    public String getTrack() {return track;}

    public String getTeamId() {return teamId;}

    public String getUserId() {return userId;}

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }


}
