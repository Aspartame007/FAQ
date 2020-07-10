package com.example.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableTextView = findViewById(R.id.expandable_View);
        ExpandableTextViewAdapter adapter = new ExpandableTextViewAdapter(MainActivity.this);
        expandableTextView.setAdapter(adapter);
    }
}