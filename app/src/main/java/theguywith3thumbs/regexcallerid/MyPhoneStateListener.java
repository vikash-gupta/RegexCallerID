package theguywith3thumbs.regexcallerid;

/**
 * Created by home on 15/9/15.
 */
//http://stackoverflow.com/questions/10136490/get-phone-number-of-present-incoming-and-outgoing-call
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyPhoneStateListener extends PhoneStateListener {

    private Context activityContext;
    Context context; // Context to make Toast if required
    Intent i1;
    Toast toast = null;
    public MyPhoneStateListener(Context context)
    {
        activityContext = context;
        /*i1 = new Intent(context, MainActivity.class);
        i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);*/
    }

    public void onCallStateChanged(int state, String incomingNumber) {
        Log.i("MyPhoneStateListener", "onCallStateChanged" +incomingNumber);

        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                if(toast !=null)
                    toast.cancel();
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                if(toast !=null)
                    toast.cancel();
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                if(incomingNumber.contains(RegexCaller.number)) {
                    String msg = RegexCaller.name + " is calling";
                    toast = Toast.makeText(activityContext,msg, Toast.LENGTH_LONG);
                    toast.show();
                }

                break;

                /*try {
                    Toast toast = Toast.makeText(activityContext,
                            "Going for sleep and activity will start", Toast.LENGTH_LONG);
                    toast.show();
                    Thread.sleep(3000);
                    activityContext.startActivity(i1);
                } catch (Exception e) {
                    Log.i("Error",e.getLocalizedMessage());
                }
                break;*/
        }
    }

}
