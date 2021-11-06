package com.example.quiz_real;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  public static ArrayList<Modelclass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new Modelclass("what .... name ? ","a","b","c","d","ans"));

        list.add(new Modelclass("where are we form ? ","cambodia","Thailand","Laos","Vietnam","cambodia"));

    }
}