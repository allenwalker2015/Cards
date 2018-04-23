package com.allen.cards;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by uca on 04-18-18.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>{


    List<Serie> lista;
    Context contexto;

    public SeriesAdapter(List<Serie> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return (new SeriesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        holder.text.setText(lista.get(position).getName());
        holder.img.setImageResource(lista.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public  class SeriesViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView text;
        ImageView img;
        Button fav;

        public SeriesViewHolder(View itemView){
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            text = itemView.findViewById(R.id.texto);
            img = itemView.findViewById(R.id.imagen);
            fav = itemView.findViewById(R.id.starbutton);
            Log.d("IMG", "SeriesViewHolder: " + img);

            fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!lista.get(getAdapterPosition()).getisFav()) {
                        lista.get(getAdapterPosition()).setFav(true);
                        fav.setText("ELIMINAR");
                        Log.d("CLICK_LISTENER_LISTA" ,
                                "Click en "+ getAdapterPosition() + "valor:" +
                                        lista.get(getAdapterPosition()).getisFav() );
                    } else {
                        lista.get(getAdapterPosition()).setFav(false);
                        fav.setText("FAV");
                        Log.d("CLICK_LISTENER_LISTA" ,
                                "Click en "+ getAdapterPosition() + "valor:" +
                                        lista.get(getAdapterPosition()).getisFav() );
                    }
                }

            });
        }
    }
    public List<Serie> getLista() {
        return lista;
    }
}
