package naosincronizando;



public class BufferNaoSincronizado implements Buffer 
{
   private int buffer = -1; 
   
   public void set( int value )
   {
      System.out.printf( "Produtor escreve\t%2d", value );
      buffer = value;
   } 

   
   public int get()
   {
      System.out.printf( "Consumidor le\t%2d", buffer );
      return buffer; 
   } 
} 


