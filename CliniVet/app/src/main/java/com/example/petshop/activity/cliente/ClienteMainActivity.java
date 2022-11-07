package com.example.petshop.activity.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClienteMainActivity extends AppCompatActivity {

//    private ImageButton ib_menu;

    private LinearLayout menu_meus_pets, menu_agendar_atendimento, menu_consultar_agendamentos;
    private TextView txtView_nomeUsuario;
    private DatabaseReference mDatabase;
    private FirebaseAuth fAuth;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientemainactivity);

        iniciaComponentes();

        configCliques();

        DatabaseReference userNameReference = mDatabase.child("usuarios").child(userID).child("nome");

        userNameReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    String value = task.getResult().getValue(String.class);
                    txtView_nomeUsuario.setText(value);
                } else {
                    Log.d("TAG", task.getException().getMessage()); //Don't ignore potential errors!
                }
            }
        });

    }

    private void configCliques(){
//        ib_menu.setOnClickListener(view -> {
//            PopupMenu popupMenu = new PopupMenu(this, ib_menu);
//            popupMenu.getMenuInflater().inflate(R.menu.menu_home_usuario, popupMenu.getMenu());
//
//            popupMenu.setOnMenuItemClickListener(menuItem -> {
//                if(menuItem.getItemId() == R.id.menu_minhas_reservas){
//                    startActivity(new Intent(this, MinhasReservasActivity.class));
//                }else if(menuItem.getItemId() == R.id.menu_meus_pets){
//                    startActivity(new Intent(this, MeusPetsActivity.class));
//                }else if(menuItem.getItemId() == R.id.menu_minha_conta){
//                    Toast.makeText(this, "Minha conta", Toast.LENGTH_SHORT).show();
//                }
//
//
//                return true;
//            });
//            popupMenu.show();
//        });

        menu_meus_pets.setOnClickListener(view ->
                startActivity(new Intent(this, MeusPetsActivity.class))
        );

        menu_agendar_atendimento.setOnClickListener(view ->
                startActivity(new Intent(this, AgendarAtendimento.class))
        );

        menu_consultar_agendamentos.setOnClickListener(view ->
                startActivity(new Intent(this, MinhasReservasActivity.class))
        );

    }

    private void iniciaComponentes(){
//        ib_menu = findViewById(R.id.ib_menu);

        menu_meus_pets = findViewById(R.id.menu_meus_pets_home);
        menu_agendar_atendimento = findViewById(R.id.menu_agendar_atendimento);
        menu_consultar_agendamentos = findViewById(R.id.menu_consultar_agendamentos);
        txtView_nomeUsuario = findViewById(R.id.txtView_nomeUsuario);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        fAuth = FirebaseAuth.getInstance();

        userID = fAuth.getCurrentUser().getUid();

    }

}