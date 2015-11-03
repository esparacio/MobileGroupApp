package edu.pwageselon.elonlocator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by highr on 10/29/2015.
 */
public class Building {

    private String name, latitude, longitude, monday, tuesday, wednesday, thursday, friday,
            saturday, sunday;

    private String mondayDate, tuesdayDate, wednesdayDate, thursdayDate, fridayDate,
            saturdayDate, sundayDate;

    private boolean currentlyOpen = false;

    private Calendar today = Calendar.getInstance();
    private Calendar timeOpen = Calendar.getInstance();
    private Calendar timeClose = Calendar.getInstance();

    private SimpleDateFormat simpleDateInput = new SimpleDateFormat("HHmm", Locale.US);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a", Locale.US);

    public Building() {
    }

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

        formatTimes();
        currentlyOpen = checkIfOpen();
        System.out.println(currentlyOpen);
    }

    private boolean checkIfOpen() {
        int dayOfTheWeek = today.get(Calendar.DAY_OF_WEEK);
            switch (dayOfTheWeek) {
                case Calendar.MONDAY:
                    return doCheck(monday);

                case Calendar.TUESDAY:
                    return doCheck(tuesday);

                case Calendar.WEDNESDAY:
                    return doCheck(wednesday);

                case Calendar.THURSDAY:
                    return doCheck(thursday);

                case Calendar.FRIDAY:
                    return doCheck(friday);

                case Calendar.SATURDAY:
                    return doCheck(saturday);

                case Calendar.SUNDAY:
                    return doCheck(sunday);
            }
        return false;
    }

    private void formatTimes() {
        mondayDate = doFormat(monday);
        tuesdayDate = doFormat(tuesday);
        wednesdayDate = doFormat(wednesday);
        thursdayDate = doFormat(thursday);
        fridayDate = doFormat(friday);
        saturdayDate = doFormat(saturday);
        sundayDate = doFormat(sunday);
    }

    private String doFormat(String hours) {
        String formattedHours = "";
        if (hours.equals("a") || hours.equals("A")) {
            return "Open All Day";
        } else if (hours.equals("n") || hours.equals("N")) {
            return "Closed All Day";
        } else {
            if (hours.contains(";")) {
                String[] multipleTimes = hours.split(";");

                for (String multipleTime : multipleTimes) {
                    String[] times = multipleTime.split("-");
                    try {
                        for (int t = 0; t < times.length - 1; t += 2) {
                            Date date;
                            if (formattedHours.equals("")) {
                                date = simpleDateInput.parse(times[t]);
                                formattedHours = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(times[t + 1]);
                                formattedHours += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(times[t]);
                                formattedHours += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(times[t + 1]);
                                formattedHours += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                String[] multipleTimes = hours.split("-");
                try {
                    for (String times : multipleTimes) {
                        Date date;
                        if (formattedHours.equals("")) {
                            date = simpleDateInput.parse(times);
                            formattedHours = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(times);
                            formattedHours += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return formattedHours;
    }

    private boolean doCheck(String hours) {

        if (hours.equals("a") || hours.equals("A")) {
            return true;
        } else if (hours.equals("n") || hours.equals("N")) {
            return false;
        } else {
            if (hours.contains(";")) {
                String[] multipleTimes = hours.split(";");

                for (String multipleTime : multipleTimes) {
                    String[] times = multipleTime.split("-");
                    for (int t = 0; t < times.length - 1; t += 2) {
                        String openHour = "" + times[t].charAt(0) + times[t].charAt(1);
                        String openMinute = "" + times[t].charAt(2) + times[t].charAt(3);
                        timeOpen.set(Calendar.HOUR_OF_DAY, Integer.parseInt(openHour));
                        timeOpen.set(Calendar.MINUTE, Integer.parseInt(openMinute));
                        String closeHour = "" + times[t + 1].charAt(0) + times[t + 1].charAt(1);
                        String closeMinute = "" + times[t+1].charAt(2) + times[t+1].charAt(3);
                        timeClose.set(Calendar.HOUR_OF_DAY, Integer.parseInt(closeHour));
                        timeClose.set(Calendar.MINUTE, Integer.parseInt(closeMinute));

                        System.out.println("TODAY: " + today.getTime() + " CLOSE: " + timeClose.getTime() + " OPEN: " + timeOpen.getTime());

                        if (today.after(timeOpen) &&  today.before(timeClose)) {
                            return true;
                        }
                    }
                }

            } else {
                String[] multipleTimes = hours.split("-");
                String openHour = "" + multipleTimes[0].charAt(0) + multipleTimes[0].charAt(1);
                String openMinute = "" + multipleTimes[0].charAt(2) + multipleTimes[0].charAt(3);
                timeOpen.set(Calendar.HOUR_OF_DAY, Integer.parseInt(openHour));
                timeOpen.set(Calendar.MINUTE, Integer.parseInt(openMinute));
                String closeHour = "" + multipleTimes[1].charAt(0) + multipleTimes[1].charAt(1);
                String closeMinute = "" + multipleTimes[1].charAt(2) + multipleTimes[1].charAt(3);
                timeClose.set(Calendar.HOUR_OF_DAY, Integer.parseInt(closeHour));
                timeClose.set(Calendar.MINUTE, Integer.parseInt(closeMinute));

                System.out.println("222TODAY: " + today.getTime() + " CLOSE: " + timeClose.getTime() + " OPEN: " + timeOpen.getTime());

                if (today.after(timeOpen) &&  today.before(timeClose)) {
                    return true;
                }
            }
        }
        return false;
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

    public boolean isCurrentlyOpen() {
        return currentlyOpen;
    }
}
