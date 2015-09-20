package theguywith3thumbs.regexcallerid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText inputNumberPattern;
    EditText inputName;
    static final String STATE_NUMBER = "inputNumber";

    private void SetupButtonEventHandler()
    {
        mButton = (Button)findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                inputNumberPattern = (EditText) findViewById(R.id.numberPattern);
                RegexCaller.number = inputNumberPattern.getText().toString();
                inputName = (EditText) findViewById(R.id.contactName);
                RegexCaller.name = inputName.getText().toString();
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            RegexCaller.number = savedInstanceState.getString(STATE_NUMBER);
        }

        if(RegexCaller.number !=null)
        {
            inputNumberPattern = (EditText)findViewById(R.id.numberPattern);
            inputNumberPattern.setText(RegexCaller.number);

            inputName = (EditText)findViewById(R.id.contactName);
            inputName.setText(RegexCaller.name);
        }

        SetupButtonEventHandler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Log.i("AppCompatActivity", "onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.i("AppCompatActivity", "onOptionsItemSelected");
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(STATE_NUMBER, RegexCaller.number);
        super.onSaveInstanceState(savedInstanceState);
    }
}
