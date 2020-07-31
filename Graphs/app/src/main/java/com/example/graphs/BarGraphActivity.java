package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarGraphActivity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);
        barChart = findViewById(R.id.bargarph);

        barEntries = new ArrayList<>();

        String v1 = getIntent().getStringExtra("key1");
        String v2 = getIntent().getStringExtra("key2");
        String v3 = getIntent().getStringExtra("key3");
        String v4 = getIntent().getStringExtra("key4");
        String v5 = getIntent().getStringExtra("key5");


        barEntries.add(new BarEntry(2000, Float.parseFloat(v1)));
        barEntries.add(new BarEntry(2001, Float.parseFloat(v2)));
        barEntries.add(new BarEntry(2002, Float.parseFloat(v3)));
        barEntries.add(new BarEntry(2003, Float.parseFloat(v4)));
        barEntries.add(new BarEntry(2004, Float.parseFloat(v5)));

        BarDataSet dataSet = new BarDataSet(barEntries,"Customers");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(16f);

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.animateY(2000);
    }
}