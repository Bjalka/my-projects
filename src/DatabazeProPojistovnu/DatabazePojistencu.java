package DatabazeProPojistovnu;

import java.util.Scanner;

/**
 * Třída DatabazePojistencu vytváří interaktivní rámec pro správu databáze pojištěnců. Umožňuje přidávat nové pojištence,
 * zobrazovat jejich seznam, vyhledávat v databázi a ukončit program. Využívá tříd Scanner, Databaze a UzivatelskeRozhrani.
 */
public class DatabazePojistencu {

    /**
     * Hlavní metoda programu. Inicializuje objekty pro práci s uživatelským rozhraním. Obsahuje hlavní smyčku programu
     * pro zpracování uživatelských voleb.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializace Scanneru pro čtení vstupu od uživatele
        Databaze databaze = new Databaze(); // Inicializace Databaze pro správu pojištěnců
        DatabazeProPojistovnu.UzivatelskeRozhrani rozhrani = new DatabazeProPojistovnu.UzivatelskeRozhrani(scanner, databaze); // Propojení databáze a rozhraní

        System.out.println("\nVítejte v databázi pojištěnců. Zadejte volbu:");

        // Hlavní smyčka aplikace. Zobrazuje uživatelské menu a zpracovává vstupy od uživatele.
        while (true) {

            System.out.println();
            System.out.println("1 - Přidat pojištěnce");
            System.out.println("2 - Zobrazit všechny pojištěnce");
            System.out.println("3 - Vyhledat pojištěnce");
            System.out.println("4 - Konec");
            String volba = scanner.nextLine().trim(); // Načtení uživatelské volby

            // Zpracování volby zadané uživatelem pomocí switch (case 1-3 volají metody z třídy UzivatelskeRozhrani)
            switch (volba) {
                case "1":
                    rozhrani.pridejPojistence(); // Volba pro přidání nového pojištěnce
                    break;

                case "2":
                    rozhrani.zobrazVsechnyPojistence(); // Volba pro zobrazení seznamu pojištěnců
                    break;

                case "3":
                    rozhrani.vyhledejPojistence(); // Volba pro vyhledání pojištěnce dle jména a příjmení
                    break;

                case "4":
                    System.out.println("Konec programu."); // Volba ukončující aplikaci
                    return;

                default:
                    System.out.println("Neplatná volba. Zkuste to, prosím, znovu.\n"); // Ošetření neplatné volby
            }
        }
    }
}