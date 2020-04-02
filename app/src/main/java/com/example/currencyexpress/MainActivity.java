package com.example.currencyexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ONE_USD = "1 USD = ";

    private RadioButton euroRadioButton;
    private RadioButton kenyaShillingRadioButton;
    private RadioButton indianRupeeRadioButton;
    private RadioButton emiratiDirhamRadioButton;
    private RadioButton mexicanPesoRadioButton;
    private ImageView currencyImageView;
    private TextView exchangeRateTextView;
    private Button purchaseButton;
    private ForeignCurrency[] foreignCurrencies;
    private double rate;
    private String exchangeRateString;
    private String currencySymbol;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euroRadioButton = findViewById(R.id.euro_radio_button);
        kenyaShillingRadioButton = findViewById(R.id.kenyan_shilling_radio_button);
        indianRupeeRadioButton = findViewById(R.id.indian_rupee_radio_button);
        emiratiDirhamRadioButton = findViewById(R.id.emirati_dirham_radio_button);
        mexicanPesoRadioButton = findViewById(R.id.mexican_peso_radio_button);
        currencyImageView = findViewById(R.id.currency_imageview);
        exchangeRateTextView = findViewById(R.id.exchange_rate_textview);
        purchaseButton = findViewById(R.id.purchase_button);

        foreignCurrencies = new ForeignCurrency[5];
        foreignCurrencies[0] = new ForeignCurrency(R.id.euro_radio_button, R.drawable.euro_image,
                                            0.89832);
        foreignCurrencies[1] = new ForeignCurrency(R.id.kenyan_shilling_radio_button,
                                            R.drawable.kenyan_shillings_image, 102.598);
        foreignCurrencies[2] = new ForeignCurrency(R.id.indian_rupee_radio_button,
                                                R.drawable.indian_rupee_image, 74.0252);
        foreignCurrencies[3] = new ForeignCurrency(R.id.emirati_dirham_radio_button,
                                            R.drawable.emirati_dirham_image, 3.6725);
        foreignCurrencies[4] = new ForeignCurrency(R.id.mexican_peso_radio_button,
                                                R.drawable.mexican_peso_image, 20.1123);

        currencySymbol = ForeignCurrency.EURO;

        euroRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 0;
                rate = foreignCurrencies[0].getExchangeRate();
                exchangeRateString = ONE_USD + rate + " " + ForeignCurrency.EURO;
                currencyImageView.setImageResource(R.drawable.euro_image);
                exchangeRateTextView.setText(exchangeRateString);
                currencySymbol = ForeignCurrency.EURO;
            }
        });

        kenyaShillingRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 1;
                rate = foreignCurrencies[1].getExchangeRate();
                exchangeRateString = ONE_USD + rate + " " + ForeignCurrency.KENYA_SHILLING;
                currencyImageView.setImageResource(R.drawable.kenyan_shillings_image);
                exchangeRateTextView.setText(exchangeRateString);
                currencySymbol = ForeignCurrency.KENYA_SHILLING;
            }
        });

        indianRupeeRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 2;
                rate = foreignCurrencies[2].getExchangeRate();
                exchangeRateString = ONE_USD + rate + " " + ForeignCurrency.INDIAN_RUPEE;
                currencyImageView.setImageResource(R.drawable.indian_rupee_image);
                exchangeRateTextView.setText(exchangeRateString);
                currencySymbol = ForeignCurrency.INDIAN_RUPEE;
            }
        });

        emiratiDirhamRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 3;
                rate = foreignCurrencies[3].getExchangeRate();
                exchangeRateString = ONE_USD + rate + " " + ForeignCurrency.EMIRATI_DIRHAM;
                currencyImageView.setImageResource(R.drawable.emirati_dirham_image);
                exchangeRateTextView.setText(exchangeRateString);
                currencySymbol = ForeignCurrency.EMIRATI_DIRHAM;
            }
        });

        mexicanPesoRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = 4;
                rate = foreignCurrencies[4].getExchangeRate();
                exchangeRateString = ONE_USD + rate + " " + ForeignCurrency.MEXICAN_PESO;
                currencyImageView.setImageResource(R.drawable.mexican_peso_image);
                exchangeRateTextView.setText(exchangeRateString);
                currencySymbol = ForeignCurrency.MEXICAN_PESO;
            }
        });

        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent purchaseIntent = new Intent(MainActivity.this,
                                                        PurchaseActivity.class);
                purchaseIntent.putExtra("symbol", currencySymbol);
                purchaseIntent.putExtra("exchangeRate", foreignCurrencies[index].getExchangeRate());
                purchaseIntent.putExtra("image", foreignCurrencies[index].getCurrencyImage());

                startActivity(purchaseIntent);
            }
        });
    }
}
