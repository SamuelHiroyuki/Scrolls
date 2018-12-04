package com.example.vitor.scrolsfinal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.vitor.scrolsfinal.CadastroActivity;
import com.example.vitor.scrolsfinal.Classes.AppState;
import com.example.vitor.scrolsfinal.Classes.User;
import com.example.vitor.scrolsfinal.Database.DatabaseHelper;
import com.example.vitor.scrolsfinal.PrincipalActivity;
import com.example.vitor.scrolsfinal.R;

import static com.example.vitor.scrolsfinal.CadastroActivity.PREF_PASSWORD;
import static com.example.vitor.scrolsfinal.CadastroActivity.PREF_USERNAME;
import static com.example.vitor.scrolsfinal.CadastroActivity.PREF_USER_ID;

public class LooginActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    private static final String PREF_UNAME = "Email";
    private static final String PREF_PASSWORD = "Password";
    private final String DefaultUnameValue = "";
    private String UnameValue;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    private final String DefaultPasswordValue = "";
    private String PasswordValue;
    private EditText txtEmail, txtPass;
    private String chkEmail, chkPass;
    private Button mEmailSignInButton;
    private UserLoginTask mAuthTask = null;
    private String username, password;
    CheckBox chkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loogin);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtPass = (EditText) findViewById(R.id.Pass);




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


        mEmailSignInButton = (Button) findViewById(R.id.log_in);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();

                loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
                loginPrefsEditor = loginPreferences.edit();
                saveLogin = loginPreferences.getBoolean("saveLogin", false);

                txtEmail.setText(loginPreferences.getString("username", ""));
                txtPass.setText(loginPreferences.getString("password", ""));

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
        chkPass = password;

        boolean cancel = false;
        View focusView = null;
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            txtPass.setError(getString(R.string.error_incorrect_password));
            focusView = txtPass;
            cancel = true;
        }
        //Define a senha como campo obrigatório
        if (TextUtils.isEmpty(password)) {
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

        email = txtEmail.getText().toString();
        chkEmail = email;
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String query = "SELECT * FROM User WHERE EmailUser = " + " '" + email + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() == 1) {


            helper.close();
            return true;
        } else {
            helper.close();
            return false;
        }
    }

    public void trocar() {
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String email = txtEmail.getText().toString();
        String pass = txtPass.getText().toString();

        String query = "SELECT * FROM User WHERE EmailUser =" + " '" + chkEmail + "'" + "AND PassUser =" + " '" + chkPass + "'";
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        User usuario = new User();
        for (int i = 0; i < cursor.getCount(); i++) {
            int id = cursor.getInt(0);
            String password = cursor.getString(1);
            String name = cursor.getString(2);
            String emailStr = cursor.getString(3);
            usuario = new User(id, password, name, emailStr);

        }
       int idUser = usuario.get_IdUser();
       String ID_USER =  Integer.toString(idUser);
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                .edit()
                .putString(PREF_USER_ID, ID_USER)

                .commit();
        Intent i = new Intent(this, PrincipalActivity.class);
        i.putExtra("LoggedUser", usuario);
        startActivity(i);


    }




public void onClick(View view){
        if (view == mEmailSignInButton){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(txtEmail.getWindowToken(),0);

            username = txtEmail.getText().toString();
            password = txtPass.getText().toString();

                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", username);
                loginPrefsEditor.putString("password", password);
                loginPrefsEditor.commit();


        }
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

    @Override
    public void onPause(){
        super.onPause();
        savePreferences();
    }
    public void onResume(){
        super.onResume();
        loadPreferences();
    }
    private void savePreferences(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        //Editar e comitar
        UnameValue = txtEmail.getText().toString();
        PasswordValue = txtPass.getText().toString();
        editor.putString(PREF_UNAME, UnameValue);
        editor.putString(PREF_PASSWORD, PasswordValue);
        editor.commit();
    }
    private void loadPreferences(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        //Get value
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);
        txtEmail.setText(UnameValue);
        txtPass.setText(PasswordValue);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }
}

/* https://developers.google.com/identity/sign-in/android/start-integrating
 * https://developers.google.com/identity/sign-in/android/sign-in
 * links para usuario se cadastrar com conta do Google
 * */