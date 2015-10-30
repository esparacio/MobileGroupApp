package edu.pwageselon.elonlocator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by highr on 10/29/2015.
 */
public class Building {

    private String name, latitude, longitude, monday, tuesday, wednesday, thursday, friday,
            saturday, sunday;

    private String mondayDate, tuesdayDate, wednesdayDate, thursdayDate, fridayDate,
            saturdayDate, sundayDate;

    public Building(String name, String latitude, String longitude, String monday,
                         String tuesday, String wednesday, String thursday, String friday,
                         String saturday, String sunday) {

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;

        mondayDate = "NOT ENTERING THE FOR LOOP LIKE A SHITTY PIECE OF SHIT. FUCK THIS SHIT I'M OUT, SHITWHORE";

        formatDates();
        formatTimes();

    }

    private void formatTimes() {
        if (monday.equals("a") || monday.equals("A")) {
            mondayDate = "Open All Day";
        }

        if (monday.equals("n") || monday.equals("N")) {
            mondayDate = "Closed All Day";
        }

        if (tuesday.equals("a") || tuesday.equals("A")) {
            tuesdayDate = "Open All Day";
        }

        if (tuesday.equals("n") || tuesday.equals("N")) {
            tuesdayDate = "Closed All Day";
        }

        if (wednesday.equals("a") || wednesday.equals("A")) {
            wednesdayDate = "Open All Day";
        }

        if (wednesday.equals("n") || wednesday.equals("N")) {
            wednesdayDate = "Closed All Day";
        }

        if (thursday.equals("a") || thursday.equals("A")) {
            thursdayDate = "Open All Day";
        }

        if (thursday.equals("n") || thursday.equals("N")) {
            thursdayDate = "Closed All Day";
        }

        if (friday.equals("a") || friday.equals("A")) {
            fridayDate = "Open All Day";
        }

        if (friday.equals("n") || friday.equals("N")) {
            fridayDate = "Closed All Day";
        }

        if (saturday.equals("a") || saturday.equals("A")) {
            saturdayDate = "Open All Day";
        }

        if (saturday.equals("n") || saturday.equals("N")) {
            saturdayDate = "Closed All Day";
        }

        if (sunday.equals("a") || sunday.equals("A")) {
            sundayDate = "Open All Day";
        }

        if (sunday.equals("n") || sunday.equals("N")) {
            sundayDate = "Closed All Day";
        }
    }

    private void formatDates() {
        SimpleDateFormat simpleDateInput = new SimpleDateFormat("HHmm");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");

        if (!monday.equals("a") || !monday.equals("A")) {
            String[] mondayTimes;
                mondayTimes = monday.split("-");
            try {
                for (int i = 0; i > mondayTimes.length-1; i++) {
//                    if (mondayDate == null){
                        Date date = simpleDateInput.parse(mondayTimes[0]);
                        mondayDate = "" + simpleDateFormat.format(date);
//                    }
                     date = simpleDateInput.parse(mondayTimes[1]);
                    mondayDate += " - " + simpleDateFormat.format(date);

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (!tuesday.equals("a") || !tuesday.equals("A")) {
            try {
                Date date = simpleDateInput.parse(tuesday);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        if (!wednesday.equals("a") || !wednesday.equals("A")) {
            try {
                Date date = simpleDateInput.parse(wednesday);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        if (!thursday.equals("a") || !thursday.equals("A")) {
            try {
                Date date = simpleDateInput.parse(thursday);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        if (!friday.equals("a") || !friday.equals("A")) {
            try {
                Date date = simpleDateInput.parse(friday);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        if (!saturday.equals("a") || !saturday.equals("A")) {
            try {
                Date date = simpleDateInput.parse(saturday);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }

        if (!sunday.equals("a") || !sunday.equals("A")) {
            try {
                Date date = simpleDateInput.parse(sunday);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getMondayDate() {
        return mondayDate;
    }

    public String getTuesdayDate() {
        return tuesdayDate;
    }

    public String getWednesdayDate() {
        return wednesdayDate;
    }

    public String getThursdayDate() {
        return thursdayDate;
    }

    public String getFridayDate() {
        return fridayDate;
    }

    public String getSaturdayDate() {
        return saturdayDate;
    }

    public String getSundayDate() {
        return sundayDate;
    }
}
