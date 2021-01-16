import java.awt.Graphics;
import java.awt.Color;

public class Player extends gameObject{
    public Player(int x, int y, ID id) {
        super(x,y,id); //please review abstract classes
    }
    
    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        if(y<=0 || y > Boxy.LENGTH - 100) {
        velY = 0;
        }
        
        if(x<=0 || x > Boxy.LENGTH - 100) {
        velX = 0;
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,30,30);
    }
}
