package com.asktroapp.myapplication;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by mobiltek26 on 9/5/16.
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {

    private Context mContext;
    private List<Books> booksList;
    CustomItemClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bookName, author,category;
        public ImageView bookImage;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            bookName = (TextView) view.findViewById(R.id.bookName);
            author = (TextView) view.findViewById(R.id.author);
            category = (TextView) view.findViewById(R.id.category);
            bookImage = (ImageView) view.findViewById(R.id.bookImage);
        /*    cardView = (CardView) view.findViewById(R.id.CardView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Toast.makeText(itemView.getContext(), booksList[pos], Toast.LENGTH_SHORT).show();

                }
            });*/
        }
    }
    public BooksAdapter(Context mContext, List<Books> booksList,CustomItemClickListener listener) {
        this.mContext = mContext;
        this.booksList = booksList;
        this.listener = listener;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_card, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(v, myViewHolder.getAdapterPosition());

            }
        });


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
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
