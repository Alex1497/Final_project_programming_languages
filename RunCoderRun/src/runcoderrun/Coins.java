package runcoderrun;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Coins {
	private ArrayList<Coin> coins;
	
	/**
	 * Constructor default de la clase Coins
	 * @param Ninguno
	 */
	public Coins(){
		coins = new ArrayList<Coin>(32);
	}
	
	/**
	 * Metodo para obtener la lista de monedas
	 * @return ArrayList<Moneda> Esto regresara la lista de monedas
	 */
	public ArrayList<Coin> getCoins() {
		return coins;
	}
	
	/**
	 * Metodo para establecer la lista de monedas
	 * @param coins Lista de monedas
	 */
	public void setCoins(ArrayList<Coin> coins) {
		this.coins = coins;
	}
	
	/**
	 * Metodo que genera la lista de monedas
	 * @param  solids Clase que crea objetos
	 */
	public void generateCoin(ArrayList<Solid> solids){
		Solid aux = solids.get(solids.size() - 1);
		int ax1 = aux.getX1();
		int aw = aux.getWidth();
		int ay1 = aux.getY1();
		Random random = new Random();

		int x1 = random.nextInt(aw-30) + ax1;
		int y1 = ay1 - 32;
		int width = 30;
		int height = 30;
		
		
		Coin coin = new Coin(x1, y1, width, height);
		coins.add(coin);
	}
	
	/**
	 * Metodo que vuelve a crear monedas si se caen de las plataformas o 
	* las elimina si entra en contacto con el personaje
	 * @param  ninguno
	 */
	public void play(){
		ArrayList<Integer> ints = new ArrayList<Integer>(15);
		ListIterator<Coin> itr = coins.listIterator();
		
		while(itr.hasNext()){
			Coin coin = itr.next();
			if(coin.moveLeft()){
				int i = itr.previousIndex();
				ints.add(i);
			}
		}
		
		ListIterator<Integer> itr_1 = ints.listIterator();
		while(itr_1.hasNext()){
			int i = itr_1.next();
			coins.remove(i);
		}
	}
	
	public void stop(){
		coins.removeAll(coins);
	}	
	
	/**
	 * Metodo para dibujar monedas
	 * @param g Objeto grafico para dibujar el fondo en BgPanel
	 */
	public void paint(Graphics g){
		ListIterator<Coin> itr = coins.listIterator();
		while(itr.hasNext()){
			Coin coin = itr.next();
			coin.paint(g);
		}
	}
}
