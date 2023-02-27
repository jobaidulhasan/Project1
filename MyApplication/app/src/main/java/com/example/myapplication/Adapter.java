package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //initialize part--------------->
    public static OntiemClick ontiemClick;
    Context context;
    String product_name[];
    String prodcut_details[];

    ///Create a constructor------------------------>
    Adapter(Context context,String product_name[],String prodcut_details[])
    {
        this.context=context;
        this.product_name=product_name;
        this.prodcut_details=prodcut_details;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recyceler_item_design,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.product_name.setText(product_name[position]);
        holder.product_details.setText(prodcut_details[position]);
    }

    @Override
    public int getItemCount() {
        return product_name.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView product_name,product_details;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name=itemView.findViewById(R.id.product_name);
            itemView.setOnClickListener(this);
            product_details=itemView.findViewById(R.id.product_details);
        }

        @Override
        public void onClick(View v){

            ontiemClick.onclick(v,getAdapterPosition());

        }
    }

    public interface OntiemClick{
        void onclick(View view,int position);
    }

    public void OnitemClickListener(OntiemClick ontiemClick)
    {
        Adapter.ontiemClick=ontiemClick;
    }

}
