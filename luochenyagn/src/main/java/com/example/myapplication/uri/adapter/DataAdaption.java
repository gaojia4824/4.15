package com.example.myapplication.uri.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.text.Data1;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdaption extends RecyclerView.Adapter {
    private ArrayList<Data1.DataBean.CatalogBean> mData;
    private Context mContext;

    public DataAdaption(ArrayList<Data1.DataBean.CatalogBean> data, Context context) {
        mData = data;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder1 holder1 = (ViewHolder1) holder;
        holder1.mView.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {
        private TextView mView;
        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            mView=itemView.findViewById(R.id.te);

        }
    }
}
