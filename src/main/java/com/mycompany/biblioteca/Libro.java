
package com.mycompany.biblioteca;

public class Libro {
    String Titulo;
    String autor;
    int isbn;
    int numcd;

    public Libro() {
    }

    public Libro(String Titulo, String autor, int isbn,int numcd) {
        this.Titulo = Titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numcd=numcd;
    }

    public String gletTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getNumcd() {
        return numcd;
    }

    public void setNumcd(int numcd) {
        this.numcd = numcd;
    }

    @Override
    public String toString() {
        return "Libro{" + "Titulo=" + Titulo + ", autor=" + autor + ", isbn=" + isbn + ", numcd=" + numcd + '}';
    }    
    
    
}
