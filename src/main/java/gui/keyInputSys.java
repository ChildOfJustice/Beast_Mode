package gui;

import com.jme3.collision.CollisionResults;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import core.Core;
import org.lwjgl.Sys;
import player.sys.CurrentPlayer;

import static core.Core.globalInputManager;  // <-- !!!  similar to using namespace (!)

public class keyInputSys {

    static public void setUpKeys() {
        globalInputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        globalInputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        globalInputManager.addMapping("Forward", new KeyTrigger(KeyInput.KEY_W));
        globalInputManager.addMapping("Backward", new KeyTrigger(KeyInput.KEY_S));
        globalInputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        globalInputManager.addListener(Core.app, "Left");
        globalInputManager.addListener(Core.app, "Right");
        globalInputManager.addListener(Core.app, "Forward");
        globalInputManager.addListener(Core.app, "Backward");
        globalInputManager.addListener(Core.app, "Jump");
    }

    public static void analyzeAction(String binding, boolean isPressed) {
        switch (binding) {
            case "Left":
                Core.currentPlayer.left = isPressed;
                break;
            case "Right":
                Core.currentPlayer.right = isPressed;
                break;
            case "Forward":
                Core.currentPlayer.forward = isPressed;
                break;
            case "Backward":
                Core.currentPlayer.backward = isPressed;
                break;
            case "Jump":
                Core.currentPlayer.jumpState = true;
                break;
        }
    }
}
