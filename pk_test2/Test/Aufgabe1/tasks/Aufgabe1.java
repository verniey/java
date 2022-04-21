import java.util.Arrays;

/*
Schreiben bzw. vervollständigen Sie gekennzeichnete Programmteile wie in den Kommentaren beschrieben.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!
Verwenden Sie die gegebenen Testklassen zum Überprüfen Ihrer Lösung. Die Korrektheit dieser Testfälle
ist notwendig, aber nicht hinreichend für eine korrekte Lösung.
*/
public class Aufgabe1 {

    /*
    Aufgabe: Manipulation von einfachen Arrays.

        Ergänzen Sie fehlende Teile dieser Klasse entsprechend den Kommentaren
        an den mit TODO gekennzeichneten Stellen.
        Sonstige Anforderungen: Die Verwendung der Klasse 'String' oder 'StringBuffer'
        ist nicht erlaubt. Es sollen keine zusätzlichen Methoden implementiert werden.
        Hinweis: Die beiden gefragten Methoden funktionieren ähnlich. Sie dürfen sich
        daher gegenseitig aufrufen, oder auch unabhängig implementiert werden.

    Punkte (maximal 20):
        10 Punkte für die Implementierung von 'repeat',
        10 Punkte für die Implementierung von 'expand'.
    */

    // Schreibt 'rep' Mal den Wert an der Stelle 'pos' in die
    // darauffolgenden Stellen.
    // Alle Einträge nach 'pos' verschieben sich um 'rep' Positionen
    // in Richtung größerem Index, um für die neuen Einträge Platz zu machen.
    // Die letzten 'rep' Einträge mit größten Indizes gehen
    // durch die Verschiebung verloren.
    // Beachten Sie die Beispiele in der Methode 'main' (siehe unten).
    // Vorbedingung: array != null und array.length > 0 und
    // pos und die Summe pos+rep sind gültige Indizes.
    public static void repeat(int[] array, int pos, int rep) {
        // TODO: implementieren Sie die Methode.

        do {

            for (int i = array.length -1; i > pos ; i--) {
                int temp = array[i -1];
                array[i] = temp;

            }

        } while (--rep > 0);
    }

    // Liefert ein neues Array zurück, in dem der Eintrag an der Stelle 'pos'
    // array[pos] Mal an dieser Stelle eingefügt wird. Das zurückgelieferte Array
    // ist um array[pos] Einträge größer als 'array', sodass auch die verschobenen
    // Einträge Platz haben.
    // Beachten Sie die Beispiele in der Methode 'main' (siehe unten).
    // Das originale Array 'array' wird von der Methode nicht verändert.
    // Vorbedingung: array != null und array.length > 0 und
    // 'pos' ist ein gültiger Index.
    public static int[] expand(int[] array, int pos) {
        // TODO: implementieren Sie die Methode.
        int[]a = new int[array.length + array[pos]];
        System.out.println(a.length);
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
        repeat(a, pos, array[pos]);
        return a;
    }

    // Diese Methode können Sie zum Testen nutzen. Sie geht nicht in die Beurteilung ein.
    public static void main(String[] args) {

        //Testen von 'repeat':
        int[] array = new int[]{15,14,10,12,17};
        repeat(array,2,1);
        System.out.println(Arrays.toString(array)); //[15, 14, 10, 10, 12]

        array = new int[]{15,14,10,12,17};
        repeat(array,1,2);
        System.out.println(Arrays.toString(array)); //[15, 14, 14, 14, 10]

        //Testen von 'expand':
        array = new int[]{5,6,3,8,9};
        System.out.println("expand ");
        System.out.println(Arrays.toString(expand(array,2))); //[5, 6, 3, 3, 3, 3, 8, 9]

    }
}

