package runcoderrun;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Solids {
	private int hf;
	private int wf;
	ArrayList<Solid> solids;
	
	/**
	 * Constructor default de la clase Solids
	 * @param Ninguno
	 */
	public Solids(){
		solids=new ArrayList<Solid>(300);
	}
	
	/**
	 * Metodo para obtener la lista de solidos
	 * @return ArrayList<Solid> Esto regresara la lista de solidos
	 */
	public ArrayList<Solid> getSolids() {
		return solids;
	}
	
	/**
	 * Metodo para establecer la lista de solidos
	 * @param solids Lista de solidos
	 */
	public void setSolids(ArrayList<Solid> solids) {
		this.solids = solids;
	}
	
	/**
	 * Metodo que genera plataformas y las guarda en una lista
	 * @param  ninguno
	 */
	public void generateSolid(){
		Solid aux = solids.get(solids.size() - 1);
		int ay2 = aux.getY2(); 
		int step = 100;
		Random random = new Random();
		int y1 = 0;
		
		while(y1 < 40 || y1 > (hf - 100)){
			y1 = random.nextInt(step * 2) + (ay2 - step);
		}
		
		int x1 = wf + random.nextInt(48) + 10;
		
		
		int width = random.nextInt(120) + 180;
		int height = 20;
		
		Solid solid = new Solid(false, 0, x1, y1, width, height, "resources/floor_long.png");
		solids.add(solid);		
	}
	
	/**
	 * Metodo que genera plataformas de lava y las guarda en una lista
	 * @param  ninguno
	 */
	public void generateLavaSolid(){
		Solid aux = solids.get(solids.size() - 1);
		if(aux.getType() == 0){
			int ax1 = aux.getX1();
			int aw = aux.getWidth();
			int ah = aux.getHeight();
			int ay1 = aux.getY1();
	
			int x1 = ax1 - 4;
			int y1 = ay1;
			int width = aw + 8;
			int height = ah;
			
			
			Solid solid = new Solid(true, 1, x1, y1, width, height, "resources/lava_long.png");
			solids.add(solid);
		}
	}
	
	/**
	 * Metodo que genera plataformas de veneno y las guarda en una lista
	 * @param  ninguno
	 */
	public void generatePoisonSolid(){
		Solid aux = solids.get(solids.size() - 1);
		if(aux.getType() == 0){
			int ax1 = aux.getX1();
			int aw = aux.getWidth();
			int ah = aux.getHeight();
			int ay1 = aux.getY1();
	
			int x1 = ax1 - 4;
			int y1 = ay1;
			int width = aw + 8;
			int height = ah;
			
			Solid solid = new Solid(true, 2, x1, y1, width, height, "resources/poison_long.png");
			solids.add(solid);
		}
	}
	
	/**
	 * Metodo que genera la meta
	 * @param  ninguno
	 */
	public void generateGoalSolid(){
		int x1 = wf;
		int y1 = 0;
		int width = wf;
		int height = hf;
		
		Solid solid = new Solid(false, 3, x1, y1, width, height, "resources/youWin.png");
		solids.add(solid);		
	}
	
	/**
	 * Metodo que vuelve a crear poderes si se caen de las plataformas o 
	* las elimina si entra en contacto con el personaje
	 * @param  ninguno
	 */
	public void initialize(){
		Solid aux = new Solid(false, 0, 0, 300, 640, 20, "resources/floor_long.png");
		solids.add(aux);
	}
	
	/**
	 * Metodo que mueve a la izquierda los solidos
	 * @param  ninguno
	 */
	public void play(){
		ArrayList<Integer> ints = new ArrayList<Integer>(15);
		ListIterator<Solid> itr = solids.listIterator();
		
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(solid.moveLeft()){
				int i = itr.previousIndex();
				ints.add(i);
			}
		}
		
		ListIterator<Integer> itr_1 = ints.listIterator();
		while(itr_1.hasNext()){
			int i = itr_1.next();
			solids.remove(i);
		}
	}
	
	/**
	* Metodo para que sirve para delimitar el tamanio de la pantalla
	* @param width Ancho, height Alto
	*/
	public void setFrameSize(int width, int height){
		hf = height;
		wf = width;
	}
	
	/**
	* Metodo para que borra todos los solidos
	* @param ninguno
	*/
	public void stop(){
		solids.removeAll(solids);
	}
	
	/**
	* Metodo para ver los datos de los solidos
	* @return String Lista de datos del solido
	*/
	public String toString(){
		String str = "";
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
			str += solid.toString() + "\n\n";
		}
		return str;
	}
	
	/**
	 * Metodo para dibujar solidos
	 * @param g Objeto grafico para dibujar el sprite de los solidos
	 */
	public void paint(Graphics g){
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid=itr.next();
			solid.paint(g);
		}
	}	
}
