package sg.edu.rp.c346.id21021785.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float fltGPA = Float.parseFloat(etGPA.getText().toString());
        SharedPreferences namePref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = namePref.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", fltGPA);
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String savedName = prefs.getString("name", "John");
        float savedGPA = prefs.getFloat("gpa", 0);
        etName.setText(savedName);
        etGPA.setText(savedGPA +"");
    }
}