package runcoderrun;
import java.util.ArrayList;
import java.util.ListIterator;

public class Characters {
	private ArrayList<Character> characters;
	
	/**
	 * Constructor default de la clase Characters
	 * @param Ninguno
	 */
	public Characters(){
		characters = new ArrayList<Character>(8);
	}
	
	/**
	 * Metodo para obtener la lista del personajes
	 * @return ArrayList<Personaje> Esto regresara la lista de personajes
	 */
	public ArrayList<Character> getCharacters() {
		return characters;
	}

	/**
	 * Metodo para establecer la lista del personajes
	 * @param characters Lista del personajes
	 */
	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}

	/**
	 * Metodo para agregar personajes
	 * @param character Personaje que se va a agregar
	 */
	public void addCharacter(Character character){
		characters.add(character);
	}
	
	/**
	 * Metodo para comprar personajes
	 * @param character Personaje que se va a comprar user Usuario del juego
	 * @return int Si el personaje se compro con exito
	 */
	public int buyCharacter(Character character, User user){
		int aux = -1;//Unexpected error
		
		if(user.getCoins() < character.getPrice()){
			aux = 0;//Not enough money
		}
		else if(characters.contains(character)){
			character.setAvailable(true);
			characters.set(characters.indexOf(character), character);
			aux = 1;//Success
		}
		
		return aux;
	}
	
	/**
	 * Metodo para seleccionar un personaje
	 * @param character Personaje que se va a elegir
               * @return boolean Si el personaje esta elegido
	 */
	public boolean chooseCharacter(Character character){
		boolean aux = false;
		
		if(characters.contains(character)){
			ListIterator<Character> itr = characters.listIterator();
			while(itr.hasNext()){
				Character auxC = itr.next();
				auxC.setChoosen(false);
			}
			
			character.setChoosen(true);
			characters.set(characters.indexOf(character), character);
			aux = true;
		}
		return aux;
	}
	
	/**
	 * Metodo para obtener el personaje elegido
     * @return Character Si el personaje esta elegido
	 */
	public Character getCurrentCharacter(){
		ListIterator<Character> itr = characters.listIterator();
		Character character = new Character();
		
		while(itr.hasNext()){
			Character auxC = itr.next();
			if(auxC.getChoosen()){
				character = auxC;
			}
		}
		
		return character;
	}
	
	/**
	 * Metodo para ver el numero de índice del personaje
               * @return boolean Numero de índice del personaje
	 */
	public int getCurrentCharacterInt(){
		ListIterator<Character> itr = characters.listIterator();
		int index = 0;
		
		while(itr.hasNext()){
			Character auxC = itr.next();
			if(auxC.getChoosen()){
				index = itr.previousIndex();
			}
		}
		
		return index;
	}	
}
