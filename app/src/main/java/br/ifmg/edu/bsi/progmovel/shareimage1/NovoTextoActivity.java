package br.ifmg.edu.bsi.progmovel.shareimage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NovoTextoActivity extends AppCompatActivity {

    public static String EXTRA_TEXTO_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual";
    public static String EXTRA_NOVO_TEXTO = "br.ifmg.edu.bsi.progmovel.shareimage1.novo_texto";
    public static String EXTRA_TAMANHO_FONTE_ATUAL = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual";
    public static String EXTRA_NOVO_TAMANHO_FONTE = "br.ifmg.edu.bsi.progmovel.shareimage1.texto_atual";


    private EditText etTexto;
    private EditText etFonte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_texto);

        etTexto = findViewById(R.id.etTexto);
        etFonte = findViewById(R.id.etFonte);
        Intent intent = getIntent();

        String textoAtual = intent.getStringExtra(EXTRA_TEXTO_ATUAL);
        float fonteAtual = intent.getFloatExtra(EXTRA_TAMANHO_FONTE_ATUAL, 64f);

        etTexto.setText(textoAtual);
        etFonte.setText(String.valueOf(fonteAtual));
    }

    public void enviarNovoTexto(View v) {
        String novoTexto = etTexto.getText().toString();
        String novoTextoTamahno = etFonte.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOVO_TEXTO, novoTexto);
        intent.putExtra(EXTRA_NOVO_TAMANHO_FONTE , novoTextoTamahno);
        setResult(RESULT_OK, intent);
        finish();
    }
}