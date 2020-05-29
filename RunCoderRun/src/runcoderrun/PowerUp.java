package runcoderrun;
import java.awt.Graphics;

public class PowerUp extends MyGraphics {
	private int type;
	
	/**
	 * Constructor default de la clase Power Up
	 * @param Ninguno
	 */
	public PowerUp(){
		super();
		type=0;
		setImageByName("resources/Jump_cristal.png");
	}
	
	/**
	 * Segundo constructor  de la clase PowerUp
	 * @param x1 Posicion de x, y1 Posicion de y, width Ancho del poder, height Alto del
	* poder, img_name Nombre del sprite
	 */
	public PowerUp(int type, int x1, int y1, int width, int height, String img_name){
		super(x1, y1, width, height);
		this.type=type;
		setImageByName(img_name);
	}

	/**
	 * Metodo para obtener el tipode poder
	 * @return int Esto regresara el tipo de poder
	 */
	public int getType() {
		return type;
	}

	/**
	 * Metodo para establecer el tipo de poder
	 * @param type Tipo  de poder
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * Metodo que hace que los poderes se desplacen a la izquierda
	 * @param ninguno
	 */
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
	
	/**
	 * Metodo que hace que los poderes les den habilidades a los personajes
	 * @param ninguno
	 */
	public void colisionCharacter(User user){
		Character character=user.getCurrentCharacter();
		if(type==0)
			character.setJump(200);
		if(type==1)
			character.setSpeed(200);
		if(type==2)
			character.setBrickBreaker(true);
		if(type==3)
			character.setFireRes(true);
		if(type==4)
			character.setPoisonRes(true);
		if(type==5)
			character.setSpikeRes(true);
	}
	
	/**
	* Metodo para ver los datos del poder
	* @return String Lista de datos del poder
	*/
	public String toString(){
		return super.toString()+" type: "+type;
	}
	
	/**
	 * Metodo para hacer validaciones con variables del objeto Power Up 
	 * @return boolean Valor que determina si los datos a comparar son iguales o diferentes
	 */
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(!(obj instanceof MyGraphics))
			return false;
		PowerUp powerup=(PowerUp)obj;
		return (this.type==powerup.type);
	}

	/**
	 * Metodo para dibujar poderes
	 * @param g Objeto grafico para dibujar los poderes
	 */
	public void paint(Graphics g){
		g.drawImage(image, x1, y1, width, height, null);
	}
}

