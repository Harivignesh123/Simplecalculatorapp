package android.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button t=(Button) findViewById(R.id.getstarted);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 i=new Intent(MainActivity.this,calculator.class);
                 startActivity(i);
            }
        });
    }
}
