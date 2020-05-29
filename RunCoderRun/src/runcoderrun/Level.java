package runcoderrun;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Level{
	private Environment environment;
	private ScoreBoard score_board;
	private Image bg_img; 
	private int status;//0 locked, 1 unlocked, 2 passed, 3 lost
	private int id;
	private int hf;
	private int wf;
	private int duration;
	private Character character;
        private String img;
	
	/**
	 * Constructor default de la clase Level
	 * @param ninguno
	 */
	public Level(String img_name, int duration){
		this.duration = duration;
		environment = new Environment(this.duration);
		score_board = new ScoreBoard();
		status = 0;
		character = new Character();
		this.img = img_name;
		bg_img = new ImageIcon(img_name).getImage();
	}
		
	/**
	 * Metodo para obtener la altura del frame
	 * @return int Altura del frame
	 */
	public int getHf() {
		return hf;
	}

	/**
	 * Metodo para establecer la altura del frame
	 * @param hf Altura del frame
	 */
	public void setHf(int hf) {
		this.hf = hf;
	}

	/**
	 * Metodo para obtener el ancho del frame
	 * @return int Ancho   del frame
	 */
	public int getWf() {
		return wf;
	}

	/**
	 * Metodo para establecer la altura del frame
	 * @param hf Altura del frame
	 */
	public void setWf(int wf) {
		this.wf = wf;
	}
	
	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	/**
	 * Metodo para obtener los personajes
	 * @return Personaje Esto regresara la lista de personajes
	 */
	public Character getCharacter() {
		return character;
	}

	/**
	 * Metodo para establecer los personajes
	 * @param character Personaje
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}
	/**
	 * Metodo para obtener el estatus del nivel
	 * @return int Esto regresara el estatus del nivel
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * Metodo para establecer el estatus del nivel
	 * @param status Estatus del nivel
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * Metodo para obtener el id del nivel
	 * @return int Esto regresara el id del nivel
	 */
	public int getId(){
		return id;
	}
        
        public String getLevelImg(){
            return img;
        }
	
	/**
	 * Metodo para establecer el id del nivel
	 * @param id Id del nivel
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * Metodo para iniciarlizar a todos los objetos que están en el nivel
	 * @param user Usuario
	 */
	public void iniatilize(User user){
		this.status = 1;
		environment.initialize();
		character.initialize();
		score_board.initialize(character, user);
		
		character.setX1(128);
		character.setY1(260);
	}
	
	/**
	 * Metodo para detener la generacion del ambiente en el nivel
	 * @param ninguno
	 */
	public void play(int time, User user){
		environment.play();
		score_board.play(time, character,user);
		
		if(character.getStatus() == 0){
			run(user);
		}
		else if(character.getStatus() == 1){
			jump(user);
		}
		//Game over
		if(character.getLife() <= 0){
			status = 3;
		}
	}	
	
	public void stop(){
		environment.stop();
	}
	
	/**
	 * Metodo para sirve para que salte el personaje
	 * @param user Usuario 
	 */
	public void jump(User user){
		int aux = character.jump(environment, user, score_board);
		if(aux == 0){
			status = 2;
		}
	}
	/**
	 * Metodo para que sirve para que corra el personaje
	 * @param user Usuario 
	 */
	public void run(User user){
		int aux = character.run(environment, user, score_board);
		
		if(aux == 0){
			status = 2;
		}
		else if(aux == -2){
			status = 3;
		}
	}
	
	/**
	 * Metodo para que sirve para que el personaje no salte en el aire
	 * @param user Usuario 
	 */
	public boolean canJump(){
		if(character.getStatus() == 0 && character.moveDown(environment)== -1){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Metodo para que sirve para delimitar el tamanio de la pantalla
	 * @param width Ancho, height Alto
	 */
	public void setFrameSize(int width, int height){
		setHf(height);
		setWf(width);
		character.setFrameSize(width, height);
		environment.setFrameSize(width, height);
	}
	
	/**
	* Metodo para que sirve para generar el ambiente
	* @param time Tiempo
	*/
	public void generate(int time){
		environment.generate(time);
	}

	/**
	 * Metodo para hacer validaciones con variables del objeto level 
	 * @return boolean Valor que determina si los datos a comparar son iguales o diferentes
	 */
	public boolean equals(Object obj){
		if(obj == this)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Level))
			return false;
		
		Level level = (Level)obj;
		return level.id == this.id;
	}
	
	/**
	* Metodo para ver los datos del nivel
	* @return String Lista de datos del nivel
	*/
	public String toString(){
		String str = environment.toString();
		return str;
	}
	
	/**
	 * Metodo para dibujar el nivel
	 * @param g Objeto grafico para dibujar el nivel
	 */
	public void paint(Graphics g){
		g.drawImage(bg_img, 0, 0, wf, hf, null);
		character.paint(g);
		environment.paint(g);
		score_board.paint(g);
	}

}
