package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Product;
import com.example.myapplication.R;

import java.util.List;

public class tAdapter extends RecyclerView.Adapter<tAdapter.ViewHolder> {

    private List<Product> tckProductList;
    private OnItemClickListener itemClickListener;

    private int layout;

    private Context context;

    public tAdapter(List<Product> tckProductList, int layout, OnItemClickListener listener) {
        this.tckProductList = tckProductList;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindT(tckProductList.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtProductName, txtProductQuantity, txtProductCost;

        public ViewHolder(View itemView) {
            super(itemView);
            txtProductName = itemView.findViewById(R.id.txtTicketProductName);
            txtProductQuantity = itemView.findViewById(R.id.txtTicketProductQuantity);
            txtProductCost = itemView.findViewById(R.id.txtTicketProductCost);
        }

        public void bindT(final Product product, final tAdapter.OnItemClickListener listener) {
            txtProductName.setText(product.getName());
            txtProductQuantity.setText(product.getQuantity());
            txtProductCost.setText("" + product.getCost());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(product, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Product product, int position);
    }
}
