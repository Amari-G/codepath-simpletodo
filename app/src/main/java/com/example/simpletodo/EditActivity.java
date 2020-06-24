package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // When the user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etItem.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Oops, you forgot to name your item.", Toast.LENGTH_SHORT).show();
                } else {
                    // Create an intent which will contain the results
                    Intent i = new Intent();

                    // Pass the data
                    i.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                    i.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                    // Set the result of the intent
                    setResult(RESULT_OK, i);

                    // Finish activity, close the screen and go back
                    finish();
                }
            }
        });
    }
}
