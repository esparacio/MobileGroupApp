package edu.pwageselon.elonlocator;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PeterWages on 11/2/15.
 */
    public class SpecialAdapter extends ArrayAdapter {

    private boolean open = false;

    public SpecialAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        if (open) {
            view.setBackgroundColor(R.color.green);
        } else {
            view.setBackgroundColor(R.color.elon_red);
        }
        return view;
    }

    public void setOpenness(boolean open) {
        this.open = open;
    }
}
