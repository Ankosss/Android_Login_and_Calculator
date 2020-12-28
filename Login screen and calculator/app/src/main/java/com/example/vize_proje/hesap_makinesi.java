package com.example.vize_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class hesap_makinesi extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,topla,cikar,carp,bol,esit,tmz,sil,nkt;
    EditText goster;
    double birinci=0;
    double ikinci=0;
    String islem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap_makinesi);
        bt0=findViewById(R.id.btn0);
        bt1=findViewById(R.id.btn1);
        bt2=findViewById(R.id.btn2);
        bt3=findViewById(R.id.btn3);
        bt4=findViewById(R.id.btn4);
        bt5=findViewById(R.id.btn5);
        bt6=findViewById(R.id.btn6);
        bt7=findViewById(R.id.btn7);
        bt8=findViewById(R.id.btn8);
        bt9=findViewById(R.id.btn9);
        nkt=findViewById(R.id.btn_nokta);
        topla=findViewById(R.id.btn_top);
        cikar=findViewById(R.id.btn_cikar);
        carp=findViewById(R.id.btn_carp);
        bol=findViewById(R.id.btn_bol);
        esit=findViewById(R.id.btn_esit);
        tmz=findViewById(R.id.btn_tmz);
        sil=findViewById(R.id.btn_sil);
        goster=findViewById(R.id.Gosterge);
        SharedPreferences sh;
        sh=this.getSharedPreferences("com.example.vize_proje", Context.MODE_PRIVATE);
        double sonuc=Double.valueOf(sh.getString("son_sayi",""));
        goster.setText(sonuc+"");



        esit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=goster.getText().toString();
                if (a.equals(""))
                {
                    Toast.makeText(hesap_makinesi.this, "Lütfen sayı girdikten sonra işlem yapmaya çalışın.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Double sonuc=0.0;
                    ikinci=Double.valueOf(goster.getText().toString());
                    switch (islem)
                    {
                        case "top":

                            sonuc=birinci+ikinci;
                            goster.setText(sonuc.toString());

                        break;
                        case "cik":

                            sonuc=birinci-ikinci;
                            goster.setText(sonuc.toString());

                        break;
                        case "carp":

                            sonuc=birinci*ikinci;
                            goster.setText(sonuc.toString());

                        break;
                        case "bol":

                            sonuc=birinci/ikinci;
                            goster.setText(sonuc.toString());

                        break;
                    }
                    birinci=0;
                    ikinci=0;
                    islem="";

                        nkt.setEnabled(false);


                    sh.edit().putString("son_sayi", goster.getText().toString()).apply(); //isim değeri

                }
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=goster.getText().toString();
                x+="0";
                goster.setText(x);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String x=goster.getText().toString();
                x+="1";
                goster.setText(x);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String x=goster.getText().toString();
                x+="2";
                goster.setText(x);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String x=goster.getText().toString();
                x+="3";
                goster.setText(x);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=goster.getText().toString();
                x+="4";
                goster.setText(x);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=goster.getText().toString();
                x+="5";
                goster.setText(x);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=goster.getText().toString();
                x+="6";
                goster.setText(x);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=goster.getText().toString();
                x+="7";
                goster.setText(x);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=goster.getText().toString();
                x+="8";
                goster.setText(x);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=goster.getText().toString();
                x+="9";
                goster.setText(x);
            }
        });

        nkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String x=goster.getText().toString();
                    x+=".";
                    goster.setText(x);
                    nkt.setEnabled(false);
            }
        });

        topla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String a=goster.getText().toString();
                if (a.equals(""))
                {
                    Toast.makeText(hesap_makinesi.this, "Lütfen sayı girdikten sonra işlem yapmaya çalışın.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    birinci=Double.valueOf(goster.getText().toString());
                    islem="top";
                    temizle();
                    nkt.setEnabled(true);
                }

            }
        });

        cikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String a=goster.getText().toString();
                if (a.equals(""))
                {
                    Toast.makeText(hesap_makinesi.this, "Lütfen sayı girdikten sonra işlem yapmaya çalışın.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    birinci=Double.valueOf(goster.getText().toString());
                    islem="cik";
                    temizle();
                    nkt.setEnabled(true);
                }

            }
        });

        carp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String a=goster.getText().toString();
                if (a.equals(""))
                {
                    Toast.makeText(hesap_makinesi.this, "Lütfen sayı girdikten sonra işlem yapmaya çalışın.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    birinci=Double.valueOf(goster.getText().toString());
                    islem="carp";
                    temizle();
                    nkt.setEnabled(true);
                }

            }
        });

        bol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String a=goster.getText().toString();
                if (a.equals(""))
                {
                    Toast.makeText(hesap_makinesi.this, "Lütfen sayı girdikten sonra işlem yapmaya çalışın.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    birinci=Double.valueOf(goster.getText().toString());
                    islem="bol";
                    temizle();
                    nkt.setEnabled(true);
                }

            }
        });

        tmz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goster.setText("");
                birinci=0;
                ikinci=0;
                islem="";
                nkt.setEnabled(true);
            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yeni=goster.getText().toString();

                if(yeni.length()!=0)
                {
                    yeni = yeni.substring(0,yeni.length()-1);
                    goster.setText(yeni);

                    //Düzeltilen Alan
                    if (yeni.length()>0)
                    {
                    Double dsayi=Double.valueOf(goster.getText().toString());
                    Integer ksayi=dsayi.intValue();
                    String knt_sayi=String.valueOf(ksayi);
                    if (yeni.matches(knt_sayi))
                    {
                        nkt.setEnabled(true);
                        //Toast.makeText(hesap_makinesi.this, "Eşleşti yeni:"+yeni+" knt: "+knt_sayi, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        //Toast.makeText(hesap_makinesi.this, "Eşleşmedi yeni:"+yeni+" knt: "+knt_sayi, Toast.LENGTH_SHORT).show();
                        nkt.setEnabled(false);
                    }
                    }
                    //Düzeltilen alan son
                }

            }
        });


    }
    void temizle()
    {
        goster.setText("");
    }
}