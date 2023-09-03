package com.example.lab1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab1.databinding.ActivityMain2Binding;
import com.example.lab1.databinding.ActivityMainBinding;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


    ActivityMain2Binding binding;



    String adivinare = "";
    String adivinando = "";

    Integer tries = 0;

    ArrayList<String> pressedLetters = new ArrayList<>();


    private long StartTime=0;
    private long StopTime=0;
    private boolean contadorActivo = false;

    ArrayList<String> registros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        boolean start = getIntent().getBooleanExtra("start",false);
        if(start){
            StartGame();
        }


        binding.button7.setOnClickListener(v -> {
             String adivinar =  StartGame();
            Log.d("Palabra a adivinar: ", adivinar);
        });



        binding.a.setOnClickListener(v -> {
            if(!pressedLetters.contains("A")){
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.a.getText());
                positions=  encontrarPosicionesDeLetra(adivinare,'A');
                if(positions.size()==0){
                    noHayLetra();
                }else{
                    adivinando = revelarLetras(adivinare,adivinando,'A');
                }

                pressedLetters.add("A");
            }


        });
        binding.d.setOnClickListener(v -> {
            if(!pressedLetters.contains("D")){
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.d.getText());
                positions=  encontrarPosicionesDeLetra(adivinare,'D');
                if(positions.size()==0){
                    noHayLetra();
                }else{
                    adivinando = revelarLetras(adivinare,adivinando,'D');
                }

                pressedLetters.add("D");
            }


        });
        binding.e.setOnClickListener(v -> {
            if(!pressedLetters.contains("E")){
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.e.getText());
                positions=  encontrarPosicionesDeLetra(adivinare,'E');
                if(positions.size()==0){
                    noHayLetra();
                }else{
                    adivinando = revelarLetras(adivinare,adivinando,'E');
                }

                pressedLetters.add("E");
            }


        });
        binding.r.setOnClickListener(v -> {
            if(!pressedLetters.contains("R")){
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.r.getText());
                positions=  encontrarPosicionesDeLetra(adivinare,'R');
                if(positions.size()==0){
                    noHayLetra();
                }else{
                    adivinando = revelarLetras(adivinare,adivinando,'R');
                }

                pressedLetters.add("R");
            }


        });
        binding.s.setOnClickListener(v -> {
            if(!pressedLetters.contains("S")){
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.s.getText());
                positions=  encontrarPosicionesDeLetra(adivinare,'S');
                if(positions.size()==0){
                    noHayLetra();

                }else{
                    adivinando = revelarLetras(adivinare,adivinando,'S');
                }

                pressedLetters.add("S");
            }


        });

        binding.b.setOnClickListener(v -> {
            if (!pressedLetters.contains("B")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.b.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'B');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'B');
                }

                pressedLetters.add("B");
            }
        });

        binding.c.setOnClickListener(v -> {
            if (!pressedLetters.contains("C")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.c.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'C');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'C');
                }

                pressedLetters.add("C");
            }
        });

        binding.f.setOnClickListener(v -> {
            if (!pressedLetters.contains("F")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.f.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'F');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'F');
                }

                pressedLetters.add("F");
            }
        });

        binding.g.setOnClickListener(v -> {
            if (!pressedLetters.contains("G")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.g.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'G');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'G');
                }

                pressedLetters.add("G");
            }
        });

        binding.h.setOnClickListener(v -> {
            if (!pressedLetters.contains("H")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.h.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'H');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'H');
                }

                pressedLetters.add("H");
            }
        });

        binding.i.setOnClickListener(v -> {
            if (!pressedLetters.contains("I")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.i.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'I');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'I');
                }

                pressedLetters.add("I");
            }
        });

        binding.j.setOnClickListener(v -> {
            if (!pressedLetters.contains("J")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.j.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'J');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'J');
                }

                pressedLetters.add("J");
            }
        });

        binding.k.setOnClickListener(v -> {
            if (!pressedLetters.contains("K")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.k.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'K');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'K');
                }

                pressedLetters.add("K");
            }
        });

        binding.l.setOnClickListener(v -> {
            if (!pressedLetters.contains("L")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.l.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'L');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'L');
                }

                pressedLetters.add("L");
            }
        });

        binding.m.setOnClickListener(v -> {
            if (!pressedLetters.contains("M")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.m.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'M');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'M');
                }

                pressedLetters.add("M");
            }
        });

        binding.n.setOnClickListener(v -> {
            if (!pressedLetters.contains("N")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.n.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'N');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'N');
                }

                pressedLetters.add("N");
            }
        });

        binding.o.setOnClickListener(v -> {
            if (!pressedLetters.contains("O")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.o.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'O');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'O');
                }

                pressedLetters.add("O");
            }
        });

        binding.p.setOnClickListener(v -> {
            if (!pressedLetters.contains("P")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.p.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'P');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'P');
                }

                pressedLetters.add("P");
            }
        });

        binding.q.setOnClickListener(v -> {
            if (!pressedLetters.contains("Q")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.q.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'Q');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'Q');
                }

                pressedLetters.add("Q");
            }
        });

        binding.t.setOnClickListener(v -> {
            if (!pressedLetters.contains("T")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.t.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'T');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'T');
                }

                pressedLetters.add("T");
            }
        });

        binding.u.setOnClickListener(v -> {
            if (!pressedLetters.contains("U")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.u.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'U');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'U');
                }

                pressedLetters.add("U");
            }
        });

        binding.v.setOnClickListener(v -> {
            if (!pressedLetters.contains("V")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.v.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'V');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'V');
                }

                pressedLetters.add("V");
            }
        });

        binding.w.setOnClickListener(v -> {
            if (!pressedLetters.contains("W")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.w.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'W');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'W');
                }

                pressedLetters.add("W");
            }
        });

        binding.x.setOnClickListener(v -> {
            if (!pressedLetters.contains("X")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.x.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'X');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'X');
                }

                pressedLetters.add("X");
            }
        });

        binding.y.setOnClickListener(v -> {
            if (!pressedLetters.contains("Y")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.y.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'Y');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'Y');
                }

                pressedLetters.add("Y");
            }
        });

        binding.z.setOnClickListener(v -> {
            if (!pressedLetters.contains("Z")) {
                ArrayList<Integer> positions = new ArrayList<>();

                Log.d("LetraPresionada: ", (String) binding.z.getText());
                positions = encontrarPosicionesDeLetra(adivinare, 'Z');
                if (positions.size() == 0) {
                    noHayLetra();
                } else {
                    adivinando = revelarLetras(adivinare, adivinando, 'Z');
                }

                pressedLetters.add("Z");
            }
        });








    }

    /*Para el menu*/
    //--------------------------------
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public void statsBtn(MenuItem menuItem){
        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
        intent.putStringArrayListExtra("registro",registros);
        launcher.launch(intent);
    }

    //------------------------------
    public String StartGame(){
        Random random = new Random();
        String palabra = GameContants.words.get(random.nextInt(6));
        String underscore = generarGuiones(palabra);
        binding.wordTextView.setText(underscore);
        binding.wordTextView.setGravity(Gravity.CENTER_HORIZONTAL);

        tries=0;
        getDraw();


        //El contador activa inicia con false por default

        //Si al entrar aca esta con true

        //debo pararlo



        if (!contadorActivo) {
            StartTime = System.currentTimeMillis()/1000;
            contadorActivo=true;
        } else{
            String cancel = "Se cancelo: "+ finishing()+ " segundos";
            binding.count.setText(cancel);
            contadorActivo=!contadorActivo;
            registros.add(cancel);
        }

        pressedLetters.clear();
        adivinare = palabra;
        return palabra;
    }


    public String generarGuiones(String palabra){
        String guiones = "";
        for(int i = 0; i<palabra.length();i++){
            guiones = guiones+"_";

        }
        adivinando = guiones;
        return guiones;
    }

    public ArrayList<Integer> encontrarPosicionesDeLetra(String palabra, char letra) {
        ArrayList<Integer> posiciones = new ArrayList<>();

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                posiciones.add(i);
            }
        }

        return posiciones;
    }


    public String revelarLetras (String adivinare,String guiones, char letraAdivinada){

        char[] guionesArray = guiones.toCharArray();
        char[] adivinareArray = adivinare.toCharArray();

        for(int i = 0; i<guiones.toCharArray().length;i++){
            if(adivinareArray[i] ==letraAdivinada){
                guionesArray[i] = letraAdivinada;
            }
        }
        binding.wordTextView.setText(String.valueOf(guionesArray));

        posibleWin(String.valueOf(guionesArray));


        return String.valueOf(guionesArray);
    }

    public void getDraw(){

        switch (tries) {
            case 0:
                binding.imageView2.setImageResource(R.drawable.game0);
                break;
            case 1:
                binding.imageView2.setImageResource(R.drawable.game1);
                break;
            case 2:
                binding.imageView2.setImageResource(R.drawable.game2);
                break;
            case 3:
                binding.imageView2.setImageResource(R.drawable.game3);
                break;
            case 4:
                binding.imageView2.setImageResource(R.drawable.game4);
                break;
            case 5:
                binding.imageView2.setImageResource(R.drawable.game5);
                break;
            case 6:
                binding.imageView2.setImageResource(R.drawable.game6);
                break;
            case 7:
                binding.imageView2.setImageResource(R.drawable.game7);
                break;
            default:
                binding.imageView2.setImageResource(R.drawable.game7);
                break;
        }


    }

    public String finishing (){
        StopTime = System.currentTimeMillis()/1000;
        String rpta = String.valueOf(StopTime-StartTime);

        return rpta;
    }


    public void posibleWin (String adivinando){



        if(!adivinando.contains("_")){
            String win = "Ganó / Terminó en "+ finishing() +" segundos";
            contadorActivo = !contadorActivo;
            binding.count.setText(win);
            registros.add(win);

        }

    }

    public void noHayLetra(){
        tries++;
        getDraw();

        if(tries==7){
            String fail = "Perdió en "+finishing()+ " segundos";
            registros.add(fail);
            binding.count.setText(fail);
            contadorActivo=!contadorActivo;
        }
    }


    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode()==RESULT_OK){
                    Intent data = result.getData();
                    boolean newgame = data.getBooleanExtra("newgame",false);
                    if(newgame){
                        StartGame();
                    }
                }
            }
    );


}