import Engine.*;
import Engine.Characters.*;
import Engine.Object;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    //MODULE SCRIPTS---------------------------------------------------------------------------
    private MouseInput mouseInput;
    // EasyCreateObject elips = new EasyCreateObject();
//    EasyCreateObject Spherex = new EasyCreateObject();
//    EasyCreateObject Sphere2x = new EasyCreateObject();

    boolean pressed = false;

    LinkKirby Kirby = new LinkKirby();

    Awoofy awoofy = new Awoofy();

    BroomHatter broomHatter = new BroomHatter();

    Lolipop lolipop = new Lolipop();

    Camera cam = new Camera();

    int Scene = 0;

    //MODULE SCRIPT BOLEH DIRUBAH---------------------------------------------------
    private Window window =
            new Window
                    (1280, 720, "Kirby eating pepos");
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    //Deklarasi Array---------------------------------------------------
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();


    // Inisialisasi Model disini

    public void createBaseland() {
        EasyCreateObject plate = new EasyCreateObject();
        plate.Box(objects, 200, 50, 200);
        plate.Objectnya.scaleObject(100f, 5f, 100f);
        plate.Objectnya.translateObject(0f, -0.35f, 0f);
    }

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_LINE_SMOOTH);
        //glShadeModel(GL_SMOOTH);
        mouseInput = window.getMouseInput();
        // Render model lewat easyCreateObject
        //elips.Sphere(objects, 80, 55, 55);  //Contoh Pake easyCreate
        //Spherex.Sphere(objects, 155, 155, 155, 155/255f, 191/255f,11/255f);  //Contoh Pake easyCreate

        Kirby.create();
        Kirby.MoveContents(objects);

        awoofy.create();
        awoofy.MoveContents(objects);

        broomHatter.create();
        broomHatter.MoveContents(objects);

        lolipop.create();
        lolipop.MoveContents(objects);

        objects.get(0).translateObject(0.0f, 0.0f, 0f); //Kirby
        objects.get(1).translateObject(-0.69f, 0.0f, 0f); //Awoofy
        objects.get(2).translateObject(0.69f, 0.0f, 0f); //BroomHatter
        objects.get(3).translateObject(0.0f, -0.2f, -0.3f); //Lolipop

        createBaseland();
        //Cam initialize
        cam.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
        cam.setPosition(0f, 0f, -3f);
    }

    public void resetAnims() {
        objects.clear();

        Kirby = new LinkKirby();
        awoofy = new Awoofy();
        broomHatter = new BroomHatter();
        lolipop = new Lolipop();

        Kirby.create();
        Kirby.MoveContents(objects);
        awoofy.create();
        awoofy.MoveContents(objects);
        broomHatter.create();
        broomHatter.MoveContents(objects);
        lolipop.create();
        lolipop.MoveContents(objects);
/*
        objects.get(0).translateObject(0.0f,0.0f,0f); //Kirby
        objects.get(1).translateObject(-0.69f,0.0f,0f); //Awoofy
        objects.get(2).translateObject(0.69f,0.0f,0f); //BroomHatter
        objects.get(3).translateObject(0.0f, -0.2f,-0.3f); //Lolipop

 */
        createBaseland();
    }
    public void allChar(){
        objects.clear();

        Kirby = new LinkKirby();
        awoofy = new Awoofy();
        broomHatter = new BroomHatter();

        Kirby.create();
        Kirby.MoveContents(objects);
        awoofy.create();
        awoofy.MoveContents(objects);
        broomHatter.create();
        broomHatter.MoveContents(objects);
        createBaseland();
    }
    public void justKirby(){
        objects.clear();
        Kirby = new LinkKirby();
        Kirby.create();
        Kirby.MoveContents(objects);
        createBaseland();
    }

    public void justKirbyLoli(){
        objects.clear();
        Kirby = new LinkKirby();
        lolipop = new Lolipop();
        Kirby.create();
        lolipop.create();
        Kirby.MoveContents(objects);
        lolipop.MoveContents(objects);
        createBaseland();
    }

    public void justAwoofyBroom(){
        objects.clear();
        awoofy = new Awoofy();
        broomHatter = new BroomHatter();
        awoofy.create();
        broomHatter.create();
        awoofy.MoveContents(objects);
        broomHatter.MoveContents(objects);
        createBaseland();
    }

    public void justAwoofyBroomLoli(){
        objects.clear();
        awoofy = new Awoofy();
        broomHatter = new BroomHatter();
        lolipop = new Lolipop();
        awoofy.create();
        broomHatter.create();
        lolipop.create();
        awoofy.MoveContents(objects);
        broomHatter.MoveContents(objects);
        lolipop.MoveContents(objects);
        createBaseland();
    }

    //UNTUK NGE ANIMASI
    public void sceneChanges() {
        resetAnims();
        if (Scene < 0) { // all char sejajar
            Scene = 0;
        }
        System.out.println("Scene " + Scene +" sekarang");
        if (Scene == 1) { // Introduksi kirby
//            objects.get(0).translateObject(0.0f, 0.0f, 0f); //Kirby
//            objects.get(1).translateObject(0f, 0.0f, 2f); //Awoofy
//            objects.get(1).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);
//            objects.get(2).translateObject(0.69f, 0.0f, 2f); //BroomHatter
//            objects.get(2).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);
//            objects.get(3).translateObject(0.0f, -0.2f, 0.9f); //Lolipop
            justKirby();
        }
        else if (Scene == 2){ // Introduksi Awoofy dan Broomhatter
            justAwoofyBroom();
            objects.get(0).translateObject(0.2f, 0.0f, 0f); //Awoofy
            objects.get(1).translateObject(-0.2f, 0.0f, 0f); //BroomHatter
        }
        else if (Scene == 3){// kirby pegang lolipop
            justKirbyLoli();
            objects.get(0).translateObject(0.0f, 0.0f, 0f); //Kirby
            objects.get(0).getChildObject().get(2).addChild(objects.get(1));
            objects.get(1).translateObject(0.8f, -0.15f, -0.3f); //Lolipop dipegang kirby
        }
        else if (Scene == 4) { // awoofy dan broom curi lolipop dari kirby
            // kirby nginjek awoofy
//            objects.get(0).translateObject(0.0f, 0.5f, -2f); //Kirby
//            objects.get(1).translateObject(0f, 0.0f, 2f); //Awoofy
//            objects.get(1).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);
//            objects.get(2).translateObject(0.69f, 0.0f, 2f); //BroomHatter
//            objects.get(2).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);
//            objects.get(3).translateObject(0.0f, -0.2f, -0.3f); //Lolipop
            objects.get(0).translateObject(0.0f, 0.0f, 0f); //Kirby
            objects.get(1).getChildObject().get(4).getChildObject().add(objects.get(3));
            objects.get(1).translateObject(-0.20f, 0.0f, 0.7f); //Awoofy
            objects.get(1).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);
            objects.get(2).translateObject(0.20f, 0.0f, 0.7f); //BroomHatter
            objects.get(2).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);
            objects.get(3).translateObject(-0.35f, -0.2f, 0.3f); //Lolipop di tangan awoofy
        }
        else if (Scene == 5){ // kirby ngejar lolipop yg diambil loli ada di tangan awoofy
            objects.get(0).translateObject(0.0f, 0.0f, 2f); //Kirby
            objects.get(1).translateObject(-0.20f, 0.0f, 0f); //Awoofy
            objects.get(2).translateObject(0.20f, 0.0f, 0f); //BroomHatter
            objects.get(3).translateObject(0.15f, -0.15f, -0.3f); //Lolipop
            objects.get(1).getChildObject().get(4).getChildObject().add(objects.get(3));
            // Lolipop ada di tangan Awoofy
        }
        else if (Scene == 6){ // kirby hadap awoofy dan makan awoofy
            allChar();
            objects.get(0).translateObject(0.0f, 0.0f, 0f); //Kirby
            objects.get(0).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
            objects.get(1).translateObject(-0.69f, 0.0f, 0f); //Awoofy
            objects.get(2).translateObject(0.69f, 0.0f, 0f); //BroomHatter
//            objects.get(3).translateObject(0.0f, -0.2f, -0.3f); //Lolipop
        }
        else if (Scene == 7){ // kirby hadap broom dan makan broom
            allChar();
            objects.get(0).translateObject(0.0f, 0.0f, 0f); //Kirby
            objects.get(0).rotateObject((float)Math.toRadians(-90f),0f,1f,0f);
            objects.get(1).translateObject(-0.69f, -1f,0f); //Awoofy turun
            objects.get(2).translateObject(0.69f, 0.0f, 0f); //BroomHatter
//            objects.get(3).translateObject(0.0f, -0.2f, -0.3f); //Lolipop
        }
        else {
            // posisi netral
            objects.get(0).translateObject(0.0f, 0.0f, 0f); //Kirby
            objects.get(1).translateObject(-0.69f, 0.0f, 0f); //Awoofy
            objects.get(2).translateObject(0.69f, 0.0f, 0f); //BroomHatter
            objects.get(3).translateObject(0.0f, -0.2f, -0.3f); //Lolipop
        }
    }

    public void drawScenarios(){
        if (Scene == 1) {
            Kirby.walkAnim(false);
        }
        else if (Scene == 2){
            awoofy.walkAnim(false);
            broomHatter.basicAnim(false);
        }
        else if (Scene == 3) {
            Kirby.upDownAnim(false);
//            lolipop.upDownAnim(false);
        }
        else if (Scene == 4){
            awoofy.upDownAnim(false);
//            lolipop.upDownAnim(false);
            broomHatter.basicAnim(false);
        }
        else if (Scene == 5) {
            awoofy.run(false);
            broomHatter.run(false);
            Kirby.walkAnim(false);
            Kirby.run(false);
            awoofy.walkAnim(false);
            awoofy.handAnim(false);
            broomHatter.basicAnim(false);

        }
        else if (Scene == 6){
            // animasi kirby buka mulut
            // awoofy kemakan
            Kirby.EAT(false);
            awoofy.eaten(false);
        }
        else if (Scene == 7){
            // animasi kirby buka mulut
            // broom kemakan
            Kirby.EAT(false);
            broomHatter.mengecildimakan(false);
        }
        else {
            Kirby.walkAnim(false);
//            awoofy.walkAnim(false);
//            awoofy.handAnim(false);
//            awoofy.splat(false);
//            broomHatter.splat(false);
        }
    }
    //INPUT
    public void input() {

        // radian awal adalah 0.5f
        // tak ganti ke 1f supaya cepet aja
        if (window.isKeyPressed(GLFW_KEY_D)) {
            cam.addRotation((float) Math.toRadians(0f), (float) Math.toRadians(2f));
//            for(int zi= 0; zi < objects.size(); zi++) {
//                objects.get(zi).rotationObject((float) Math.toRadians(1f), 0f, 1f, 0f);
//            }
            //objects.get(0).translateObject(0.0f,0.0f,0.00015f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            cam.addRotation((float) Math.toRadians(0f), (float) Math.toRadians(-2f));
//            for(int zi= 0; zi < objects.size(); zi++) {
//                objects.get(zi).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
//            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            cam.moveBackwards((float) Math.toRadians(2f));
//            for(int zi= 0; zi < objects.size(); zi++) {
//                objects.get(zi).rotateObject((float)Math.toRadians(1f),1f,0f,0f);
//            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            cam.moveForward((float) Math.toRadians(2f));
//            for(int zi= 0; zi < objects.size(); zi++) {
//                objects.get(zi).rotateObject((float)Math.toRadians(1f),-1f,0f,0f);
//            }
        }
        if (window.isKeyPressed(GLFW_KEY_T)) {
            for (int i = 0; i < objects.size(); i++) {
                objects.get(i).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_F)) {
            objects.get(2).rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            if (!pressed) {
                Scene -= 1;
                sceneChanges();
                pressed = true;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            if (!pressed) {
                Scene += 1;
                sceneChanges();
                pressed = true;
            }
        }
        if (window.isKeyReleased(GLFW_KEY_RIGHT) && window.isKeyReleased(GLFW_KEY_LEFT)) {
            pressed = false;
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            cam.moveLeft((float) Math.toRadians(2f));
            //cam.moveBackwards(0.1f);
            //objects.get(0).translateObject(0.0f,0.0f,-0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
            cam.moveRight((float) Math.toRadians(3f));
            //cam.moveForward(0.1f);
            //objects.get(0).translateObject(0.0f,0.0f,0.01f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            cam.moveDown((float) Math.toRadians(2f));
            //cam.moveForward(0.1f);
            //objects.get(0).translateObject(0.0f,0.0f,0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            cam.moveUp((float) Math.toRadians(2f));
            //cam.moveForward(0.1f);
            //objects.get(0).translateObject(0.0f,0.0f,0.01f);
        }


        if (mouseInput.isLeftButtonPressed()) {
            Vector3f pos = mouseInput.getCurrentPos();

            pos.x = (pos.x - (window.getWidth()) / 2.0f) /
                    (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) /
                    (-window.getHeight() / 2.0f);
            pos.z = (pos.z - (window.getHeight()) / 2.0f) /
                    (-window.getHeight() / 2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1)
                    && !(pos.z > 1 || pos.z < -0.97))) {
                System.out.println("x : " + pos.x + " y : " + pos.y + " z : " + pos.z);
            }
        }
    }

    //DRAW SCENE ANIMATIONNYA


    public void loop() {
        //SKYBOX
        while (window.isOpen()) {
            window.update();
            glClearColor(0.6f,
                    0.6f, 0.9f,
                    0.75f);
            GL.createCapabilities();

            //DRAW SCENE ANIMATIONNYA
            drawScenarios();
            //---------------------------------------------

            input();

            for (Object object : objects) {
                    object.draw(cam, projection);
            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}