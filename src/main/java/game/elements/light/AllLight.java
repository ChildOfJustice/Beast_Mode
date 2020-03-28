package game.elements.light;

import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;

import static core.Core.globalRootNode;

public class AllLight {
    public AllLight (float power, ColorRGBA color){
        AmbientLight al = new AmbientLight();
        al.setColor(color.mult(power));
        globalRootNode.addLight(al);
    }
}
