package com.asktroapp.myapplication;

import android.graphics.Bitmap;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class Books {

    private String bookName;
    private String author;
    private String category;
    private String edition;
    private int bookImage;

    public Books() { }

        public Books(String bookName,String author,String category,String edition,int bookImage)
        {
            this.bookName = bookName;
            this.author = author;
            this.category = category;
            this.edition = edition;
            this.bookImage = bookImage;

        }

    public String getBookName() {
        return bookName;
    }

    public String setBookName(String bookName)
    {
        return  bookName;
    }

    public String setAuthor(String author) {
        return author;
    }


    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getBookImage() {
        return bookImage;
    }

    public void setBookImage(int bookImage) {
        this.bookImage = bookImage;
    }
}




