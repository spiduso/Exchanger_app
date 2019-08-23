package com.example.exchanger;

import androidx.appcompat.app.AppCompatActivity;
// import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float rate;
    String help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView currency_input = (TextView) findViewById(R.id.currency_input);
        final TextView currency_output = (TextView) findViewById(R.id.currency_output);
        final EditText amount_input = (EditText) findViewById(R.id.input);
        final TextView amount_output = (TextView) findViewById(R.id.output);
        final Button btn_rate = (Button) findViewById(R.id.btn_rate);

        rate = 0.039f;
        help = "rate: " + rate;
        btn_rate.setText(help);

        btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        Switch cswitch = (Switch) findViewById(R.id.switcher);

        cswitch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String a = currency_input.getText().toString();
                currency_input.setText(currency_output.getText().toString());
                currency_output.setText(a);

                rate = 1 / rate;
                help = "rate: " + rate;
                btn_rate.setText(help);

                a = amount_input.getText().toString();
                amount_input.setText(amount_output.getText().toString());
                amount_output.setText(a);
            }
        });

        amount_input.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (!s.equals("")) {
                    if ("".equals(amount_input.getText().toString())) {
                        amount_output.setText(amount_output.getHint());
                    } else if (".".equals(amount_input.getText().toString())) {
                        amount_input.setText("0.");
                        float a = Float.parseFloat(amount_input.getText().toString());
                        float c = rate * a;
                        amount_output.setText(String.valueOf(c));
                        amount_input.setSelection(amount_input.getText().length());

                    } else {
                        float a = Float.parseFloat(amount_input.getText().toString());
                        float c = rate * a;
                        amount_output.setText(String.valueOf(c));
                        amount_input.setSelection(amount_input.getText().length());
                    }
                }

            }


            public void beforeTextChanged(CharSequence xs, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {
                if ("".equals(amount_input.getText().toString())) {
                    amount_output.setText(amount_output.getHint());
                } else if (".".equals(amount_input.getText().toString())) {
                    amount_input.setText("0.");
                    float a = Float.parseFloat(amount_input.getText().toString());
                    float c = rate * a;
                    amount_output.setText(String.valueOf(c));
                    amount_input.setSelection(amount_input.getText().length());
                }  else {
                    float a = Float.parseFloat(amount_input.getText().toString());
                    float c = rate * a;
                    amount_output.setText(String.valueOf(c));
                    amount_input.setSelection(amount_input.getText().length());
                }
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, ChangeRate.class);
        startActivity(intent);
    }

}
