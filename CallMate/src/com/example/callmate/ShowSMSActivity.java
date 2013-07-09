package com.example.callmate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

public class ShowSMSActivity extends Activity{

	final Context context=this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
	}
	
	public void displaySMS(String smsText) {

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setMessage(smsText);
		// set title
		alertDialogBuilder.setTitle("CallMate");
		alertDialogBuilder.show();

	}
	
}
