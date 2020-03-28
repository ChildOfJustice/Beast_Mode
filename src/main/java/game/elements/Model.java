package game.elements;

import com.bulletphysics.collision.shapes.BoxShape;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

import static core.Core.*;

public class Model extends WorldObject {
    final public RigidBodyControl bodyControl = null;

    public Model(float x, float y, float z, String fileTexture,String fileModel) {

        spatial = globalAssetManager.loadModel(fileModel);
        Material tex = new Material(globalAssetManager, "Common/MatDefs/Light/Lighting.j3md");
        tex.setTexture("DiffuseMap", globalAssetManager.loadTexture(fileTexture));
        spatial.setMaterial(tex);
        globalRootNode.attachChild(spatial);
        spatial.move(x, y, z);

//        shape = new BoxCollisionShape(new Vector3f(10,2,10));
//        bodyControl = new RigidBodyControl(shape, 0);
//        pivot = new Node("AAAAA!!!!!");
//        spatial = pivot;
//        spatial.addControl(bodyControl);
//        globalRootNode.attachChild(pivot);
//        globalRootNode.attachChild(spatial);

//        Box box = new Box(10,2,10);
//        geom = new Geometry("geom", box);
////      geom.setQueueBucket(RenderQueue.Bucket.Transparent);
//        this.texture = globalAssetManager.loadTexture("block1.png");
//        mat = new Material(globalAssetManager, "Common/MatDefs/Misc/Unshaded.j3md");
////      mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
//        mat.setTexture("ColorMap", texture);
//        geom.setMaterial(mat);
//        pivot = new Node("AAAAA!!!!!");
//        pivot.attachChild(geom);
//        geom.setLocalTranslation(new Vector3f(x, y, z));
//        globalRootNode.attachChild(pivot);
    }
//    Geometry geom = new Geometry("geom", box);
////        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
//        this.texture = globalAssetManager.loadTexture(fileTextureName);
//    mat = new Material(globalAssetManager, "Common/MatDefs/Misc/Unshaded.j3md");
////        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
//        mat.setTexture("ColorMap", texture);
//        geom.setMaterial(mat);
//    pivot = new Node("pivot");
//        pivot.attachChild(geom);
//        geom.setLocalTranslation(new Vector3f(x, y, z));
//        globalRootNode.attachChild(pivot);

}
