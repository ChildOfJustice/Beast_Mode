package game.elements;

import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

import static core.Core.globalAssetManager;
import static core.Core.globalRootNode;

public class Model extends WorldObject {

    public Model(float x, float y, float z, String fileTexture,String fileModel) {

        Spatial model = globalAssetManager.loadModel(fileModel);
        Material tex = new Material(globalAssetManager, "Common/MatDefs/Light/Lighting.j3md");
        tex.setTexture("DiffuseMap", globalAssetManager.loadTexture(fileTexture));
        model.setMaterial(tex);
        globalRootNode.attachChild(model);
        model.move(x, y, z);
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
