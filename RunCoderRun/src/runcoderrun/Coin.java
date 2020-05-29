package runcoderrun;
import java.awt.Graphics;

public class Coin extends MyGraphics{
	/**
	 * Constructor default de la clase Coin
	 * @param Ninguno
	 */
	public Coin(){
		super();	
		setImageByName("resources/coin.png");
	}
	
	/**
	 * Segundo constructor  de la clase coin
	 * @param x1 Posicion de x, y1 Posicion de y, width Ancho de la moneda, height Alto de la 
	* moneda
	 */
	public Coin(int x1, int y1, int width, int height){
		super(x1, y1, width, height);
		setImageByName("resources/coin.png");
	}
	
	/**
	 * Metodo que guarda las monedas que el jugador obtenga
	 * @param user Usuario
	 */
	public void collisionCharacter(User user){
		user.setCoins(user.getCoins()+1);
	}
	
	/**
	* Metodo para ver los datos de la moneda
	* @return String Lista de datos de la moneda
	*/
	public String toString(){
		return super.toString();
	}
	
	/**
	 * Metodo para hacer validaciones con variables del objeto moneda 
	 * @return boolean Valor que determina si los datos a comparar son iguales o diferentes
	 */
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(!(obj instanceof MyGraphics))
			return false;
		//Coin coin=(Coin)obj;
		return true;
	}
	
	/**
	 * Metodo para dibujar monedas
	 * @param g Objeto grafico para dibujar las monedas
	 */
	public void paint(Graphics g){
		g.drawImage(image, x1, y1, width, height, null);
	}
	
	public boolean moveLeft(){
		boolean collision = false;
		int aux = x1 - 3;

		if(aux >= (0 - width)){
			x1 = aux;
			x2 -= 3;
		}
		else{
			x1 = (0 - width);
			x2 = x1 + width;
			collision = true;
		}	
		return collision;
	}
}
