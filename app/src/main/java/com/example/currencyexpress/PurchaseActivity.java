package com.example.currencyexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

@SuppressLint("Registered")
public class PurchaseActivity extends AppCompatActivity {

    private final double SERVICE_FEE = .05;

    private Button backButton;
    private TextView symbolTextView;
    private TextView exchangeRateTextView;
    private ImageView currencyImageView;
    private EditText quantityEditText;
    private Button completeButton;
    private String symbol;
    private double exchangeRate;
    private String exchangeRateText;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        final NumberFormat formatter = NumberFormat.getCurrencyInstance();

        backButton = findViewById(R.id.back_button);
        symbolTextView = findViewById(R.id.symbol_textview);
        exchangeRateTextView = findViewById(R.id.exchange_rate_textview);
        currencyImageView = findViewById(R.id.currency_imageview);
        quantityEditText = findViewById(R.id.quantity_edittext);
        completeButton = findViewById(R.id.complete_button);
        totalTextView = findViewById(R.id.total_textview);

        symbol = getIntent().getStringExtra("symbol");
        exchangeRate = getIntent().getDoubleExtra("exchangeRate", 0);
        exchangeRateText = MainActivity.ONE_USD + exchangeRate;// + " " + symbol;

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(mainIntent);
            }
        });

        symbolTextView.setText(symbol);
        exchangeRateTextView.setText(exchangeRateText);
        currencyImageView.setImageResource(getIntent().getIntExtra("image", 0));

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity;
                double subTotal;
                double total;
                String totalText;

                quantity = Integer.parseInt(quantityEditText.getText().toString().trim());
                subTotal = (quantity / exchangeRate);
                total = subTotal + (subTotal * SERVICE_FEE);

                totalText = "Total:   " + formatter.format(total);

                totalTextView.setText(totalText);
            }
        });
    }
}
