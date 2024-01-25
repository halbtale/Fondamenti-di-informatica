/**
  * interfaccia Dizionario
  * interfaccia per esercitazione: Laboratorio 9
  */
public interface Dizionario // -- interfaccia Dizionario
{
   /**
      rende vuoto il contenitore
   */
   void makeEmpty();

   /**
      verifica se il contenitore e' vuoto
      @return true se il contenitore e' vuoto, false altrimenti
   */
   boolean isEmpty();
   
   /**
      @return il numero di elementi nel contenitore
   */
   int size();
   
   /**
      inserisce nel contenitore la coppia t/v
      @param t la chiave specificata
      @param v il valore specificato
   */
   void insert(int t, double v);
   
   /**
      restituisce il valore associato alla chiave specificata
      @param t la chiave specificata
      @return il valore associato alla chiave specificata
      @throws java.util.NoSuchElementException se la chiave non e' nel contenitore
   */
   double find(int t) throws java.util.NoSuchElementException;

   /**
      rimuove la coppia t/v dal contenitore. Se la chuiave non e' presente nel
      contenitore, termina silenziosamente
      @param t la chiave specificata
   */
   void remove(int t);
}