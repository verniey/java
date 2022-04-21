/*
Schreiben bzw. vervollständigen Sie gekennzeichnete Programmteile wie in den Kommentaren beschrieben.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!
Verwenden Sie die gegebenen Testklassen zum Überprüfen Ihrer Lösung. Die Korrektheit dieser Testfälle
ist notwendig, aber nicht hinreichend für eine korrekte Lösung. Es werden damit nur bestimmte
Spezialfälle geprüft. Liefern die Testklassen keinen Fehler, garantiert dies noch nicht die
Korrektheit Ihrer Lösung gemäß der Angabe.
*/

public class Aufgabe2 {

    /*
    Aufgabe:
        Objekte der Klasse Tree stellen binäre Suchbäume über ganze Zahlen mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 20):
        10 Punkte für 'printLevel',
        10 Punkte für 'sumGreaterEqual'.

        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    // Just for testing (geht nicht in die Beurteilung ein).
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.add(6);
        tree.add(8);

        System.out.println(tree);  // [1,2,5,6,7,8]

        System.out.println("Check printLevel:");
        tree.printLevel(0);    // 5
        tree.printLevel(1);
        /*
        7
        2
        */
        tree.printLevel(2);
        /*
        8
        6
        1
        */
        tree.printLevel(5);    // (keine Ausgabe oder leere Zeile)

        System.out.println("Check sumGreaterEqual:");
        System.out.println(tree.sumGreaterEqual(2)); // 28
        System.out.println(tree.sumGreaterEqual(7)); // 15

    }

}

class Node {

    // Ändern Sie diese Variablen nicht. Deklarieren Sie keine weiteren Objekt-/globalen Variablen.

    int elem;
    Node left;
    Node right;

    // Konstruktor
    Node(int elem) {
        this.elem = elem;
    }

    // Fügt ein Element hinzu
    void add(int elem) {
        if (elem < this.elem) {
            if (left == null) {
                left = new Node(elem);
            } else {
                left.add(elem);
            }
        } else {
            if (right == null) {
                right = new Node(elem);
            } else {
                right.add(elem);
            }
        }
    }

    @Override
    // Liefert eine lesbare Repräsentation (Komma getrennte Liste der Elemente).
    public String toString() {
        String result = Integer.toString(elem);
        if (left != null) {
            result = left + "," + result;
        }
        if (right != null) {
            result += "," + right;
        }
        return result;

    }

    public void printLevel(int i){
        String s = Integer.toString(elem);
        if (i == 0){
            System.out.println(s);
        }else {
            if (right != null){
                right.printLevel(i -1);
            }
            if (left != null){
                left.printLevel(i - 1);
            }
        }
    }

    public int sumGreaterEqual(int lower){
        int sum = this.elem >= lower ? elem : 0;
        if (left != null){
            sum += left.sumGreaterEqual(lower);
        }
        if (right != null){
            sum+= right.sumGreaterEqual(lower);
        }
        return sum;
    }
    // TODO: Definieren Sie hier rekursive Hilfsmethoden.

} // Ende der Definition von Node

class Tree {

    // Die Wurzel des Baums. Deklarieren Sie keine weiteren Objekt-/globalen Variablen.
    private Node root;

    // Fügt dem Baum 'elem' hinzu.
    public void add(int elem) {
        if (root == null) {
            root = new Node(elem);
        } else {
            root.add(elem);
        }
    }

    // Liefert die Summe aller Werte im Baum, die größer oder gleich 'lower' sind.
    // Liefert 0 wenn der Baum leer ist.
    // FORDERUNG: Es sollen dabei möglichst wenige Knoten durchmustert werden.
    public int sumGreaterEqual(int lower) {
        // TODO: Implementieren Sie die Methode.
        // TODO: Es sollen dabei möglichst wenige Knoten durchmustert werden.
        //return -1; //TODO: Diese Zeile löschen.
        if (root != null){
            return root.sumGreaterEqual(lower);
        }
        return 0;

    }

    // Gibt alle Elemente einer bestimmten Ebene
    // des Baums in absteigender Reihenfolge durif ()ch Leerzeichen getrennt
    // in einer Zeile auf dem Bildschirm aus.
    public void printLevel(int i) {
        // TODO: Implementieren Sie die Methode.
        if (root != null){
            root.printLevel(i);
        }
    }

    // Liefert eine Komma getrennte Liste der Elemente in aufsteigender Reihenfolge
    // mit umschliessenden eckigen Klammern.
    @Override
    public String toString() {
        if (root == null) {
            return "[]";
        }
        return "[" + root + "]";

    }
}


