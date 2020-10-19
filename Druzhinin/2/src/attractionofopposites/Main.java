package attractionofopposites;


import magicofnumbers.MagicOfNumbers;

public class Main {

    public static void main(String [] args) {

        // Home work 2.1
        System.out.println("#Home work 1\n");

        MagicOfNumbers magic = new MagicOfNumbers();
        magic.generateMagic();

        // Home work 2.2
        System.out.println("\n#Home work 2\n");

        AttractionOfOpposites attractions = new AttractionOfOpposites();
        attractions.fillArray();
        attractions.printOfArray();
        attractions.checkOpposites();

    }
}
