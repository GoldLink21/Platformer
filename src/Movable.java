import java.awt.Graphics;

public interface Movable {
    void paint(Graphics g);
    void move();
    void setPosition(int x,int y);
}
