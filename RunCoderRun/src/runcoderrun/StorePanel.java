package runcoderrun;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StorePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Image image;
	Character character;
	private ArrayList<MyButton> buttons;
	private JLabel label_0;
	private MyButton btn_0;
        private MusicPlayer mp;

	/**
	 * Constructor default de la clase StorePanel
	 * @param mw Instancia de la clase MainWindow, user Usuario
	 */
	public StorePanel(MainWindow mw, User user, MusicPlayer mp){
		super();
		image = new ImageIcon("resources/nueve.png").getImage();
		character = new Character();
		character.setX1(128);
		character.setY1(260);
		buttons = new ArrayList<MyButton>(8);
		label_0 = new JLabel();
		
		btn_0 = new MyButton("Return");
		MyButton btn_1 = new MyButton("Buy");
		MyButton btn_2 = new MyButton("Buy");
		MyButton btn_3 = new MyButton("Buy");
		MyButton btn_4 = new MyButton("Buy");
		MyButton btn_5 = new MyButton("Buy");
		MyButton btn_6 = new MyButton("Buy");
		MyButton btn_7 = new MyButton("Buy");
		MyButton btn_8 = new MyButton("Buy");
                this.mp = mp;
		
		buttons.add(btn_1);buttons.add(btn_2);buttons.add(btn_3);buttons.add(btn_4);
		buttons.add(btn_5);buttons.add(btn_6);buttons.add(btn_7);buttons.add(btn_8);
		
		
		
		btn_0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mw.hideStoreSection();
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
					Characters characters = user.getCharacters();
					Character character = characters.getCharacters().get(index);
					
					if(character.isAvailable()){
						characters.chooseCharacter(character);
					}
					else{
						int buy = user.buyCharacter(character);
						if(buy == 1){
							JOptionPane.showMessageDialog(null, user.getCharacters().getCharacters().get(index).getName()+" is now available!");
						}
						else if(buy == 0){
							JOptionPane.showMessageDialog(null, "Not enough coins");
						}
						else{
							JOptionPane.showMessageDialog(null, "Unexpected error");
						}
					}
					initialize(user);
				}
			});
		}
		
		initialize(user);
	}
	
	/**
	 * Metodo que inicializa los botones, los limites y el fondo de la ventana, el fondo,
	* las fuentes, el texto y los demás elementos
	 * @param  ninguno
	 */
	public void initialize(User user){
		setLayout(null);
		
		label_0.setBounds(16, 380, 256, 32);
		btn_0.setBounds(510, 380, 180, 32);
		buttons.get(0).setBounds(32, 16, 192, 48);
		buttons.get(1).setBounds(256, 16, 192, 48);
		buttons.get(2).setBounds(480, 16, 192, 48);
		buttons.get(3).setBounds(32, 80, 192, 48);
		buttons.get(4).setBounds(256, 80, 192, 48);
		buttons.get(5).setBounds(480, 80, 192, 48);
		buttons.get(6).setBounds(32, 144, 192, 48);
		buttons.get(7).setBounds(256, 144, 192, 48);	
		
		this.add(label_0);
		this.add(btn_0);
		
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("resources/coin.png").getImage().getScaledInstance(38, 32, Image.SCALE_DEFAULT));
		label_0.setIcon(imageIcon);
		label_0.setBackground(new Color(255,255,255));
		label_0.setForeground(new Color(255,193,7));
		label_0.setOpaque(true);
		label_0.setFont(new Font("Serif", Font.BOLD, 18));
		label_0.setText("Coins: " + user.getCoins());
		
		
		
		ListIterator<MyButton>itr = buttons.listIterator();
		while(itr.hasNext()){
			MyButton button = itr.next();
			int index = itr.previousIndex();
			
			button.setIcon(new ImageIcon("resources/Personaje_"+(index + 1)+".png"));
			
			if(user.getCharacters().getCharacters().get(index).isAvailable()){
				button.setText("Select ");
				button.setEnabled(true);
			}
			else{
				button.setText("Buy $"+user.getCharacters().getCharacters().get(index).getPrice());
				button.setEnabled(true);
			}
			
			this.add(button);
		}
		
		buttons.get(user.getCharacters().getCurrentCharacterInt()).setText("Selected");
		buttons.get(user.getCharacters().getCurrentCharacterInt()).setEnabled(false);
	}
	
	/**
	 * Metodo para dibujar la ventana de la tienda
	 * @param g Objeto grafico para dibujar la pantalla de la tienda
	 */
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

	}
}
