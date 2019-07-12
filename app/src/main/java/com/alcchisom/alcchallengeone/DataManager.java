package com.alcchisom.alcchallengeone;

class DataManager {
    public static final String USER_NAME = "Nwisu Chisom Victor";
    public static final String SLACK_NAME = "@chisom_nwisu";
    public static final String SLACK_TEAM_ID = "TJPKMLNMS";
    public static final String USER_ID = "UKHMKT1HS";
    public static final String COUNTRY = "Nigeria";
    public static final String EMAIL = "nwisuchisom@gmail.com";
    public static final String PHONE = "+234 803 871 4611";
    public static final String TRACK = "Android";
    private static DataManager _instance;
    public static DataManager getInstance(){
        if(_instance == null){
            return new DataManager();
        }
        return _instance;
    }

    public User getUser(){
        return new User(USER_NAME, SLACK_NAME, COUNTRY, EMAIL, PHONE, SLACK_TEAM_ID, TRACK, USER_ID);
    }

}
