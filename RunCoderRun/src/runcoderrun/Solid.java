package runcoderrun;
import java.awt.Graphics;

public class Solid extends MyGraphics {
	private boolean has_damage;
	private int type;
	
	/**
	 * Constructor default de la clase Solid
	 * @param Ninguno
	 */
	public Solid(){
		super();
		has_damage=false;
		type=0;
		setImageByName("resources/floor_long.png");
	}
	
	/**
	 * Segundo constructor  de la clase Solid
	 * @param x1 Posicion de x, y1 Posicion de y, width Ancho del poder, height Alto del
	* poder, img_name Nombre del sprite
	 */
	public Solid(boolean has_damage, int type, int x1, int y1, int width, int height, String img_name){
		super(x1, y1, width, height);
		this.has_damage=has_damage;
		this.type=type;
		setImageByName(img_name);
	}

	public boolean isHas_damage() {
		return has_damage;
	}

	public void setHas_damage(boolean has_damage) {
		this.has_damage = has_damage;
	}

	/**
	 * Metodo para obtener el tipo de solido
	 * @return int Esto regresara el tipo de solido
	 */
	public int getType() {
		return type;
	}

	/**
	 * Metodo para establecer el tipo de solido
	 * @param type Tipo de solido
	 */
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * Metodo que mueve a la izquierda los solidos
	 * @param  ninguno
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
	* Metodo para ver los datos de los solidos
	* @return String Lista de datos del solido
	*/
	public String toString(){
		return super.toString() + " has damage: "+has_damage+" type: "+type;
	}
	
	/**
	 * Metodo para hacer validaciones con variables del objeto Solid 
	 * @return boolean Valor que determina si los datos a comparar son iguales o diferentes
	 */
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(!(obj instanceof MyGraphics))
			return false;
		Solid solid=(Solid)obj;
		return(this.has_damage==solid.has_damage);
	}
	
	/**
	 * Metodo para dibujar solidos
	 * @param g Objeto grafico para dibujar los solidos
	 */
	public void paint(Graphics g){
		g.drawImage(image, x1, y1, width, height, null);
	}

}
