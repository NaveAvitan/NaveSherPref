package com.example.navesherpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    TextView tvx;
    String str;
    Integer x2;

    int x;

    /**
     * set the options menu
     *
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    /**
     * here you move to credit activity
     *
     * @param menu
     * @return
     */
    public boolean onOptionsItemSelected(MenuItem menu) {
        String st = menu.getTitle().toString();
        if ((st.equals("credits"))) {
            Intent si = new Intent(this, credits.class);
            startActivity(si);
        }


        return true;
    }

    /**
     * here you Declaration of variables
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.editText);
        tvx = findViewById(R.id.textView);
         x = 0;
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
         x2=settings.getInt("thenum",-3);
        String str=settings.getString("theword","tryagain");
        x=x2+x;
        tvx.setText(""+x2);
        edt.setText(str);




    }

    /**
     * here you add 1 to the counter every click and presenting the counter
     * @param view
     */

    public void cou(View view) {
        x++;
        tvx.setText(""+x);

    }

    /**
     * here you reset the counter
     * @param view
     */
    public void res(View view) {
        x=0;
        tvx.setText(""+0);
    }

    /**
     * here you save your shared preferneces and finish the app
     * @param view
     */
    public void ex(View view) {
        str= edt.getText().toString();
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("thenum",x);
        editor.putString("theword",str);
        editor.commit();
        finish();
    }
}
