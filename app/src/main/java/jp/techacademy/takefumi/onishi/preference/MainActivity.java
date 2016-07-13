package jp.techacademy.takefumi.onishi.preference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mPreference;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreference = PreferenceManager.getDefaultSharedPreferences(this);
        mEditText = (EditText) findViewById(R.id.edit1);


        Button putButton = (Button) findViewById(R.id.putButton);
        putButton.setOnClickListener(new View.OnClickListener() {
            SharedPreferences.Editor editor = mPreference.edit();


            @Override
            public void onClick(View view) {
                editor.putString("TEXT", mEditText.getText().toString());
                editor.apply();
            }
        });

        Button getButton = (Button) findViewById(R.id.getButton);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText(mPreference.getString("TEXT", "未設定です"));
            }
        });
    }


}
