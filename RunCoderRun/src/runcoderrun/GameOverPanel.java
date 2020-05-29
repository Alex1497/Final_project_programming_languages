package runcoderrun;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Image image;
	MyButton btn_0;
        String str = "Paused";
        MusicPlayer mp;
	
	/**
	 * Constructor default de la clase GameOverPanel
	 * @param mw Instancia de la clase MainWindow, user Usuario
	 */
	public GameOverPanel(MainWindow mw, User user){
		super();
		btn_0 = new MyButton("Main menu");
		image = new ImageIcon("resources/gameOver.png").getImage();
                mp = new MusicPlayer("resources/music/thanatos.wav");
		
		btn_0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mw.hideGameOverSection();
				mw.showMainSection();
                                mp.stop();
			}
		});
	}
	
	/**
	* Metodo que activa la pantaña de Game Over
	 * @param ninguno
	 */
	public void initialize(){
		setLayout(null); 
		btn_0.setBounds(240, 370, 220, 32);
		this.add(btn_0);
                mp.play();
	}
	
	/**
	* Metodo para el fondo de game over
	 * @param g Objeto grafico para dibujar el fondo en BgPanel
	 */
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

	}	
}
