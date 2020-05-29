package runcoderrun;
import java.awt.Color;
import java.awt.Graphics;

public class ScoreBoard {
	private int score;
	private int coins;
	private int total_coins;
	private int life;
        private int high_score;
	
	public ScoreBoard(){
		score = 0;
		coins = 0;
		total_coins = 0;
                high_score = 0;
	}
	
	public void initialize(Character character, User user){
		score = 0;
		coins = 0;
		life = character.getLife();
		total_coins = user.getCoins();
                high_score = user.getHighScore();
                
	}
	
	public void play(int time, Character character, User user){
		increaseScore(time, user);
		life = character.getLife();
	}
	
	public void increaseScore(int time, User user){
		if(time%10 == 0){
			score++;
                        user.setHighScore(score);
		}
	}
	
	public void increaseCoins(User user, int n){
		coins += n;
		total_coins = user.getCoins() + n;
		//score += 8;
		user.setCoins(total_coins);
	}
	
	public void drawScore(Graphics g){
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, 120, 76);
		g.setColor(new Color(255,255,255));
		g.drawString("Score:"+score, 4, 16);
                g.drawString("Highscore:"+high_score, 4, 28);
		g.drawString("Lifes: "+life, 4, 40);
		g.drawString("Coins: "+coins, 4, 52);
		g.drawString("Total Coins: "+total_coins, 4, 64);
	}
	
	public void paint(Graphics g){
		drawScore(g);
	}
}
