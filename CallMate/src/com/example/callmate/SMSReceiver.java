package com.example.callmate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {

	private final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
	
	@Override
	public void onReceive(Context context, Intent intent) {

		
		if (intent.getAction().equals(ACTION)) {
			Bundle bundle = intent.getExtras();

			if (bundle != null) {
				Object[] pdusObj = (Object[]) bundle.get("pdus");
				SmsMessage message = SmsMessage
						.createFromPdu((byte[]) pdusObj[0]);
				String smsMessage = message.getMessageBody();
				if (smsMessage.contains("FLAG"))
					smsMessage = smsMessage.replaceAll("FLAG", "");

				System.out.println("\n\n======================\n"+smsMessage+"\n\n");

				SMSParser parser=new SMSParser(smsMessage);
				if(parser.isValidMessage()){
					System.out.println("Valid message..");
					new CallHandler().callNumber(parser.getNumbers().get(0));
				}
			 
			}

		}

	}

}
