package com.duyhq.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Extract the SMS message data from 'intent'
        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);


        for (int i = 0; i < messages.length; i++) {
            SmsMessage currentMessage = messages[i];
            String senderNum = currentMessage.getDisplayOriginatingAddress(); // Get the sender's phone number
            String message = currentMessage.getDisplayMessageBody(); // Content
            Toast.makeText(context, "Sender: " + senderNum + ", message: " + message, Toast.LENGTH_LONG).show();
        }
    }
}
