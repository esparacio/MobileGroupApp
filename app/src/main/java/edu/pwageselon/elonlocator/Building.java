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

    }

    private void formatTimes() {
        SimpleDateFormat simpleDateInput = new SimpleDateFormat("HHmm");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");

        if (monday.equals("a") || monday.equals("A")) {
            mondayDate = "Open All Day";
        } else if (monday.equals("n") || monday.equals("N")) {
            mondayDate = "Closed All Day";
        } else {
            String[] mondayTimes;
            String[] mondayMultipleTimes;
            if (monday.contains(";")) {
                mondayMultipleTimes = monday.split(";");

                for (int i = 0; i < mondayMultipleTimes.length; i++) {
                    mondayTimes = mondayMultipleTimes[i].split("-");
                    try {
                        for (int t = 0; t < mondayTimes.length-1; t = t + 2) {
                            Date date;
                            if (mondayDate == null) {
                                date = simpleDateInput.parse(mondayTimes[t]);
                                mondayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(mondayTimes[t+1]);
                                mondayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(mondayTimes[t]);
                                mondayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(mondayTimes[t+1]);
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
                    for (int t = 0; t < mondayTimes.length; t++) {
                        Date date;
                        if (mondayDate == null) {
                            date = simpleDateInput.parse(mondayTimes[t]);
                            mondayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(mondayTimes[t]);
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
            String[] tuesdayTimes;
            String[] tuesdayMultipleTimes;
            if (tuesday.contains(";")) {
                tuesdayMultipleTimes = tuesday.split(";");

                for (int i = 0; i < tuesdayMultipleTimes.length; i++) {
                    tuesdayTimes = tuesdayMultipleTimes[i].split("-");
                    try {
                        for (int t = 0; t < tuesdayTimes.length-1; t = t + 2) {
                            Date date;
                            if (tuesdayDate == null) {
                                date = simpleDateInput.parse(tuesdayTimes[t]);
                                tuesdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(tuesdayTimes[t+1]);
                                tuesdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(tuesdayTimes[t]);
                                tuesdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(tuesdayTimes[t+1]);
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
                    for (int t = 0; t < tuesdayTimes.length; t++) {
                        Date date;
                        if (tuesdayDate == null) {
                            date = simpleDateInput.parse(tuesdayTimes[t]);
                            tuesdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(tuesdayTimes[t]);
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
            String[] wednesdayTimes;
            String[] wednesdayMultipleTimes;
            if (wednesday.contains(";")) {
                wednesdayMultipleTimes = wednesday.split(";");

                for (int i = 0; i < wednesdayMultipleTimes.length; i++) {
                    wednesdayTimes = wednesdayMultipleTimes[i].split("-");
                    try {
                        for (int t = 0; t < wednesdayTimes.length-1; t = t + 2) {
                            Date date;
                            if (wednesdayDate == null) {
                                date = simpleDateInput.parse(wednesdayTimes[t]);
                                wednesdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(wednesdayTimes[t+1]);
                                wednesdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(wednesdayTimes[t]);
                                wednesdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(wednesdayTimes[t+1]);
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
                    for (int t = 0; t < wednesdayTimes.length; t++) {
                        Date date;
                        if (wednesdayDate == null) {
                            date = simpleDateInput.parse(wednesdayTimes[t]);
                            wednesdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(wednesdayTimes[t]);
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
            String[] thursdayTimes;
            String[] thursdayMultipleTimes;
            if (thursday.contains(";")) {
                thursdayMultipleTimes = thursday.split(";");

                for (int i = 0; i < thursdayMultipleTimes.length; i++) {
                    thursdayTimes = thursdayMultipleTimes[i].split("-");
                    try {
                        for (int t = 0; t < thursdayTimes.length-1; t = t + 2) {
                            Date date;
                            if (thursdayDate == null) {
                                date = simpleDateInput.parse(thursdayTimes[t]);
                                thursdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(thursdayTimes[t+1]);
                                thursdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(thursdayTimes[t]);
                                thursdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(thursdayTimes[t+1]);
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
                    for (int t = 0; t < thursdayTimes.length; t++) {
                        Date date;
                        if (thursdayDate == null) {
                            date = simpleDateInput.parse(thursdayTimes[t]);
                            thursdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(thursdayTimes[t]);
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
            String[] mondayTimes;
            String[] mondayMultipleTimes;
            if (friday.contains(";")) {
                mondayMultipleTimes = friday.split(";");

                for (int i = 0; i < mondayMultipleTimes.length; i++) {
                    mondayTimes = mondayMultipleTimes[i].split("-");
                    try {
                        for (int t = 0; t < mondayTimes.length-1; t = t + 2) {
                            Date date;
                            if (fridayDate == null) {
                                date = simpleDateInput.parse(mondayTimes[t]);
                                fridayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(mondayTimes[t+1]);
                                fridayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(mondayTimes[t]);
                                fridayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(mondayTimes[t+1]);
                                fridayDate += " - " + simpleDateFormat.format(date);
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                mondayTimes = friday.split("-");
                try {
                    for (int t = 0; t < mondayTimes.length; t++) {
                        Date date;
                        if (fridayDate == null) {
                            date = simpleDateInput.parse(mondayTimes[t]);
                            fridayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(mondayTimes[t]);
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
            String[] saturdayTimes;
            String[] saturdayMultipleTimes;
            if (saturday.contains(";")) {
                saturdayMultipleTimes = saturday.split(";");

                for (int i = 0; i < saturdayMultipleTimes.length; i++) {
                    saturdayTimes = saturdayMultipleTimes[i].split("-");
                    try {
                        for (int t = 0; t < saturdayTimes.length-1; t = t + 2) {
                            Date date;
                            if (saturdayDate == null) {
                                date = simpleDateInput.parse(saturdayTimes[t]);
                                saturdayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(saturdayTimes[t+1]);
                                saturdayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(saturdayTimes[t]);
                                saturdayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(saturdayTimes[t+1]);
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
                    for (int t = 0; t < saturdayTimes.length; t++) {
                        Date date;
                        if (saturdayDate == null) {
                            date = simpleDateInput.parse(saturdayTimes[t]);
                            saturdayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(saturdayTimes[t]);
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
            String[] sundayTimes;
            String[] sundayMultipleTimes;
            if (sunday.contains(";")) {
                sundayMultipleTimes = sunday.split(";");

                for (int i = 0; i < sundayMultipleTimes.length; i++) {
                    sundayTimes = sundayMultipleTimes[i].split("-");
                    try {
                        for (int t = 0; t < sundayTimes.length-1; t = t + 2) {
                            Date date;
                            if (sundayDate == null) {
                                date = simpleDateInput.parse(sundayTimes[t]);
                                sundayDate = "" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(sundayTimes[t+1]);
                                sundayDate += " - " + simpleDateFormat.format(date);

                            } else {
                                date = simpleDateInput.parse(sundayTimes[t]);
                                sundayDate += ",\n" + simpleDateFormat.format(date);
                                date = simpleDateInput.parse(sundayTimes[t+1]);
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
                    for (int t = 0; t < sundayTimes.length; t++) {
                        Date date;
                        if (sundayDate == null) {
                            date = simpleDateInput.parse(sundayTimes[t]);
                            sundayDate = "" + simpleDateFormat.format(date);
                        } else {
                            date = simpleDateInput.parse(sundayTimes[t]);
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
}
