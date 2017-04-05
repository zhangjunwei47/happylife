package com.zc.happy.life.happylife;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mengxn on 16-12-15.
 */

public class LibraryContentAdapter extends RecyclerView.Adapter<LibraryContentAdapter.ContentViewHolder> {

    private Context mContext;

    public LibraryContentAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_library_content, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {

        ContentViewHolder(View itemView) {
            super(itemView);
        }
    }
}
