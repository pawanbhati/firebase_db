package com.pawan.firebasedatabase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.pawan.firebasedatabase.R;
import com.pawan.firebasedatabase.models.Items;

import org.w3c.dom.Text;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductView> {

    List<Items> list;
    Context context;

    public ProductListAdapter(List<Items> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_products, parent, false);
        return new ProductView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductView holder, int position) {
        holder.txtName.setText(list.get(position).getProductId());
        if (list.get(position).isInStock()) {
            holder.txtStatus.setText("Available");
            holder.txtStatus.setTextColor(ContextCompat.getColor(context, android.R.color.holo_green_dark));
        } else {
            holder.txtStatus.setText("Out Of Stock");
            holder.txtStatus.setTextColor(ContextCompat.getColor(context, android.R.color.holo_red_dark));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProductView extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtStatus;

        public ProductView(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_listitem_product_name);
            txtStatus = (TextView) itemView.findViewById(R.id.txt_listitem_product_status);
        }
    }
}
