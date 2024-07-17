package br.ifmg.edu.bsi.progmovel.shareimage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class NovaCorActivity extends AppCompatActivity {

    public static String EXTRA_COR_ATUAL_SUPERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.cor_atual_superior";
    public static String EXTRA_NOVA_COR_SUPERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_cor_superior";

    public static String EXTRA_COR_ATUAL_INFERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.cor_atual_inferior";
    public static String EXTRA_NOVA_COR_INFERIOR = "br.ifmg.edu.bsi.progmovel.shareimage1.nova_cor_inferior";

    private EditText inputCorSuperior;
    private EditText inputCorInferior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_cor);

        inputCorSuperior = findViewById(R.id.inputCorSuperior);
        inputCorInferior = findViewById(R.id.inputCorInferior);

        Intent intent = getIntent();
        String corAtualSuperior = intent.getStringExtra(EXTRA_COR_ATUAL_SUPERIOR);
        String corAtualInferior = intent.getStringExtra(EXTRA_COR_ATUAL_INFERIOR);

        inputCorSuperior.setText(corAtualSuperior);
        inputCorInferior.setText(corAtualInferior);

    }
    public void enviarNovaCor(View v) {
        String novaCorSuperior = inputCorSuperior.getText().toString();
        String novaCorInferior = inputCorInferior.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(EXTRA_NOVA_COR_SUPERIOR, novaCorSuperior);
        intent.putExtra(EXTRA_NOVA_COR_INFERIOR, novaCorInferior);

        setResult(RESULT_OK, intent);
        finish();
    }
}