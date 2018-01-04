package com.example.student.dd2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    ArrayList<String> data;
    TextView tv, tv2;
    EditText ed;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spinner);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        ed = (EditText) findViewById(R.id.editText);

        data = new ArrayList<String>();
        data.add("AA11");
        data.add("BB22");
        data.add("CC33");

        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                data);

        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(data.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void click1(View v)
    {
        int pos = sp.getSelectedItemPosition();
        tv2.setText(data.get(pos));
    }

    public void clickAdd(View v)
    {
        data.add(ed.getText().toString());
        adapter.notifyDataSetChanged();
    }

    public void clickDel(View v)
    {
        data.remove(sp.getSelectedItemPosition());
        adapter.notifyDataSetChanged();
    }
}
