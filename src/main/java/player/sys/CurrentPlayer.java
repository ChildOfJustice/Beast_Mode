package player.sys;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import game.elements.MyBox;
import core.Core;
import game.elements.WorldObject;

public class CurrentPlayer {
    static public int left = 0, right = 0, up = 0, down = 0;
    public static boolean jumpState = false;
    public static boolean ableToJump = true;

    public static float v;

    static public CollisionShape sceneShape = new BoxCollisionShape(new Vector3f(1, 1, 1));
    static public RigidBodyControl playerShape;

    public static WorldObject actualObject;
    public static int jumpTimer;
    public static float jumpSpeed;
    public static int maxJumpTime;

    public CurrentPlayer(Vector3f size, Vector3f pos, String textureFilePath){
//        currentPlayer = new MyBox(size.x,size.y,size.z,pos.x,pos.y,pos.z,textureFilePath);

        v = 1.5f;
        jumpSpeed = 10f;
        maxJumpTime = 100;

        actualObject = new WorldObject(size.x,size.y,size.z,pos.x,pos.y,pos.z,textureFilePath);
        playerShape = new RigidBodyControl(sceneShape,2000.1f);
    }

    public static void move() {
        if(CurrentPlayer.left == 1) {
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.x -= CurrentPlayer.v;
            CurrentPlayer.left = 0;
        } else if(CurrentPlayer.left == 2){
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.x += CurrentPlayer.v;
            CurrentPlayer.left = 0;
        }
        if(CurrentPlayer.right == 1) {
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.x += CurrentPlayer.v;
            CurrentPlayer.right = 0;
        } else if(CurrentPlayer.right == 2){
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.x -= CurrentPlayer.v;
            CurrentPlayer.right = 0;
        }


        if(CurrentPlayer.down == 1) {
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.z += CurrentPlayer.v;
            CurrentPlayer.down = 0;
        } else if(CurrentPlayer.down == 2){
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.z -= CurrentPlayer.v;
            CurrentPlayer.down = 0;
        }
        if(CurrentPlayer.up == 1) {
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.z -= CurrentPlayer.v;
            CurrentPlayer.up = 0;
        } else if(CurrentPlayer.up == 2){
            Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.z += CurrentPlayer.v;
            CurrentPlayer.up = 0;
        }
    }

    public static void jump() {
        Core.globalSpeed = playerShape.getLinearVelocity();
        Core.globalSpeed.y = CurrentPlayer.jumpSpeed;
        CurrentPlayer.jumpTimer++;
        if(CurrentPlayer.jumpTimer >= CurrentPlayer.maxJumpTime){
            CurrentPlayer.jumpState = false;
            CurrentPlayer.jumpTimer = 0;
        }
    }
}
