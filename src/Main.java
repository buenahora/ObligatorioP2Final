import Classes.Cancion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import Classes.ArtistaCantidad;
import Classes.Sistema;
import uy.edu.um.prog2.adt.closedhash.ClosedHashImpl;
import uy.edu.um.prog2.adt.closedhash.DuplicateKey;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.adt.maxheap.MiMaxHeap;

import static Classes.Sistema.leerCanciones;

public class Main {

    public static void main(String[] args) throws DuplicateKey, ParseException {
        Sistema.leerCanciones();
        int option;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione una opción:");
            System.out.println("1. Top 10 canciones en un país en un día dado");
            System.out.println("2. Top 5 canciones que aparecen en más top 50 en un día dado");
            System.out.println("3. Top 7 artistas que más aparecen en los top 50 para un rango de fechas dado");
            System.out.println("4. Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
            System.out.println("5. Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas");
            System.out.println("0. Salir");

            option = sc.nextInt();

            sc.nextLine();
            System.out.println();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el pais: ");
                    String pais = sc.nextLine();
                    pais = pais.trim();

                    System.out.println("Ingrese una fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();
                    fecha = fecha.trim();

                    MyList<Cancion> cancionesPaisFecha = Sistema.top10CancionesPaisFecha(pais, fecha);

                    if(cancionesPaisFecha.isEmpty()) {
                        break;
                    }

                    System.out.println("El top 10 de canciones en el pais dado en la fecha dada es: ");
                    for (int i = 0; i < cancionesPaisFecha.size(); i++) {
                        System.out.println((i + 1) + ". " + cancionesPaisFecha.get(i).getName() + " (" + cancionesPaisFecha.get(i).getArtists() + ")");
                    }

                    System.out.println();
                    break;

                case 2:
                    System.out.println("Ingrese una fecha (YYYY-MM-DD): ");
                    String fecha2 = sc.nextLine();
                    MyList<Cancion> cancionesTop5 = Sistema.top5CancionesMasTop50Fecha(fecha2);
                    System.out.println();

                    if(cancionesTop5.isEmpty()) {
                        break;
                    }

                    System.out.println("El top 5 de canciones que aparecen en mas top 50 es: ");
                    for (int i = 0; i < cancionesTop5.size(); i++) {
                        Cancion cancionActual = cancionesTop5.get(i);

                        System.out.println((i + 1) + ". " + cancionActual.getName() + " aparece " + cancionActual.getContador() +" veces");
                    }

                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese una fecha inicial (YYYY-MM-DD): ");
                    String fechaInicial = sc.nextLine();

                    System.out.println("Ingrese una fecha final (YYYY-MM-DD): ");
                    String fechaFinal = sc.nextLine();

                    MyLinkedListImpl<ArtistaCantidad> cancionesTop7Artistas = Sistema.top7ArtistasMasTop50Fecha(fechaInicial, fechaFinal);

                    if(cancionesTop7Artistas.isEmpty()) {
                        break;
                    }

                    System.out.println("El top 7 artistas que mas aparece en el top 50 en el rango de fechas dado es: ");
                    for (int i = 0; i < cancionesTop7Artistas.size(); i++) {
                        System.out.println((i+1) +" - "+cancionesTop7Artistas.get(i).artista+" aparece "+cancionesTop7Artistas.get(i).cantidad+" veces");
                    }
                    System.out.println();

                    break;
                case 4:
                    try {
                        System.out.println("Ingrese el artista: ");
                        String artista = sc.nextLine();
                        artista = artista.trim();

                        System.out.println("Ingrese una fecha (YYYY-MM-DD): ");
                        String fecha4 = sc.nextLine();
                        fecha4 = fecha4.trim();


                        System.out.println();
                        int cantidadVecesArtista = Sistema.cantidadVecesArtistaTop50Fecha(artista, fecha4);

                        if(cantidadVecesArtista == -1) {
                            System.out.println("No se encontraron canciones para la fecha ingresada.");
                            break;
                        }

                        if(cantidadVecesArtista == 0) {
                            System.out.println("El artista ingresado no aparece en el top 50 en la fecha dada.");
                            break;
                        }

                        System.out.println(artista +" aparecio " + cantidadVecesArtista +" veces" + " en tops 50 en la fecha dada");
                        System.out.println();

                    }catch (NullPointerException e){
                        System.out.println("Ingrese una opcion valida");
                    }
                    break;

                case 5:

                    System.out.println("Ingrese una fecha inicial (YYYY-MM-DD): ");
                    String fechaInicial2 = sc.nextLine();

                    System.out.println();
                    System.out.println("Ingrese una fecha final (YYYY-MM-DD): ");
                    String fechaFinal2 = sc.nextLine();

                    int tempoMin;
                    int tempoMax;

                    try {
                        do {
                            System.out.println();
                            System.out.println("Ingrese el tempo minimo (debe ser un numero mayor a 0): ");
                            tempoMin = sc.nextInt();
                        } while (tempoMin < 0);

                        sc.nextLine();

                        do {
                            System.out.println();
                            System.out.println("Ingrese el tempo maximo (debe ser un numero mayor a 0): ");
                            tempoMax = sc.nextInt();
                        } while (tempoMax < 0);
                    } catch(Exception e) {
                        System.out.println("Ingrese un numero valido.");
                        break;
                    }


                    System.out.println();
                    int cantidadVecesTempo = Sistema.cantidadCancionesTempoRangoFecha(tempoMin, tempoMax, fechaInicial2, fechaFinal2);

                    if(cantidadVecesTempo == -1) {
                        break;
                    }

                    System.out.println("Hay "+cantidadVecesTempo+" canciones entre las fechas dadas con un tempo en el rango dado.");
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    System.out.println();
                    break;
            }
        } while (option != 0);
    }

}