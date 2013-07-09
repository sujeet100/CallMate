package com.example.callmate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	final Context context=this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		readSMS();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void readSMS() {
		Button readButton = (Button) findViewById(R.id.readsms);

		readButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
		 alertDialogBuilder.setMessage("Hello :)");
		// set title
			alertDialogBuilder.setTitle("CallMate");
		 alertDialogBuilder.show();
				
								
				//code to read sms
				
				
			}
		});

	}

}