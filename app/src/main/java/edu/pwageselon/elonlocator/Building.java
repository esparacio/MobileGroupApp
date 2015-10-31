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

    private String[] mondayTimes, mondayMultipleTimes, tuesdayTimes, tuesdayMultipleTimes,
            wednesdayTimes, wednesdayMultipleTimes, thursdayTimes, thursdayMultipleTimes, fridayTimes,
            fridayMultipleTimes, saturdayTimes, saturdayMultipleTimes, sundayTimes, sundayMultipleTimes;

    private boolean currentlyOpen = false;

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
        checkIfOpen();

    }

    private void checkIfOpen() {
        Calendar today = Calendar.getInstance();
        int dayOfTheWeek = today.get(Calendar.DAY_OF_WEEK);

        try {
            switch (dayOfTheWeek) {
                case Calendar.MONDAY:
                    if (mondayDate.equals("Open All Day")) {
                        currentlyOpen = true;
                    } else if (mondayDate.equals("Closed All Day")) {
                        currentlyOpen = false;
                    }
                case Calendar.TUESDAY:

                case Calendar.WEDNESDAY:

                case Calendar.THURSDAY:

                case Calendar.FRIDAY:

                case Calendar.SATURDAY:
                    if (saturdayDate.equals("Open All Day")) {
                        currentlyOpen = true;
                    } else if (saturdayDate.equals("Closed All Day")) {
                        currentlyOpen = false;
                    } else if (saturdayMultipleTimes == null) {
                             timeOpen.setTime(simpleDateFormat.parse(saturdayTimes[0]));
                             timeClose.setTime(simpleDateFormat.parse(saturdayTimes[1]));
                            if (timeOpen.after(timeClose)) {
                                Calendar nextDay = Calendar.getInstance();
                                nextDay.setTime(timeClose.getTime());
                                nextDay.add(Calendar.DATE, 1);
                                timeClose.setTime(nextDay.getTime());
                            }
                            if (today.after(timeOpen.getTime()) && today.before(timeClose.getTime())) {
                                currentlyOpen = true;
                            }
                    } else if (saturdayMultipleTimes.length < 0) {
                        for (int i = 0; i < saturdayMultipleTimes.length; i++) {
                            saturdayTimes = saturdayMultipleTimes[i].split("-");
                            for (int t = 0; t < saturdayTimes.length - 1; t += 2) {
                                 timeOpen.setTime(simpleDateFormat.parse(saturdayTimes[t]));
                                 timeClose.setTime(simpleDateFormat.parse(saturdayTimes[t + 1]));
                                if (timeOpen.after(timeClose)) {
                                    Calendar nextDay = Calendar.getInstance();
                                    nextDay.setTime(timeClose.getTime());
                                    nextDay.add(Calendar.DATE, 1);
                                    timeClose.setTime(nextDay.getTime());
                                }
                                if (today.after(timeOpen) && today.before(timeClose)) {
                                    currentlyOpen = true;
                                }
                            }
                        }
                    }

                case Calendar.SUNDAY:
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void formatTimes() {
        if (monday.equals("a") || monday.equals("A")) {
            mondayDate = "Open All Day";
        } else if (monday.equals("n") || monday.equals("N")) {
            mondayDate = "Closed All Day";
        } else {
            if (monday.contains(";")) {
                mondayMultipleTimes = monday.split(";");

                for (String mondayMultipleTime : mondayMultipleTimes) {
                    mondayTimes = mondayMultipleTime.split("-");
                    try {
                        for (int t = 0; t < mondayTimes.length - 1; t += 2) {
                            Date date;
                            if (mondayDate == null) {
                                date = simpleDateInput.parse(mondayTimes[t]);
                                mondayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(mondayTimes[t + 1]);
                                mondayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(mondayTimes[t]);
                                mondayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(mondayTimes[t + 1]);
                                mondayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                mondayTimes = monday.split("-");
                try {
                    for (String mondayTime : mondayTimes) {
                        Date date;
                        if (mondayDate == null) {
                            date = simpleDateInput.parse(mondayTime);
                            mondayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(mondayTime);
                            mondayDate += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (tuesday.equals("a") || tuesday.equals("A")) {
            tuesdayDate = "Open All Day";
        } else if (tuesday.equals("n") || tuesday.equals("N")) {
            tuesdayDate = "Closed All Day";
        } else {
            if (tuesday.contains(";")) {
                tuesdayMultipleTimes = tuesday.split(";");

                for (String tuesdayMultipleTime : tuesdayMultipleTimes) {
                    tuesdayTimes = tuesdayMultipleTime.split("-");
                    try {
                        for (int t = 0; t < tuesdayTimes.length - 1; t += 2) {
                            Date date;
                            if (tuesdayDate == null) {
                                date = simpleDateInput.parse(tuesdayTimes[t]);
                                tuesdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(tuesdayTimes[t + 1]);
                                tuesdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(tuesdayTimes[t]);
                                tuesdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(tuesdayTimes[t + 1]);
                                tuesdayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                tuesdayTimes = tuesday.split("-");
                try {
                    for (String tuesdayTime : tuesdayTimes) {
                        Date date;
                        if (tuesdayDate == null) {
                            date = simpleDateInput.parse(tuesdayTime);
                            tuesdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(tuesdayTime);
                            tuesdayDate += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (wednesday.equals("a") || wednesday.equals("A")) {
            wednesdayDate = "Open All Day";
        } else if (wednesday.equals("n") || wednesday.equals("N")) {
            wednesdayDate = "Closed All Day";
        } else {
            if (wednesday.contains(";")) {
                wednesdayMultipleTimes = wednesday.split(";");

                for (String wednesdayMultipleTime : wednesdayMultipleTimes) {
                    wednesdayTimes = wednesdayMultipleTime.split("-");
                    try {
                        for (int t = 0; t < wednesdayTimes.length - 1; t += 2) {
                            Date date;
                            if (wednesdayDate == null) {
                                date = simpleDateInput.parse(wednesdayTimes[t]);
                                wednesdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(wednesdayTimes[t + 1]);
                                wednesdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(wednesdayTimes[t]);
                                wednesdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(wednesdayTimes[t + 1]);
                                wednesdayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                wednesdayTimes = wednesday.split("-");
                try {
                    for (String wednesdayTime : wednesdayTimes) {
                        Date date;
                        if (wednesdayDate == null) {
                            date = simpleDateInput.parse(wednesdayTime);
                            wednesdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(wednesdayTime);
                            wednesdayDate += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (thursday.equals("a") || thursday.equals("A")) {
            thursdayDate = "Open All Day";
        } else if (thursday.equals("n") || thursday.equals("N")) {
            thursdayDate = "Closed All Day";
        } else {
            if (thursday.contains(";")) {
                thursdayMultipleTimes = thursday.split(";");

                for (String thursdayMultipleTime : thursdayMultipleTimes) {
                    thursdayTimes = thursdayMultipleTime.split("-");
                    try {
                        for (int t = 0; t < thursdayTimes.length - 1; t += 2) {
                            Date date;
                            if (thursdayDate == null) {
                                date = simpleDateInput.parse(thursdayTimes[t]);
                                thursdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(thursdayTimes[t + 1]);
                                thursdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(thursdayTimes[t]);
                                thursdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(thursdayTimes[t + 1]);
                                thursdayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                thursdayTimes = thursday.split("-");
                try {
                    for (String thursdayTime : thursdayTimes) {
                        Date date;
                        if (thursdayDate == null) {
                            date = simpleDateInput.parse(thursdayTime);
                            thursdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(thursdayTime);
                            thursdayDate += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (friday.equals("a") || friday.equals("A")) {
            fridayDate = "Open All Day";
        } else if (friday.equals("n") || friday.equals("N")) {
            fridayDate = "Closed All Day";
        } else {
            if (friday.contains(";")) {
                fridayMultipleTimes = friday.split(";");

                for (String fridayMultipleTime : fridayMultipleTimes) {
                    fridayTimes = fridayMultipleTime.split("-");
                    try {
                        for (int t = 0; t < fridayTimes.length - 1; t += 2) {
                            Date date;
                            if (fridayDate == null) {
                                date = simpleDateInput.parse(fridayTimes[t]);
                                fridayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(fridayTimes[t + 1]);
                                fridayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(fridayTimes[t]);
                                fridayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(fridayTimes[t + 1]);
                                fridayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                fridayTimes = friday.split("-");
                try {
                    for (String fridayTime : fridayTimes) {
                        Date date;
                        if (fridayDate == null) {
                            date = simpleDateInput.parse(fridayTime);
                            fridayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(fridayTime);
                            fridayDate += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (saturday.equals("a") || saturday.equals("A")) {
            saturdayDate = "Open All Day";
        } else if (saturday.equals("n") || saturday.equals("N")) {
            saturdayDate = "Closed All Day";
        } else {
            if (saturday.contains(";")) {
                saturdayMultipleTimes = saturday.split(";");

                for (String saturdayMultipleTime : saturdayMultipleTimes) {
                    saturdayTimes = saturdayMultipleTime.split("-");
                    try {
                        for (int t = 0; t < saturdayTimes.length - 1; t += 2) {
                            Date date;
                            if (saturdayDate == null) {
                                date = simpleDateInput.parse(saturdayTimes[t]);
                                saturdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(saturdayTimes[t + 1]);
                                saturdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(saturdayTimes[t]);
                                saturdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(saturdayTimes[t + 1]);
                                saturdayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                saturdayTimes = saturday.split("-");
                try {
                    for (String saturdayTime : saturdayTimes) {
                        Date date;
                        if (saturdayDate == null) {
                            date = simpleDateInput.parse(saturdayTime);
                            saturdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(saturdayTime);
                            saturdayDate += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        if (sunday.equals("a") || sunday.equals("A")) {
            sundayDate = "Open All Day";
        } else if (sunday.equals("n") || sunday.equals("N")) {
            sundayDate = "Closed All Day";
        } else {
            if (sunday.contains(";")) {
                sundayMultipleTimes = sunday.split(";");

                for (String sundayMultipleTime : sundayMultipleTimes) {
                    sundayTimes = sundayMultipleTime.split("-");
                    try {
                        for (int t = 0; t < sundayTimes.length - 1; t += 2) {
                            Date date;
                            if (sundayDate == null) {
                                date = simpleDateInput.parse(sundayTimes[t]);
                                sundayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(sundayTimes[t + 1]);
                                sundayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(sundayTimes[t]);
                                sundayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(sundayTimes[t + 1]);
                                sundayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                sundayTimes = sunday.split("-");
                try {
                    for (String sundayTime : sundayTimes) {
                        Date date;
                        if (sundayDate == null) {
                            date = simpleDateInput.parse(sundayTime);
                            sundayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(sundayTime);
                            sundayDate += " - " + simpleDateFormat.format(date);
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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

    public boolean isCurrentlyOpen() {
        return currentlyOpen;
    }

    public String[] getTimeOpen() {
        return saturdayMultipleTimes;
    }

    public String[] getTimeClose() {
        return saturdayTimes;
    }
}
