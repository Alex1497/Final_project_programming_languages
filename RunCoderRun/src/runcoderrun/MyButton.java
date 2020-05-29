package runcoderrun;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
/**
 * Clase MyButton servira para crear los distintos botones que habra dentro del juego
 * @author Alejandro Alvarez
 * @author Antonio Perez
 * @version 1.0
 *
 */
public class MyButton extends JButton{
	private static final long serialVersionUID = 1L;
	private Color color;
	private Color border_color;
	private Color text_color;
	private LineBorder border;
	private String text;
	/**
	 * Constructor de la clase Button
	 * @param ninguno
	 */
	
	public MyButton(){
		super();
		
		color = new Color(139,166,73);
		border_color = new Color(97,116,51);
		text_color = new Color(255,255,255);
		border = new LineBorder(border_color);
		text = "Boton";
		
		initializeButton();
	}
	/**
	 * Segundo constructor de la clase Button
	 * @param text Texto que contiene el texto que va dentro del boton
	 */
	public MyButton(String text){
		super();
		
		color = new Color(139,166,73);
		border_color = new Color(97,116,51);
		text_color = new Color(255,255,255);
		border = new LineBorder(border_color);
		this.text = text; 
		
		initializeButton();
	}
        
	/**
	 * Metodo para obtener el color del boton
	 * @return color Esto regresa el color del boton
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Metodo para establecer el color del boton
	 * @param color Color del boton
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Metodo para obtener el color del borde del boton
	 * @return border_color Esto regresa el color del borde del boton
	 */
	public Color getBorderColor() {
		return border_color;
	}
	/**
	 * Metodo para establecer el color del borde del boton
	 * @param border_color Color del borde del boton
	 */
	public void setBorderColor(Color border_color) {
		this.border_color = border_color;
	}
	/**
	 * Metodo para obtener el color del texto del boton
	 * @return text_color Esto regresa el color del texto del boton
	 */
	public Color getTextColor() {
		return text_color;
	}
	/**
	 * Metodo para establecer el color del texto del boton
	 * @param text_color Color del texto del boton
	 */
	public void setTextColor(Color text_color) {
		this.text_color = text_color;
	}
	/**
	 * Metodo para obtener el borde del boton
	 * @return border Esto regresa el  borde del boton
	 */
	public LineBorder getBorder() {
		return border;
	}
	/**
	 * Metodo para establecer el  borde del boton
	 * @param border Borde del boton
	 */
	public void setBorder(LineBorder border) {
		this.border = border;
	}
	/**
	 * Metodo para obtener el  texto del boton
	 * @return text Esto regresa  texto del boton
	 */
	public String getText() {
		return text;
	}
	/**
	 * Metodo para establecer el texto del boton
	 * @param text Texto del boton
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * Metodo para inicializar el boton, aplicando caracterisiticas predeterminadas
	 * @return ninguno
	 */
	private void initializeButton(){
		this.setBorder(border);
		this.setBackground(color);
		this.setBorderPainted(true);
		this.setFocusPainted(false);
		this.setFont(new Font("Serif", Font.BOLD, 18));
		this.setForeground(text_color);
		this.setOpaque(true);
		this.setText(text);
	}

}
