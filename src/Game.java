import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener{
    private Board board;

    private Game(){
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        setTitle("Platformer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board=new Board();
        add(board);
        addKeyListener(this);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[]args){new Game();}

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e) {
        setKeys(e,true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        setKeys(e,false);

        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            Data.setMenu(Data.MENU_GAME);
            System.out.println(Data.getMenu());
        }
    }

    private void setKeys(KeyEvent e,boolean bool){
        if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)
            Data.setRight(bool);
        if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)
            Data.setLeft(bool);
        if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W)
            Data.setUp(bool);
        if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S)
            Data.setDown(bool);
    }
}
