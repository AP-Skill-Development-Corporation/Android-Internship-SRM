package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActiivty extends AppCompatActivity {

    PieChart pieChart;
    ArrayList<PieEntry> pieEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_actiivty);
        pieChart =findViewById(R.id.pichart);

        pieEntries = new ArrayList<>();

        String v1 = getIntent().getStringExtra("key1");
        String v2 = getIntent().getStringExtra("key2");
        String v3 = getIntent().getStringExtra("key3");
        String v4 = getIntent().getStringExtra("key4");
        String v5 = getIntent().getStringExtra("key5");

        pieEntries.add(new PieEntry(Float.parseFloat(v1),"2015"));
        pieEntries.add(new PieEntry(Float.parseFloat(v2),"2016"));
        pieEntries.add(new PieEntry(Float.parseFloat(v3),"2017"));
        pieEntries.add(new PieEntry(Float.parseFloat(v4),"2018"));
        pieEntries.add(new PieEntry(Float.parseFloat(v5),"2019"));

        PieDataSet dataSet =new PieDataSet(pieEntries,"Students");
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setValueTextSize(16f);
        dataSet.setValueTextColor(Color.WHITE);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.setCenterText("Students");
        pieChart.getDescription().setEnabled(false);
        pieChart.animate();

    }
}