package gui;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import core.Core;
import org.lwjgl.Sys;
import player.sys.CurrentPlayer;

import static core.Core.globalInputManager;  // <-- !!!  similar to using namespace (!)

public class keyInputSys {

    static public void setUpKeys() {
        globalInputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        globalInputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        globalInputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        globalInputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
        globalInputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        globalInputManager.addListener(Core.app, "Left");
        globalInputManager.addListener(Core.app, "Right");
        globalInputManager.addListener(Core.app, "Up");
        globalInputManager.addListener(Core.app, "Down");
        globalInputManager.addListener(Core.app, "Jump");
    }

    public static void analyzeAction(String binding, boolean isPressed) {
        switch (binding) {
            case "Left":
                CurrentPlayer.left = isPressed;
                break;
            case "Right":
                CurrentPlayer.right = isPressed;
                break;
            case "Up":
                CurrentPlayer.up = isPressed;
                break;
            case "Down":
                CurrentPlayer.down = isPressed;
                break;
            case "Jump":
                CurrentPlayer.jumpState = true;
                break;
        }
    }
}
