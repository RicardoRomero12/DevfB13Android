package com.example.listas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Richy on 20/02/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    private List<Animales> myAnimalesList;
    private Context myContext;
    private LayoutInflater mLayoutInflater;
    private MyItemListener myItemListener;



    public MyAdapter(List<Animales> myAnimalesList, Context myContext) {
        this.myAnimalesList = myAnimalesList;
        this.myContext = myContext;
        mLayoutInflater =  LayoutInflater.from(myContext);

    }

    public void setMyItemListener(MyItemListener myItemListener) {
        this.myItemListener = myItemListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = mLayoutInflater.inflate(R.layout.item_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(viewItem,myContext);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Animales animales = myAnimalesList.get(position);
        holder.render(animales);
    }

    @Override
    public int getItemCount() {
        return myAnimalesList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imagen;
        private TextView titulo;
        private TextView descripcion;
        private Context myContext;


        public MyViewHolder(View itemView, Context context) {
            super(itemView);
            myContext=context;
            findViews(itemView);
            itemView.setOnClickListener(this);
        }

        private void findViews(View itemView){
            imagen = (ImageView) itemView.findViewById(R.id.imagen_lista);
            titulo = (TextView) itemView.findViewById(R.id.titulo_lista);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion_lista);
        }

        public void render(Animales animales){
            titulo.setText(animales.getNombre());
            descripcion.setText(animales.getDescripcion());
            Picasso.with(myContext).load(animales.getUrl()).into(imagen);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            myItemListener.onItemClick(position, myAnimalesList.get(position).getNombre());
        }
    }



    public interface MyItemListener{

        public void onItemClick(int posicion, String name);

    }
}
