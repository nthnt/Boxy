import java.util.LinkedList;
import java.awt.Graphics;

public class Handler { //will handle and render each object individually
    LinkedList<gameObject> obj = new LinkedList<gameObject>(); //what is a linked list?
    
    public void tick() {
        for(int i = 0; i < obj.size(); i++) { //loops through all objects in linked list
           gameObject tempObj = obj.get(i);
           
           tempObj.tick();
        }
    }
    
    public void render(Graphics g){ //wtf does this do? I think this renders the graphics
        for(int i = 0; i < obj.size(); i++) { //loops through all objects in linked list
           gameObject tempObj = obj.get(i);
           
           tempObj.render(g);
        }
    }
    
    public void addObj(gameObject obj) { //adds obj to linked list
        this.obj.add(obj);
    }
    
    public void removeObj(gameObject obj) { //removes obj to linked list
        this.obj.remove(obj);
    }
}
