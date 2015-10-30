package edu.pwageselon.elonlocator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DiningActivity extends Activity {

    private final String fileName = "DiningData.csv";

    private ListView listView;
    private ArrayAdapter<String> adapter;

    private ArrayList<Building> buildings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        listView = (ListView) findViewById(R.id.listviewdining);
        listView.setOnItemClickListener(onItemClickListener);
        listView.setOnItemLongClickListener(onItemLongClickListener);

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

                adapter.add(name);
                Building building = new Building(name, latitude, longitude, monday, tuesday,
                        wednesday, thursday, friday, saturday, sunday);

                buildings.add(building);

                adapter.add("" + building.getMondayDate());
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

    AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String name = listView.getItemAtPosition(i).toString();
                }
            };

    AdapterView.OnItemLongClickListener onItemLongClickListener =
            new AdapterView.OnItemLongClickListener() {

                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String name = listView.getItemAtPosition(i).toString();
                    return true;
                }
            };
}
