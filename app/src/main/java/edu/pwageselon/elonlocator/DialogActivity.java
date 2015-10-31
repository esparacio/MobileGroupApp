package edu.pwageselon.elonlocator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends Activity implements OnClickListener {

    Button okay_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        okay_button = (Button) findViewById(R.id.okay_button);
        okay_button.setOnClickListener(this);

        TextView building = (TextView) findViewById(R.id.buildingName);
        TextView monday = (TextView) findViewById(R.id.monday_hours);
        TextView tuesday = (TextView) findViewById(R.id.tuesday_hours);
        TextView wednesday = (TextView) findViewById(R.id.wednesday_hours);
        TextView thursday = (TextView) findViewById(R.id.thursday_hours);
        TextView friday = (TextView) findViewById(R.id.friday_hours);
        TextView saturday = (TextView) findViewById(R.id.saturday_hours);
        TextView sunday = (TextView) findViewById(R.id.sunday_hours);

        Intent intent = getIntent();

        building.setText(intent.getStringExtra("name"));
        monday.setText(intent.getStringExtra("monday"));
        tuesday.setText(intent.getStringExtra("tuesday"));
        wednesday.setText(intent.getStringExtra("wednesday"));
        thursday.setText(intent.getStringExtra("thursday"));
        friday.setText(intent.getStringExtra("friday"));
        saturday.setText(intent.getStringExtra("saturday"));
        sunday.setText(intent.getStringExtra("sunday"));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.okay_button:

                this.finish();
                break;
        }
    }
}