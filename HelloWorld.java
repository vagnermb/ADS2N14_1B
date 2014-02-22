import java.util.Scanner;

public class Ler{
    public static void main (String [] args){
   
   Scanner entrada = new Scanner(System.in); 
   String nome ="";
   System.out.println("Digite o seu nome.");
   nome = entrada.next();
   System.out.println("Hello"+nome);

   }
}

