package com.allen.cards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    List<Serie> lista,favoritos;
    SeriesAdapter series,favs;
    Button listabot,favbot;
    LinearLayoutManager manager;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listabot = findViewById(R.id.peliculasButton);
        favbot = findViewById(R.id.favButton);
        lista = llenarLista();
        rv = findViewById(R.id.recycler);
        manager = new LinearLayoutManager(this);
        series = new SeriesAdapter(lista, this) {
            @Override
            public void eliminarLista(int posicion, SeriesViewHolder holder) {

            }

            @Override
            public void hideElement(int posicion, SeriesViewHolder holder) {

            }
        };
        favs = new SeriesAdapter(lista ,this) {
            @Override
            public void eliminarLista(int posicion, SeriesViewHolder holder) {
                favs.getLista().remove(posicion);
                favs.notifyItemRemoved(posicion);
                favs.notifyItemRangeChanged(posicion,favs.getLista().size());
            }

            @Override
            public void hideElement(int posicion, SeriesViewHolder holder) {
                if(lista.get(posicion).getisFav()){

                }
            }
        };
        rv.setLayoutManager(manager);
        rv.setAdapter(series);
        rv.setHasFixedSize(true);
        favbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                List<Serie> oldad = ((SeriesAdapter)rv.getAdapter()).getLista();
//                List<Serie> ad = new ArrayList<>(oldad);
//                Iterator<Serie> newfavs = ad.iterator();
//                while (newfavs.hasNext()) {
//                    if (!newfavs.next().getisFav()) {
//                        newfavs.remove();
//                    }
//                }
//                favs = new SeriesAdapter(ad, view.getContext()) {
//                    @Override
//                    public void eliminarLista(int posicion, SeriesViewHolder holder) {
//                        favs.getLista().remove(posicion);
//                        favs.notifyItemRemoved(posicion);
//                        favs.notifyItemRangeChanged(posicion,favs.getLista().size());
//                    }
//                };
                rv.swapAdapter(favs,false);
                Log.d("BOTON_FAVORITOS", "se cambio la lista");
            }
        });
        listabot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rv.swapAdapter(series,false);
                Log.d("BOTON_PELICULAS", "se cambio la lista");
            }
        });
    }

    public List<Serie> llenarLista(){
        List<Serie> lista = new ArrayList<>();

        lista.add(new Serie("50 Sombras","","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",android.R.drawable.alert_dark_frame));
        lista.add(new Serie("51 Sombras","","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",android.R.drawable.bottom_bar));
        lista.add(new Serie("52 SOmbras","","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",android.R.drawable.arrow_down_float));


        return lista;
    }

    public void updateFavoritos(List<Serie> series) {

    }
}
