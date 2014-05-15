package ControladoresTeclas;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


	public class ControlTeclas extends PlainDocument{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void insertString(int n,String cadena , javax.swing.text.AttributeSet a)throws BadLocationException{
			super.insertString(n, cadena.replaceAll("[^0-9|.]", ""), a);
		}
	}



