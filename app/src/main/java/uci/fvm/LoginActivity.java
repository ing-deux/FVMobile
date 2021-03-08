package uci.fvm;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText userText;
    private EditText pswdText;
    private Button loginButton;

    private static final String TAG = "ActivityLogin";
    private static final int REQUEST_SIGNUP = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userText=(EditText)findViewById(R.id.input_user);
        pswdText=(EditText)findViewById(R.id.input_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginButton=(Button)findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Login() {
        Log.d(TAG, "Login");
        if (!validate()) {
            onLoginFailed();
            return;
        }
        loginButton.setEnabled(false);

        final ProgressDialog progresDialog=new ProgressDialog(LoginActivity.this);
        progresDialog.setIndeterminate(true);
        progresDialog.setMessage("Iniciando Sesión...");
        progresDialog.show();

        String user=userText.getText().toString();
        String pswd=pswdText.getText().toString();

        //Implementar Autenticacion


        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginSuccess();

                progresDialog.dismiss();
            }
        },3000);
    }

    private void onLoginSuccess() {
        loginButton.setEnabled(true);
        finish();
    }

    private void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
    }

    public boolean validate() {
        boolean valid = true;

        String user=userText.getText().toString();
        String pswd=pswdText.getText().toString();

        if (user.isEmpty()){
            userText.setError("El campo esta vacio");
            valid=false;
        }
        if (pswd.isEmpty() || pswd.length()<4){
            pswdText.setError("Contraseña demasiado corta");
            valid=false;
        }
        return valid;
    }
}
