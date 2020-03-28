package player.sys;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import game.elements.MyBox;
import core.Core;
import game.elements.WorldObject;

public class CurrentPlayer {
    static public boolean left = false, right = false, up = false, down = false;
    public static boolean jumpState = false;
    public static boolean ableToJump = true;

    public static float v;


    static public RigidBodyControl playerShape;

    public static MyBox actualObject;
    public static int jumpTimer;
    public static float jumpSpeed;
    public static int maxJumpTime;

    public CurrentPlayer(Vector3f size, Vector3f pos, String textureFilePath){
//        currentPlayer = new MyBox(size.x,size.y,size.z,pos.x,pos.y,pos.z,textureFilePath);

        v = 1.5f;
        jumpSpeed = 10f;
        maxJumpTime = 100;

        actualObject = new MyBox(pos.x,pos.y,pos.z,textureFilePath,size.x,size.y,size.z);
        //playerShape = actualObject.bodyControl;
    }

    public static void move() {
        if(CurrentPlayer.right){
            //Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.x = CurrentPlayer.v;
            System.out.println(Core.globalSpeed.x );
        } else {
            Core.globalSpeed.x = 0;
        }
        if(CurrentPlayer.left){
            //Core.globalSpeed = playerShape.getLinearVelocity();
            Core.globalSpeed.x = -CurrentPlayer.v;
        } else {
            Core.globalSpeed.x = 0;
        }

//        if(CurrentPlayer.left == 1) {
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.x -= CurrentPlayer.v;
//            CurrentPlayer.left = 0;
//        } else if(CurrentPlayer.left == 2){
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.x += CurrentPlayer.v;
//            CurrentPlayer.left = 0;
//        }
//        if(CurrentPlayer.right == 1) {
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.x += CurrentPlayer.v;
//            CurrentPlayer.right = 0;
//        } else if(CurrentPlayer.right == 2){
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.x -= CurrentPlayer.v;
//            CurrentPlayer.right = 0;
//        }
//
//
//        if(CurrentPlayer.down == 1) {
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.z += CurrentPlayer.v;
//            CurrentPlayer.down = 0;
//        } else if(CurrentPlayer.down == 2){
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.z -= CurrentPlayer.v;
//            CurrentPlayer.down = 0;
//        }
//        if(CurrentPlayer.up == 1) {
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.z -= CurrentPlayer.v;
//            CurrentPlayer.up = 0;
//        } else if(CurrentPlayer.up == 2){
//            Core.globalSpeed = playerShape.getLinearVelocity();
//            Core.globalSpeed.z += CurrentPlayer.v;
//            CurrentPlayer.up = 0;
//        }
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
