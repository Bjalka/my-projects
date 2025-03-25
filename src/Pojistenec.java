package DatabazeProPojistovnu;

/**
 * Třída Pojistenec reprezentuje pojištěnce v databázi. Uchovává základní informace o pojištěnci, jako jsou jméno,
 * příjmení, věk a telefonní číslo. Třída obsahuje konstruktory pro inicializaci těchto hodnot a metody pro jejich
 * získání (gettery). Také přepisuje metodu toString(), aby poskytla textovou reprezentaci objektu.
 */

public class Pojistenec {

    // Deklarace vlastností (atributů) třídy, které jsou po zadání uživatelem neměnné (final) pro každého pojištěnce
    final String jmeno;
    final String prijmeni;
    final int vek;
    final String telefonniCislo;

    /**
     * Konstruktor třídy Pojistenec, který nastavuje hodnoty všech vlastností na základě vstupních parametrů.
     * @param jmeno Jméno pojištěnce
     * @param prijmeni Příjmení pojištěnce
     * @param vek Věk pojištěnce
     * @param telefonniCislo Telefonní číslo pojištěnce
     */
    public Pojistenec(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    public String ziskejJmeno() {
        return jmeno;
    }

    public String ziskejPrijmeni() {
        return prijmeni;
    }

    /**
     * Přepsání metody toString(), která vrací textovou reprezentaci objektu Pojistenec
     * @return Vrácení řetězce obsahujícího jméno, příjmení, věk a telefonní číslo pojištěnce
     */
    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", věk: " + vek + ", tel.: " + telefonniCislo;
    }
}
