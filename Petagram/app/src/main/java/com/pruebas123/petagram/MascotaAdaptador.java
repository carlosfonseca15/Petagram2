package com.pruebas123.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImagen());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvCalificacionCV.setText(String.valueOf(mascota.getCalificacion()));
        mascotaViewHolder.ibCalificacionCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cal = mascota.getCalificacion() + 1;
                mascota.setCalificacion(cal);
                Toast.makeText(activity, "Diste a " + mascota.getNombre() + "C= " + mascota.getCalificacion(), Toast.LENGTH_LONG).show();
                notifyDataSetChanged();  //hace actulizar el valor
            }
        });
    }

    @Override
    public int getItemCount() {  //cant de elem de la lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton ibCalificacionCV;
        private TextView tvNombreCV;
        private TextView tvCalificacionCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            ibCalificacionCV = (ImageButton) itemView.findViewById(R.id.ibCalificacionCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvCalificacionCV = (TextView) itemView.findViewById(R.id.tvCalificacionCV);

        }
    }
}
