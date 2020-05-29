package runcoderrun;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class PowerUps {
	private ArrayList<PowerUp>power_ups;
	
	/**
	 * Constructor default de la clase PowerUps
	 * @param Ninguno
	 */
	public PowerUps(){
		power_ups = new ArrayList<PowerUp>(100);
	}
	
	/**
	 * Metodo para obtener la lista de poderes
	 * @return ArrayList<Power Up> Esto regresara la lista de poderes
	 */
	public ArrayList<PowerUp> getPowerUps() {
		return power_ups;
	}
	
	/**
	 * Metodo para establecer la lista de poderes
	 * @param power_ups Lista de poderes
	 */
	public void setPowerUps(ArrayList<PowerUp> power_ups) {
		this.power_ups = power_ups;
	}
	
	/**
	 * Metodo que genera poderes y lo guarda en la lista de poderes
	 * @param  solids Clase que crea objetos
	 */
	public void generatePowerUp(ArrayList<Solid> solids){
		Solid aux = solids.get(solids.size() - 1);
		int ax1 = aux.getX1();
		int aw = aux.getWidth();
		int ay1 = aux.getY1();
		String power_names[] = new String[7];
		power_names[0] = "resources/earth_cristal.png";
		power_names[1] = "resources/fire_cristal.png";
		power_names[2] = "resources/jump_cristal.png";
		power_names[3] = "resources/poison_cristal.png";
		power_names[4] = "resources/speed_cristal.png";
		power_names[5] = "resources/steel_cristal.png";
				
		Random random = new Random();

		int x1 = random.nextInt(aw-30) + ax1;
		int y1 = ay1 - 32;
		int width = 30;
		int height = 30;
		int type = random.nextInt(6);
		
		PowerUp power_up = new PowerUp(type, x1, y1, width, height, power_names[type]);
		power_ups.add(power_up);
	}
	
	/**
	 * Metodo que genera puas y las guarda en la lista de puas
	 * @param  solids Clase que crea objetos
	 */
	public void generateSpike(ArrayList<Solid> solids){
		String power_name = "resources/spike.png";
		Solid aux = solids.get(solids.size() - 1);
		int ax1 = aux.getX1();
		int aw = aux.getWidth();
		int ay1 = aux.getY1();
		
		Random random = new Random();

		int x1 = random.nextInt(aw-30) + ax1;
		int y1 = ay1 - 50;
		int width = 30;
		int height = 50;
		
		PowerUp power_up = new PowerUp(6, x1, y1, width, height, power_name);
		power_ups.add(power_up);
	}
	
	public void generateBrick(ArrayList<Solid> solids){
		String power_name = "resources/block.png";
		Solid aux = solids.get(solids.size() - 1);
		int ax1 = aux.getX1();
		int aw = aux.getWidth();
		int ay1 = aux.getY1();
		
		Random random = new Random();

		int x1 = random.nextInt(aw-30) + ax1;
		int y1 = ay1 - 30;
		int width = 50;
		int height = 30;
		
		PowerUp power_up = new PowerUp(7, x1, y1, width, height, power_name);
		power_ups.add(power_up);
	}	
	
	/**
	 * Metodo que vuelve a crear poderes si se caen de las plataformas o 
	* las elimina si entra en contacto con el personaje
	 * @param  ninguno
	 */
	public void play(){
		ArrayList<Integer> ints = new ArrayList<Integer>(15);
		ListIterator<PowerUp> itr = power_ups.listIterator();
		
		while(itr.hasNext()){
			PowerUp power_up = itr.next();
			if(power_up.moveLeft()){
				int i = itr.previousIndex();
				ints.add(i);
			}
		}
		
		ListIterator<Integer> itr_1 = ints.listIterator();
		while(itr_1.hasNext()){
			int i = itr_1.next();
			power_ups.remove(i);
		}
	}
	
	/**
	 * Metodo que elimina todos los poderes 
	 * @param  ninguno
	 */
	public void stop(){
		power_ups.removeAll(power_ups);
	}		
	
	/**
	 * Metodo para dibujar poderes
	 * @param g Objeto grafico para dibujar el sprite de los poderes
	 */
	public void paint(Graphics g){
		ListIterator<PowerUp> itr = power_ups.listIterator();
		while(itr.hasNext()){
			PowerUp power_up = itr.next();
			power_up.paint(g);
		}
	}
}
