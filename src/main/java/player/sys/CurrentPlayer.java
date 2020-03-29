package player.sys;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import game.elements.MyBox;
import core.Core;
import game.elements.WorldObject;

public class CurrentPlayer {
    public boolean left = false, right = false, forward = false, backward = false;
    public boolean jumpState = false;
    public boolean ableToJump = true;

    public float v;


    //static public RigidBodyControl playerShape;

    public MyBox actualObject;
    public int jumpTimer;
    public float jumpSpeed;
    public int maxJumpTime;
    public float gravity;

    public CurrentPlayer(Vector3f pos, String textureFilePath, Vector3f size){
//        currentPlayer = new MyBox(size.x,size.y,size.z,pos.x,pos.y,pos.z,textureFilePath);

        v = 0.5f;
        jumpSpeed = 10f;
        maxJumpTime = 100;

        actualObject = new MyBox(pos.x,pos.y,pos.z,textureFilePath,size.x,size.y,size.z);
        //playerShape = actualObject.bodyControl;
    }


    public void gravitation(){
        boolean fall = true;

        CollisionResults results = new CollisionResults();
        //CurrentPlayer.actualObject.pivot.getLocalTranslation(), new Vector3f(0, -1, 0)
        Ray ray = new Ray(Core.currentPlayer.actualObject.geom.getLocalTranslation(), new Vector3f(0f, -1f, 0f));
        Core.solidMap.geom.collideWith(ray, results);
        if(results.size() > 0) {
            float dist = results.getCollision(0).getDistance();
            //Vector3f pt = results.getCollision(0).getContactPoint();
            //String hit = results.getCollision(0).getGeometry().getName();
            //System.out.println("* Столкновение #" + 0);
            //System.out.println(" Shoot in" + hit + " в " + pt + ", на " + dist + " wu.");
            if (dist < 1.0f) {
                fall = false;
            }
        }
        if(fall) moveToLocation(0, -gravity, 0);
    }

    private void moveToLocation(float x, float y, float z){
        actualObject.geom.setLocalTranslation(actualObject.geom.getLocalTranslation().x + x, actualObject.geom.getLocalTranslation().y + y, actualObject.geom.getLocalTranslation().z + z);
    }

    public void move() {
        if(backward){
            //blaaaah  chto za bred s move()
            //actualObject.pivot.move(new Vector3f(actualObject.pivot.getLocalTranslation().x, actualObject.pivot.getLocalTranslation().y-v, actualObject.pivot.getLocalTranslation().z));
            moveToLocation(0, 0, v);
        }

        if(forward)moveToLocation(0, 0, -v);
        if(right)moveToLocation(v, 0, 0);
        if(left)moveToLocation(-v, 0, 0);


    }

//    public static void jump() {
//        Core.globalSpeed = playerShape.getLinearVelocity();
//        Core.globalSpeed.y = CurrentPlayer.jumpSpeed;
//        CurrentPlayer.jumpTimer++;
//        if(CurrentPlayer.jumpTimer >= CurrentPlayer.maxJumpTime){
//            CurrentPlayer.jumpState = false;
//            CurrentPlayer.jumpTimer = 0;
//        }
//    }
}
