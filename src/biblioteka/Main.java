package biblioteka;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Biblioteka B = Biblioteka.wczytajBiblioteke("biblioteka");
        
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice != 11) {
            int rok;
            int id = B.ileKsiazek() + 1;
            String tytul, nazwiskoAutora, imionaAutora, kategorie;

            System.out.println("#############################################################");
            System.out.println("#   [1]     Dodaj nową ksiązkę do biblioteki                #");
            System.out.println("#   [2]     Wyświetl wszystkie książki w bibliotece         #");
            System.out.println("#   [3]     Edytuj wybraną książkę                          #");
            System.out.println("#   [4]     Wyświetl ile jest książek w bibliotece          #");
            System.out.println("#   [5]     Wypożycz książkę z biblioteki                   #");
            System.out.println("#   [6]     Zwróć książke do biblioteki                     #");
            System.out.println("#   [7]     Wyświetl po tytule, nazwisku lub kategorii      #");
            System.out.println("#   [8]     Funkcje dodatkowe                               #");
            System.out.println("#   [9]     Wyświetl książki posortowane wg. kryterium      #");
            System.out.println("#   [10]    Zarządzanie biblioteką                          #");
            System.out.println("#   [11]    Wyjście z programu                              #");
            System.out.println("#############################################################");
            System.out.print("Wybieram = ");
            choice = in.nextInt();

            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("Tytuł książki: ");
                    in.nextLine();
                    tytul = in.nextLine();
                    while (tytul.isEmpty() || tytul.equals("")) {
                        System.out.print("Tytuł książki: ");
                        tytul = in.nextLine();
                    }
                    System.out.print("\nNazwisko autora: ");
                    nazwiskoAutora = in.nextLine();
                    while (nazwiskoAutora.isEmpty() || nazwiskoAutora.equals("")) {
                        System.out.print("\nNazwisko autora: ");
                        nazwiskoAutora = in.nextLine();
                    }
                    System.out.print("\nImiona autora: ");
                    imionaAutora = in.nextLine();
                    while (imionaAutora.isEmpty() || imionaAutora.equals("")) {
                        System.out.print("\nImiona autora: ");
                        imionaAutora = in.nextLine();
                    }
                    System.out.print("\nKategorie książki: ");
                    kategorie = in.nextLine();
                    while (kategorie.isEmpty() || kategorie.equals("")) {
                        System.out.print("\nKategorie książki: ");
                        kategorie = in.nextLine();
                    }
                    System.out.print("\nRok wydania książki: ");
                    rok = in.nextInt();
                    
                    if (rok >= 1700 && rok <= 2012) {
                        Ksiazka k = new Ksiazka(id, tytul, nazwiskoAutora, imionaAutora, rok, kategorie);
                        B.dodajKsiazke(k);
                    } else {
                        System.out.println("Rok wydania musi być w przedziale od 1700 do 2012 !");
                    }
                    break;
                case 2:
                    System.out.println("PEŁNE WYŚWIETLANIE");
                    B.wyswietl();
                    System.out.println("");
                    System.out.println("UPROSZCZONE WYŚWIETLANIE");
                    B.wyswietl1();
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Podaj id książki do edycji: ");
                    int id1 = in.nextInt();
                    id1--;
                    System.out.println("Książka do edytowania: ");
                    B.wyswietlId(id1);

                    int choice1 = 0;
                    while (choice1 != 6) {
                        System.out.println("#############################");
                        System.out.println("#   [1] Edytuj imiona       #");
                        System.out.println("#   [2] Edytuj nazwisko     #");
                        System.out.println("#   [3] Edytuj tytul        #");
                        System.out.println("#   [4] Edytuj rok wydania  #");
                        System.out.println("#   [5] Edytuj kategorie    #");
                        System.out.println("#   [6] Koniec edycji       #");
                        System.out.println("#############################");
                        System.out.print("Wybieram = ");
                        choice1 = in.nextInt();
                        System.out.println();
                        switch (choice1) {
                            case 1:
                                System.out.print("Imiona autora: ");
                                in.nextLine();
                                imionaAutora = in.nextLine();
                                B.giveImiona(id1, imionaAutora);
                                break;
                            case 2:
                                System.out.print("\nNazwisko autora: ");
                                in.nextLine();
                                nazwiskoAutora = in.nextLine();
                                B.giveNazwisko(id1, nazwiskoAutora);
                                break;
                            case 3:
                                System.out.print("Tytuł książki: ");
                                in.nextLine();
                                tytul = in.nextLine();
                                B.giveTytul(id1, tytul);
                                break;
                            case 4:
                                System.out.print("\nRok wydania książki: ");
                                in.nextLine();
                                rok = in.nextInt();
                                B.giveRok(id1, rok);
                                break;
                            case 5:
                                System.out.print("\nKategorie książki: ");
                                in.nextLine();
                                kategorie = in.nextLine();
                                B.giveKategorie(id1, kategorie);
                                break;
                        }
                    }
                    System.out.println("Książka po edycji: ");
                    B.wyswietlId(id1);
                    break;
                case 4:
                    System.out.print("W bibliotece jest: " + B.ileKsiazek() + " książek\n");
                    break;
                case 5:
                    System.out.print("Podaj id książki do wypożyczenia: ");
                    int id2 = in.nextInt();
                    id2--;
                    if (B.GetCzyWypozyczona(id2) == false) {
                        B.giveCzyWypozyczona(id2, true);
                        System.out.println("Książka została wypożyczona.");
                    } else {
                        System.out.println("Nie możesz wypożyczyć książki ponieważ jest już wypożyczona");
                    }
                    break;
                case 6:
                    System.out.print("Podaj id książki do zwrócenia: ");
                    int id3 = in.nextInt();
                    id3--;
                    if (B.GetCzyWypozyczona(id3) == false) {
                        System.out.println("Nie można zwrócić książki ponieważ jest niewypożyczona");
                    } else {
                        B.giveCzyWypozyczona(id3, false);
                        B.give1toLiczbaWypozyczen(id3);
                        System.out.println("Książka została zwrócona.");
                    }
                    break;
                case 7:
                    int choice2 = 0;
                    while (choice2 != 4) {
                        System.out.println("#############################");
                        System.out.println("#   [1] Szukaj po tytule    #");
                        System.out.println("#   [2] Szukaj po nazwisku  #");
                        System.out.println("#   [3] Szukaj po kategorii #");
                        System.out.println("#   [4] Wyjście             #");
                        System.out.println("#############################");
                        System.out.print("Wybieram = ");
                        choice1 = in.nextInt();

                        switch (choice1) {
                            case 1:
                                System.out.println("Podaj tytul: ");
                                String tytul1 = in.next();
                                B.wyswietlTytul(tytul1);
                                break;
                            case 2:
                                System.out.println("Podaj nazwisko: ");
                                String nazwisko1 = in.next();
                                B.wyswietlNazwisko(nazwisko1);
                                break;
                            case 3:
                                System.out.println("Podaj kategorie: ");
                                String kategoria1 = in.next();
                                B.wyswietlKategoria(kategoria1);
                                break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("################################################################################");
                    System.out.println("#   [a] Wyświetlnie książek wypożyczonych i liczby wszystkich wypożyczeń       #");
                    System.out.println("#   [b] Wyświetlanie 5 najczęściej wypożyczanych egzemplarzy                   #");
                    System.out.println("#   [c]                                                                        #");
                    System.out.println("#   [d]                                                                        #");
                    System.out.println("################################################################################");
                    System.out.print("Wybieram = ");
                    char choice3 = in.next().charAt(0);
                    System.out.println();
                    switch (choice3) {
                        case 'a':
                            B.wyswietlWypozyczone();
                            break;
                        case 'b':
                            
                            break;
                        case 'c':
                            break;
                        case 'd':
                            break;
                    }
                    break;
                case 9:
                    break;
                case 10:
                    int choice4 = 0;
                    while (choice4 != 3) {
                        String sciezka;
                        System.out.println("#####################################");
                        System.out.println("#   [1] Zapisz biblioteke do pliku  #");
                        System.out.println("#   [2] Wczytaj biblioteke z pliku  #");
                        System.out.println("#   [3] Powrót do głownego menu     #");
                        System.out.println("#####################################");
                        System.out.print("Wybieram = ");
                        choice4 = in.nextInt();
                        System.out.println();
                        switch (choice4) {
                            case 1:
                                System.out.println("Podaj nazwe pliku: ");
                                sciezka = in.next();
                                B.zapiszBiblioteke(sciezka);
                                break;
                            case 2:
                                System.out.println("Podaj nazwe pliku: ");
                                sciezka = in.next();
                                
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
