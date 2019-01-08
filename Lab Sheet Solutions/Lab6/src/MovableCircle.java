
public class MovableCircle implements Movable,Comparable<MovableCircle>{
	private MovablePoint center;
	private int radius;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed,int radius) {
		center = new MovablePoint(x,y,xSpeed,ySpeed);
	}
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		center.y -=  center.ySpeed;
	}
	public void moveDown() {
		// TODO Auto-generated method stub
		center.y += center.ySpeed;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		center.x -= center.xSpeed;
	}

	@Override
	public void moveRight() {
		center.x += center.xSpeed;
	}
	public String toString()
	{
		return "Point at (" + center.x + "," + center.y + ")";
	}
	public int getString()
	{
		return this.radius;
	}
	public int compareTo(MovablePoint theta)
	{
		if(this.radius == theta.getRadius())
		{
			return 0;
		}
		else if(this.radius>theta.radius)
		{
			
		}
	}

}
