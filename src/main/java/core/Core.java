package core;//package core;

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
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.Control;
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
import gui.GUI;
import game.elements.WorldObject;
import gui.keyInputSys;

import player.sys.CurrentPlayer;

import static player.sys.CurrentPlayer.playerShape;
//^

public class Core extends SimpleApplication implements ActionListener {
    // Main static Variables
    static public Core app = new Core();
    public static AssetManager globalAssetManager;
    public static InputManager globalInputManager;
    public static Node globalRootNode;
    //^_^

    public static float eps = 0.001f;
    public static int camZoom = 20;
    //^

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
    public static Vector3f globalSpeed = new Vector3f(0,0,0);
    @Override
    public void simpleInitApp() {

        //Global vars init
        globalAssetManager = this.assetManager;
        globalInputManager = this.inputManager;

        globalRootNode = rootNode;
        //^

        assetManager.registerLocator("assets", FileLocator.class);
        bulletAppState = new BulletAppState();
        bulletAppState.setDebugEnabled(true);//strange lines are here
        stateManager.attach(bulletAppState);

        //Init functions calls
        keyInputSys.setUpKeys();
        //^
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));




        //TODO change like in Mark's classes
        WorldObject bg = new WorldObject(50f,100f,1f, 0, 4f, -4f, "Test\\Texture1.jpg");
        sceneModel = bg.geom;
        sceneModel.addControl(new RigidBodyControl(0));
        rootNode.attachChild(sceneModel);
        bulletAppState.getPhysicsSpace().add(sceneModel);
        Model testM = new Model(1,1,1,"textyre.png", "mod.obj");
        MyBox testB = new MyBox("Test\\Texture1.jpg",2,2,2,2,2,2);

        WorldObject floor = new WorldObject(5f,1f,1f, 0, -2f, -1f, "Test\\Texture1.jpg");
        Geometry sceneModel1 = floor.geom;
        sceneModel1.addControl(new RigidBodyControl(0));
        rootNode.attachChild(sceneModel1);
        bulletAppState.getPhysicsSpace().add(sceneModel1);
        //sceneModel.setLocalScale(2f);

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(0.1f, 0.7f, 1.0f));
        rootNode.addLight(sun);


        CurrentPlayer mainPlayer = new CurrentPlayer(new Vector3f(1,1,1), new Vector3f(0,4,-2), "Test\\Player.png");
        // bg = new WorldObject(50f,6f,1f,0f, 0f, 0f,"Test\\Texture1.jpg" );
        //CurrentPlayer mainPlayer = new CurrentPlayer(new Vector3f(1,1,1), new Vector3f(0,0,1), "Test\\Player.png");

        //CapsuleCollisionShape sceneShape = new CapsuleCollisionShape(1f, 1f, 1);
        //CollisionShape sceneShape = new BoxShape(new javax.vecmath.Vector3f(1, 1, 1));
        //CharacterControl playerShape = new CharacterControl(sceneShape, 0.15f);
        //playerShape.setSpatial(CurrentPlayer.actualObject.geom);
        CurrentPlayer.actualObject.geom.addControl(playerShape);
        bulletAppState.getPhysicsSpace().add(playerShape);

        flyCam.setMoveSpeed(0f);
    }

    @Override
    public void onAction(String binding, boolean isPressed, float tpf) {
        keyInputSys.analyzeAction(binding, isPressed);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO sometimes moving is very strange, we need to consider our way to control cube, not with only coords handling
        Vector3f tempV = playerShape.getLinearVelocity();

        CurrentPlayer.move();
        cam.setLocation(new Vector3f(playerShape.getPhysicsLocation().x, playerShape.getPhysicsLocation().y, playerShape.getPhysicsLocation().z+camZoom));

        globalSpeed.y = tempV.y;

        if(CurrentPlayer.jumpState) CurrentPlayer.jump();

        playerShape.setLinearVelocity(globalSpeed);
        //playerShape.setGravity(new Vector3f(0, -100f, 0));
    }
}