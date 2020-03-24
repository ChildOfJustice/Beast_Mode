package game.elements;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
import sun.jvm.hotspot.opto.RootNode;


import static core.Core.globalAssetManager;
import static core.Core.globalRootNode;

public class WorldObject {
    public Geometry geom;
    public Texture texture;
    public Material mat;
    public Node pivot;
    public Spatial spatial;



}
