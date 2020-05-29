package runcoderrun;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BgPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image image;
	private String image_name;
	
	/**
	 * Constructor de la clase BgPanel
	 * @param image_name Dirección de la imagen de fondo a mostrar
	 */
	public BgPanel(String image_name){
		this(new ImageIcon(image_name).getImage());
		this.image_name = image_name;
	}

	/**
	 * Segundo constructor de la clase BgPanel
	 * @param image Imagen de fondo del BgPanel
	 */
	public BgPanel(Image image){
		this.image = image;
		setLayout(null);
	}

	/**
	 * Método para obtener la dirección de la imagen de fondo del BgPanel
	 * @return String Esto regresa la dirección de la imagen del BgPanel
	 */
	public String getImageName() {
		return image_name;
	}

	/**
	 * Método para establecer la dirección de la imagen de fondo del BgPanel
	 * @param image_name Dirección de la imagen del fondo del BgPanel
	 */
	public void setImageName(String image_name) {
		this.image_name = image_name;
	}
	
	/**
	 * Método para dibujar la imagen de fondo del BgPanel
	 * @param g Objeto grafico para dibujar el fondo en BgPanel
	 */
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}

}
