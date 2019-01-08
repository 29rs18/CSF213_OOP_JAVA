
public class MovablePoint implements Movable,Comparator<MovablePoint>{
	int x,y,xSpeed,ySpeed;

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		super();
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		this.y -=this.ySpeed; 
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		this.y += this.ySpeed;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		this.x -= this.xSpeed;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		this.x += this.xSpeed;
	}
	public String toString()
	{
		return "Point at (" + x + "," + y + ")";
	}

	

}
