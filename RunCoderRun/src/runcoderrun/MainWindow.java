package runcoderrun;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private MyButton btn_1;
	private MyButton btn_2;
	private MyButton btn_3;
	private BgPanel panel;
	private MyPanel mpanel;
	private StorePanel spanel;
	private GameOverPanel gopanel;
        private GamePausedPanel ppanel;
	private SuccessPanel supanel;
	private LevelPanel lpanel;
	private Levels levels;
	private User user;
        MusicPlayer mp;
        MusicPlayer mpl;
        MusicPlayer mps;
	
	/**
	 * Constructor default de la clase MainWindow
	 * @param ninguno
	 */
	public MainWindow(){
		super("Run Coder Run!");
		levels = new Levels();
		panel = new BgPanel("resources/main_background.png");
		btn_1 = new MyButton("Store");
		btn_2 = new MyButton("Play");
		btn_3 = new MyButton("About");
                mp = new MusicPlayer("resources/music/departure.wav");
                mpl = new MusicPlayer("resources/music/melee.wav");
                mps = new MusicPlayer("resources/music/wii.wav");
                
               
		
		user = new User();	
		user.setCoins(200);
		initializeUser();
		
		mpanel = new MyPanel(this, user);
		spanel = new StorePanel(this, user,mps);
		gopanel = new GameOverPanel(this, user);
		supanel = new SuccessPanel(this, user);
		lpanel = new LevelPanel(this, user, levels, mpl);
                ppanel = new GamePausedPanel(this, user);
             
		
		initialize();
		hidePlaySection();
		hideStoreSection();
		hideGameOverSection();
		hideSuccessSection();
		hideLevelSection();
		showMainSection();
                hidePausedSection();
		
		btn_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				hideMainSection();
				showStoreSection();
                                mps.play();
			}
		});
		
		btn_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				hideMainSection();
				//showPlaySection();
				showLevelSection();
                                mpl.play();
			}
		});	
		
		btn_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Developed by Alejandro Alvarez Palafox\nPlay with mouse clik");
			}
		});
	}
	
	/**
	 * Metodo que inicializa los botones, los limites y el fondo de la ventana
	 * @param  ninguno
	 */
	private void initialize(){
		this.getContentPane().setLayout(new BorderLayout());
		this.setSize(720, 480);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setIcon();
		this.initializeLevels();
				
		btn_1.setBounds(16, 356, 216, 32);
		btn_2.setBounds(248, 356, 216, 32);
		btn_3.setBounds(480, 356, 216, 32);
		spanel.setBounds(0, 0, (this.getWidth() - 16), (this.getHeight() - 56));
		mpanel.setBounds(0, 0, (this.getWidth() - 16), (this.getHeight() - 56));
		gopanel.setBounds(0, 0, (this.getWidth() - 16), (this.getHeight() - 56));
		supanel.setBounds(0, 0, (this.getWidth() - 16), (this.getHeight() - 56));
		lpanel.setBounds(0, 0, (this.getWidth() - 16), (this.getHeight() - 56));
                ppanel.setBounds(0, 0, (this.getWidth() - 16), (this.getHeight() - 56));
		
		this.getContentPane().add(panel);
		panel.add(btn_1);
		panel.add(btn_2);
		panel.add(btn_3);
		panel.add(spanel);
		panel.add(mpanel);
		panel.add(gopanel);
		panel.add(supanel);
		panel.add(lpanel);
                panel.add(ppanel);
                
	}
	
	/**
	 * Metodo que inicializa a los personajes
	 * @param  ninguno
	 */
	private void initializeUser(){
		//life, price, x1, y1, width, height, jump, speed, available,choosen, brick_breaker, fire_res, poison_res, spike_res, img_name
		Character character_1 = new Character("Max", 3, 0, 128, 260, 32, 40, 4, 1, true, true, false, false, false, false, "resources/J1G.gif");
		Character character_2 = new Character("John", 3, 10, 128, 260, 32, 40, 3, 7, false, false, false, false, false, false, "resources/J2G.gif");
		Character character_3 = new Character("Liz", 3, 15, 128, 260, 32, 40, 7, 2, false, false, false, false, false, false, "resources/J3G.gif");
		Character character_4 = new Character("Sam", 3, 20, 128, 260, 32, 40, 4, 4, false, false, false, true, false, false, "resources/J4G.gif");
		Character character_5 = new Character("Zombie-man", 3, 25, 128, 260, 32, 40, 5, 5, false, false, false, false, true, false, "resources/J5G.gif");
		Character character_6 = new Character("Cyclopina", 4, 30, 128, 260, 32, 40, 5, 5, false, false, true, false, false, false, "resources/J6G.gif");
		Character character_7 = new Character("Marsha", 4, 40, 128, 260, 32, 40, 5, 6, false, false, false, false, false, true, "resources/J7G.gif");
		Character character_8 = new Character("Juan-Ponch-Man", 20, 150, 128, 260, 32, 40, 6, 6, false, false, true, true, true, true, "resources/J8G.gif");
		
		
		user.getCharacters().addCharacter(character_1);
		user.getCharacters().addCharacter(character_2);
		user.getCharacters().addCharacter(character_3);
		user.getCharacters().addCharacter(character_4);
		user.getCharacters().addCharacter(character_5);
		user.getCharacters().addCharacter(character_6);
		user.getCharacters().addCharacter(character_7);
		user.getCharacters().addCharacter(character_8);
	}
	
	public void initializeLevels(){
		Level level_1 = new Level("resources/level1.png", 1);
		Level level_2 = new Level("resources/level2.png", 2);
		Level level_3 = new Level("resources/level3.png", 3);
		Level level_4 = new Level("resources/level4.png", 4);
		Level level_5 = new Level("resources/level4.png", 2);
		
		levels.addLevel(level_1);levels.addLevel(level_2);levels.addLevel(level_3);levels.addLevel(level_4);levels.addLevel(level_5);
	}
	
	/**
	 * Metodo que desaparece la pantalla de Game over
	 * @param  ninguno
	 */
	public void hideGameOverSection(){
		gopanel.setFocusable(false);
		gopanel.setVisible(false);
	}
        
        public void hidePausedSection(){
		ppanel.setFocusable(false);
		ppanel.setVisible(false);
	}
	
	public void hideLevelSection(){
		lpanel.setFocusable(false);
		lpanel.setVisible(false);
	}
	
	/**
	 * Metodo que desaparece la pantalla del menú principal
	 * @param  ninguno
	 */
	public void hideMainSection(){
		btn_1.setVisible(false);
		btn_2.setVisible(false);
		btn_3.setVisible(false);
                mp.stop();
	}
	
	/**
	 * Metodo que desaparece la pantalla donde juega el usuario
	 * @param  ninguno
	 */
	public void hidePlaySection(){
		mpanel.stop();
		mpanel.setVisible(false);
		mpanel.setFocusable(false);
	}
	
	public void hideStoreSection(){
		spanel.setVisible(false);
		spanel.setFocusable(false);
	}
	
	public void hideSuccessSection(){
		supanel.setVisible(false);
		supanel.setFocusable(false);
	}
	
	//Show sections
	/**
	 * Metodo que despliega la pantalla de Game over
	 * @param  ninguno
	 */
	public void showGameOverSection(){
                btn_1.setVisible(false);
		gopanel.initialize();
		gopanel.setFocusable(true);
		gopanel.setVisible(true);
	}
        
        public void showPausedSection(Level level){
                btn_1.setVisible(false);
		ppanel.initialize();
		ppanel.setFocusable(true);
		ppanel.setVisible(true);
                mp.stop();
	}
	
	public void showLevelSection(){
                
		lpanel.initialize(user, levels);
		lpanel.setFocusable(true);
		lpanel.setVisible(true);
	}
	/**
	 * Metodo que despliega la pantalla del menú principal
	 * @param  ninguno
	 */
	public void showMainSection(){
                
		btn_1.setVisible(true);
		btn_2.setVisible(true);
		btn_3.setVisible(true);
                mp.play();
	}
	/**
	 * Metodo que despliega la pantalla donde juega el usuario
	 * @param  ninguno
	 */
	public void showPlaySection(Level level){
		mpanel.setLevel(level);
		mpanel.initialize(user);
		mpanel.setFrameSize((this.getWidth() - 16), (this.getHeight() - 56));
		mpanel.setFocusable(true);
		mpanel.setVisible(true);
                
	}
        
        public void resumePlaySection(){
		mpanel.getLevel();
		mpanel.setFrameSize((this.getWidth() - 16), (this.getHeight() - 56));
		mpanel.setFocusable(true);
		mpanel.setVisible(true);
                mp.stop();
	}
	
	/**
	 * Metodo que despliega la pantalla de la tienda
	 * @param  ninguno
	 */
	public void showStoreSection(){
		spanel.initialize(user);
		spanel.setFocusable(true);
		spanel.setVisible(true);
                mp.stop();
                mps.play();
	}
	
	public void showSuccessSection(){
		supanel.initialize();
		supanel.setFocusable(true);
		supanel.setVisible(true);
	}
	/**
	 * Metodo que asigna el Sprite de un jugador como el icono del juego
	 * @param  ninguno
	 */
	private void setIcon(){
		Image image = new ImageIcon("resources/Personaje_1.png").getImage();
		this.setIconImage(image);
	}
       

    public static int getWIDTH() {
        return WIDTH;
    }
    
   
    public static int getHEIGHT() {
        return HEIGHT;
    }


}

