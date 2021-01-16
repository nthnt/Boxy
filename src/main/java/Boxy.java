import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Boxy extends Canvas implements Runnable{
    public static final int WIDTH = 650;
    public static final int LENGTH = WIDTH / 12 * 8;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    
    public Boxy() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        
        new Window (WIDTH, LENGTH, "Boxy", this);

        handler.addObj(new Player(100, 100, ID.Player));
    }
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() { //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if(running) {
                render();
            }
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer+= 1000;
                frames = 0;
            }
                
        }
    }
    
    private void tick() {
        handler.tick();
    }
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, LENGTH);
        
        handler.render(g);
        
        g.dispose();
        bs.show();
    }
    
    
    public static void main(String[] args) {
        new Boxy();
    }
}
