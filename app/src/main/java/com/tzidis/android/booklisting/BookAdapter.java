package com.tzidis.android.booklisting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;


import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {


    private static final String LOG_TAG = BookAdapter.class.getSimpleName();
    private Context context = getContext();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param books       A List of Book objects to display in a list
     */

    public BookAdapter(Activity context, List<Book> books) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, books);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Book} object located at this position in the list
        Book currentBook = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID title_text_view
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);

        // set this text on the name TextView
        titleTextView.setText(currentBook.getTitle());

        // Find the TextView in the list_item.xml layout with the ID subtitle_text_view
        TextView authorsTextView = (TextView) listItemView.findViewById(R.id.author_text_view);

        // set this text on the subtitleTextView
        authorsTextView.setText(currentBook.getAuthors());

        //Find the ImageView in the list_item.xml with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //Use Glide to set image to the ImageView
        Glide.with(getContext())
                .load(currentBook.getThumbnail())
                .into(imageView);

        //Create an implicit intent to display the detailed book information if the user taps on the list item
        final Intent itemIntent = new Intent(context, BookDetails.class);

        //Put the properties of the Object to the intent
        itemIntent.putExtra("bookTitle", currentBook.getTitle());
        itemIntent.putExtra("bookAuthors", currentBook.getAuthors());
        itemIntent.putExtra("bookPublisher", currentBook.getPublisher());
        itemIntent.putExtra("bookDescription", currentBook.getDescription());
        itemIntent.putExtra("bookPageCount", currentBook.getPageCount());
        itemIntent.putExtra("bookThumbnail", currentBook.getThumbnail());

        //Start the intent if the user taps on the list item
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(itemIntent);
            }
        });

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
