public class Aufgabe2 {

    /*
    Aufgabe:
        Methoden zur Manipulation eines zwei-dimensionalen Arrays, interpretiert
        als Matrix (mit Zeilen und Spalten).
        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren
        an den mit TODO gekennzeichneten Stellen.
        Sonstige Anforderungen: Die Verwendung der Klasse 'String' oder 'StringBuffer'
        ist nicht erlaubt.

    Punkte (maximal 20):
        10 Punkte für 'bargraph',
        10 Punkte für 'axis'.
    */

    // Erzeugt aus 'data' ein Balkendiagramm, d.h. ein rechteckiges Array
    // in dem die Anzahl der Zeichen '#' (d.h., Höhe des Balkens) der i-ten Spalte
    // dem Wert data[i] entspricht. Das Zeichen '.' wird dort als Füllzeichen genutzt,
    // wo kein '#' steht. Die Höhe des Arrays wird durch den maximalen Wert in
    // 'data' vorgegeben, die Breite durch die Länge von 'data'.
    // Beachten Sie die Beispiele in der Methode 'main'.
    // Vorbedingung: 'data' ist nicht null und enthält nur Einträge >= 0.
    public static char[][] bargraph(int[] data) {
        // TODO: implementieren Sie die Methode.
        int h = 0;
        for (int i : data){
            h = h > i ? h : i;
        }
        char[][] res = new char[h][data.length];
        for (int i = 0; i < res.length; i++){
            for (int j = 0; j< res[i].length; j++){
                res[i][j] = '.';
            }
        }
        int row = 0;
        int col = 0;

        for (int i = 0; i < data.length; i++){
            int val = data[i];

            while (val-- > 0){
                res[row][col] = '#';
                ++row;
            }
            ++col;
            row = 0;
        }
        return res;

    }

    // Liefert ein neues Array mit dem gleichen Inhalt wie 'bargraph',
    // jedoch erweitert um eine Achsenbeschriftung, d.h.
    // in der ersten Zeile (unterste Zeile) stehen die Spaltenindizes.
    // Siehe dazu das Beispiel in der Methode 'main'.
    // HINWEIS: Sie können diese Methode auch dann implementieren, wenn Sie
    // die Methode 'bargraph' nicht implementiert haben.
    // Vorbedingung: bargraph != null und alle Zeilen (Arrays der zweiten Ebene)
    // von 'bargraph' sind gleich lang,
    // bargraph.length > 0 und bargraph[0].length > 0.
    public static char[][] axis(char[][] bargraph) {
        //TODO: Implementieren Sie diese Methode
        char[][] copy = new char[bargraph.length + 1][bargraph[0].length];
        for (int i = bargraph.length - 1; i >= 0; i--) {

            for (int j = 0; j < bargraph[i].length; j++) {
                copy[i+1][j] = bargraph[i][j];
            }
        }

        for (int i = 0; i < bargraph[0].length; i++) {
            copy[0][i] = Character.forDigit(i, 10);
        }




        return copy;
    }

    // Gibt das angegebene Array zeilenweise aus.
    // Der Zeilenindex erhöht sich von unten nach oben.
    // Der Spaltenindex erhöht sich von links nach rechts.
    // Vorbedingung: array != null und alle array[i] != null (0 <= i < array.length)
    // DIESE METHODE SOLL NICHT VERÄNDERT WERDEN.
    public static void printMultiArray(char[][] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

    }

    // Diese Methode können Sie zum Testen nutzen. Sie geht nicht in die Beurteilung ein.
    public static void main(String[] args) {

        //Testen von 'bargraph':
        printMultiArray(bargraph(new int[]{1,3,5,4,2,1,0,1,0}));
        // .   .   #   .   .   .   .   .   .
        // .   .   #   #   .   .   .   .   .
        // .   #   #   #   .   .   .   .   .
        // .   #   #   #   #   .   .   .   .
        // #   #   #   #   #   #   .   #   .

        System.out.println();

        //Testen von 'axis':
        //Falls die Methode 'bargraph' nicht implementiert wurde,
        //wird hier zunächst ein Array erzeugt.
        char[][] bargraph = new char[5][9];
        bargraph[4] = new char[] {'.','.','#','.','.','.','.','.','.'};
        bargraph[3] = new char[] {'.','.','#','#','.','.','.','.','.'};
        bargraph[2] = new char[] {'.','#','#','#','.','.','.','.','.'};
        bargraph[1] = new char[] {'.','#','#','#','#','.','.','.','.'};
        bargraph[0] = new char[] {'#','#','#','#','#','#','.','#','.'};


        bargraph = axis(bargraph);
        printMultiArray(bargraph);
        // .   .   #   .   .   .   .   .   .
        // .   .   #   #   .   .   .   .   .
        // .   #   #   #   .   .   .   .   .
        // .   #   #   #   #   .   .   .   .
        // #   #   #   #   #   #   .   #   .
        // 0   1   2   3   4   5   6   7   8

    }

}

