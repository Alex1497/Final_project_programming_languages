package runcoderrun;
import java.awt.Graphics;
import java.util.ArrayList;

public class Environment {
	private PowerUps power_ups;
	private Solids solids;
	private Coins coins;
	private int duration;
	
	/**
	 * Constructor default de la clase Environment
	 * @param Ninguno
	 */
	public Environment(int duration){
		this.duration = duration;
		solids = new Solids();
		power_ups = new PowerUps();
		coins = new Coins();
	}
	
	/**
	 * Metodo para obtener solidos
	 * @return Solids Esto regresara un objeto solido
	 */
	public Solids getSolids() {
		return solids;
	}
	
	/**
	 * Metodo para establecer solidos
	 * @param solids Solidos
	 */
	public void setSolids(Solids solids) {
		this.solids = solids;
	}
	
	/**
	 * Metodo para obtener monedas
	 * @return Coins Esto regresara un objeto moneda
	 */
	public Coins getCoins() {
		return coins;
	}

	/**
	 * Metodo para establecer monedas
	 * @param coins Monedas del juego
	 */
	public void setCoins(Coins coins) {
		this.coins = coins;
	}
	
	/**
	 * Metodo para obtener poderes
	 * @return PowerUps Esto regresara un objeto poder
	 */
	public PowerUps getPowerUps() {
		return power_ups;
	}

	/**
	 * Metodo para establecer poderes
	 * @param power_ups Poderes del juego
	 */
	public void setPowerUps(PowerUps power_ups) {
		this.power_ups = power_ups;
	}

	/**
	* Metodo para ver los datos de entorno
	* @return String Lista de datos del entorno
	*/
	public String toString(){
		String str = solids.toString();
		return str;
	}
	
	/**
	* Metodo para dibujar monedas, plataformas y podered
	 * @param g Objeto grafico para dibujar el fondo en BgPanel
	 */
	public void paint(Graphics g){
		solids.paint(g);
		coins.paint(g);
		power_ups.paint(g);
	}
	
	public void initialize(){
		solids.initialize();
	}
	
	public void play(){
		solids.play();
		coins.play();
		power_ups.play();
	}
	
	public void stop(){
		solids.stop();
		coins.stop();
		power_ups.stop();
	}
	
	public void generate(int time){
		ArrayList<Solid>asolids = solids.getSolids();
				
		if(time >= (100000*duration) && asolids.get(asolids.size() - 1).getType() != 3){
			solids.generateGoalSolid();
		}
		else if(asolids.get(asolids.size() - 1).getType() != 3){
			if(time%125 == 0){
				solids.generateSolid();
			}
			
			if(time >= 350){
				if(time%200 == 0){
					coins.generateCoin(asolids);
				}
				if(time%427 == 0){
					power_ups.generateSpike(asolids);
				}
				if(time%600 == 0){
					power_ups.generateBrick(asolids);
				}
				if(time%4000 == 0){
					solids.generateLavaSolid();
				}
				if(time%3000 == 0){
					solids.generatePoisonSolid();
				}
				if(time%800 == 0){
					power_ups.generatePowerUp(asolids);
				}			
			}
		}
	}
	
	public void setFrameSize(int width, int height){
		solids.setFrameSize(width, height);
	}	
}
