package com.allen.cards;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by uca on 04-18-18.
 */

public abstract class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>{

    SeriesViewHolder vh;
    List<Serie> lista;
    Context contexto;

    public SeriesAdapter(List<Serie> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        vh= new SeriesViewHolder(v);
        return (vh);
    }

    @Override
    public void onBindViewHolder(final SeriesViewHolder holder, final int position) {

        holder.text.setText(lista.get(position).getName());
        holder.img.setImageResource(lista.get(position).getImg());
        final ImageButton fav = holder.fav;
        final Serie elemento = lista.get(position);
        hideElement(position,holder);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!elemento.getisFav()) {

                    elemento.setFav(true);
                    fav.setImageResource(android.R.drawable.btn_star_big_on);
                    Log.d("CLICK_LISTENER_LISTA" ,
                            "Click en "+ position + "valor:" +
                                    elemento.getisFav() );
                } else {
                    elemento.setFav(false);
                    fav.setImageResource(android.R.drawable.btn_star_big_off);
                    eliminarLista(position,holder);
                    Log.d("CLICK_LISTENER_LISTA" ,
                            "Click en "+ position + "valor:" +
                                    elemento.getisFav());

                }
            }

        });


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public  class SeriesViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView text;
        ImageView img;
        ImageButton fav;

        public SeriesViewHolder(View itemView){
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            text = itemView.findViewById(R.id.texto);
            img = itemView.findViewById(R.id.imagen);
            fav = itemView.findViewById(R.id.starbutton);

        }


    }
    public List<Serie> getLista() {
        return lista;
    }

    public abstract void eliminarLista(int posicion, SeriesViewHolder holder);
    public abstract void hideElement(int posicion,SeriesViewHolder holder);
}
