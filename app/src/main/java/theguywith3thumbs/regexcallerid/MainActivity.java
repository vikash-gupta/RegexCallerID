package theguywith3thumbs.regexcallerid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText inputNumberPattern;
    EditText inputName;
    static final String STATE_NUMBER = "inputNumber";
    static final String STATE_NAME = "inputName";

    private void SetupButtonEventHandler()
    {
        mButton = (Button)findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                inputNumberPattern = (EditText) findViewById(R.id.number);
                RegexCaller.number = inputNumberPattern.getText().toString();

                inputName = (EditText) findViewById(R.id.name);
                RegexCaller.name = inputName.getText().toString();
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.activity_main);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            RegexCaller.number = savedInstanceState.getString(STATE_NUMBER);
            RegexCaller.name = savedInstanceState.getString(STATE_NAME);
        }

        if(RegexCaller.number !=null && RegexCaller.name !=null)
        {
            inputNumberPattern = (EditText)findViewById(R.id.number);
            inputNumberPattern.setText(RegexCaller.number);

            inputName = (EditText)findViewById(R.id.name);
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
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(STATE_NUMBER, RegexCaller.number);
        savedInstanceState.putString(STATE_NAME, RegexCaller.name);

    }
}
