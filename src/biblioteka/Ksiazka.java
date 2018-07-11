package biblioteka;

import java.io.*;

public class Ksiazka implements Serializable {
    public int id;
    public String tytul;
    public String nazwiskoAutora;
    public String imionaAutora;
    public int rok;
    public String kategorie;
    public boolean czyWypozyczona;
    public int liczbaWypozyczen;
    
    
    public Ksiazka(int id, String tytul, String nazwiskoAutora, String imionaAutora, int rok, String kategorie) {
        this.id = id;
        this.tytul = tytul;
        this.nazwiskoAutora = nazwiskoAutora;
        this.imionaAutora = imionaAutora;
        this.rok = rok;
        this.kategorie = kategorie;
        this.czyWypozyczona = false;
        this.liczbaWypozyczen = 0;
    }
    
    int getId() { return id; }
    String getTytul() { return tytul; }
    String getNazwiskoAutora() { return nazwiskoAutora; }
    String getImionaAutora() { return imionaAutora; }
    int getRok() { return rok; }
    String getKategorie() { return kategorie; }
    int getLiczbaWypozyczen() { return liczbaWypozyczen; }
    String getCzyWypozyczona() { 
        if (czyWypozyczona) { 
            return "tak"; 
        } else
            return "nie";
    }
    boolean getCzyWypozyczona1() { return  czyWypozyczona; }
    public String getInicjaly() {
        char i1 = 0, i2 = 0;
        for (int i = 0; i < imionaAutora.length(); i++) {
            i1 = imionaAutora.charAt(0);
            if (Character.isWhitespace(imionaAutora.charAt(i))) {
                i2 = imionaAutora.charAt(i+1);
            }
            else { return i1+"."; }
        }
        return i1+"."+" "+i2+".";
    }
 
    
    
    public String toString() {
        return String.format("%5d %-30s %-20s %-20s %10d %-20s %10s %10d", id, tytul, nazwiskoAutora, imionaAutora, rok, kategorie, getCzyWypozyczona(), liczbaWypozyczen);
    }
}
