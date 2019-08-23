package com.example.exchanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ChangeRate extends AppCompatActivity {

    String chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_rate);

        final Spinner spin1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spin2 = (Spinner) findViewById(R.id.spinner2);

        // --- spinner1 ---
        List<String> currency = new ArrayList<String>();
        currency.add("EUR");
        currency.add("HUF");
        currency.add("CZK");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currency);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin1.setAdapter(dataAdapter);

        // --- spinner1 ---

        // --- spinner2 ---
        final List<String> currency2 = new ArrayList<String>();
        currency2.add("EUR");
        currency2.add("HUF");
        currency2.add("CZK");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, currency2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spin2.setAdapter(dataAdapter2);
        // --- spinner2 ---

        spin1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chosen = spin1.getSelectedItem().toString();
                if (spin2.getSelectedItem().toString() == chosen) {
                    if (spin2.getSelectedItemPosition() - 1 == -1)
                        spin2.setSelection(spin2.getSelectedItemPosition() + 1);
                    else
                        spin2.setSelection(spin2.getSelectedItemPosition() - 1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

        spin2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chosen = spin2.getSelectedItem().toString();
                if (spin1.getSelectedItem().toString() == chosen) {
                    if (spin1.getSelectedItemPosition() - 1 == -1)
                        spin1.setSelection(spin1.getSelectedItemPosition() + 1);
                    else
                        spin1.setSelection(spin1.getSelectedItemPosition() - 1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
    }
}
