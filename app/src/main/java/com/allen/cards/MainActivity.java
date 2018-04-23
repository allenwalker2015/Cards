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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listabot = findViewById(R.id.peliculasButton);
        favbot = findViewById(R.id.favButton);
        lista = llenarLista();
        rv = findViewById(R.id.recycler);
        manager = new LinearLayoutManager(this);
        series = new SeriesAdapter(lista,this);
        favs = new SeriesAdapter(new ArrayList<Serie>() ,this);
        rv.setLayoutManager(manager);
        rv.setAdapter(series);
        rv.setHasFixedSize(true);
        favbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateFavoritos(((SeriesAdapter)rv.getAdapter()).lista);
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
        Iterator<Serie> favs = series.iterator();
        while (favs.hasNext()) {
            if (!favs.next().getisFav()) {
                favs.remove();
            }
        }
        lista = series;
        this.favs = new SeriesAdapter(series ,this);
        rv.swapAdapter(this.favs,false);
    }
}
