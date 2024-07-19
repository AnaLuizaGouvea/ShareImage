package br.ifmg.edu.bsi.progmovel.shareimage1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.BitmapDrawable;
import java.io.ByteArrayOutputStream;
import android.graphics.drawable.Drawable;

public class TemplateActivity extends AppCompatActivity {

    public static final String EXTRA_TEMPLATE_NOVO = "br.ifmg.edu.bsi.progmovel.shareimage1.template_novo";

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

    }

    public void enviarNovoTemplate(View view) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TEMPLATE_NOVO, converterDrawableParaBytearray(view));

        setResult(RESULT_OK, intent);
        finish();
    }

    private byte[] converterDrawableParaBytearray(View view) {
        ImageView imageView = view.findViewById(view.getId());
        Drawable drawable = imageView.getDrawable();

        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            int width = drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight();
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        return byteArray;
    }
}