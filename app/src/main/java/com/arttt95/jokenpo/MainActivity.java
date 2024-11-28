package com.arttt95.jokenpo;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        this.setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    public void selecionarPedra(View view ) {


        verificarGanhador("Pedra");

    }

    public void selecionarPapel(View view ) {

        verificarGanhador("Papel");

    }

    public void selecionarTesoura(View view ) {

        verificarGanhador("Tesoura");

    }

    private void verificarGanhador(String escolhaUsuario) {

        System.out.println("Item clicado: " + escolhaUsuario);

    }
}