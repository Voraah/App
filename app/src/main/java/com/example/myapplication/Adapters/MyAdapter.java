package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Product;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements Filterable {

    private List<Product> productList;
    private List<Product> allProducts;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context context;

    public MyAdapter(List<Product> productList, int layout, OnItemClickListener listener) {
        this.productList = productList;
        this.allProducts = new ArrayList<>(productList);
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
        holder.bind(productList.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Product> filteredList = new ArrayList<Product>();

            if (constraint.toString().isEmpty()) {
                filteredList.addAll(allProducts);
            } else {
                for (Product product : allProducts) {
                    if (product.name.toLowerCase().contains(constraint.toString().toLowerCase()))
                        filteredList.add(product);
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            productList.clear();
            productList.addAll((Collection<? extends Product>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProduct;
        public TextView txtCardName, txtCardPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtCardName = itemView.findViewById(R.id.txtCardName);
            txtCardPrice = itemView.findViewById(R.id.txtCardPrice);
        }

        @SuppressLint("SetTextI18n")
        public void bind(final Product product, final OnItemClickListener listener) {

            Picasso.get().load(product.getImg()).fit().error(product.getImg()).into(imgProduct);
            txtCardName.setText(product.getName());
            txtCardPrice.setText("Price: S/." + product.getPrice());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(product, getAdapterPosition());
                }
            });
        }
    }

    //Declarando interfaz con métodos a implementar
    public interface OnItemClickListener {
        void onItemClick(Product product, int position);
    }
}
