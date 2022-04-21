public class Aufgabe3 {

    /*
    Aufgabe:
        Rekursive Methoden.
        Verändern Sie die Implementierungen der Methoden dieser Klasse entsprechend
        den Kommentaren an den mit TODO gekennzeichneten Stellen.

        Die Methoden sollen Ihr Ein-/Ausgabeverhalten auf gültigen Eingaben behalten.

        Der Programmcode soll OHNE GLOBALE VARIABLEN
        (Variablen, die außerhalb eines Methodenrumpfs deklariert werden) auskommen!

        Die gegebenen Methodenköpfe sollen nicht verändert werden.
        Zusätzliche Hilfsmethoden sind nicht erlaubt.

    Punkte (maximal 20):
        8 Punkte für die Implementierung von 'digits',
        6 Punkte für die Implementierung von 'f',
        6 Punkte für die Implementierung von 'largestRemainder',
    */

    // liefert die i+1 niedrigstwertigen Ziffern der Dezimaldarstellung von 'n' als String
    // (die Einerstelle steht darin ganz rechts). Ziffern werden durch ',' getrennt.
    // Vorbedingung: n > 0
    public static String digits(int n, int i) {
        //TODO: Ersetzen Sie die Schleife durch Rekursion.
        String s = "";
        if (i > 0){
            if (n > 0){
                s = digits(n / 10, i -1);
                if (s.equals("")){
                    s += n % 10;
                }else {
                    s = s + "," + n % 10;
                }
            }

        }
        return s;

    }
    public static String digitsI(int n, int i) {
        //TODO: Ersetzen Sie die Schleife durch Rekursion.
        String s = "";
        do {
            s = i <= 0 ? s : n%10 + (s.equals("") ? "" : "," + s);
            n /= 10;
            i--;
        } while (n > 0);
        return s;

    }

    // Vorbedingung: x >= 0 und y > 0
    public static boolean f(int x, int y) {
        //TODO: Entfernen Sie die Rekursion (ersetzen Sie durch Schleife oder Operator).
        while (x > 0){
            x-= y;
        }
        return x == 0;
    }
    public static boolean fI(int x, int y) {
        //TODO: Entfernen Sie die Rekursion (ersetzen Sie durch Schleife oder Operator).
        return x < y ? x == 0 : f(x-y, y);
    }

    // Liefert den maximalen Rest der Division durch 'divisor' über alle Einträge in 'array' zurück.
    // Vorbedingung: array != null und array.length > 0.
    public static int largestRemainder(int[] array, int divisor) {
        //TODO: Ersetzen Sie die Schleife durch Rekursion.
        int idx = 0;

        if (idx < array.length - 1){
            idx++;
            int res = largestRemainderI(array, divisor);
            return Math.max(res, array[idx] % divisor);
        }
        return idx;
    }

    public static int largestRemainderI(int[] array, int divisor) {
        //TODO: Ersetzen Sie die Schleife durch Rekursion.
        int max = array[0] % divisor;
        while(array.length > 1) {
            array = java.util.Arrays.copyOfRange(array, 1, array.length);
            int remainder = array[0] % divisor;
            if (max < remainder) {
                max = remainder;
            }
        }
        return max;
    }

    // Diese Methode können Sie zum Testen nutzen. Geht nicht in die Beurteilung ein.
    public static void main(String[] args) {

        System.out.println(largestRemainder(new int[]{3,20,5,5,19,2,6},5)); // 4
        System.out.println(largestRemainder(new int[]{3,20,5,5,19,2,6},3)); // 2
        System.out.println();
        System.out.println(digitsI(15,7)); //1,5
        System.out.println(digits(15,7)); //1,5
        System.out.println(digits(1542167,3)); //1,6,7
        System.out.println(digits(1542167,4)); //2,1,6,7
        System.out.println(digits(1542167,0)); //
        System.out.println(digits(1542167,6)); //5,4,2,1,6,7
        System.out.println(digits(1542167,7)); //1,5,4,2,1,6,7

        System.out.println();
        System.out.println(f(23,4));
        System.out.println(fI(23,4));
        System.out.println(f(-23,4));
        System.out.println(fI(-23,4));
        System.out.println(f(6,64));
        System.out.println(fI(6,64));
        System.out.println(f(10,5));
        System.out.println(fI(10,5));

    }

}

