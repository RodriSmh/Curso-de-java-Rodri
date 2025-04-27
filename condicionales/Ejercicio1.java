/**
 * 28 determinar si un numero entero es multiplo de 10
 */
package condicionales;
import javax.swing.JOptionPane;
/**
 * 
 */
public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num1;
		String mensaje;
		num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero: "));
		mensaje = (num1%10==0)? "es multiplo de 10": "No es multiplo de 10";
		
		JOptionPane.showMessageDialog(null, mensaje);
		
	}

}
