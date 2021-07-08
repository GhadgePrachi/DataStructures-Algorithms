package datastructures.heaps.tough;

import java.util.ArrayList;
import java.util.List;

public class CalendarScheduling {
    public static List<StringMeeting> calendarMatching(List<StringMeeting> calendar1, StringMeeting dailyBounds1, List<StringMeeting> calendar2, StringMeeting dailyBounds2, int meetingDuration) {
        List<Meeting> updateCalendar1 = updateCalendar(calendar1, dailyBounds1);
        List<Meeting> updateCalendar2 = updateCalendar(calendar2, dailyBounds2);
        List<Meeting> mergedCalendar = mergedCalendars(updateCalendar1, updateCalendar2);
        List<Meeting> falttenedCalendar = flattenCalendar(mergedCalendar);
        return getMatchingAvailabilities(falttenedCalendar, meetingDuration);
    }

    public static List<Meeting> updateCalendar(List<StringMeeting> calendar, StringMeeting dailyBounds) {
        List<StringMeeting> updateCalendar = new ArrayList<>();
        updateCalendar.add(new StringMeeting("0:00", dailyBounds.start));
        updateCalendar.addAll(calendar);
        updateCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));

        List<Meeting> calendarInMinutes = new ArrayList<>();
        for (int i = 0; i < updateCalendar.size(); i++) {
            calendarInMinutes.add(new Meeting(
                    timesToMinutes(updateCalendar.get(i).start),
                    timesToMinutes(updateCalendar.get(i).end)));
        }
        return calendarInMinutes;
    }

    public static List<Meeting> mergedCalendars (List<Meeting> c1, List<Meeting> c2) {
        List<Meeting> merged = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < c1.size() && j < c2.size()) {
            Meeting m1 = c1.get(i);
            Meeting m2 = c2.get(j);
            if (m1.start < m2.start) {
                merged.add(m1);
                i += 1;
            } else {
                merged.add(m2);
                j += 1;
            }
        }

        while(i < c1.size()) {
            merged.add(c1.get(i));
            i += 1;
        }

        while(j < c2.size()) {
            merged.add(c2.get(j));
            j += 1;
        }
        return merged;
    }

    public static List<Meeting> flattenCalendar (List<Meeting> calendar) {
        List<Meeting> flattened = new ArrayList<>();
        flattened.add(calendar.get(0));

        for (int i = 1; i < calendar.size(); i++) {
            Meeting currentMeeting = calendar.get(i);
            Meeting previousMeeting = flattened.get(flattened.size() - 1);
            if (previousMeeting.end < currentMeeting.start) {
                flattened.add(currentMeeting);
            } else {
                Meeting newMeeting = new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
                flattened.set(flattened.size() - 1, newMeeting);
            }
        }
        return flattened;
    }

    public static List<StringMeeting> getMatchingAvailabilities ( List<Meeting> calendar, int meetingDuration) {
        List<Meeting> matchingAvailabilities = new ArrayList<>();
        for (int i = 1; i < calendar.size(); i++) {
            int start = calendar.get(i-1).end;
            int end = calendar.get(i).start;
            int availableDuration = end - start;
            if (availableDuration >= meetingDuration)
                matchingAvailabilities.add(new Meeting(start, end));
        }

        List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<>();
        for (int i = 0; i < matchingAvailabilities.size(); i++) {
            matchingAvailabilitiesInHours.add(new StringMeeting(
                    minutesToTime(matchingAvailabilities.get(i).start),
                    minutesToTime(matchingAvailabilities.get(i).end)));
        }
        return matchingAvailabilitiesInHours;
    }
    public static int timesToMinutes(String time) {
        int delimitedIndex = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimitedIndex));
        int minutes = Integer.parseInt(time.substring(delimitedIndex + 1));
        return hours * 60 + minutes;
    }

    public static String minutesToTime(int mins) {
        int hours = mins / 60;
        int minutes = mins % 60;
        String hourString = Integer.toString(hours);
        String minutesString = minutes < 10 ? "0" + Integer.toString(minutes):Integer.toString(minutes);
        return hourString + ":" + minutesString;
    }

    public static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
