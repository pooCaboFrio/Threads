package naosincronizando;


import java.util.Random;

public class Produtor implements Runnable 
{
   private static Random    generator   = new Random();
   private Buffer           localidade; 

  
   public Produtor( Buffer compartilhado )
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
            Thread.sleep( generator.nextInt( 3000 ) ); 
            localidade.set( count ); 
            soma += count; 
            System.out.printf( "\t%2d\n", soma );
         } 
         
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } 
      } 

      System.out.printf( "\n%s\n%s\n", "Produtor terminou de produzir", soma, "Finalizando produtor." );
   } 

}
