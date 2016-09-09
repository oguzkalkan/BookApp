package com.asktroapp.myapplication.Fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asktroapp.myapplication.Books;
import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.R;

import java.util.List;

/**
 * Created by mobiltek26 on 9/9/16.
 */
public class PopularBooksAdapter extends RecyclerView.Adapter<PopularBooksAdapter.PViewHolder> {

    private Context mContext;
    private List<Books> booksList;
    CustomItemClickListener listener;

    public class PViewHolder extends RecyclerView.ViewHolder {
        public TextView bookName, author,category;
        public ImageView bookImage;

        public PViewHolder(View view) {
            super(view);
            bookName = (TextView) view.findViewById(R.id.PopbookName);
            author = (TextView) view.findViewById(R.id.Popauthor);
            category = (TextView) view.findViewById(R.id.Popcategory);
            bookImage = (ImageView) view.findViewById(R.id.PopbookImage);
        }
    }
    public PopularBooksAdapter(Context mContext, List<Books> booksList,CustomItemClickListener listener) {
        this.mContext = mContext;
        this.booksList = booksList;
        this.listener = listener;
    }

    public PViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_books_card, parent, false);
        final PViewHolder pViewHolder = new PViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(v, pViewHolder.getAdapterPosition());

            }
        });


        return pViewHolder;
    }

    @Override
    public void onBindViewHolder(PViewHolder holder, int position) {
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
