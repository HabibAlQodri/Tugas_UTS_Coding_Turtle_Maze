package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_key extends SupportObject {

    public OBJ_key(){

        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/object/key.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
