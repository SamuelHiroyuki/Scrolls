package com.example.vitor.scrolsfinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vitor.scrolsfinal.Database.DatabaseHelper;

public class LooginActivity extends AppCompatActivity {

   EditText txtEmail, txtPass;
   String chkEmail, chkPass;
   Button mEmailSignInButton ;
    private UserLoginTask mAuthTask = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loogin);
        txtEmail = (EditText)findViewById(R.id.Email);
        txtPass = (EditText)findViewById(R.id.Pass);
        txtPass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });
        mEmailSignInButton = (Button) findViewById(R.id.sign_in);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }


    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        txtEmail.setError(null);
        txtPass.setError(null);

        // Store values at the time of the login attempt.
        String email = txtEmail.getText().toString();
        String password = txtPass.getText().toString();

        boolean cancel = false;
        View focusView = null;
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            txtPass.setError(getString(R.string.error_incorrect_password));
            focusView = txtPass;
            cancel = true;
    }
        //Define a senha como campo obrigatório
        if(TextUtils.isEmpty(password)){
            txtPass.setError(getString(R.string.error_field_required));
            focusView = txtPass;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            txtEmail.setError(getString(R.string.error_field_required));
            focusView = txtEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            txtEmail.setError(getString(R.string.error_invalid_email));
            focusView = txtEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.

            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }


    private boolean isEmailValid(String email) {

        email = txtEmail.getText().toString() ;
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT * FROM User WHERE EmailUser = "+" '"+email+"'";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.getCount()==1){


            helper.close();
            return true;
        }
        else{helper.close();return false;}
    }

    public void trocar() {
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String email = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();
        String query = "SELECT * FROM User WHERE EmailUser =" + " '" + email + "'" + "AND" + " '" + pass + "'";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            int id = cursor.getInt(0);
            String password = cursor.getString(1);
            String name = cursor.getString(2);
            String emailStr = cursor.getString(3);

            }
            Intent i = new Intent(this, PrincipalActivity.class);
        startActivity(i);

                }










    private boolean isPasswordValid(String password) {

        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String email = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();
        String query = "SELECT * FROM User WHERE PassUser = "+" '"+pass+"' AND EmailUser = '"+email+"'";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.getCount()==1){

            helper.close();
            return true;
        }
        else{helper.close();return false;}

    }
    /*
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }
    */

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }



        @Override
        protected Boolean doInBackground(Void... voids) {

/*
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }*/
            return true;
        }
        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;


            if (success) {
                trocar();
            } else {
                txtPass.setError(getString(R.string.error_incorrect_password));
                txtEmail.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;

        }


    }
    public void Cad (View v){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }
    }

/* https://developers.google.com/identity/sign-in/android/start-integrating
* https://developers.google.com/identity/sign-in/android/sign-in
* links para usuario se cadastrar com conta do Google
* */