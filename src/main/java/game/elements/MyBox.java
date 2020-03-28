package game.elements;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

import static core.Core.*;

public class MyBox extends WorldObject  {
    public MyBox(float x, float y, float z,String TextureFileName,float width, float height, float depth) {
        Box box = new Box(width, height, depth);
        geom = new Geometry("geom", box);
//      geom.setQueueBucket(RenderQueue.Bucket.Transparent);
        this.texture = globalAssetManager.loadTexture(TextureFileName);
        mat = new Material(globalAssetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        mat.setTexture("ColorMap", texture);
        geom.setMaterial(mat);
        pivot = new Node("pivot");
        pivot.attachChild(geom);
        geom.setLocalTranslation(new Vector3f(x, y, z));
        globalRootNode.attachChild(pivot);
    }

}
