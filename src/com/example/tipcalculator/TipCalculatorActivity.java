package com.example.tipcalculator;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		EditText etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
		etTotalAmount.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(9,2)});
	}

	public void calculateTip(View v) {
		EditText etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
		int tipPercentage = 0;
		double totalAmount = 0, totalTip = 0;
		
		try {
			tipPercentage = Integer.parseInt(v.getTag().toString());
			totalAmount = Double.parseDouble(etTotalAmount.getText().toString());
		} catch (NumberFormatException e) {
			System.out.println("Could not parse " + e);
			Toast.makeText(getApplicationContext(), "Please enter a valid Total Amount", Toast.LENGTH_SHORT).show();
		}
		
		totalTip = (totalAmount/100)*tipPercentage;
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		TextView tvTotalTip = (TextView) findViewById(R.id.tvTotalTip);
		tvTotalTip.setText("Tip is: " + nf.format(totalTip));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
