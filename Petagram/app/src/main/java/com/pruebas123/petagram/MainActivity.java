package com.pruebas123.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotas_sort;
    private RecyclerView listaMascotas;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.top5:
                Toast.makeText(this, "Diste a top5", Toast.LENGTH_SHORT).show();
                sortLista();
                irDetalleTop5();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miactionbar);
        miActionBar.setTitleTextColor(getResources().getColor(R.color.textoOscuro));
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.dog_footprint);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasTotal);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        iniciaListaMascotas();
        inicializaAdaptador();
    }

    public void irDetalleTop5(){
        Intent intent = new Intent(this, DetalleTop5.class);
        //intent.putExtra("FILES_TO_SEND", mascotas_sort);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)mascotas_sort);
        intent.putExtra("BUNDLE",args);
        startActivity(intent);
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void iniciaListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.chispa, "Chispa", 0));
        mascotas.add(new Mascota(R.drawable.coco, "Coco", 5));
        mascotas.add(new Mascota(R.drawable.jack, "Jack", 3));
        mascotas.add(new Mascota(R.drawable.lucas, "Lucas", 5));
        mascotas.add(new Mascota(R.drawable.max, "Max", 2));
        mascotas.add(new Mascota(R.drawable.rex, "Rex", 1));
        mascotas.add(new Mascota(R.drawable.rocky, "Rocky", 4));
        mascotas.add(new Mascota(R.drawable.thor, "Thor", 1));
        mascotas.add(new Mascota(R.drawable.toby, "Toby", 0));
        mascotas.add(new Mascota(R.drawable.zeus, "Zeus", 4));

    }

    public void sortLista(){
        mascotas_sort = mascotas;
        Collections.sort(mascotas_sort, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota m1, Mascota m2) {
                String dato1 = String.valueOf(m1.getCalificacion());
                String dato2 = String.valueOf(m2.getCalificacion());
                return dato1.compareTo(dato2);
            }
        });

        mascotas_sort.subList(0, 5).clear();
    }

}