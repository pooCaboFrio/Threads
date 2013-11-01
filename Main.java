/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package naosincronizando;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author rosenhaim
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ExecutorService executor = Executors.newFixedThreadPool( 2 );

      
      Buffer localidade = new BufferNaoSincronizado();

      System.out.println( "Ação\t\tValor\tProdduzido\tConsumido" );
      System.out.println( "------\t\t-----\t--------\t--------\n" );

      
      try 
      {
         executor.execute( new Produtor( localidade ) );
         executor.execute( new Consumidor( localidade ) );
      } 
      catch ( Exception exception )
      {
         exception.printStackTrace();
      } 

      executor.shutdown(); 
   } 
    
}
