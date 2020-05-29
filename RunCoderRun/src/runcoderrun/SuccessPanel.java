package runcoderrun;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SuccessPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Image image;
	MyButton btn_0;
	MusicPlayer mp;
	/**
	 * Constructor default de la clase SuccessPanel
	 * @param mw Instancia de la clase MainWindow, user Usuario
	 */
	public SuccessPanel(MainWindow mw, User user){
		super();
		btn_0 = new MyButton("Menú principal");
		image = new ImageIcon("resources/youWin.png").getImage();
                mp = new MusicPlayer("resources/music/success.wav");
		
		btn_0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mw.hideSuccessSection();
				mw.showMainSection();
                                mp.stop();
			}
		});
	}
	
	/**
	 * Metodo que inicializa los botones, y el fondo de la ventana
	 * @param  ninguno
	 */
	public void initialize(){
		setLayout(null);
		btn_0.setBounds(240, 370, 220, 32);
		mp.play();
		this.add(btn_0);
	}
	
	/**
	 * Metodo para dibujar la ventana de ¡ganaste!
	 * @param g Objeto grafico para dibujar la pantalla de ¡ganaste!
	 */
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

	}	
}

