package com.nytimes.articles.view.base;


import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Generic Base adapter for recycler views
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
public abstract class BaseAdapter<T extends RecyclerView.ViewHolder, D> extends RecyclerView.Adapter<T>{

    public abstract void setData(List<D> data);
}