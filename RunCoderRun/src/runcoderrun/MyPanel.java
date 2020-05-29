package runcoderrun;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Level level;
	private Timer timer;
	private int time;
        private MyButton btn_p;
        private MyButton btn_r;
        private MyButton btn_mm;
        private MyButton pause_txt;
        private boolean pause;
        private Font fuente;
        MusicPlayer mp;
        private int mwh;
        private int mww;
        
        
       
	/**
	 * Constructor default de la clase MyPanel
	 * @param mw Instancia de la clase MainWindow, user Usuario
	 */
	public MyPanel(MainWindow mw, User user){
		super();
		time = 0;
                pause = false;
                btn_p = new MyButton("Pause");
                btn_r = new MyButton("Resume");
                btn_mm = new MyButton("Main Menu");
                pause_txt = new MyButton("Paused");
                pause_txt.setOpaque(false);
                pause_txt.setContentAreaFilled(false);
                pause_txt.setBorderPainted(false);
                pause_txt.setFont(new Font("Serif", Font.BOLD, 100));
                level = new Level("resources/level1.png", 1);
                mwh = mw.getHeight();
                mww = mw.getWidth();
                
                
               
                
                btn_p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                                pause = true;
                                pause_txt.setVisible(true);
                                btn_p.setVisible(false);
                                btn_r.setVisible(true);
                                btn_mm.setVisible(true);
                                mp.pause();
                                
			}
		});
                
                btn_r.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//mw.hidePlaySection();
				//mw.showPausedSection(level);
                                pause = false;
                                btn_p.setVisible(true);
                                btn_r.setVisible(false);
                                btn_mm.setVisible(false);
                                pause_txt.setVisible(false);
                                mp.resume();
			}
		});
                
                btn_mm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                            pause = false;
                            btn_p.setVisible(true);
                            btn_r.setVisible(false);
                            btn_mm.setVisible(false);
                            mw.hidePlaySection();
                            mw.showMainSection();
                            mp.stop();
                             
                                
			}
		});
		
		timer = new Timer(25, new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(level.getStatus() == 2){
					mw.hidePlaySection();
					mw.showSuccessSection();
                                        mp.stop();
				}
				else if(level.getStatus() == 3){
					mw.hidePlaySection();
					mw.showGameOverSection();
                                        mp.stop();
				}
				else{   
                                        if(!pause){
                                            level.play(time, user);
                                            level.generate(time);
                                            repaint();
                                            time++;
                                        }
                                        
                                        
				}
			}
		});
		
	
		
		setAction();		
	}
	
	/**
	 * Metodo que asigna el mouse para que salte el jugador
	 * @param  ninguno
	 */
	private void setAction(){
		this.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(level.canJump()){
					level.getCharacter().setStatus(1);
					
					Timer timer_1 = new Timer(3600000, new ActionListener(){
						public void actionPerformed(ActionEvent te) {
							level.getCharacter().setStatus(0);
							((Timer)te.getSource()).stop();
						}
					});
					
					timer_1.setInitialDelay(1400);
					timer_1.start();
				}
			}
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	* Metodo para que sirve para delimitar el tamanio de la pantalla
	* @param width Ancho, height Alto
	*/
	public void setFrameSize(int width, int height){
		level.setFrameSize(width, height);
	}
	
	/**
	* Metodo para que sirve para detener los niveles
	* @param ninguno
	*/
	public void stop(){
		timer.stop();
		level.stop();
	}
	
	/**
	* Metodo para que sirve para inicializar los niveles
	* @param user Usuario
	*/
	public void initialize(User user){
                
                if(level.getLevelImg() == "resources/level1.png"){
                    mp = new MusicPlayer("resources/music/colony9.wav");
                }
                
                if(level.getLevelImg() == "resources/level2.png"){
                    mp = new MusicPlayer("resources/music/stoneTemple.wav");
                }
                
                if(level.getLevelImg() == "resources/level3.png"){
                    mp = new MusicPlayer("resources/music/gaur.wav");
                }
                
                if(level.getLevelImg() == "resources/level4.png"){
                    mp = new MusicPlayer("resources/music/requiem.wav");
                }
                
                mp.play();
                System.out.println(level.getLevelImg());
                
                setLayout(null);
                btn_p.setBounds(480, 16,216,32);
                this.add(btn_p);
                btn_r.setBounds(380, 260,220,32);
                this.add(btn_r);
                btn_r.setVisible(false);
                btn_mm.setBounds(130, 260, 220, 32);
                //240, 370, 220, 32
                this.add(btn_mm);
                btn_mm.setVisible(false);
                pause_txt.setBounds(100, 100, 500, 100);
                this.add(pause_txt);
                pause_txt.setVisible(false);
		timer.start();
		time = 0;
		this.level.setCharacter(user.getCurrentCharacter());
		this.level.iniatilize(user);
	}
        
        
        
       
	
        
	public void paintComponent(Graphics g){
		level.paint(g);
                
	}
}
