import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{

    private static ArrayList<Entity>entities=new ArrayList<>();
    private static ArrayList<Entity>toAdd=new ArrayList<>();

    private boolean first=false;

    Board(){
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(Data.BOARD_SIZE,Data.BOARD_SIZE));
        newGame();
    }

    private void newGame(){
        Timer timer=new Timer(1000/60,this);
        timer.start();
        addEntity(new Player(0,0));
    }

    private void addEntities(){
        while(toAdd.size()>0)
            entities.add(toAdd.remove(0));
    }

    private void removeEntities(){
        int i=0;
        while(i<entities.size()){
            if(entities.get(i).toRemove())entities.remove(i);
            else i++;
        }
    }

    public static void addEntity(Entity e){toAdd.add(e);}

    public static ArrayList<Entity> getEntities(){return entities;}

    private void paintEntities(Graphics g){
        if(Data.isGamePlay()) {
            for (Entity entity : entities) {
                entity.move();
                entity.paint(g);
            }

            removeEntities();
            addEntities();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        paintEntities(g);

        printAllText(g);
    }

    private final Font titleFont=new Font("TimesRoman",Font.BOLD,28),
            subtitleFont=new Font("TimesRoman",Font.BOLD,16);

    private void printAllText(Graphics g){
        if(Data.isMainMenu()){
            printCentered("Platformer",titleFont,1/3.0,g);
        }
    }

    private void printSimpleString(String s,int width,int YPos,Graphics g){
        g.drawString(s,(width/2-(int)(g.getFontMetrics().getStringBounds(s,g).getWidth())/2),YPos);
    }


    private void printCentered(String s,Font font,double yPos,Graphics g){
        //Modified version of printSimpleString for only printing in the center of the screen
        g.setFont(font);
        g.setColor(Color.BLACK);
        printSimpleString(s,getWidth(),(int)(getHeight()*yPos),g);
    }

    private void printCentered(String s,Font font,double yPos,Color color,Graphics g){
        //Modified version of printSimpleString for only printing in the center of the screen
        g.setFont(font);
        g.setColor(color);
        printSimpleString(s,getWidth(),(int)(getHeight()*yPos),g);
    }
}
