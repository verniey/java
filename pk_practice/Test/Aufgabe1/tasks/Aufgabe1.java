import javafx.collections.transformation.TransformationList;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/*
Schreiben bzw. vervollständigen Sie gekennzeichnete Programmteile wie in den Kommentaren beschrieben.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!
Verwenden Sie die gegebenen Testklassen zum Überprüfen Ihrer Lösung. Die Korrektheit dieser Testfälle
ist notwendig, aber nicht hinreichend für eine korrekte Lösung. Es werden damit nur bestimmte
Spezialfälle geprüft. Liefern die Testklassen keinen Fehler, garantiert dies noch nicht die
Korrektheit Ihrer Lösung gemäß der Angabe.
*/

public class Aufgabe1 {

    /*
    Aufgabe: Umgang mit Klassen und Objekten, sowie vorgefertigten Datenstrukturen.

        Ergänzen Sie fehlende Teile der Klassen 'Rectangle' und 'Figure' entsprechend den Kommentaren
        an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 40):
        14 Punkte in Summe für Klasse 'Rectangle':
            5 Punkte für Variablen und Konstruktoren,
            4 Punkte für 'hasElement'
            1 Punkt  für 'symbol',
            4 Punkte für 'moveVertical',
        26 Punkte in Summe für Klasse 'Figure':
            3 Punkte für den Konstruktor
            3 Punkte für 'add'
            7 Punkte für 'get'
            6 Punkte für 'delete'
            7 Punkte für 'toString'

    Auch für teilweise korrekte Lösungen werden Punkte vergeben.

    */



    // Diese Methode können Sie zum Testen nutzen. Sie geht nicht in die Beurteilung ein.
    public static void main(String[] args) {

        //Testen von Position:
        Position p = new Position(1,2);

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if ((x == 1 && y == 2) != new Position(x,y).equals(p)) {
                    System.out.println("Fehler in Klasse 'Position'!");
                }
            }
        }

        //Testen von Rectangle:
        Rectangle rect1 = new Rectangle(new Position(0,0), new Position(4,5), '#');
        Rectangle rect2 = new Rectangle(new Position(3,3), new Position(3,7), 'o');

        Figure fig = new Figure(10,10);
        fig.add(rect1);
        fig.add(rect2);

        for (int x = 0; x < 6; x++) {
            int y = x+2;
            fig.add(new Rectangle(new Position(x,y), new Position(x,y),'\\'));
        }

        System.out.println(fig);

        rect1.moveVertical(3);

        System.out.println(fig);

        Rectangle rect3 = fig.get(new Position(2,6));
        System.out.println(rect3 == rect1);

        fig.delete(new Position(2,6));
        System.out.println(fig);

        fig.delete(new Position(3,5));
        System.out.println(fig);

        /* Erwartete Ausgabe:

        #####.....
        #####.....
        \####.....
        #\#o#.....
        ##\o#.....
        ###\#.....
        ...o\.....
        ...o.\....
        ..........
        ..........

        ..........
        ..........
        \.........
        #\#o#.....
        ##\o#.....
        ###\#.....
        ###o\.....
        ###o#\....
        #####.....
        ..........

        true
        ..........
        ..........
        \.........
        .\.o......
        ..\o......
        ...\......
        ...o\.....
        ...o.\....
        ..........
        ..........

        ..........
        ..........
        \.........
        .\.o......
        ..\o......
        ...o......
        ...o\.....
        ...o.\....
        ..........
        ..........

        */
    }
}

// Diese Klasse repräsentiert eine 2D-Position mit 2 Koordinaten.
// Es kann davon ausgegangen werden, dass beide Koordinaten größer oder gleich 0 sind.
// Diese Klasse soll nicht verändert werden.
class Position {

    private final int x;
    private final int y;

    // Initialisiert diese Position mit den angegebenen Koordinaten x und y.
    // Annahme: x >= 0 und y >= 0.
    public Position(int x, int y) {
        this.x = x;
        this.y = y;

    }

    // Liefert true, genau dann wenn die x-Kordinate kleiner als die von 'p' ist
    public boolean hasSmallerXThan(Position p) {
        return this.x < p.x;

    }

    // Liefert true, genau dann wenn die y-Kordinate kleiner als die von 'p' ist
    public boolean hasSmallerYThan(Position p) {
        return this.y < p.y;

    }

    // Liefert eine Position mit derselben x-Koordinate und
    // um 'deltaY' erhöhter y-Koordinate zurück.
    public Position movedVertical(int deltaY) {
        return new Position(x, y + deltaY);

    }

    @Override
    // Die equals-Methode: Überprüft die Gleichheit mit einem anderen
    // Objekt 'o'. Diese Methode kann für die
    // Implementierung der anderen Klassen benutzt werden.
    // liefert true, wenn das angegebene Objekt 'o' eine Position mit
    // den gleichen Koordinaten wie diese Position ist, sonst false.
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }

        if (o.getClass() != Position.class) {
            return false;
        }

        Position p = (Position) o;

        if (p.x == this.x && p.y == this.y) {
            return true;
        } else {
            return false;
        }

    }

    // Liefert den Hashcode dieser Position. Dieser entspricht
    // der x-Koordinate der Position.
    public int hashCode() {
        return this.x + this.y;

    }

}

// Repräsentiert eine rechteckige Region mit horizontalen und vertikalen Kanten.
// Sie wird durch die zwei diagonal gegenüberliegenden Eckpunkte definiert (inklusive),
// und durch das Zeichen, mit dem diese Region gefüllt wird.
class Rectangle {

    //TODO: Deklarieren Sie entsprechende Variablen mit einer sinnvollen Sichtbarkeit.
    private Position p1;
    private Position p2;
    private Character ch;

    // Das achsenparallele Rechteck wird durch die zwei diagonal
    // gegenüberliegenden Eckpunkte p1 = (x1,y1) und p2 = (x2,y2) definiert,
    // wobei gilt: x1 <= x2 und y1 <= y2.
    // Wirft eine IllegalArgumentException, wenn diese Bedingung verletzt wird.
    public Rectangle(Position p1, Position p2, char ch){
        // TODO: Implementieren Sie den Konstruktor.

        if (p1.hasSmallerYThan(p1) && p1.hasSmallerYThan(p2)) {
            throw new IllegalArgumentException("must be: x1 <= x2 und y1 <= y2");
        }

        this.p1 = p1;
        this.p2 = p2;
        this.ch = ch;
    }

    // Gibt an, ob 'p' innerhalb dieses Rechtecks liegt.
    // Liefert in diesem Fall 'true', sonst 'false'.
    public boolean hasElement(Position p) {
        // TODO: Implementieren Sie die Methode.

        if (p.hasSmallerXThan(p1) || p.hasSmallerYThan(p1) || p2.hasSmallerXThan(p) || p2.hasSmallerYThan(p)) {
            return false;
        } else {
            return true;

        }


    }

    // Liefert das Zeichen, mit dem das Rechteck gefüllt ist.
    public char symbol() {

        // TODO: Implementieren Sie die Methode.
        return this.ch;
    }

    // Verschiebt das Rechteck (also seine Eckpunkte) vertikal.
    public void moveVertical(int deltaY) {

        // TODO: Implementieren Sie die Methode.
//2 Eckpunkte fehlen
        p1 = this.p1.movedVertical(deltaY);
        p2 = this.p2.movedVertical(deltaY);

    }

}

// Diese Klasse repräsentiert eine Zeichnung mit 'height' Zeilen der Länge 'width'.
// Die Zeichnung besteht aus beliebig vielen Rechtecken, die
// nebeneinander oder auch überlappend gezeichnet werden.
class Figure {

    // Deklarieren Sie keine weiteren Objekt-/globalen Variablen.

    // Speichert die gesetzten Pixel
    private List<Rectangle> rectangles;

    // Höhe und Breite des Bildes (gültiger Bildbereich von 0 bis height-1 bzw. width-1).
    private int height, width;

    // Konstruktor: initialisiert diese 'Figure' als leere Zeichnung
    // ohne Rechtecke.
    public Figure(int width, int height) {
        // TODO: Implementieren Sie den Konstruktor.
        this.rectangles = new LinkedList<>();
        this.width = width;
        this.height = height;


    }

    // Fügt der Zeichnung ein Rechteck hinzu.
    // Dieses darf auch teilweise oder vollständig
    // außerhalb des Bildbereichs liegen (wird nicht überprüft).
    public void add(Rectangle rectangle) {
        // TODO: Implementieren Sie die Methode.
        rectangles.add(rectangle);

    }

    // Liefert jenes Rechteck, das zuletzt hinzugefügt wurde und
    // die Position p enthält.
    // Falls es kein solches Rechteck gibt, wird 'null' geliefert.
    public Rectangle get(Position p) {
        // TODO: Implementieren Sie die Methode.
        for (int i = rectangles.size() - 1; i >=0; i--) {
            if (rectangles.get(i).hasElement(p)) {
                return rectangles.get(i);
            }
        }
        return null;
    }

    // Löscht jenes Rechteck, das zuletzt hinzugefügt wurde und
    // die Position p enthält.
    // Liefert 'true', wenn der Aufruf die Figure verändert hat,
    // oder 'false', wenn es an der Position kein Rechteck gibt.
    public boolean delete(Position p) {
        // TODO: Implementieren Sie die Methode.
        for (int i = rectangles.size() - 1; i >=0; i--) {
            if (rectangles.get(i).hasElement(p)) {
                return rectangles.remove(rectangles.get(i));
            }
        }
        return false;

    }

    @Override
    // Liefert eine lesbare Repräsentation, in der die Zeichnung
    // als Raster mit 'height' Zeilen der Länge 'width' dargestellt wird.
    // Später hinzugefügte Rechtecke überlagern früher hinzugefügte,
    // d.h. in jeder Position wird immer das Zeichen des zuletzt hinzugefügten
    // Rechtecks gesetzt. Befindet sich an einer Position kein Rechteck,
    // wird '.' zur Markierung des leeren Hintergrunds gesetzt.
    // Zeichen außerhalb des Bildbereichs werden nicht dargestellt.
    // (siehe Beispiele in 'main').
    public String toString() {
        // TODO: Implementieren Sie die Methode.
        StringBuilder str = new StringBuilder();

        for (int x = 0; x < width; x++) {
            for (int  y= 0; y < height; y++) {
                Position position = new Position(y, x);
                Rectangle rectangle = this.get(position);
                if (rectangle != null) {
                    str.append(rectangle.symbol());

                } else {
                    str.append(".");
                }
            }
            str.append("\n");

        }

        return str.toString();
    }

}
