package game.elements;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;


import static core.Core.globalAssetManager;

public class WorldObject {
    public static Node globalRootNode;

    public float xBox;
    public float yBox;
    public float zBox;

    public Texture texture;
    public Material mat;
    public Node pivot;

    public WorldObject(float xBoxP,float  yBoxP,float  zBoxP, float x, float y, float z, String fileName) {
        xBox = xBoxP;
        yBox = yBoxP;
        zBox = zBoxP;
        Box box = new Box(xBox, yBox, zBox);
        Geometry geom = new Geometry("geom", box);
//        geom.setQueueBucket(RenderQueue.Bucket.Transparent);
        this.texture = globalAssetManager.loadTexture(fileName);
        mat = new Material(globalAssetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        mat.setTexture("ColorMap", texture);
        geom.setMaterial(mat);
        pivot = new Node("pivot");
        pivot.attachChild(geom);
        geom.setLocalTranslation(new Vector3f(x, y, z));
        globalRootNode.attachChild(pivot);
    }
}
