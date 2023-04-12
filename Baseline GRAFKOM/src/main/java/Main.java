import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    //MODULE SCRIPTS---------------------------------------------------------------------------
    private MouseInput mouseInput;
    EasyCreateObject easyCreateObject = new EasyCreateObject();
    Camera cam = new Camera();

    //MODULE SCRIPT BOLEH DIRUBAH---------------------------------------------------
    private Window window =
            new Window
                    (800, 800, "Hello World");
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    //Deklarasi Array---------------------------------------------------
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
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
        cam.setPosition(0,0,1.953f);

        // Render model lewat easyCreateObject
        easyCreateObject.Sphere(objects);
    }

    public void input() {
//        if (window.isKeyPressed(GLFW_KEY_F)) {
//            System.out.println("F");
//        }
//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            objects.get(0).getChildObject().get(0);
//        }
//
        if (window.isKeyPressed(GLFW_KEY_F)) {
            objects.get(0).rotateObject((float)Math.toRadians(1f),2f,4f,2f);
        }

        if (mouseInput.isLeftButtonPressed()) {
            Vector3f pos = mouseInput.getCurrentPos();
//            System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth()) / 2.0f) /
                    (window.getWidth() / 2.0f);
            pos.y = (pos.y - (window.getHeight()) / 2.0f) /
                    (-window.getHeight() / 2.0f);
            pos.z = (pos.z - (window.getHeight()) / 2.0f) /
                    (-window.getHeight() / 2.0f);

            //System.out.println("x : "+pos.x+" y : "+pos.y);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1)
            && !(pos.z > 1 || pos.z < -0.97))) {
                System.out.println("x : " + pos.x + " y : " + pos.y + " z : " + pos.z);
                //objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
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
//            for (Object object : objects) {
//                object.draw(cam, projection);
//            }
            for (Awoofy awoofy : objectsAwoofy){
                awoofy.draw(cam,projection);
            }
//            for (Object object : objectsRectangle) {
//                object.draw(cam, projection);
//            }
            for (Object object : objectsPointsControl) {
                object.drawLine(cam,projection);
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