package com.zc.happy.life.happylife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.txznet.music.home.home.manager.TileManager;
import com.txznet.music.home.home.model.CategoryTile;
import com.txznet.music.home.home.model.LocalTile;
import com.txznet.music.home.home.model.RadioTile;
import com.txznet.music.home.home.model.Tile;
import com.txznet.music.home.home.model.TileType;
import com.txznet.music.view.BlankTileView;
import com.txznet.music.view.CategoryTileView;
import com.txznet.music.view.LocalTileView;
import com.txznet.music.view.RadioTileView;
import com.txznet.music.view.TileView;

/*************************************
 * 类名称：Class Name
 * 类描述：Do What
 *
 * @version: 2.3.2
 * @author: 刘云龙
 * @time: 2016/12/14
 **********************************/
public class TileAdapter extends android.support.v7.widget.RecyclerView.Adapter<TileAdapter.ViewHolder> {
    private Tile[] mData;

    public TileAdapter(Context context, Tile[] mData) {
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TileType.Category:
                return new ViewHolder(new CategoryTileView(parent.getContext()));
            case TileType.Local:
                return new ViewHolder(new LocalTileView(parent.getContext()));
            case TileType.Radio:
                return new ViewHolder(new RadioTileView(parent.getContext()));
            default:
                return new ViewHolder(new BlankTileView(parent.getContext()));
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        mData[position].setEditState(TileManager.sEditState);
//        mData[position].setPlayState(TileManager.sPlayState);
        mData[position].show((TileView) holder.itemView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData[position].singleClick((TileView) v);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mData[position].longClick((TileView) v);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.length;
    }

    @Override
    public int getItemViewType(int position) {
        int type = TileType.Blank;
        if (mData[position] instanceof CategoryTile) {
            type = TileType.Category;
        } else if (mData[position] instanceof LocalTile) {
            type = TileType.Local;
        } else if (mData[position] instanceof RadioTile) {
            type = TileType.Radio;
        } else {
            type = TileType.Blank;
        }
        return type;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
