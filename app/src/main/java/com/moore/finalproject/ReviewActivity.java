package com.moore.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.moore.finalproject.database.MyDBHandler;

public class ReviewActivity extends AppCompatActivity {

    //define your widget variable layout

    private TableLayout tableLayout;

    //define SQL controller variable
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        //get reference to the layout widget
        tableLayout = (TableLayout) findViewById(R.id.tableLayout1);

        // instantiate the handler constructor
        dbHandler = new MyDBHandler(this);

        //ball the build table method
        BuildTable();
    }

    // responsible for building the table programically
    private void BuildTable() {
        dbHandler.open();
        Cursor c = dbHandler.readEntry();

        int rows = c.getCount();
        int cols = c.getColumnCount();

        c.moveToFirst();

        // outer for loop
        TableRow row = null;
        for (int i = 0; i < rows; i++) {

            // How i want my tow to be laid out

            row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TableRow tr1=(TableRow)v;
                    TextView tv1= (TextView)tr1.getChildAt(0);

                    Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                    intent.putExtra("id", tv1.getText().toString());
                    startActivity(intent);
                }
            });

            // inner for loop
            for (int j = 0; j < cols; j++) {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                tv.setBackgroundResource(R.drawable.cell_shape);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);
                tv.setTextColor(Color.BLACK);

                tv.setText(c.getString(j));

                row.addView(tv);
            }


            c.moveToNext();

            tableLayout.addView(row);

            // close datable
            dbHandler.close();
        }
    }
}