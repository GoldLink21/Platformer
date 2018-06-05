public class Data {

    public enum Menus{
        MAIN,GAME,END,PAUSE
    }

    final static int BOARD_SIZE=500;

    private static Menus menu=Menus.MAIN;

    private static boolean right,left,up,down,space;

    private final static boolean debug=true;
    
    private static int x=0,y=0;

    public static void setDown(boolean down) {Data.down = down;}
    public static void setRight(boolean right) {Data.right = right;}
    public static void setLeft(boolean left) {Data.left = left;}
    public static void setUp(boolean up) {Data.up = up;}
    public static void setSpace(boolean space){Data.space = space;}

    public static void setMenu(Menus val){menu=val;}
    
    public static void setX(int num){x=num;}
    public static void setY(int num){y=num;}
    public static void changeX(int dx){x+=dx;}
    public static void changeY(int dy){y+=dy;}

    public static boolean isRight() {return right;}
    public static boolean isLeft() {return left;}
    public static boolean isUp() {return up;}
    public static boolean isDown() {return down;}
    public static boolean isSpace(){return space;}

    public static Menus getMenu(){return menu;}
    public static int getX(){return x;}
    public static int getY(){return y;}

    public static boolean isMainMenu(){return menu==Menus.MAIN;}
    public static boolean isGamePlay(){return menu==Menus.GAME;}
    public static boolean isGamePaused(){return menu==Menus.PAUSE;}
    public static boolean isGameEnd(){return menu==Menus.END;}

    public static void debugPrint(String s){
        if(debug)
            System.out.println(s);
    }
}
