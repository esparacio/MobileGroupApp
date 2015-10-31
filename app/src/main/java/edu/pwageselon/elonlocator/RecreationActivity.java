package edu.pwageselon.elonlocator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RecreationActivity extends Activity {

    private final String fileName = "RecreationData.csv";

    private ListView listView;
    private ArrayAdapter<String> adapter;

    private ArrayList<Building> buildings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreation);

        listView = (ListView) findViewById(R.id.listviewrecreation);
        listView.setOnItemClickListener(onItemClickListener);
        listView.setOnItemLongClickListener(onItemLongClickListener);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

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

                Building building = new Building(name, latitude, longitude, monday, tuesday,
                        wednesday, thursday, friday, saturday, sunday);
                buildings.add(building);

                adapter.add(name);

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
                    Building current = buildings.get(i);

                    Intent intent = new Intent(RecreationActivity.this, DialogActivity.class);
                    intent.putExtra("name", current.getName());
                    intent.putExtra("monday", current.getMondayDate());
                    intent.putExtra("tuesday", current.getTuesdayDate());
                    intent.putExtra("wednesday", current.getWednesdayDate());
                    intent.putExtra("thursday", current.getThursdayDate());
                    intent.putExtra("friday", current.getFridayDate());
                    intent.putExtra("saturday", current.getSaturdayDate());
                    intent.putExtra("sunday", current.getSundayDate());

                    startActivity(intent);
                }
            };

    AdapterView.OnItemLongClickListener onItemLongClickListener =
            new AdapterView.OnItemLongClickListener() {

                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Building current = buildings.get(i);

                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=" + current.getLatitude() + "," + current.getLongitude()));
                    startActivity(intent);

                    return true;
                }
            };
}

