package naosincronizando;

import java.util.Random;

public class Consumidor implements Runnable 
{ 
   private static Random    gerador     = new Random();
   private Buffer           localidade; 

   
   public Consumidor( Buffer compartilhado )
   {
      localidade = compartilhado;
   } 

    public void run()
   {
      int soma = 0;

      for ( int count = 1; count <= 10; count++ ) 
      {
         try 
         {
            Thread.sleep( gerador.nextInt( 3000 ) );    
            soma += localidade.get();
            System.out.printf( "\t\t\t%2d\n", soma );
         } 
          catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } 
      } 

      System.out.printf( "\n%s %d.\n%s\n", 
         "Consumidor leu o total de valores : ", soma, "Finalizando consumidor." );
   } 
} 

