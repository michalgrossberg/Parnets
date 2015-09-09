package com.parent.michal.parnets;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LogIn extends Activity {

    Button btnSubmit;
    EditText etFname, etLname, etMail, etPassword, etRepassword;
    public static final String BASE_URL = "http://10.0.0.6:3000";

    RestAdapter restAdapter;
    User user;

    @Override
    protected void onRestart() {
        super.onRestart();
        btnSubmit.setBackgroundResource(R.drawable.button_pressed);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

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

                btnSubmit.setBackgroundResource(R.drawable.button_pressed);
                int flag = 1;
/*                if (etPassword.getText().toString().equals("")) {
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

                 user=new User(etFname.getText().toString(),etLname.getText().toString()
                        ,etMail.getText().toString(),etPassword.getText().toString(),UserType.CUSTOMER);

                 restAdapter = new RestAdapter.Builder()
                        .setEndpoint(BASE_URL)
                        .build();
                //once the server will be handy:
        CreateUserAsyncTask createTask =new CreateUserAsyncTask();
                createTask.execute();
                // POST /users/register

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


    class CreateUserAsyncTask extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... params) {
            ServerInterface server=restAdapter.create(ServerInterface.class);
            server.createUser(user,new Callback<User>() {
                @Override
                public void success(User user, Response response) {

                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                    startActivity(intent);
                }

                @Override
                public void failure(RetrofitError retrofitError) {

                    Toast.makeText(getApplicationContext(), retrofitError.toString(), Toast.LENGTH_SHORT).show();

                }
            });

            return null;
        }
    }
}
