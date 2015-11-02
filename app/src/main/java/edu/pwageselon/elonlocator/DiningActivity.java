package edu.pwageselon.elonlocator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class DiningActivity extends Activity {

    private final String fileName = "DiningData.csv";

    private ListView listView;
    private ArrayAdapter<String> adapter;

    private ArrayList<Building> buildings = new ArrayList<>();

    private boolean open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        listView = (ListView) findViewById(R.id.listviewdining);
        listView.setOnItemClickListener(onItemClickListener);
        listView.setOnItemLongClickListener(onItemLongClickListener);

        adapter = new SpecialAdapter(this, android.R.layout.simple_list_item_1) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.WHITE);

                if (buildings.get(position).isCurrentlyOpen()) {
                    view.setBackgroundColor(Color.rgb(53, 94, 59));
                } else {
                    view.setBackgroundColor(Color.rgb(168, 40, 40));
                }
                return view;
            }

        };
        listView.setAdapter(adapter);

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName)));

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

        for (int i = 0; i < buildings.size(); i++) {
            adapter.add(buildings.get(i).getName());
        }
    }

    AdapterView.OnItemClickListener onItemClickListener =
            new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Building current = buildings.get(i);

                    Intent intent = new Intent(DiningActivity.this, DialogActivity.class);
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
