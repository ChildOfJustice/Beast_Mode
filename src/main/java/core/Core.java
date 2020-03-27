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
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.*;
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

import map.MapSys;
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
        // Вычислить результаты обнаружения


        //MapSys.initMap();
        //^
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));



        //TODO change like in Mark's classes
        //WorldObject bg = new MyBox("Test\\Texture1.jpg", 0, 4f, -4f, 50f,100f,1f, 0);
        //Model testM = new Model(1,1,1,"textyre.png", "mod.obj");
        //MyBox testB = new MyBox("Test\\Texture1.jpg",2,2,2,2,2,2);

        //WorldObject floor = new MyBox("Test\\Texture1.jpg",0, -2f, -1f, 5f,1f,1f, 0);
        //sceneModel.setLocalScale(2f);

//        DirectionalLight sun = new DirectionalLight();
//        sun.setDirection(new Vector3f(100f, 210f, 100f));
//        rootNode.addLight(sun);
//        PointLight lamp_light = new PointLight();
//        lamp_light.setColor(ColorRGBA.White);
//        lamp_light.setRadius(100f);
//        lamp_light.setPosition(new Vector3f(0,10,4));
//        rootNode.addLight(lamp_light);


        CurrentPlayer mainPlayer = new CurrentPlayer(new Vector3f(1,1,1), new Vector3f(0,4,2), "Test\\Player.png", 2);




//        CollisionResults results = new CollisionResults();
//        CurrentPlayer.actualObject.pivot.collideWith(b, results);
//        System.out.println("Number of Collisions between" +
//                a.getName()+ " and " + b.getName() + ": " + results.size());
//        // Используйте результаты
//        if (results.size() > 0) {
//            // Как реагировать при обнаружении столкновения
//            CollisionResult closest  = results.getClosestCollision();
//            System.out.println("What was hit? " + closest.getGeometry().getName() );
//            System.out.println("Where was it hit? " + closest.getContactPoint() );
//            System.out.println("Distance? " + closest.getDistance() );
//        } else {
//            // Как реагировать, когда не произошло столкновение
//        }

        // bg = new WorldObject(50f,6f,1f,0f, 0f, 0f,"Test\\Texture1.jpg" );
        //CurrentPlayer mainPlayer = new CurrentPlayer(new Vector3f(1,1,1), new Vector3f(0,0,1), "Test\\Player.png");
        
        //CapsuleCollisionShape sceneShape = new CapsuleCollisionShape(1f, 1f, 1);
        //CollisionShape sceneShape = new BoxShape(new javax.vecmath.Vector3f(1, 1, 1));
        //CharacterControl playerShape = new CharacterControl(sceneShape, 0.15f);
        //playerShape.setSpatial(CurrentPlayer.actualObject.geom);
        //CurrentPlayer.actualObject.geom.addControl(playerShape);
        //globalBulletAppState.getPhysicsSpace().add(playerShape);

//        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
//        player = new CharacterControl(capsuleShape, 0.05f);
//        player.setJumpSpeed(20);
//        player.setFallSpeed(30);
//
//        player.setGravity(30f);
//        player.setPhysicsLocation(new Vector3f(0, 10, 0));
//
//        globalBulletAppState.getPhysicsSpace().add(player);

        flyCam.setMoveSpeed(50f);
    }

    @Override
    public void onAction(String binding, boolean isPressed, float tpf) {
        keyInputSys.analyzeAction(binding, isPressed);
    }

    @Override
    public void simpleUpdate(float tpf) {
        // 1. Сбросим список результатов.
        CollisionResults results = new CollisionResults();
        // 2. Направим луч от точки расположения камеры по направлению камеры.
        Ray ray = new Ray(cam.getLocation(), cam.getDirection());
        // 3. Соберём пересечения между Ray и Shootables в списке результатов.
        // НЕ проверяйте столкновения с корневым узлом, потому что все столкновения будут попадать в skybox!
        //Всегда создавайте отдельный узел для объектов, с которыми вы хотите реализовать столкновения.
        CurrentPlayer.actualObject.pivot.collideWith(ray, results);
        // 4. Распечатаем результат.
        System.out.println("----- Collis? " + results.size() + "-----");
        for (int i = 0; i < results.size(); i++) {
            // Для каждого попадания мы узнаем название геометрии, место попадания и расстояние.
            float dist = results.getCollision(i).getDistance();
            Vector3f pt = results.getCollision(i).getContactPoint();
            String hit = results.getCollision(i).getGeometry().getName();
            System.out.println("* Столкновение #" + i);
            System.out.println("  Вы стреляли в " + hit + " в " + pt + ", на расстояние " + dist + " wu.");
        }

//        camDir.set(cam.getDirection()).multLocal(0.6f);
//        camLeft.set(cam.getLeft()).multLocal(0.4f);
//        walkDirection.set(0, 0, 0);
//        if (CurrentPlayer.left) {
//            walkDirection.addLocal(camLeft);
//        }
//        if (CurrentPlayer.right) {
//            walkDirection.addLocal(camLeft.negate());
//        }
//        if (CurrentPlayer.up) {
//            walkDirection.addLocal(camDir);
//        }
//        if (CurrentPlayer.down) {
//            walkDirection.addLocal(camDir.negate());
//        }
//        player.setWalkDirection(walkDirection);
//        cam.setLocation(player.getPhysicsLocation());
        //playerShape.setGravity(new Vector3f(0, -100f, 0));
    }
}