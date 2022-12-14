package com.example.petshopx.activity.cliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.petshopx.R;
import com.example.petshopx.adapter.AdapterReservas;
import com.example.petshopx.helper.FirebaseHelper;
import com.example.petshopx.model.Reserva;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinhasReservasActivity extends AppCompatActivity implements AdapterReservas.OnClick {

    private List<Reserva> reservaList = new ArrayList<>();

    private ProgressBar progressBar;
    private TextView text_info;
    private RecyclerView rv_reservas;
    private AdapterReservas adapterReservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_reservas);

        iniciaComponentes();

        configRv();

        configCliques();

        recuperaReservas();
    }

    private void configCliques(){
        findViewById(R.id.ib_voltar).setOnClickListener(view -> finish());
        findViewById(R.id.ib_historico).setOnClickListener(view -> {
            startActivity(new Intent(this, MeuHistoricoReservasActivity.class));
        });
    }

    private void configRv(){
        rv_reservas.setLayoutManager(new LinearLayoutManager(this));
        rv_reservas.setHasFixedSize(true);
        adapterReservas = new AdapterReservas(reservaList, this);
        rv_reservas.setAdapter(adapterReservas);
    }

    private void recuperaReservas(){
        DatabaseReference reference = FirebaseHelper.getDatabaseReference()
                .child("reservas")
                .child(FirebaseHelper.getIdFirebase());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                reservaList.clear();
                if(snapshot.exists()){
                    for(DataSnapshot snap : snapshot.getChildren()){
                        Reserva reserva = snap.getValue(Reserva.class);

                        if(!reserva.getStatus().equals("cancelada") && !reserva.getStatus().equals("concluida")){
                            reservaList.add(reserva);
                        }

                    }
                    text_info.setText("");
                }else{
                    text_info.setText("Nenhuma reserva cadastrada.");
                }

                progressBar.setVisibility(View.GONE);
                Collections.reverse(reservaList);
                adapterReservas.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void iniciaComponentes(){
        progressBar = findViewById(R.id.progressBar);
        text_info = findViewById(R.id.text_info);
        rv_reservas = findViewById(R.id.rv_reservas);

        TextView text_titulo = findViewById(R.id.text_titulo);
        text_titulo.setText("Minhas Reservas");
    }

    @Override
    public void OnClickListener(Reserva reserva) {

    }
}