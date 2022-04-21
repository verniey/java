import java.util.*;

/*
Schreiben bzw. vervollständigen Sie gekennzeichnete Programmteile wie in den Kommentaren beschrieben.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!
Verwenden Sie die gegebenen Testklassen zum Überprüfen Ihrer Lösung. Die Korrektheit dieser Testfälle
ist notwendig, aber nicht hinreichend für eine korrekte Lösung.
*/

public class Aufgabe1 {

    /*
    Aufgabe: Umgang mit Klassen und Objekten, sowie vorgefertigten Datenstrukturen.

        Ergänzen Sie fehlende Teile der unten angeführten Klassen entsprechend den Kommentaren
        an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 40):
        3 Punkte in Summe für Klasse 'Time':
            3 Punkte für den Konstruktor
        21 Punkte in Summe für Klasse 'Timeslot':
            16 Punkte für Variable, Konstruktor, Methoden 'start' und 'end'
            5 Punkte für 'toString'
        16 Punkte in Summe für Klasse 'Timetable':
            3 Punkte für Variablen und Konstruktor
            4 Punkte für 'add'
            5 Punkte für 'getStart'
            4 Punkte für 'toString'

     Auch für teilweise korrekte Lösungen werden Punkte vergeben.

    */



    // Diese Methode können Sie zum Testen nutzen. Sie geht nicht in die Beurteilung ein.
    public static void main(String[] args) {

        //Testen von Time:
        Time t = new Time(12,30);
        System.out.println(t); // 12:30
        t = new Time(12).add(new Time(13,30));
        System.out.println(t); // 25:30
        t = new Time(0,-12);
        System.out.println(t); // -00:12
        t = new Time(-2,12);
        System.out.println(t); // -01:48
        t = new Time(2);
        System.out.println(t); // 02:00
        System.out.println(new Time(12).lessThan(new Time(13))); // true
        System.out.println(t.equals(new Time(2))); // true
        System.out.println(t.equals(new Time(2).add(new Time(1)))); // false

        //Testen von Timeslot:
        Timeslot ts1 = new Timeslot(2,new Time(10,30),60);
        Timeslot ts2 = new Timeslot(1,new Time(35,-30),60);
        Timeslot ts3 = new Timeslot(1,new Time(35,0),60);
        Timeslot ts4 = new Timeslot(0,new Time(-1),60);
        System.out.println(ts1.toString()); // Mi, 10:30 - 11:30
        System.out.println(ts2.toString()); // Mi, 10:30 - 11:30
        System.out.println(ts3.toString()); // Mi, 11:00 - 12:00
        System.out.println(ts4.toString()); // So, 23:00 - 24:00
        System.out.println(ts1.equals(ts2)); // true
        System.out.println(ts1.equals(ts3)); // false


        //Testen von Timetable
        Timetable tt = new Timetable();
        tt.add("PK",new Timeslot(0,new Time(15),120));
        tt.add("Mathe",new Timeslot(3,new Time(9,30),60));
        tt.add("Security",new Timeslot(3,new Time(15,00),120));
        System.out.println(tt);
        System.out.println(tt.getStart("Security"));

        /* Erwartete Ausgabe (die Reihefolge der Einträge darf abweichen):
        {Mathe=Do, 09:30 - 10:30, PK=Mo, 15:00 - 17:00, Security=Do, 15:00 - 17:00}
        15:00
        */

    }
}

// Diese Klasse repräsentiert eine Zeitangabe bestehend aus Stunden und Minuten.
class Time {

    // Intern wird eine Zeitangabe in Minuten gespeichert.
    private final int totalMinutes;

    // Konstruktor: initialisiert die Zeitangabe mit Stunden 'h',
    // und Minuten 'm'. Die Wertebereiche der Parameterwerte sind
    // nicht eingeschränkt (können auch negativ sein, z.B. bei einem Countdown).
    // Minuten laufen in Stunden über.
    public Time(int h, int m) {
        this.totalMinutes = 60*h + m;

    }

    // Konstruktor: initialisiert die Zeitangabe mit vollen Stunden 'h',
    // d.h., Minuten sind 0.
    public Time(int h) {
        // TODO: Implementieren Sie den Konstruktor.
        this(h,0);

    }

    // Liefert die Summe dieser Zeitangabe mit einer weiteren Zeitangabe.
    public Time add (Time t) {
        return new Time(0, this.totalMinutes + t.totalMinutes);

    }

    // Gibt an, ob diese Zeitangabe kleiner als die angegebene Zeitangabe ist.
    public boolean lessThan(Time t) {
        return this.totalMinutes < t.totalMinutes;

    }

    @Override
    // Liefert eine lesbare Repräsentation der Uhrzeit in der Form
    // HH:MM, also z.B.: 13:43 oder 02:45
    public String toString() {
        String time = totalMinutes < 0 ? "-" : "";
        return time + String.format("%02d:%02d", Math.abs(totalMinutes/60), Math.abs(totalMinutes%60));

    }

    @Override
    // Die equals-Methode: Überprüft die Gleichheit im Bezug auf
    // die Zeitangabe.
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != Time.class) {
            return false;
        }
        Time t = (Time) o;
        return t.totalMinutes == this.totalMinutes;

    }

    @Override
    // Die hashCode-Methode, die den Hashcode dieses Punktes liefert.
    public int hashCode() {
        return this.totalMinutes;

    }
}

// Diese Klasse repräsentiert einen Kalendereintrag (Event), mit Startuhrzeit und Enduhrzeit.
class Timeslot {

    private int weekday; //0 = Mo, 1 = Di, ..., 6 = So
    private Time start; //Startuhrzeit

    // TODO: Deklarieren Sie hier eine weitere Objekt-/globale Variable
    // TODO: um die Dauer bzw. Enduhrzeit des Timeslots zu speichern.

    private Time end;
    private static final String [] WEEK = {"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"};

    // Konstruktor: initialisiert dieses mit Index des Wochentages
    // 0-6, sowie Startuhrzeit und Dauer in Minuten.
    // Die Startzeitangabe ist relativ zur Tageszeit 00:00 des
    // angegebenen Tages.
    // Negative Zeitangaben bedeuten, dass der Zeitslot in den Tagen
    // davor stattfindet.
    // Zeitangaben größer als 23:59 bedeuten, dass der Zeitslot an
    // darauffolgenden Tagen stattfindet.
    // Weiters dauert kein Timeslot länger als bis 24:00 jenes Tages an dem
    // er startet, d.h. falls die Enduhrzeit auf den nächsten Tag fiele,
    // wird sie mit 24:00 festgelegt.
    public Timeslot(int weekday, Time start, int minutes) {
        //         Timeslot ts1 = new Timeslot(2,new Time(10,30),60);
        //         System.out.println(ts1.toString()); // Mi, 10:30 - 11:30
        // TODO: Implementieren Sie den Konstruktor.
        this.weekday = weekday;
        this.start = start;
        this.end = start.add(new Time(0, minutes));

        // Negative Zeitangaben
        if (start.lessThan(new Time(0, 0))) {
            this.weekday = ( weekday - 1 + 7) % 7;
            this.start = new Time(24).add(start);
            this.end = this.start.add(new Time(0, minutes));
        }

        // Zeitangaben größer als 23:59
        if (!start.lessThan(new Time(23, 59))) {
            this.weekday = weekday + 1 % 7;
            this.start = start.add(new Time(-24,0));
            this.end = this.start.add(new Time(0, minutes));
        }

        // kein Timeslot dauert länger als bis 24:00
        if (!this.end.lessThan(new Time(24,0))) {
            this.end = new Time(24,0);
        }
    }


    // Liefert die Uhrzeit des Starts des Timeslots. Diese liegt
    // zwischen 00:00 und 23:59.
    public Time start() {
        // TODO: Implementieren Sie die Methode.
        return this.start;

    }

    // Liefert die Uhrzeit des Endes des Timeslots. Diese liegt
    // zwischen der Startzeit und 24:00.
    public Time end() {
        // TODO: Implementieren Sie die Methode.
        return end;
    }

    // Liefert den Wochentag (0-6) des Events.
    public int weekday() {
        return weekday;

    }

    @Override
    // Liefert eine lesbare Repräsentation mit Wochentag und Uhrzeit.
    // Beispiel:
    // Mi, 11:30 - 12:15
    // (siehe Beispiele in 'main').
    public String toString() {
        // TODO: Implementieren Sie die Methode.
        return WEEK[weekday] + ", " + start + " - " + end;

    }

    @Override
    // Die equals-Methode: Überprüft die Gleichheit
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != Timeslot.class) {
            return false;
        }
        Timeslot ts = (Timeslot) o;

        return ts.weekday == this.weekday
                && ts.end().equals(this.end())
                && ts.start().equals(this.start());

    }

    @Override
    // Die hashCode-Methode, die den Hashcode dieses Punktes liefert.
    public int hashCode() {
        return this.start().hashCode() + this.end().hashCode() + this.weekday();

    }

}

// Diese Klasse repräsentiert einen Stundenplan für eine Woche. Es können
// Einträge bestehend aus textueller Beschreibung und einem Timeslot
// gemacht werden.
class Timetable {

    // TODO: Deklarieren Sie hier die Objekt-/globale Variable
    private Map<String, Timeslot> map ;


    // Konstruktor: initialisiert diesen Wochenplan als leer.
    public Timetable() {
        // TODO: Implementieren Sie die Methode.
        map = new HashMap<>();

    }

    // Fügt einen neuen 'timeslot' mit Beschreibung 'description' hinzu.
    // Ein etwaiger bereits vorhandener Timeslot mit der
    // gleichen Beschreibung wird durch den neuen 'timeslot' ersetzt.
    public void add(String description, Timeslot timeslot) {
        // TODO: Implementieren Sie die Methode.
        map.put(description, timeslot);

    }

    // Liefert die Startuhrzeit jenes Timeslots, der mit der angegebenen
    // Beschreibung eingetragen wurde. Falls eine solche nicht gefunden
    // wird, wird 'null' geliefert.
    public Time getStart(String description) {
        // TODO: Implementieren Sie die Methode.
        if (map.containsKey(description)){
            Timeslot slot = map.get(description);
            return slot.start();
        }

         return null;
    }


    @Override
    // Liefert eine lesbare Repräsentation des Wochenplans
    // mit Beschreibungen der gespeicherten Timeslots in einer
    // bestimmten Formatierung (siehe Beispiel).
    // Beispiel:
    // {Mathe=Do, 09:30 - 10:30, PK=Mi, 15:00 - 17:00, Security=Do, 15:00 - 17:00}
    public String toString() {
        // TODO: Implementieren Sie die Methode.
        return map.toString();

    }

}


