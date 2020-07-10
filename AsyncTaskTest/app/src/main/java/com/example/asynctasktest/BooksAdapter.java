package com.example.asynctasktest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {

    Context myCt;
    List<Book> myList;
    public BooksAdapter(Context ct, List<Book> booksList) {
        myCt = ct;
        myList = booksList;
    }

    @NonNull
    @Override
    public BooksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(myCt).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.MyViewHolder holder, int position) {
        Book b = myList.get(position);
        holder.tv_title.setText(b.getTitle());
        holder.tv_authors.setText(b.getAuthors());
        //Picaso or Glide these are two thirs party libraries to set the image url to the ImageView
        Glide.with(myCt).load(b.getImageLink()).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_title,tv_authors;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.bookImage);
            tv_title = itemView.findViewById(R.id.bookTitle);
            tv_authors = itemView.findViewById(R.id.bookAuthors);
        }
    }
}
