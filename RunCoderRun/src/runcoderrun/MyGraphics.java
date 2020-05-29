package runcoderrun;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MyGraphics {
	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;
	protected int height;
	protected int width;
	protected int hf;
	protected int wf;
	protected Color color;
	protected Image image;

	public MyGraphics(){
		x1 = 0;
		y1 = 0;
		width = 50;
		height = 20;
		x2 = x1 + width;
		y2 = y1 + height;
		color = new Color(255,69,0);
	}
	
	public MyGraphics(int x1, int y1, int width, int height) {
		this.x1 = x1;
		this.y1 = y1;
		this.width = width;
		this.height = height;
		this.x2 = x1 + width;
		this.y2 = y1 + height;
		color = new Color(255,69,0);
	}

	public void setX1(int x1){
		this.x1 = x1;
		this.x2 = x1 + width;
	}

	public void setY1(int y1){
		this.y1 = y1;
		this.y2 = y1 + height;
	}
	
	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}
	
	
	public void setWidth(int width){
		this.width = width;
		this.x2 = x1 + width;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setHeight(int height){
		this.height = height;
		this.y2 = y1 + height;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setImageByName(String name){
		image = new ImageIcon(name).getImage();
	}
	
	public void setFrameSize(int width, int height){
		hf = height;
		wf = width;
	}
	
	public boolean hasCollision(MyGraphics mg, int x1, int y1, int x2, int y2){
		boolean collision = false;
		
		if(mg != null){
			if(x2 > mg.getX1() && x1 < mg.getX2() && y2 > mg.getY1() && y1 < mg.getY2()){
				collision = true;
			}
		}
		
		return collision;
	}
	
	public String toString(){
		String str = "x1: " + x1 + ";y1: " + y1 + ";x2: " + x2 + ";y2: " + y2 + ";h: " + height + ";w: " + width;
		
		return str;
	}
}

