package com.example.vize_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button giris,ekle;
    SharedPreferences sh;
    SharedPreferences.Editor shedit;
    EditText kul_ad,kul_sif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giris=findViewById(R.id.giris);
        kul_ad=findViewById(R.id.ad);
        kul_sif=findViewById(R.id.sif);
        ekle=findViewById(R.id.btn_ekle);

        sh=this.getSharedPreferences("com.example.vize_proje", Context.MODE_PRIVATE);

        kul_ad.setText(sh.getString("kul_ad",""));



        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int kul_sayi=Integer.valueOf(sh.getString("kul_id","0"));
                String ad=kul_ad.getText().toString();
                String sif=kul_sif.getText().toString();

                if (!ad.matches("")&&!sif.matches(""))
                {
                    sh.edit().putString("kul_id",kul_sayi+1+"").apply();
                    sh.edit().putString(kul_sayi+"_kul_ad", ad).apply(); //isim değeri
                    sh.edit().putString(kul_sayi+"_kul_sif", sif).apply();//şifre değeri
                    Toast.makeText(MainActivity.this, "Kullanıcı oluşturuldu id="+kul_sayi, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Lütfen bilgileri girdikten sonra tekrar deneyiniz.", Toast.LENGTH_SHORT).show();
                }


            }
        });


        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kul_id=Integer.valueOf(sh.getString("kul_id",""));
                String ad=kul_ad.getText().toString();
                String sif=kul_sif.getText().toString();
                Boolean goo=false;
                for (int i=0;i<=kul_id;i++)
                {
                    String k_ad = sh.getString(i+"_kul_ad", "");
                    String k_sif = sh.getString(i+"_kul_sif", "");

                    if (k_sif.matches(sif)&&k_ad.matches(ad))
                    {

                        goo=true;
                        break;
                    }
                    else
                    {
                        goo=false;
                    }
                }
                if (goo==true)
                {
                    Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                    Intent go = new Intent(MainActivity.this, hesap_makinesi.class);
                    startActivity(go);
                }
                else Toast.makeText(MainActivity.this, "Giriş Bilgilerinde hata var lütfen tekrar deneyin", Toast.LENGTH_SHORT).show();
            }
        });

    }
}