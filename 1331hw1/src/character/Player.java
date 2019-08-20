package character;

public class Player {
	private int health;
	private int positionX;
	private int positionY;
	private int size;
	private String name;
	
	{
		health = (int) (Math.random() * 20);
	}
	
	public static void main (String[] args) {
		Player mira = new Player(10, 10, 400, "Mira");
		System.out.println(mira.getHealth());
		Player krus = new Player(100, 0, 0, 10, "Krus");
		System.out.println(krus.getHealth());
		Player.Weapon miraWeapon = mira.new Weapon(11);
		miraWeapon.damagePlayer(krus);
		System.out.println(krus.getHealth());
	}
	
	public Player() {
		this(100, 0, 0, 40, "White Bread");
	}
	public Player(String name) {
		this(100, 0, 0, 40, name);
	}
	public Player(int health, int positionX, int positionY, int size, String name) {
		this.health = health;
		this.positionX = positionX;
		this.positionY = positionY;
		this.size = size;
		this.name = name;
	}
	public Player(int positionX, int positionY, int size, String name) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.size = size;
		this.name = name;
	}
	
	private class Weapon {
		int damage;
		
		Weapon(int damage) {
			this.damage = damage;
		}
		
		void damagePlayer(Player p) {
			p.setHealth(p.getHealth() - damage);
		}
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
}
