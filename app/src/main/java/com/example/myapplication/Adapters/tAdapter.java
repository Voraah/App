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

    private List<Product> productList;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;


    public tAdapter(List<Product> products, int layout, OnItemClickListener listener) {
        this.productList = products;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout y se lo pasamos al constructor del ViewHolder, donde manejaremos
        // toda la lógica como extraer los datos, referencias...
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(productList.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtProductName, txtProductQuantity, txtProductCost;

        public ViewHolder(View itemView) {
            // Recibe la View completa. La pasa al constructor padre y enlazamos referencias UI
            // con nuestras propiedades ViewHolder declaradas justo arriba.
            super(itemView);
            txtProductName = itemView.findViewById(R.id.txtTicketProductName);
            txtProductQuantity = itemView.findViewById(R.id.txtTicketProductQuantity);
            txtProductCost = itemView.findViewById(R.id.txtTicketProductCost);
        }

        public void bind(final Product product, final OnItemClickListener listener) {
            txtProductName.setText(product.getName());
            txtProductQuantity.setText(product.getQuantity() + "");
            txtProductCost.setText("" + product.getCost());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(product, getAdapterPosition());
                }
            });
        }
    }

    // Declaramos nuestra interfaz con el/los método/s a implementar
    public interface OnItemClickListener {
        void onItemClick(Product product, int position);
    }
}
