package com.parent.michal.parnets;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogIn extends Activity {

    Button btnSubmit;
    EditText etFname, etLname, etMail, etPassword, etRepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSoftKeyboard();
        setContentView(R.layout.activity_log_in);
        etFname = (EditText) findViewById(R.id.etfname);
        etLname = (EditText) findViewById(R.id.etLname);
        etMail = (EditText) findViewById(R.id.etMail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etRepassword = (EditText) findViewById(R.id.etRepassword);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     int flag = 1;
                if (etPassword.getText().toString().equals("")) {
                    etPassword.setBackgroundResource(R.drawable.edit_text_red_border);
                    flag = 0;
                }
                if (etRepassword.getText().toString().equals("")) {
                    etRepassword.setBackgroundResource(R.drawable.edit_text_red_border);
                    flag = 0;
                }
                if (etFname.getText().toString().equals("")) {
                    etFname.setBackgroundResource(R.drawable.edit_text_red_border);
                    flag = 0;
                }
                if (etLname.getText().toString().equals("")) {
                    etLname.setBackgroundResource(R.drawable.edit_text_red_border);
                    flag = 0;
                }
                if (etMail.getText().toString().equals("")) {
                    etMail.setBackgroundResource(R.drawable.edit_text_red_border);
                    flag = 0;
                }

                if (flag==1) {
                    String pass=etPassword.getText().toString();
                    String rePass=etRepassword.getText().toString();
                    if (!pass.equals(rePass)) {
                        etPassword.setText("");
                        etRepassword.setText("");
                        Toast.makeText(getApplicationContext(), "passwords do not match", Toast.LENGTH_SHORT).show();
                        etRepassword.setBackgroundResource(R.drawable.edit_text_red_border);
                        etPassword.setBackgroundResource(R.drawable.edit_text_red_border);

                    } else {
                        Intent intent = new Intent(LogIn.this, MainActivity.class);
                        startActivity(intent);
                    }
                }*/
                Intent intent = new Intent(LogIn.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Hides the soft keyboard
     */
    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
