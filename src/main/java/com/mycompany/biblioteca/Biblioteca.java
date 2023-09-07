package com.mycompany.biblioteca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Biblioteca {
    private static Scanner sc = new Scanner(System.in);
    private static Set<Libro> libros = new HashSet<>();
    private static Set<Libro> librosPrestados = new HashSet<>();  
    public static void main(String[] args) {
        int numcd=2;
        libros.add(new Libro("Crepusculo","Gabriel",4652,2));
       
        
        String d;

        do {
            System.out.println("    Biblioteca   \n"
                    + "A.Agregar un nuevo libro a la biblioteca. \n"
                    + "B.Mostrar la lista de libros disponibles en la biblioteca. \n"
                    + "C.Buscar un libro por título y mostrar su información. \n"
                    + "D.Prestar un libro \n"
                    + "E.Devolver un libro \n");
            String opciones = sc.next();

            switch (opciones) {
                case "a":
                    AgregarLibro();
                    break;
                case "b":
                    Mostrarlibro();
                    break;
                case "c":
                    Buscarlibro();
                    break;
                case "d":
                    prestarLibro();
                    break;
                case "e":
                    devolverLibro();
            }
            System.out.println("Desea seguir en las opciones (Digite Si para continuar o No para parar)");
            d = sc.next();

        } while (d.equals("si"));
        
        AgregarLibro();
        
        
    }

    public static void AgregarLibro() {
        System.out.println("Ingrese el nombre del libro");
        String nt = sc.next();
        System.out.println("Ingrese el autor del libro");
        String al = sc.next();
        System.out.println("Ingrese el isbn del libro");
        int isbn = sc.nextInt();

        for (Libro libro : libros) {
            if (libro.getIsbn() == isbn) {
                System.out.println("El libro ya esta en la biblioteca");
                return;
            }
        }
        int numcd=2;

        Libro libro = new Libro(nt, al, isbn,numcd );
        libros.add(libro);

        System.out.println("Su libro ha sido agragado con éxito");
    }

    public static void Mostrarlibro() {
        System.out.println("\nLista de libros disponibles");
        for (Libro libro1 : libros) {
            System.out.println(libro1.toString());
        }
    }
    
    private static void Buscarlibro(){
        System.out.println("Digite el nombre del libro que desea buscar");
        String nomEnconrado=sc.next();
        
        for(Libro libro:libros){
            if(libro.gletTitulo().equalsIgnoreCase(nomEnconrado)){
                System.out.println("Informacion del Libro encontrado");
                System.out.println(libro.toString());
                return;
            }
        }
        System.out.println("No se encontro ningún libro con el titulo ingresado ");
        
    }

    private static void prestarLibro() {
    System.out.println("Ingresa el ISBN del libro a prestar: ");
    int isbnPrestar = sc.nextInt();
    Libro libroPrestado = null; 

    for (Libro libro : libros) {
        if (libro.getIsbn() == isbnPrestar) {
            libroPrestado = libro;
            break;
        }
    }

    if (libroPrestado != null) { 
        int prestado = libroPrestado.getNumcd();
        if (prestado > 0) {
            prestado--;
            libroPrestado.setNumcd(prestado);
            librosPrestados.add(libroPrestado);
            System.out.println("El libro \"" + libroPrestado.gletTitulo() + "\" fue prestado correctamente");
            System.out.println("El número de copias en el momento son: " + prestado);
        } else {
            libros.remove(libroPrestado);
            System.out.println("Todas las copias de los libros están prestadas, no es posible prestarlo en este momento");
        }
    } else {
            System.out.println("Todas las copias de los libros están prestadas, no es posible prestarlo en este momento");

    }
}

    

   private static void devolverLibro() {
    System.out.println("Ingresa el ISBN para devolver el libro");
    int isbnDevolver = sc.nextInt();
    Libro libroDevuelto = null;
   
    for (Libro libro : librosPrestados) {

        if (libro.getIsbn()==isbnDevolver) {
            libroDevuelto = libro;
            break;
        }
    }

    if (libroDevuelto != null) {
         librosPrestados.add(libroDevuelto);
         int prestado = libroDevuelto.getNumcd();
         int numcd=2;
         if(prestado<=0){
            libros.add(libroDevuelto);
            prestado++;
            libroDevuelto.setNumcd(prestado);
            System.out.println("El libro \"" + libroDevuelto.gletTitulo() + "\" fue Devuelto correctamente");
            System.out.println("El número de copias en el momento son: " + prestado);
            System.out.println(libros.toString() + "\n" + libroDevuelto.toString());
        }
         else {
            prestado++;
            libroDevuelto.setNumcd(prestado);
            if(prestado==numcd){
                librosPrestados.remove(libroDevuelto);
            }
            System.out.println("El libro \"" + libroDevuelto.gletTitulo() + "\" fue Devuelto correctamente");
            System.out.println("El número de copias en el momento son: " + prestado);
        }
    } else {
        System.out.println("Todas las copias ya estan devueltas, no es posible devolver mas");
    }
}
}

