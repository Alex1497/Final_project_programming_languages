package runcoderrun;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LevelPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Image image;
	private MyButton btn_0;
	private ArrayList<MyButton> buttons;
        MusicPlayer mp;
        MyButton lvl_txt;
        
	public LevelPanel(MainWindow mw, User user, Levels levels, MusicPlayer mp){
		super();
		image = new ImageIcon("resources/main_background.png").getImage();
		buttons = new ArrayList<MyButton>(4);
		btn_0 = new MyButton("Return");
		MyButton btn_1 = new MyButton("Nivel 1");
		MyButton btn_2 = new MyButton("Nivel 2");
		MyButton btn_3 = new MyButton("Nivel 3");
		MyButton btn_4 = new MyButton("Nivel 4");
                this.mp = mp;
                lvl_txt = new MyButton("Choose a stage");
                lvl_txt.setOpaque(false);
                lvl_txt.setContentAreaFilled(false);
                lvl_txt.setBorderPainted(false);
                lvl_txt.setFont(new Font("Serif", Font.BOLD, 50));
                
                
               
		buttons.add(btn_1);buttons.add(btn_2);buttons.add(btn_3);buttons.add(btn_4);	
               
		
		
		btn_0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mw.hideLevelSection();
				mw.showMainSection();
                                mp.stop();
			}
		});
		
		
		ListIterator<MyButton>itr = buttons.listIterator();
		while(itr.hasNext()){
			MyButton button = itr.next();
			int index = itr.previousIndex();
			
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//JOptionPane.showMessageDialog(null, user.getCharacters().getCharacters().size());
					mw.hideLevelSection();
					mw.showPlaySection(levels.getLevels().get(index));
                                        mp.stop();
                                       
				}
			});
		}
		

		
		initialize(user, levels);
	}
	
	public void initialize(User user, Levels levels){
		setLayout(null);
		lvl_txt.setBounds(22, 50, 700, 100);
		btn_0.setBounds(510, 380, 180, 32);	
		buttons.get(0).setBounds(32, 176, 192, 48);
		buttons.get(1).setBounds(256, 176, 192, 48);
		buttons.get(2).setBounds(480, 176, 192, 48);
		buttons.get(3).setBounds(32, 250, 192, 48);
                
		this.add(lvl_txt);
		this.add(btn_0);
		ListIterator<MyButton>itr = buttons.listIterator();
		while(itr.hasNext()){
			MyButton button = itr.next();
			int index = itr.previousIndex();
			
			button.setIcon(new ImageIcon("resources/level"+(index + 1)+".png"));
                        button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setText("Stage"+ (index + 1));
			button.setEnabled(true);
			this.add(button);
		}
	}
        
	
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

	}
}
