/** Ejercicio 27

***/
package condicionales;
import javax.swing.JOptionPane;
public class Ternario {
	public static void main(String[] args) {
		int numero;
		String mensaje;
		numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero: "));
		
		mensaje = (numero%2==0)? "es par": "Es impar";
		
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
