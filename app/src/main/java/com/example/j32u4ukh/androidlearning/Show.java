package com.example.j32u4ukh.androidlearning;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Show extends AppCompatActivity {
    TableLayout tableLayout;
    Map<String, Integer> map = new HashMap<>();
    String imageData[][] = new String[][] { { "001", "002", "002"},
            { "002", "001", "001"},
            { "002", "001", "001"} };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        tableLayout = (TableLayout)findViewById(R.id.tableLayout);
        tableLayout.setStretchAllColumns(true);
        map.put("001", R.drawable.back_side);
        map.put("002", R.drawable.card);
        map.put("003", R.drawable.hello_earth);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LayoutParams layoutParams = new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int imageWidth = (int) (displayMetrics.widthPixels * 0.3);
        int imageHeight = (int) (displayMetrics.heightPixels * 0.3);

        // 清除原本的表格內容
        tableLayout.removeAllViewsInLayout();

        // 橫的
        for (String[] row : imageData) {
            TableRow tablerow = new TableRow(Show.this);
            tablerow.setBackgroundColor(Color.rgb(100, 180, 70));

            // 直的
            for (final String column : row) {
                ImageView imageView = new ImageView(Show.this);
                imageView.setImageDrawable(getResources().getDrawable(map.get(column)));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Show.this, column, Toast.LENGTH_SHORT).show();
                    }
                });
                imageView.setLayoutParams(new TableRow.LayoutParams(imageWidth, imageHeight));
                tablerow.addView(imageView);
            }

            tableLayout.addView(tablerow, layoutParams);
        }

    }
}
