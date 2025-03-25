package DatabazeProPojistovnu;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída Databaze spravuje databázi pojištěnců. Vytváří a uchovává jejich seznam a na vyžádání vrací buď všechny
 * pojištěnce, případně konkrétní záznam dle jména a příjmení pojištěnce
 */
public class Databaze {

    // Deklarace proměnné pojistenci typu List, jehož položky budou objekty třídy Pojistenec
    final List<DatabazeProPojistovnu.Pojistenec> pojistenci;

    /**
     * Bezparametrický konstruktor třídy Databaze, který inicializuje prázdný seznam pojištěnců.
     */
    public Databaze() {
        this.pojistenci = new ArrayList<>();
    }

    /**
     * Metoda přidávající pojištěnce do seznamu (databáze).
     * @param pojistenec Předtsavuje pojištěnce, který bude přidán do seznamu
     */
    public void pridejPojistence(DatabazeProPojistovnu.Pojistenec pojistenec) {
        this.pojistenci.add(pojistenec);
    }

    /**
     * Metoda vracející seznam všech pojištěnců uložených v databázi
     * @return Vrací seznam všech pojištěnců
     */
    public List<DatabazeProPojistovnu.Pojistenec> vratVsechnyPojistence() {
        return this.pojistenci;
    }



    /**
     * Metoda vyhledávající pojištěnce dle jeho jména a příjmení
     * @param jmeno Představuje jméno pojištěnce
     * @param prijmeni Představuje příjmení pojištěnce
     * @return Vrací daného pojištěnce, byl-li nalezen. Jinak vrací null
     */
    public DatabazeProPojistovnu.Pojistenec vyhledejPojistence(String jmeno, String prijmeni) {
        // Průchod kolekcí (seznamem) pojištěnců s cílem nalézt shodu podle jména a příjmení
        for (DatabazeProPojistovnu.Pojistenec pojistenec : pojistenci) {
            // Pokud se jméno i příjmení shodují, vracíme daného pojištěnce
            if (pojistenec.ziskejJmeno().equalsIgnoreCase(jmeno) && pojistenec.ziskejPrijmeni().equalsIgnoreCase(prijmeni)) {
                return pojistenec;
            }
        }
        return null;
    }
}
