package com.gongyj.library.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAdapter<T, H extends BaseViewHolder> extends RecyclerView.Adapter<BaseViewHolder> {

    protected final Context context;
    protected final int layoutResId;
    protected List<T> datas;

    public BaseAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }

    public BaseAdapter(Context context, int layoutResId, List<T> datas) {
        this.context = context;
        this.layoutResId = layoutResId;
        this.datas = datas;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        BaseViewHolder viewHolder = new BaseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        T item = getItem(position);
        convert((H) holder, item);
    }

    @Override
    public int getItemCount() {
        if (datas == null || datas.size() <= 0)
            return 0;
        return datas.size();
    }

    public T getData(int position) {

        return datas.get(position);
    }

    public List<T> getDatas() {
        return datas;
    }

    public void addData(List<T> datas) {

        addData(0, datas);
    }

    public void addData(int position, List<T> datas) {
        if (datas != null && datas.size() > 0) {

            this.datas.addAll(datas);
            this.notifyItemRangeChanged(position, datas.size());
        }
    }

    public void clearData() {
        datas.clear();
        notifyItemRangeRemoved(0, datas.size());
    }

    protected T getItem(int position) {
        if (position >= datas.size()) return null;
        return datas.get(position);
    }

    protected abstract void convert(H viewHoder, T item);
}
