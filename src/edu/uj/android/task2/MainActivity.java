package edu.uj.android.task2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    protected IBANValidator validator;
    
    public MainActivity() {
        validator = new IBANValidator();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void actionSend(View v) {
        EditText ibanEdit = (EditText) findViewById(R.id.ibanText);
        String iban = ibanEdit.getText().toString();
        
        validator.setLine(iban);
        
        if (validator.validate()) {
            Toast.makeText(this, "Poprawny IBAN", Toast.LENGTH_LONG).show();
        } else {
            ibanEdit.setError("Błędny IBAN");
        }
    }
}
