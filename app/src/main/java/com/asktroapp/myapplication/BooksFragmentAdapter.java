package com.asktroapp.myapplication;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mobiltek26 on 9/8/16.
 */
public class BooksFragmentAdapter extends RecyclerView.Adapter<BooksFragmentAdapter.MViewHolder> {
    private Context mContext;
    private List<Books> booksList;

    public class MViewHolder extends RecyclerView.ViewHolder {
        public TextView bookName, author,category;
        public ImageView bookImage;

        public MViewHolder(View view) {
            super(view);
            bookName = (TextView) view.findViewById(R.id.books_bookName);
            author = (TextView) view.findViewById(R.id.books_author);
            category = (TextView) view.findViewById(R.id.books_category);
            bookImage = (ImageView) view.findViewById(R.id.books_bookImage);
        }
    }

    public BooksFragmentAdapter(Context mContext, List<Books> booksList) {
        this.mContext = mContext;
        this.booksList = booksList;
    }

    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.books_book_card, parent, false);
        final MViewHolder myViewHolder = new MViewHolder(itemView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, int position) {
        Books book = booksList.get(position);
        holder.bookName.setText(book.getBookName());
        holder.author.setText(book.getAuthor());
        holder.category.setText(book.getCategory());
        holder.bookImage.setImageResource(book.getBookImage());
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

}
