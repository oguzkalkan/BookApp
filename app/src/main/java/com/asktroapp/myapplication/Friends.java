package com.asktroapp.myapplication;

/**
 * Created by mobiltek26 on 9/9/16.
 */
public class Friends {
    private String Fname;
    private String Fsurname;
    private int bookCount;
    private int ProfileImage;
    private int FriendId;

    public Friends() { }

    public Friends(String Fname,String Fsurname,int bookCount,int ProfileImage)
    {
        this.Fname = Fname;
        this.Fsurname = Fsurname;
        this.bookCount = bookCount;
        this.ProfileImage = ProfileImage;
    }

    public String getFName() {
        return Fname;
    }

    public void setFName(String name) {
        this.Fname = name;
    }

    public String getFSurname() {
        return Fsurname;
    }

    public void setFSurname(String surname) {
        this.Fsurname = surname;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public int getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(int profileImage) {
        ProfileImage = profileImage;
    }
}
