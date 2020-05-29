package runcoderrun;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

public class Character extends MyGraphics{
	private int life;
	private int total_life;
	private int price;
	private int jump;
	private int speed;
	private boolean available;
	private boolean choosen;
	private int status;//0 running, 0 jumping
	private boolean brick_breaker;
	private boolean fire_res;
	private boolean poison_res;
	private boolean spike_res;
	private String name;
	
	
	/**
	 * Constructor default de la clase Character
	 * @param Ninguno
	 */
	public Character(){
		super();
		life = 4;
		total_life = life;
		price = 40;
		jump = 5;
		speed = 1;
		available = false;
		choosen = false;
		status = 0;
		name = "Max";
		setX1(128);
		setY1(260);
		setWidth(32);
		setHeight(40);
		
		setImageByName("resources/J1G.gif");
	}
	
	
	/**
	 * Segundo constructor de la clase Character
	 * @param name Nombre del personaje, life Vida del peronaje, Price, Precio del personaje
	 * jump Distancia que salta el personaje, speed Velocidad a la que va el personaje,         *available  Disponibilidad del personaje, choosen Si el personaje fue elegido,  *brick_breaker Si el personaje puede romper bloques, fire_res Si el personaje es *resistente al fuego, poison_res: Si el personaje es resistente al veneno, spike_res Si el *personaje es resistente a las puas, status Si el personaje tiene algún poder activo *img_name Nombre del Sprite del personaje
	 */ 
	public Character(String name, int life, int price, int x1, int y1, int width, int height, int jump, int speed, boolean available, boolean choosen,
			boolean brick_breaker, boolean fire_res, boolean poison_res, boolean spike_res, String img_name) {
		super(x1, y1, width, height);
		this.life = life;
		total_life = life;
		this.price = price;
		this.jump = jump;
		this.speed = speed;
		this.available = available;
		this.choosen = choosen;
		this.brick_breaker = brick_breaker;
		this.fire_res = fire_res;
		this.poison_res = poison_res;
		this.spike_res = spike_res;
		this.status = 0;
		this.name = name;
		setImageByName(img_name);
	}
	
	/**
	 * Metodo para obtener el nombre del personaje
	 * @return String Esto regresara el nombre del personaje
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo para establecer el nombre del personaje
	 * @param name Nombre del personaje
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Metodo para obtener el estatus del personaje
	 * @return int Esto regresara el estatus del personaje
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Metodo para establecer el estatus del personaje
	 * @param status Estatus del personaje
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Metodo para obtener la vida del personaje
	 * @return int Esto regresara la vida del personaje
	 */
	public int getLife() {
		return life;
	}
	
	/**
	 * Metodo para establecer la vida del personaje
	 * @param life Vida del personaje
	 */
	public void setLife(int life) {
		this.life = life;
	}
	
	/**
	 * Metodo para obtener la vida total del personaje
	 * @return int Esto regresara la vida total del personaje
	 */
	public int getTotalLife() {
		return total_life;
	}

	/**
	 * Metodo para establecer la vida total del personaje
	 * @param total_life Vida del personaje
	 */
	public void setTotalLife(int total_life) {
		this.total_life = total_life;
	}

	/**
	 * Metodo para obtener el precio del personaje
	 * @return int Esto regresara el precio del personaje
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Metodo para establecer el precio del personaje
	 * @param price  Precio del personaje
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * Metodo para obtener la cantidad salto del personaje
	 * @return int Esto regresara la cantidad de salto del personaje
	 */
	public double getJump() {
		return jump;
	}
	
	/**
	 * Metodo para establecer la cantidad de salto del personaje
	 * @param jump  Salto del personaje
	 */
	public void setJump(int jump) {
		this.jump = jump;
	}
	
	/**
	 * Metodo para obtener la velocidad del personaje
	 * @return int Esto regresara la velocidad del personaje
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Metodo para establecer la velocidad del personaje
	 * @param speed  Velocidad del personaje
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
        
      
	/**
	 * Metodo para obtener la disponibilidad del personaje
	 * @return boolean Esto regresara la disponibilidad del personaje
	 */
	public boolean isAvailable() {
		return available;
	}
	
	/**
	 * Metodo para establecer la disponibilidad del personaje
	 * @param available  Disponibilidad del personaje
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * Metodo para obtener la si el personaje esta elegido
	 * @return boolean Esto regresara si el personaje esta elegido
	 */
	public boolean getChoosen() {
		return choosen;
	}
	
	/**
	 * Metodo para establecer si el personaje esta elegido
	 * @param choosen  Si el personaje esta elegido
	 */
	public void setChoosen(boolean choosen) {
		this.choosen = choosen;
	}
	
	/**
	 * Metodo para obtener la si el personaje puede romper ladrillos
	 * @return boolean Esto regresara si el personaje puede romper ladrillos
	 */
	public boolean getBrickBreaker() {
		return brick_breaker;
	}

	/**
	 * Metodo para establecer si el personaje puede romper ladrillos
	 * @param brick_breaker Si el personaje esta puede romper ladrillos
	 */
	public void setBrickBreaker(boolean brick_breaker) {
		this.brick_breaker = brick_breaker;
	}
	
	/**
	 * Metodo para obtener la si el personaje es resistente al fuego
	 * @return boolean Esto regresara si el personaje es resistente al fuego
	 */
	public boolean getFireRes() {
		return fire_res;
	}
	
	/**
	 * Metodo para establecer si el personaje es resistente al fuego
	 * @param fire_res Si el personaje es resistente al fuego
	 */
	public void setFireRes(boolean fire_res) {
		this.fire_res = fire_res;
	}
	
	/**
	 * Metodo para obtener la si el personaje es resistente al veneno
	 * @return boolean Esto regresara si el personaje es resistente al veneno
	 */
	public boolean getPoisonRes() {
		return poison_res;
	}

	/**
	 * Metodo para establecer si el personaje es resistente al veneno
	 * @param poison_res Si el personaje es resistente al veneno
	 */
	public void setPoisonRes(boolean poison_res) {
		this.poison_res = poison_res;
	}
	
	/**
	 * Metodo para obtener la si el personaje es resistente a las puas
	 * @return boolean Esto regresara si el personaje es resistente a las puas
	 */
	public boolean getSpikeRes() {
		return spike_res;
	}
	
	/**
	 * Metodo para establecer si el personaje es resistente al veneno
	 * @param poison_res Si el personaje es resistente al veneno
	 */
	public void setSpikeRes(boolean spike_res) {
		this.spike_res = spike_res;
	}
	
	/**
	 * Metodo que inicializa las vidas del personaje
	 * @param ninguno
	 */
	public void initialize(){
		this.life = this.total_life;
	}
	
	/**
	 * Metodo que realiza el movimiento basico del personaje
	 * @param  environment El ambiente en que se mueve el personaje, user El usuario que 
	 * lo controla, score_board El registro de las monedas y el puntaje
	 */
	public int run(Environment environment, User user, ScoreBoard score_board){	
		int collision;
		if(this.objectCollision(environment, user, score_board)){
			collision = 0;
		}
		else{
			collision = moveDown(environment);
		}
		
		
		return collision;
	}
	
	/**
	 * Metodo que realiza el salto del personaje
	 * @param  environment El ambiente en que se mueve el personaje, user El usuario que 
	 * lo controla, score_board El registro de las monedas y el puntaje
	 */
	public int jump(Environment environment, User user, ScoreBoard score_board){
		int collision = -4;
		if(this.objectCollision(environment, user, score_board)){
			collision = 0;
		}
		else{
			moveUp(environment);
		}
		return collision;
	}
	
	
	/**
	 * Metodo que valida el movimiento hacia arriba en el salto del personaje
	 * @param  environment El ambiente en que se mueve el personaje
	 */
	public boolean moveUp(Environment environment){
		ListIterator<Solid> itr = environment.getSolids().getSolids().listIterator();
		boolean collision = false;
		int aux = y1 - jump;
		
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(hasCollisionAndMove(solid, x1, aux, x2, y2 - jump)){
				collision = true;			
			}
		}
		
		if(!collision){
			if(aux >= 0){
				y1 -= jump;
				y2 -= jump;
			}
			else{
				y1 = 0;
				y2 = width;
			}	
		}
	
		return collision;
	}	
	
	/**
	 * Metodo que valida el movimiento hacia abajo en el salto del personaje
	 * @param  environment El ambiente en que se mueve el personaje
	 */
	public int moveDown(Environment environment){
		ListIterator<Solid> itr = environment.getSolids().getSolids().listIterator();
		int collision = -3;//-3 nothing below
		int aux = y2 + jump;
		
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(hasCollisionAndMove(solid, x1, y1 + jump, x2, aux)){
				collision = -1;	//Sobrepasa un solido
			}
		}
		
		if(collision == -3){
			if(aux <= hf){
				y1 += jump;
				y2 += jump; 
			}
			else{
				y1 = hf - height;
				y2 = hf;
				collision = -2;//Toca el fondo de la pantallas
			}	
		}

		return collision;
	}	
	
	/**
	 * Metodo que valida la colision con un objeto
	 * @param  environment El ambiente en que se mueve el personaje, user El usuario que 
	 * lo controla, score_board El registro de las monedas y el puntaje
	 */
	public boolean objectCollision(Environment environment, User user, ScoreBoard score_board){
		boolean aux = false;
		ArrayList<Coin>coins = environment.getCoins().getCoins();
		ArrayList<PowerUp>power_ups = environment.getPowerUps().getPowerUps();
		ArrayList<Solid>solids = environment.getSolids().getSolids();
		ArrayList<Integer> ints;
		
		ListIterator<Coin>coin_itr = coins.listIterator();
		ListIterator<PowerUp>power_up_itr = power_ups.listIterator();
		ListIterator<Solid>solid_itr = solids.listIterator();
		ListIterator<Integer> itr;
		
		
		//Coins
		ints = new ArrayList<Integer>(15);
		while(coin_itr.hasNext()){
			Coin coin = coin_itr.next();
			if(hasCollision(coin, x1, y1, x2, y2)){
				ints.add(coin_itr.previousIndex());
				score_board.increaseCoins(user, 1);
			}
		}
		itr = ints.listIterator();
		while(itr.hasNext()){
			int i = itr.next();
			coins.remove(i);
		}
		//Power ups
		ints = new ArrayList<Integer>(15);
		while(power_up_itr.hasNext()){
			PowerUp power_up = power_up_itr.next();
			if(hasCollision(power_up, x1, y1, x2, y2)){
				if(power_up.getType() >= 0 && power_up.getType() <= 5){
					ints.add(power_up_itr.previousIndex());
					score_board.increaseCoins(user, 4);
                                        life++;
				}
				if(!spike_res && power_up.getType() == 6){
					ints.add(power_up_itr.previousIndex());
					life--;
				}
				if(!brick_breaker && power_up.getType() == 7){
					ints.add(power_up_itr.previousIndex());
					life--;
				}
			}
		}
		itr = ints.listIterator();
		while(itr.hasNext()){
			int i = itr.next();
			power_ups.remove(i);
		}	
		//Lava, goal, poison solids
		ints = new ArrayList<Integer>(15);
		while(solid_itr.hasNext()){
			Solid solid = solid_itr.next();
			if(hasCollision(solid, x1, (y1 + jump), x2, (y2 + jump)) && solid.getType() != 0){
				if(!fire_res && solid.getType() == 1){
					ints.add(solid_itr.previousIndex());
					life--;
				}
				if(!poison_res && solid.getType() == 2){
					ints.add(solid_itr.previousIndex());
					life--;
				}
				if(solid.getType() == 3){
					aux = true;
					score_board.increaseCoins(user, 10);
				}
			}
		}
		itr = ints.listIterator();
		while(itr.hasNext()){
			int i = itr.next();
			solids.remove(i);
		}
		
		return aux;
	}
	
	
	/**
	 * Metodo que valida la colision del personaje mientras esta en movimiento
	 * @param  mg Graficos del juego, x1 Posicion de x, y1 Posicion de y,  x2 Posicion de x mas *el ancho, y2 Posicion de y mas el alto
	 */
	public boolean hasCollisionAndMove(MyGraphics mg, int x1, int y1, int x2, int y2){
		boolean collision = false;
		
		if(hasCollision(mg, x1, y1, x2, y2)){
			if(x2 > this.x2){
				//this.x1 = solid.getX1() - width;
				//this.x2 = solid.getX1();
			}
			if(x1 < this.x1){
				//this.x1 = solid.getX2();
				//this.x2 = solid.getX2() + width;
			}
			if(y2 > this.y2){//Hacia abajo
				if(y2 > mg.getY1()){
					this.y1 = mg.getY1() - height;
					this.y2 = mg.getY1();
				}
			}
			if(y2 < this.y2){//Hacia arriba
				if(y1 < mg.getY2()){
					this.y1 = mg.getY2();
					this.y2 = mg.getY2() + height;
				}
			}				
			collision = true;
		}
		
		return collision;
	}		
	
	/**
	 * Método para dibujar el Sprite del personaje
	 * @param g Objeto grafico para dibujar el fondo en BgPanel
	 */
	public void paint(Graphics g){
		g.drawImage(image, x1, y1, width, height, null);
	}
	
}

