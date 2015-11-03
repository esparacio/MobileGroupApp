package edu.pwageselon.elonlocator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchAcademics(View view) {
        Intent intent = new Intent(this, AcademicsActivity.class);
        startActivity(intent);
    }

    public void launchDining(View view) {
        Intent intent = new Intent(this, DiningActivity.class);
        startActivity(intent);
    }

    public void launchHousing(View view) {
        Intent intent = new Intent(this, HousingActivity.class);
        startActivity(intent);
    }

    public void launchActivities(View view) {
        Intent intent = new Intent(this, RecreationActivity.class);
        startActivity(intent);
    }

    public void launchOther(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }
    public void launchInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }


}
