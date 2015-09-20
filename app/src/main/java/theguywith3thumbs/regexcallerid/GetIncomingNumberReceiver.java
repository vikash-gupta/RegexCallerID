/*
package theguywith3thumbs.regexcallerid;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

*/
/**
 * Created by home on 15/9/15.
 *//*

public class GetIncomingNumberReceiver extends BroadcastReceiver {

    private final String TAG = "GetIncoming";
    public static String INCOMING_NUMBER = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.i(TAG, "********************************************* inside onReceive()");
        // If bundle doesn't have any incoming data, nothing to do...
        if (bundle == null) {
            return;
        }
        Log.i(TAG, "****************************************** Bundle is not null");
        String incomingState = bundle.getString(TelephonyManager.EXTRA_STATE);
        if(incomingState.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
            INCOMING_NUMBER = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.i(TAG, "INCOMING_NUMBE"+INCOMING_NUMBER);
        }

        // start a service for speaking the contacts
//        Intent service = new Intent(context, SpellContactsService.class);
//        context.startService(service);
    }

}

*/
