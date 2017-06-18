package com.tzidis.android.booklisting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static java.security.AccessController.getContext;

public class BookDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        //Get the properties of the Book Object from the intent
        Bundle b = getIntent().getExtras();
        final String bookTitle = b.getString("bookTitle");
        final String bookAuthors = b.getString("bookAuthors");
        final String bookPublisher = b.getString("bookPublisher");
        final String bookDescription = b.getString("bookDescription");
        int bookPageCount = b.getInt("bookPageCount");
        final String bookThumbnail = b.getString("bookThumbnail");

        //Show "back" button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set the image to the ImageView in the activity_book_details.xml
        ImageView imageView = (ImageView) findViewById(R.id.image);
        Glide.with(this)
                .load(bookThumbnail)
                .into(imageView);

        //Set the title to the TextView in the activity_book_details.xml
        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(bookTitle);

        //Set the authors to the TextView in the activity_book_details.xml
        TextView authorsTextView = (TextView) findViewById(R.id.authors);
        authorsTextView.setText(bookAuthors);

        //Set the publisher to the TextView in the activity_book_details.xml
        TextView publisherTextView = (TextView) findViewById(R.id.publisher);
        publisherTextView.setText(bookPublisher);

        //Set the description to the TextView in the activity_book_details.xml
        TextView descriptionTextView = (TextView) findViewById(R.id.description);
        descriptionTextView.setText(bookDescription);

        //Set the pageCount to the TextView in the activity_book_details.xml
        TextView pageCountTextView = (TextView) findViewById(R.id.pagecount);
        pageCountTextView.setText(Integer.toString(bookPageCount));
    }
}