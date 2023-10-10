package Main;
import entity.Player;
import tile.TileManager;
import Object.SupportObject;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen setting
    public final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth =  tileSize * maxScreenCol; // 769 pixels
    public final int screenHeight =  tileSize * maxScreenRow; // 576 pixels

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // Frame Rate per Second (FPS)
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public collisionChecker cChecker = new collisionChecker(this);
    public AssetCenter aSetCenter = new AssetCenter(this);
    public Player player = new Player(this,keyH);
    public SupportObject obj [] = new SupportObject[10];

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void  setupGame (){
        aSetCenter.setObject();
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
//    public void run() {
//
//        double drawInterval = 1000000000/FPS;
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//
//        while (gameThread != null){
//
//                update();
//
//                repaint();
//
//                try {
//
//                    double remainingTime = nextDrawTime - System.nanoTime();
//                        remainingTime = remainingTime/1000000;
//
//                        if(remainingTime < 0){
//                            remainingTime = 0;
//                        }
//
//                        Thread.sleep((long) remainingTime);
//                        nextDrawTime += drawInterval;
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                }
//
//        }
//
//    }

    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

//            if(timer >= 1000000000){
//
//                System.out.println("FPS:" + drawCount);
//                drawCount = 0;
//                timer = 0;

        }
    }


    public void update(){

        player.update();

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);

        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        player.draw(g2);

        g2.dispose();

    }
}