package edu.pwageselon.campuslocator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RecreationActivity extends Activity {

    private final String fileName = "RecreationData.csv";

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreation);

        listView = (ListView) findViewById(R.id.listviewrecreation);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName)));

            listView.setAdapter(adapter);

            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] rowData = line.split(",");
                String name = rowData[0];
                String latitude = rowData[1];
                String longitude = rowData[2];
                String monday = rowData[3];
                String tuesday = rowData[4];
                String wednesday = rowData[5];
                String thursday = rowData[6];
                String friday = rowData[7];
                String saturday = rowData[8];
                String sunday = rowData[9];

                if (monday.equals("a") || monday.equals("A")) {
                    monday = "Open All Day";
                }

                adapter.add(name);
//                adapter.add(latitude);
//                adapter.add(longitude);
                adapter.add(monday);
//                adapter.add(tuesday);
//                adapter.add(wednesday);
//                adapter.add(thursday);
//                adapter.add(friday);
//                adapter.add(saturday);
//                adapter.add(sunday);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
