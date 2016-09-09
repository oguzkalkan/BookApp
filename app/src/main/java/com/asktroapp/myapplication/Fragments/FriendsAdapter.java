package com.asktroapp.myapplication.Fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asktroapp.myapplication.CustomItemClickListener;
import com.asktroapp.myapplication.Friends;
import com.asktroapp.myapplication.R;

import java.util.List;

/**
 * Created by mobiltek26 on 9/9/16.
 */
public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FViewHolder> {

    private Context mContext;
    private List<Friends> friendsList;
    CustomItemClickListener listener;

    public class FViewHolder extends RecyclerView.ViewHolder {
        public TextView FriendName, BookCount;
        public ImageView FriendImage;

        public FViewHolder(View view) {
            super(view);
            FriendName = (TextView) view.findViewById(R.id.friend_name);
            BookCount = (TextView) view.findViewById(R.id.book_count);
            FriendImage = (ImageView) view.findViewById(R.id.friend_image);;
        }
    }
    public FriendsAdapter(Context mContext, List<Friends> friendsList, CustomItemClickListener listener) {

        this.mContext = mContext;
        this.friendsList = friendsList;
        this.listener = listener;
    }

    public FViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friends_card, parent, false);
        final FViewHolder myViewHolder = new FViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(v, myViewHolder.getAdapterPosition());

            }
        });


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(FViewHolder holder, int position) {
        Friends friend = friendsList.get(position);
        String FriendName = friend.getFName() + " " + friend.getFSurname();
        holder.FriendName.setText(FriendName);
        holder.BookCount.setText("" + friend.getBookCount());
        holder.FriendImage.setImageResource(friend.getProfileImage());


    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }



}
