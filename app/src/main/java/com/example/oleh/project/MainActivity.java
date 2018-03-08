package com.example.oleh.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttoneOne (View w) {

        double x1,y1,x2,y2,x3,y3,x4,y4;
        EditText x1Viev = (EditText) findViewById(R.id.x1);
        x1 = Double.parseDouble(x1Viev.getText().toString());
        EditText x2Viev = (EditText) findViewById(R.id.x2);
        x2 = Double.parseDouble(x2Viev.getText().toString());
        EditText x3Viev = (EditText) findViewById(R.id.x3);
        x3 = Double.parseDouble(x3Viev.getText().toString());
        EditText x4Viev = (EditText) findViewById(R.id.x4);
        x4 = Double.parseDouble(x4Viev.getText().toString());
        EditText y1Viev = (EditText) findViewById(R.id.y1);
        y1 = Double.parseDouble(y1Viev.getText().toString());
        EditText y2Viev = (EditText) findViewById(R.id.y2);
        y2 = Double.parseDouble(y2Viev.getText().toString());
        EditText y3Viev = (EditText) findViewById(R.id.y3);
        y3 = Double.parseDouble(y3Viev.getText().toString());
        EditText y4Viev = (EditText) findViewById(R.id.y4);
        y4 = Double.parseDouble(y4Viev.getText().toString());
        double tn;
        EditText tnViev = (EditText) findViewById(R.id.tn);
        tn = Double.parseDouble(tnViev.getText().toString());

        Double Tn = (Double) extrapolateForValue(tn,x1,y1,x2,y2,x3,y3,x4,y4);

        TextView TnView = (TextView) findViewById(R.id.Tn);
        TnView.setText(Tn.toString());
    }



    public  double extrapolateForValue(double x, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {

            double L1 = (y1) * (((x - x2) * (x - x3) * (x - x4)) / ((x1 - x2) * (x1 - x3) * (x1 - x4)));
            double L2 = (y2) * (((x - x1) * (x - x3) * (x - x4)) / ((x2 - x1) * (x2 - x3) * (x2 - x4)));
            double L3 = (y3) * (((x - x1) * (x - x2) * (x - x4)) / ((x3 - x1) * (x3 - x2) * (x3 - x4)));
            double L4 = (y4) * (((x - x1) * (x - x2) * (x - x3)) / ((x4 - x1) * (x4 - x2) * (x4 - x3)));
            double y = L1 + L2 + L3 + L4;
            return y;
    }

    public void launchNewActivity(View view) {
        Intent intent = new Intent(this, GrafActivity.class);

        double x1,y1,x2,y2,x3,y3,x4,y4;
        Integer minx, maxx;

        TextView x1Viev = (TextView) findViewById(R.id.x1);
        x1 = Double.parseDouble(x1Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.x1", x1);
        EditText x2Viev = (EditText) findViewById(R.id.x2);
        x2 = Double.parseDouble(x2Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.x2", x2);
        EditText x3Viev = (EditText) findViewById(R.id.x3);
        x3 = Double.parseDouble(x3Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.x3", x3);
        EditText x4Viev = (EditText) findViewById(R.id.x4);
        x4 = Double.parseDouble(x4Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.x4", x4);
        EditText y1Viev = (EditText) findViewById(R.id.y1);
        y1 = Double.parseDouble(y1Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.y1", y1);
        EditText y2Viev = (EditText) findViewById(R.id.y2);
        y2 = Double.parseDouble(y2Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.y2", y2);
        EditText y3Viev = (EditText) findViewById(R.id.y3);
        y3 = Double.parseDouble(y3Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.y3", y3);
        EditText y4Viev = (EditText) findViewById(R.id.y4);
        y4 = Double.parseDouble(y4Viev.getText().toString());
        intent.putExtra("com.example.oleh.project.y4", y4);

        EditText minXViev = (EditText) findViewById(R.id.graficStart);
        minx = Integer.parseInt(minXViev.getText().toString());
        intent.putExtra("com.example.oleh.project.minx", minx);
        EditText maxXViev = (EditText) findViewById(R.id.graficEnd);
        maxx = Integer.parseInt(maxXViev.getText().toString());
        intent.putExtra("com.example.oleh.project.maxx", maxx);


        startActivity(intent);
    }
}
