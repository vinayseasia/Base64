package com.marakana;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NDKDemo extends Activity {
	 NativeLib nativeLib;

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    nativeLib = new NativeLib();
	    String helloText = nativeLib.hello();

	    // Update the UI
	    TextView outText = (TextView) findViewById(R.id.textOut);
	    outText.setText(helloText);

	    // Setup the UI
	    Button buttonCalc = (Button) findViewById(R.id.buttonCalc);

	    buttonCalc.setOnClickListener(new OnClickListener() {
	      TextView result = (TextView) findViewById(R.id.result);
	      EditText value1 = (EditText) findViewById(R.id.value1);
	      EditText value2 = (EditText) findViewById(R.id.value2);

	      public void onClick(View v) {
	        int v1, v2, res = -1;
	        v1 = Integer.parseInt(value1.getText().toString());
	        v2 = Integer.parseInt(value2.getText().toString());

	        res = nativeLib.add(v1, v2);
	        result.setText(new Integer(res).toString());
	      }
	    });
	  }
	}