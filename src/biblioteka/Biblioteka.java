package biblioteka;

import java.io.*;

public class Biblioteka implements Serializable {

    Ksiazka[] book = new Ksiazka[1000];

    public void dodajKsiazke(Ksiazka k) {
        book[getIndexOfKsiazki()] = k;
    }

    public int getIndexOfKsiazki() {
        int index = 0;
        for (Ksiazka b : book) {
            if (b != null) {
                index++;
            }
        }
        return index;
    }

    public void giveTytul(int id, String tytul) {
        book[id].tytul = tytul;
    }

    public void giveImiona(int id, String imiona) {
        book[id].imionaAutora = imiona;
    }

    public void giveNazwisko(int id, String nazwisko) {
        book[id].nazwiskoAutora = nazwisko;
    }

    public void giveKategorie(int id, String kategorie) {
        book[id].kategorie = kategorie;
    }

    public void giveRok(int id, int rok) {
        book[id].rok = rok;
    }

    public void giveCzyWypozyczona(int id, boolean czyWypozyczona) {
        book[id].czyWypozyczona = czyWypozyczona;
    }

    public boolean GetCzyWypozyczona(int id) {
        return book[id].getCzyWypozyczona1();
    }

    public void give1toLiczbaWypozyczen(int id) {
        book[id].liczbaWypozyczen++;
    }

    public int GetLiczbaWypozyczen(int id) {
        return book[id].liczbaWypozyczen;
    }

    public void wyswietlId(int id) {
        System.out.println(book[id]);
    }

    public void wyswietl() {
        for (Ksiazka b : book) {
            if (b != null) {
                System.out.println(b);
            }
        }
    }

    public void wyswietl1() {
        for (Ksiazka b : book) {
            if (b != null) {
                System.out.print(b.getId() + " ");
                System.out.print(b.getInicjaly() + " ");
                System.out.print(b.getNazwiskoAutora() + " ");
                System.out.print(b.getTytul() + " ");
                System.out.print(b.getCzyWypozyczona());
                System.out.println();
            }
        }
    }

    public String wyswietlWypozyczone() {
        int ile = 0;
        int ile1 = 0;
        int suma = 0;
        for (Ksiazka b : book) {
            if (b != null) {
                ile++;
                suma += b.getLiczbaWypozyczen();
                if (b.getCzyWypozyczona1() == true) {
                    ile1++;
                }
            }
        }
        return "Liczba wszystkich książek: " + ile + ", liczba książek obecnie wypożyczonych: " + ile1 + ", liczba wszystkich wypożyczeń: " + suma;
    }

   

    public void wyswietlTytul(String tytul) {
        int ile = 0;
        for (Ksiazka b : book) {
            for (int i = 0; i < tytul.length(); i++) {
                char s1 = b.getTytul().charAt(i);
                char s2 = tytul.charAt(i);
                if (s1 == s2) {
                    ile++;
                }
            }
            if (ile == tytul.length()) {
                System.out.println(b);
            }
        }
    }

    public void wyswietlNazwisko(String nazwisko) {
        int ile = 0;
        for (Ksiazka b : book) {
            for (int i = 0; i < nazwisko.length(); i++) {
                char s1 = b.getNazwiskoAutora().charAt(i);
                char s2 = nazwisko.charAt(i);
                if (s1 == s2) {
                    ile++;
                }
            }
            if (ile == nazwisko.length()) {
                System.out.println(b);
            }
        }
    }

    public void wyswietlKategoria(String kategoria) {
        for (Ksiazka b : book) {
            if (b.getKategorie().equals(kategoria)) {
                System.out.println(b);
            }
        }
    }

    public int ileKsiazek() {
        int ile = 0;
        for (Ksiazka b : book) {
            if (b != null) {
                ile++;
            }
        }
        return ile;
    }

    public void zapiszBiblioteke(String sciezka) throws FileNotFoundException, IOException {
        ObjectOutputStream plik = null;
        try {
            plik = new ObjectOutputStream(new FileOutputStream("pliki\\" + sciezka + ".txt"));
            plik.writeObject(this);
        } finally {
            if (plik != null) {
                plik.close();
            }
        }
    }

    public static Biblioteka wczytajBiblioteke(String sciezka) throws ClassNotFoundException, FileNotFoundException, IOException {
        ObjectInputStream plik = null;
        try {
            plik = new ObjectInputStream(new FileInputStream("pliki\\" + sciezka + ".txt"));
            return (Biblioteka) plik.readObject();
        } finally {
            if (plik != null) {
                plik.close();
            }
        }
    }
}
