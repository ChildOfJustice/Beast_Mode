package player.sys;

import com.jme3.math.Vector3f;
import game.elements.MyBox;
import game.elements.WorldObject;

public class CurrentPlayer {
    static public boolean left = false, right = false, up = false, down = false;

    public static WorldObject currentPlayer;

    public CurrentPlayer(Vector3f size, Vector3f pos, String textureFilePath){
//        currentPlayer = new MyBox(size.x,size.y,size.z,pos.x,pos.y,pos.z,textureFilePath);

    }

}
