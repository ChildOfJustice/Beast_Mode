package core;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.collision.*;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.scene.Spatial;


//OUR IMPORTS:
import gui.GUI;
import game.elements.WorldObject;
import gui.keyInputSys;
import player.sys.CurrentPlayer;
//^

public class Core extends SimpleApplication implements ActionListener {
    // Main static Variables
    static public Core app = new Core();
    public static AssetManager globalAssetManager;
    public static InputManager globalInputManager;
    //^

    static WorldObject bg;

    Spatial sceneModel;
    BulletAppState bulletAppState;
    RigidBodyControl landscape;
    CharacterControl playerControl;

    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("HardCraft");
        app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        //Global vars init
        globalAssetManager = this.assetManager;
        globalInputManager = this.inputManager;

        WorldObject.globalRootNode = rootNode;
        //^

        assetManager.registerLocator("assets", FileLocator.class);

        //Init functions calls
        keyInputSys.setUpKeys();
        //^








        bg = new WorldObject(50f,6f,1f,0f, 0f, 0f,"Test\\Texture1.jpg" );
        CurrentPlayer mainPlayer = new CurrentPlayer(new Vector3f(1,1,1), new Vector3f(0,0,1), "Test\\Player.png");

        flyCam.setMoveSpeed(50f);
    }

    @Override
    public void onAction(String binding, boolean isPressed, float tpf) {
        keyInputSys.analyzeAction(binding, isPressed);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code

        //bg.pivot.move(0,0.01f *tpf, 0);
    }

}