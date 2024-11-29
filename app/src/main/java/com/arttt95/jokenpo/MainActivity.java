package com.arttt95.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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

    private String gerarEscolhaAleatoriaApp() {

        Random random = new Random();
        int numeroAleatorio = random.nextInt(3); // 0, 1 e 2

        String[] opcoes = {"Pedra", "Papel" , "Tesoura"};

        String escolhaApp = opcoes[numeroAleatorio];

        ImageView imagemEscolhaApp = findViewById(R.id.image_escolhaApp);

        switch (escolhaApp) {

            case "Pedra":
                imagemEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
            default:
                imagemEscolhaApp.setImageResource(R.drawable.padrao);
        }

        return escolhaApp;

    }

    private void verificarGanhador(String escolhaUsuario) {

        String escolhaApp = gerarEscolhaAleatoriaApp();

        TextView textoResultado = findViewById(R.id.text_resultado);

        if ( // App ganha
            (escolhaUsuario == "Pedra" && escolhaApp == "Papel") ||
            (escolhaUsuario == "Papel" && escolhaApp == "Tesoura") ||
            (escolhaUsuario == "Tesoura" && escolhaApp == "Pedra")
        ) {  // Lógica App ganha

            textoResultado.setText("Você perdeu :(");

        } else if (  // Usuário ganha
            (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") ||
            (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
            (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ) { // Lógica Usuário ganha

            textoResultado.setText("Você ganhou :)");

        } else { // Empate

            textoResultado.setText("It's a tie buddie!");

        }

    }

}