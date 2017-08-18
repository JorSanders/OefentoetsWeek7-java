package oefentoetsweek7;

import java.util.*;

/**
 * oefentoets week 7
 *
 * @author jor sanders supermarkt bon printen
 */
public class OefentoetsWeek7 {

    //initialize
    static Scanner stdin = new Scanner(System.in);
    static int kortingsaantal, kortingspercentage, aantalArtikelen;
    static double totaalprijs;
    static String[] omschrijving;
    static double[] prijs;
    static double bedrag;

    //main method mostly layout
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.print("wat is her kortings aantal (1..9)? ");
        kortingsaantal = read(1, 9, stdin.nextInt());
        System.out.print("wat is her kortingspercentage (1..100)? ");
        kortingspercentage = read(1, 100, stdin.nextInt());
        System.out.print("hoeveel artikelen heb je gekocht? ");
        aantalArtikelen = read(0, 10000, stdin.nextInt());
        System.out.println("");
        readDescription();
        print();
    }

    //read a number and checks if its between the given min and max
    public static int read(double min, double max, int input) {
        while (input < min || input > max) {
            System.out.println("het getal moet tussen de "+min+" en "+max+" liggen.");
            System.out.print("voor opnieuw in: ");
            input = stdin.nextInt();
        }
        return input;
    }

    //reads the price and description of each product
    public static void readDescription() {
        omschrijving = new String[(int) aantalArtikelen];
        prijs = new double[(int) aantalArtikelen];

        for (int i = 0; i < aantalArtikelen; i++) {
            System.out.print("omschrijving van het artikel #" + (i + 1) + " ");
            omschrijving[i] = stdin.next();
            System.out.print('\t' + "wat is de prijs van het artikel #" + (i + 1) + " ");
            prijs[i] = stdin.nextDouble();
            totaalprijs += prijs[i];
        }
    }

    //prints the results
    public static void print() {
        System.out.println("");
        for (int i = 0; i < aantalArtikelen; i++) {
            System.out.println(omschrijving[i] + ": Eur " + prijs[i]);
        }
        System.out.println("---------------");
        System.out.println(totaalprijs);
        System.out.println("");

        if (aantalArtikelen < kortingsaantal) {
            System.out.println("je kocht minder dan " + (int) kortingsaantal + " artikelen");
            bedrag = totaalprijs;
        } else {
            System.out.println("je kocht " + (int) kortingsaantal + " of meer artikelen;"
                    + "je krijgt dus " + kortingspercentage + "% korting.");
            bedrag = totaalprijs - (totaalprijs / 100 * kortingspercentage);
        }

        System.out.println("");
        System.out.println("te betalen bedrag: " + bedrag);
    }
}
