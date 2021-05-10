package com.gongyj.library.recyclerview;

import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder  extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.views=new SparseArray<View>();
    }
    public TextView getTextView(int viewId) {
        return retrieveView(viewId);
    }

    public Button getButton(int viewId) {
        return retrieveView(viewId);
    }
    public ImageView getImageView(int viewId) {
        return retrieveView(viewId);
    }

    public View getView(int viewId) {
        return retrieveView(viewId);
    }
    protected  <T extends View> T retrieveView(int viewId){
        View view=views.get(viewId);
        if(view==null){
            view=itemView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T)view;
    }
}
