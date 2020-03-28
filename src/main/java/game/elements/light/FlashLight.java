package game.elements.light;

import com.jme3.light.SpotLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;

import static core.Core.MyCam;
import static core.Core.globalRootNode;

public class FlashLight {
    public FlashLight(float x, float y, float z, ColorRGBA color, float distance, float power, float InnerAngle, float OuterAngle){

        SpotLight spot = new SpotLight();
        spot.setSpotRange(distance);                           // distance
        spot.setSpotInnerAngle(InnerAngle * FastMath.DEG_TO_RAD); // inner light cone (central beam)
        spot.setSpotOuterAngle(OuterAngle * FastMath.DEG_TO_RAD); // outer light cone (edge of the light)
        spot.setColor(color.mult(power));         // light color
        spot.setPosition(new Vector3f(x,y,z));
        //spot.setPosition(MyCam.getLocation());               // shine from camera loc
        //spot.setDirection(MyCam.getDirection());
        globalRootNode.addLight(spot);
    }
}
