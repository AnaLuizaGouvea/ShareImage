package br.ifmg.edu.bsi.progmovel.shareimage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NovoTextoActivity extends AppCompatActivity {

    public static String EXTRA_TEXTO_ATUAL_SUPERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual_superior";
    public static String EXTRA_NOVO_TEXTO_SUPERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.novo_texto_superior";

    public static String EXTRA_TEXTO_ATUAL_INFERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual_inferior";
    public static String EXTRA_NOVO_TEXTO_INFERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.novo_texto_inferior";

    public static String EXTRA_TAMANHO_FONTE_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.fonte_atual";
    public static String EXTRA_NOVO_TAMANHO_FONTE = "br.ifmg.edu.bsi.progmovel.shareimage1.fonte_atual";


    private EditText inputTextoSuperior;
    private EditText inputTextoInferior;

    private EditText inputTamanhoFonte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_texto);

        inputTextoSuperior = findViewById(R.id.inputTextoSuperior);
        inputTextoInferior = findViewById(R.id.inputTextoInferior);
        inputTamanhoFonte = findViewById(R.id.inputTamanhoFonte);

        Intent intent = getIntent();
        String textoAtualSuperior = intent.getStringExtra(EXTRA_TEXTO_ATUAL_SUPERIOR);
        String textoAtualInferior = intent.getStringExtra(EXTRA_TEXTO_ATUAL_INFERIOR);
        float fonteAtual = intent.getFloatExtra(EXTRA_TAMANHO_FONTE_ATUAL, 64f);

        inputTextoSuperior.setText(textoAtualSuperior);
        inputTextoInferior.setText(textoAtualInferior);
        inputTamanhoFonte.setText(String.valueOf(fonteAtual));
    }

    public void enviarNovoTexto(View v) {
        String novoTextoSuperior = inputTextoSuperior.getText().toString();
        String novoTextoInferior = inputTextoInferior.getText().toString();
        String novoTextoTamahno = inputTamanhoFonte.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOVO_TEXTO_SUPERIOR, novoTextoSuperior);
        intent.putExtra(EXTRA_NOVO_TEXTO_INFERIOR, novoTextoInferior);
        intent.putExtra(EXTRA_NOVO_TAMANHO_FONTE , novoTextoTamahno);
        setResult(RESULT_OK, intent);
        finish();
    }
}