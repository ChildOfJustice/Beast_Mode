package core;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;


//OUR IMPORTS:
import game.elements.Model;
import game.elements.MyBox;
import game.elements.light.AllLight;
import game.elements.light.FlashLight;
import game.elements.light.MyLamp;
import game.elements.light.MySun;
import game.elements.WorldObject;
import gui.keyInputSys;


import player.sys.CurrentPlayer;

import static com.jme3.math.ColorRGBA.White;
//^

public class Core extends SimpleApplication implements ActionListener {
    // Main static Variables
    static public Core app = new Core();
    public static AssetManager globalAssetManager;
    public static InputManager globalInputManager;
    public static Node globalRootNode;
    public static Camera MyCam;
    //^_^

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
        globalRootNode = rootNode;
        //^

        assetManager.registerLocator("assets", FileLocator.class);

        //Init functions calls
        keyInputSys.setUpKeys();
        //^


        //OBJECT
        Model testM = new Model(11,1,1,"textyre.png", "mod.obj");
        Model testCh = new Model(9,1,1,"chankTex.png", "chank.obj");
        MyBox testB = new MyBox(10,10,2,"Test\\Texture1.jpg",2,2,2);
        Model map = new Model(10,-30,10, "MapTex.png", "Map.obj");
        //^


        //LIGHT
        MySun san = new MySun(10 , 30 , 10, White);
        AllLight globalLight = new AllLight(0.1f, White);
        FlashLight q = new FlashLight(10,-25,10, White,10,2,30,30);
        MyLamp s = new MyLamp(10,-25,10, White,30);
        //^

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