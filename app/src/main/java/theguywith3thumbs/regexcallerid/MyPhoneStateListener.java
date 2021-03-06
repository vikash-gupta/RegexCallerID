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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPhoneStateListener extends PhoneStateListener {

    private Context activityContext;
    Intent i1;
    Toast toast = null;
    public MyPhoneStateListener(Context context)
    {
        activityContext = context;
     /*   i1 = new Intent(context, IncomingCall.class);
        i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        i1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);*/
    }

    public void onCallStateChanged(int state, String incomingNumber) {
        Log.i(Constants.AppNameForLogging, "onCallStateChanged" +incomingNumber);

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
                if(RegexCaller.number !=null)
                {
                    Pattern r = Pattern.compile(RegexCaller.number);

                    Matcher m = r.matcher(incomingNumber);
                    if (m.find()) {
                        String msg = RegexCaller.name + " is calling";
                        toast = Toast.makeText(activityContext, msg, Toast.LENGTH_LONG);
                        toast.show();

                      /*  try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        activityContext.startActivity(i1);*/
                    }
                }

                break;
        }
    }

}
