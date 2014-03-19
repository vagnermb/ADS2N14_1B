import java.util.Random;

public class PessoaControl {

	public void geraNumero() {

		Random cod = new Random();
		Random n3 = new Random();
		Random n4 = new Random();
		int x;
		int y;
		int z;
		
		x = cod.nextInt(99);
		y = n3.nextInt(999);
		z = n4.nextInt(9999);
		
		System.out.println("(" + x + ") " + y + "-" + z);

		
	}

}
