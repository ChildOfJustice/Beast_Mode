package core;

import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CylinderShape;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.*;
import com.jme3.renderer.Camera;
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

    public static CurrentPlayer currentPlayer;
    static public MyBox solidMap;
    //^_^

    public static float eps = 0.001f;
    public static int camZoom = 15;
    //^

    Spatial sceneModel;
    public static BulletAppState globalBulletAppState;
    RigidBodyControl landscape;
    CharacterControl playerControl;

    private CharacterControl player;
    private Vector3f walkDirection = new Vector3f();
    private Vector3f camDir = new Vector3f();
    private Vector3f camLeft = new Vector3f();

    Model map;


    public static void main(String[] args) {
        AppSettings settings = new AppSettings(true);
        settings.setTitle("HardCraft");
        app.setSettings(settings);
        app.start();
    }
    public static Vector3f globalSpeed = new Vector3f(0,0,0);
    @Override
    public void simpleInitApp() {

        //Global vars init
        globalAssetManager = this.assetManager;
        globalInputManager = this.inputManager;

        globalBulletAppState = new BulletAppState();
        globalBulletAppState.setDebugEnabled(true);//strange lines are here

        globalRootNode = rootNode;
        //^

        assetManager.registerLocator("assets", FileLocator.class);

        stateManager.attach(globalBulletAppState);

        //Init functions calls
        keyInputSys.setUpKeys();
        //^

        currentPlayer = new CurrentPlayer(new Vector3f(0, 4, 0), "Test\\Player.png", new Vector3f(1, 1, 1));
        currentPlayer.gravity = 0.71f;

        //OBJECTS
        //Model testM = new Model(11,1,1,"textyre.png", "mod.obj");
        //Model testCh = new Model(9,1,1,"chankTex.png", "chank.obj");
        //MyBox testB = new MyBox(10,10,2,"Test\\Texture1.jpg",2,2,2);
        //map = new Model(0,-30,0, "MapTex.png", "Map.obj");
        solidMap = new MyBox(0,-30,0,"Test\\Texture1.jpg",20,2,20);
        //^

        //DirectionalLight sun = new DirectionalLight();
        //sun.setDirection(new Vector3f(0.1f, 0.7f, 1.0f));
        //rootNode.addLight(sun);

        //LIGHT
        //MySun san = new MySun(10 , 30 , 10, White);
        //AllLight globalLight = new AllLight(0.1f, White);
        //FlashLight q = new FlashLight(10,-25,10, White,10,2,30,30);
        //MyLamp s = new MyLamp(10,-25,10, White,30);
        //^

        cam.lookAt(new Vector3f(0, -10, 0),new Vector3f(0, 0f, 0));//second is for the camera rotation
        cam.setLocation(new Vector3f(0, 4, 20));
        flyCam.setMoveSpeed(0f);
        //flyCam.setEnabled(false);
    }

    @Override
    public void onAction(String binding, boolean isPressed, float tpf) {
        keyInputSys.analyzeAction(binding, isPressed);
    }

    @Override
    public void simpleUpdate(float tpf) {




        //System.out.println(cam.getDirection());

        if(currentPlayer.backward) {
            //TODO print player koords!!!!
           // System.out.println("----- Collis? " + results.size() + "-----");

//            for (int i = 0; i < results.size(); i++) {
//                float dist = results.getCollision(i).getDistance();
//                Vector3f pt = results.getCollision(i).getContactPoint();
//                String hit = results.getCollision(i).getGeometry().getName();
//                System.out.println("* Столкновение #" + i);
//                System.out.println(" Shoot in" + hit + " в " + pt + ", на " + dist + " wu.");
//                if (dist < 1.0f) {
//                    System.out.println("SADFASDASDADS");
//                    CurrentPlayer.down = false;
//                }
//            }
        }

        currentPlayer.move();
        currentPlayer.gravitation();
    }

}