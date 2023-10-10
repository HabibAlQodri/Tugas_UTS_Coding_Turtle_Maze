package Main;

import Object.OBJ_key;
import Object.OBJ_Door;
import Object.OBJ_chest;

public class AssetCenter {

    Main.GamePanel gp;

    public AssetCenter(Main.GamePanel gp){
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_key();
        gp.obj[0].worldX = 25 * gp.tileSize;
        gp.obj[0].worldY = 42 * gp.tileSize;

        gp.obj[1] = new OBJ_chest();
        gp.obj[1].worldX = 30 * gp.tileSize;
        gp.obj[1].worldY = 25 * gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 27 * gp.tileSize;
        gp.obj[2].worldY = 23 * gp.tileSize;
    }
}
