package com.example.oleh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class GrafActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graf);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        Double x1,y1,x2,y2,x3,y3,x4,y4;
        Integer minx, maxx;
        x1 = intent.getDoubleExtra("com.example.oleh.project.x1", 0);
        x2 = intent.getDoubleExtra("com.example.oleh.project.x2", 0);
        x3 = intent.getDoubleExtra("com.example.oleh.project.x3", 0);
        x4 = intent.getDoubleExtra("com.example.oleh.project.x4", 0);
        y1 = intent.getDoubleExtra("com.example.oleh.project.y1", 0);
        y2 = intent.getDoubleExtra("com.example.oleh.project.y2", 0);
        y3 = intent.getDoubleExtra("com.example.oleh.project.y3", 0);
        y4 = intent.getDoubleExtra("com.example.oleh.project.y4", 0);
        minx = intent.getIntExtra("com.example.oleh.project.minx", 0);
        maxx = intent.getIntExtra("com.example.oleh.project.maxx", 0);


        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        ArrayList list = extrapolateForGrafic(minx,maxx,x1,y1,x2,y2,x3,y3,x4,y4);
        int num = minx-maxx;
        for (int i = minx; i<=maxx; i++) {
            series.appendData(new DataPoint(i,(Double) list.get(i)),true,list.size());
        }
        graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.addSeries(series);


        // Capture the layout's TextView and set the string as its text
       // TextView textView = (TextView) findViewById(R.id.textViewX);
       // textView.setText(message.toString());
    }

    public ArrayList extrapolateForGrafic(int minX, int maxX, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        ArrayList massiv = new ArrayList<>();
        int numberOfIterations = maxX - minX;
        for (int x = minX; x <= numberOfIterations; x++) {
            double L1 = (y1) * (((x - x2) * (x - x3) * (x - x4)) / ((x1 - x2) * (x1 - x3) * (x1 - x4)));
            double L2 = (y2) * (((x - x1) * (x - x3) * (x - x4)) / ((x2 - x1) * (x2 - x3) * (x2 - x4)));
            double L3 = (y3) * (((x - x1) * (x - x2) * (x - x4)) / ((x3 - x1) * (x3 - x2) * (x3 - x4)));
            double L4 = (y4) * (((x - x1) * (x - x2) * (x - x3)) / ((x4 - x1) * (x4 - x2) * (x4 - x3)));
            double y = L1 + L2 + L3 + L4;
            massiv.add(y);
        }
        return massiv;
    }
}
