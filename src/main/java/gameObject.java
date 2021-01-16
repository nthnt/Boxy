import java.awt.Graphics;

public abstract class gameObject {
    protected int x,y;
    protected ID id;
    protected int velX, velY;
    
    public gameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setId(ID id) {
        this.id = id;
    }
    
    public void setVelX(int velX) {
        this.velX = velX;
    }
    
    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public ID getID() {
        return this.id;
    }
    
    public int getVelX() {
        return this.velX;
    }
    
    public int getVelY() {
        return this.velY;
    }
}
