package game.elements.light;

import com.jme3.light.PointLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;

import static core.Core.globalRootNode;

public class MyLamp {
    public MyLamp(float x, float y, float z, ColorRGBA color, float radius)
        {
            PointLight lamp_light = new PointLight();
        lamp_light.setColor(color);
        lamp_light.setRadius(radius);
        lamp_light.setPosition(new Vector3f(x,y,z));
        globalRootNode.addLight(lamp_light);


    }
}
