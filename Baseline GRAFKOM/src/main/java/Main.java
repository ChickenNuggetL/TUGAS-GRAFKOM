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

    LinkKirby Kirby = new LinkKirby();

    Awoofy awoofy = new Awoofy();

    BroomHatter broomHatter = new BroomHatter();

    Camera cam = new Camera();

    //MODULE SCRIPT BOLEH DIRUBAH---------------------------------------------------
    private Window window =
            new Window
                    (900, 900, "Kirby");
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    //Deklarasi Array---------------------------------------------------
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();


    // Inisialisasi Model disini
    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_LINE_SMOOTH);
        glShadeModel(GL_SMOOTH);
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

        objects.get(0).translateObject(0.0f,0.0f,0f); //Kirby
        objects.get(1).translateObject(0.69f,0.0f,0f); //Awoofy
        objects.get(2).translateObject(-0.69f,0.0f,0f); //BroomHatter
        //Cam initialize
        cam.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));
        cam.setPosition(0f,0f,1.45f);
    }

    public void input() {

        // radian awal adalah 0.5f
        // tak ganti ke 1f supaya cepet aja
        if (window.isKeyPressed(GLFW_KEY_D)) {
            for(int zi= 0; zi < objects.size(); zi++) {
                objects.get(zi).rotationObject((float) Math.toRadians(1f), 0f, 1f, 0f);
            }
            //objects.get(0).translateObject(0.0f,0.0f,0.00015f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            for(int zi= 0; zi < objects.size(); zi++) {
                objects.get(zi).rotateObject((float) Math.toRadians(1f), 0f, -1f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            for(int zi= 0; zi < objects.size(); zi++) {
                objects.get(zi).rotateObject((float)Math.toRadians(1f),1f,0f,0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for(int zi= 0; zi < objects.size(); zi++) {
                objects.get(zi).rotateObject((float)Math.toRadians(1f),-1f,0f,0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_T)) {
            for(int i = 0; i < objects.size(); i++){
                objects.get(i).rotateObject((float)Math.toRadians(1f),0f,0f,1f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_F)) {
            objects.get(2).rotateObject((float)Math.toRadians(1f),0f,0f,1f);
        }
        if (window.isKeyPressed(GLFW_KEY_G)) {
            objects.get(0).rotateObject((float)Math.toRadians(1f),0f,0f,1f);
        }
        if (window.isKeyPressed(GLFW_KEY_H)) {
            objects.get(1).rotateObject((float)Math.toRadians(1f),0f,0f,1f);
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            //cam.moveBackwards(0.1f);
            //objects.get(0).translateObject(0.0f,0.0f,-0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_E)) {
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

    public void loop() {
        //SKYBOX
        while (window.isOpen()) {
            window.update();
            glClearColor(0.6f,
                    0.6f, 0.9f,
                    0.75f);
            GL.createCapabilities();
            //code
           //INI CARA PAKENYA SALAH TAPI JGN DIHAPUS DLU
 //           for (Object object : objectsPointsControl) {
 //               object.drawLine(cam,projection);
 //           }

            Kirby.walkAnim(false);

            awoofy.walkAnim(false);

            broomHatter.basicAnim(false);
            input();
//            awoofy.handAnimation();

            for (Object object : objects) {
                object.draw();
                //object.drawC(cam,projection);
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