package DatabazeProPojistovnu;

import java.util.Scanner;

/**
 * Třída UzivatelskeRozhrani zprostředkovává komunikaci mezi metodou main a třídou Databaze. Obsahuje metody, které
 * umožňují vložit pojištěnce do databáze, zobrazit jejich kompletní výpis či vyhledat pojištěnce dle jména a příjmení.
 * Třída též umožňuje validovat následující údaje zadané uživatelem: jméno, příjmení, věk a telefonní číslo.
 */
public class UzivatelskeRozhrani {
    final Scanner scanner;
    final Databaze databaze;

    /**
     * Konstruktor třídy UzivatelskeRozhrani. Nastavuje paramatery scanner a databaze a vytváří objekt s instancemi
     * Scanner a Databaze, které umožňují komunikaci s uživatelem, stejně jako správu pojištěnců.
     * @param scanner Instance třídy Scanner pro čtení vstupu od uživatele.
     * @param databaze Instance třídy Databaze umožňující manipulaci s daty pojištěnců.
     */
    public UzivatelskeRozhrani(Scanner scanner, Databaze databaze) {
        this.scanner = scanner;
        this.databaze = databaze;
    }

    /**
     * Metoda ukládající nového pojištěnce do databáze. Postupně vyzve uživatele k zadání jména, příjmení, věku a tel.
     * čísla, přičemž zadané údaje validuje
     */
    public void pridejPojistence() {
        String jmeno;
        String prijmeni;

        // Načtení a validace jména
        while (true) {
            System.out.print("Zadejte jméno: ");
            jmeno = scanner.nextLine().trim();
            if (overPlatnostJmena(jmeno)) {
                break;
            } else {
                System.out.println("Jméno musí obsahovat pouze písmena a nesmí být prázdné. Zkuste to, prosím, znovu.");
            }
        }

        // Načtení a validace příjmení
        while (true) {
            System.out.print("Zadejte příjmení: ");
            prijmeni = scanner.nextLine().trim();
            if (overPlatnostJmena(prijmeni)) {
                break;
            } else {
                System.out.println("Příjmení musí obsahovat pouze písmena a nesmí být prázdné. Zkuste to, prosím, znovu.");
            }
        }

        // Načtení a validace věku
        int vek;
        while (true) {
            System.out.print("Zadejte věk: ");
            // Blok try-catch zachycuje případnou chybu při zadávání hodnot.
            try {
                vek = Integer.parseInt(scanner.nextLine().trim());
                if (vek >= 0 && vek <= 120) {
                    break; // Číslo zadané v platném formátu (číslo datového typu int od 0 do 120) smyčku přeruší
                } else {
                    System.out.println("Věk musí být v rozmezí 0 až 120. Zkuste to, prosím, znovu.");
                }
            } catch (NumberFormatException e) { // vyvolání výjimky v případě neplatného uživatelského vstupu
                System.out.println("Věk musí být číslo. Zkuste to, prosím, znovu.");
            }
        }

        // Načtení a validace tel. čísla
        String telefonniCislo;
        while (true) {
            System.out.print("Zadejte telefonní číslo: ");
            telefonniCislo = scanner.nextLine().trim();
            if (telefonniCislo.matches("\\+?\\d{9,12}")) { // regulární výraz stanovující povolený formát čísla
                break; // Telefonní číslo zadané v platém forámtu ukončí smyčku
            } else {
                System.out.println("Telefonní číslo musí obsahovat číslo ve formátu (+420)123456789. Zkuste to, prosím, znovu.");
            }
        }

        // Vytvoření nového pojištěnce a vložení příslušných údajů do databáze
        Pojistenec pojistenec = new Pojistenec(jmeno, prijmeni, vek, telefonniCislo);
        databaze.pridejPojistence(pojistenec);
        System.out.println("\nPojištěnec byl úspěšně přidán. Zvolte další volbu.");
    }

    /**
     * Vyvtoření metody, která vypíše seznam všech pojištěnců uložených v databázi. Nejprve vytiskne nadpis
     * "Seznam všech pojištěných" a poté iteruje přes všechny pojištěnce vrácené metodou vratVsechnyPojistence()
     * z objektu databaze. Každý pojištěnec je vytištěn na nový řádek.
     */
    public void zobrazVsechnyPojistence() {
        System.out.println("\nSeznam všech pojištěnců:");
        for (Pojistenec p : databaze.vratVsechnyPojistence()) {
            System.out.println(p);
        }
    }

    /**
     * Vytvoření metody umožňující uživateli vyhledat konkrétního pojištěnce v databázi. Metoda nejprve vyzve uživatele
     * k zadání jména a příjmení. Poté pomocí metody vyhledejPojistence() objektu databaze
     * provede vyhledání pojištěnce dle zadaného jména a příjmení. Pokud je pojištěnec nalezen, zobrazí jeho informace
     * v konzoli. Pokud nalezen není, informuje uživatele, že pojištěnec neexistuje.
     */
    public void vyhledejPojistence() {
        System.out.print("Zadejte jméno: ");
        String jmeno = scanner.nextLine().trim();
        System.out.print("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();

        Pojistenec nalezenyPojistenec = databaze.vyhledejPojistence(jmeno, prijmeni);
        if (nalezenyPojistenec != null) {
            System.out.println("\nNalezený pojištěnec:");
            System.out.println(nalezenyPojistenec); // vypíše pojištěnce pomocí metody toString()
        } else {
            System.out.println("\nPojištěnec nebyl nalezen.");
        }
    }

    private boolean overPlatnostJmena(String name) {
        return name.matches("[A-Za-zÀ-ž]+"); // Regulární výraz stanovující povolené znaky
    }
}
