package Object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_chest extends SupportObject {

    public OBJ_chest(){

        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/object/chest.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
