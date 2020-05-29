package runcoderrun;

public class User {
	private Characters characters;
	private int score;
	private int coins;
	private String name;
        private int high_score;
	/**
	 * Constructor de la clase User
	 * @param ninguno
	 */
	
	public User(){
		characters = new Characters();
		score = 0;
		coins = 0;
                high_score = 0;
                
	}
	/**
	 * Segundo constructor de la clase User
	 * @param characters Array List de personajes, score Puntaje del juego, coins Monedas obtenidas durante las partidas
	 */
	public User(Characters characters, int score, int coins) {
		this.characters = characters;
		this.score = score;
		this.coins = score;
	}
	/**
	 * Metodo para obtener la lista de Personajes
	 * @return Character Esto regresara la lista de personajes
	 */
	public Characters getCharacters() {
		return characters;
	}
	
	/**
	 * Metodo para establecer la lista de personajes
	 * @param characters Lista de personajes
	 */
	public void setCharacters(Characters characters) {
		this.characters = characters;
	}
	/**
	 * Metodo para obtener el puntaje
	 * @return Score Esto regresara el puntaje
	 */
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
        
        public int getHighScore() {
		return high_score;
	}
	public void setHighScore(int score) {
            if(score > high_score)
		high_score = score;
	}
        
        
	/**
	 * Metodo para obtener las monedas
	 * @return int Esto regresara la cantidad de monedas
	 */
	public int getCoins() {
		return coins;
	}
	
	/**
	 * Metodo para establecer las monedas
	 * @param coins Monedas
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	/**
	 * Metodo para obtener el nombre 
	 * @return String Esto regresara el nombre
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Metodo para establecer el nombre
	 * @param name Nombre
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Metodo para comprar personajes
	 * @param character Personaje
	 */
	public int buyCharacter(Character character){
		int aux = characters.buyCharacter(character, this);
		
		if(aux == 1){
			System.out.println(character.getName()+" is now available");
			coins -= character.getPrice();
		}
		
		return aux;
	}
	
	/**
	 * Metodo para elegir personaje
	 * @param character Personaje
	 */
	public void chooseCharacter(Character character){
		if(characters.chooseCharacter(character)){
			System.out.println(character.getName()+" was choosen");
		}
	}
	
	/**
	 * Metodo para saber que personaje esta elegido
	 * @return Character Personaje
	 */
	public Character getCurrentCharacter(){
		return characters.getCurrentCharacter();
	}
}
