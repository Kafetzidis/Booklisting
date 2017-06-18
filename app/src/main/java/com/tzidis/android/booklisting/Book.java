package com.tzidis.android.booklisting;

/**
 * Created by Tzidis on 13-Jun-17.
 */

public class Book {

    private String mTitle;
    private String mAuthors;
    private String mPublisher;
    private String mDescription;
    private int mPageCount;
    private String mThumbnail;

 /*
  * Create a new Book object.
  *
  * @param title is the title of the book
  * @param authors are the authors of the book
  * @param publisher is the publisher of the book
  * @param description is the description of the book
  * @param pageCount is the number of pages of the book
  * @param thumbnail is the link to the image of the cover
  * */

    public Book(String title, String authors, String publisher, String description,
                int pageCount, String thumbnail){

        mTitle = title;
        mAuthors = authors;
        mPublisher = publisher;
        mDescription = description;
        mPageCount = pageCount;
        mThumbnail = thumbnail;
    }

    /**
     * Get the the title of the book
     */

    public String getTitle(){return mTitle;}

    /**
     * Get the authors of the book
     */

    public String getAuthors(){return mAuthors;}

    /**
     * Get the publisher of the book
     */

    public String getPublisher(){return mPublisher;}

    /**
     * Get the description of the book
     */

    public String getDescription(){return mDescription;}

    /**
     * Get the publisher of the book
     */

    public int getPageCount(){return mPageCount;}

    /**
     * Get the thumbnail of the book
     */

    public String getThumbnail(){return mThumbnail;}

}
