import Engine.*;
import Engine.Characters.Awoofy;
import Engine.Characters.BroomHatter;
import Engine.Characters.LinkKirby;
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
    EasyCreateObject elips = new EasyCreateObject();
    EasyCreateObject Sphere = new EasyCreateObject();
    Camera cam = new Camera();

    //MODULE SCRIPT BOLEH DIRUBAH---------------------------------------------------
    private Window window =
            new Window
                    (900, 800, "Hello World");
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    //Deklarasi Array---------------------------------------------------
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private ArrayList<Awoofy> objectsAwoofy
            = new ArrayList<>();

    private ArrayList<BroomHatter> objectBroomHatter
            = new ArrayList<>();

    private ArrayList<LinkKirby> objectsLinkKirby
            = new ArrayList<>();

    // Inisialisasi Model disini
    public void init() {
        window.init();
        GL.createCapabilities();
        mouseInput = window.getMouseInput();

        //Cam initialize
        cam.setPosition(0,0,1f);
        cam.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));

        // Render model lewat easyCreateObject
        elips.Sphere(objects, 80, 55, 55);  //Contoh Pake easyCreate
        Sphere.Sphere(objects, 55, 55, 55, 155/255f, 191/255f,11/255f);  //Contoh Pake easyCreate
        objects.get(0).translateObject(0f,0f,-0.1f);
        objects.get(1).translateObject(0f,0f,-0.1f);

    }

    public void input() {

        if (window.isKeyPressed(GLFW_KEY_D)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.5f),0f,1f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.5f),0f,-1f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.5f),1f,0f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_F)) {
            objects.get(0).rotateObject((float)Math.toRadians(1f),0f,0f,1f);
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
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();

            //code
           //INI CARA PAKENYA SALAH TAPI JGN DIHAPUS DLU
 //           for (Awoofy awoofy : objectsAwoofy){
 //               awoofy.draw(cam,projection);
 //           }
 //           for (Object object : objectsPointsControl) {
 //               object.drawLine(cam,projection);
 //           }
            for (Object object : objects) {
                object.drawC(cam,projection);
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