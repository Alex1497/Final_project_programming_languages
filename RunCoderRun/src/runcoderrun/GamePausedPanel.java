package runcoderrun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePausedPanel extends JPanel{
    private static final long serialVersionUID = 1L;
	Image image;
        Font fuente;
	MyButton btn_0;
        MyButton btn_1;
        
	
	/**
	 * Constructor default de la clase GameOverPanel
	 * @param mw Instancia de la clase MainWindow, user Usuario
	 */
	public GamePausedPanel(MainWindow mw, User user){
		super();
		btn_0 = new MyButton("Menú principal");
                btn_1 = new MyButton("Reanudar");
		image = new ImageIcon("resources/gameOver.png").getImage();
		
		btn_0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mw.hidePausedSection();
				mw.showMainSection();
			}
		});
                btn_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mw.hidePausedSection();
				mw.resumePlaySection();
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
                btn_1.setBounds(280, 370, 220, 32);
		
		this.add(btn_0);
                this.add(btn_1);
	}
	
	/**
	* Metodo para el fondo de game over
	 * @param g Objeto grafico para dibujar el fondo en BgPanel
	 */
	public void paintComponent(Graphics g){
		fuente = new Font("TimesRoman", Font.BOLD, 100);
		g.setFont(fuente);
		g.setColor(Color.black);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                g.setColor(Color.white);
                g.drawString("Paused", 200, 100);

	}	
    
}
