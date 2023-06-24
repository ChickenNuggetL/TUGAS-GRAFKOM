import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class CobaBlender {
    int countTree =9;
    float tempCount = -16f;
    boolean keyRditekan = false;
    float derajatkamera;
    private Window window =
            new Window
                    (1920, 1080, "Hello World");
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private MouseInput mouseInput;

    static float rot = 0f;
    int countDegree = 0;
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    Camera camera = new Camera();

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        mouseInput = window.getMouseInput();
        camera.setPosition(0, 1f, 1.7f);
        camera.moveDown(0.6f);


        // floor office
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        ObjectLoader objectLoader = new ObjectLoader("C:\\Users\\Lenovo\\OneDrive\\Documents\\GitHub\\TUGAS-GRAFKOM\\TUGAS-GRAFKOM-BARU\\resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_FLOOR.fbx", "fbx");
        objects.get(0).setVertices(objectLoader.vertices);
        objects.get(0).setNormal(objectLoader.normals);
        objects.get(0).setIndicies(objectLoader.indicies);

        objects.get(0).scaleObject(1f, 0f, 2f);
        objects.get(0).translateObject(0f, 0f, 0f);

        // floor wall depan
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0.0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader("", "fbx");
        objects.get(0).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).scaleObject(1f, 5f, f);
        objects.get(0).translateObject(1f, 0f, 0f);

//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        objectLoader = new ObjectLoader("resources/Helicopter.fbx", "fbx");
//        objects.get(1).setVertices(objectLoader.vertices);
//        objects.get(1).setNormal(objectLoader.normals);
//        objects.get(1).setIndicies(objectLoader.indicies);
//
//        objects.get(1).scaleObject(0.001f, 0.0001f, 0.000001f);
//        objects.get(1).translateObject(3.0f, 0.0f, 0.0f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.20f, 0.15f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        objectLoader = new ObjectLoader("resources/farm_house.fbx", "fbx");
//        objects.get(2).setVertices(objectLoader.vertices);
//        objects.get(2).setNormal(objectLoader.normals);
//        objects.get(2).setIndicies(objectLoader.indicies);
//        objects.get(2).scaleObject(0.2f, 0.2f, 0.2f);
//        objects.get(2).translateObject(-16.0f, -7.0f, 10.0f);
//        objects.get(2).rotateObject(1f, 0.0f, 1f,0f);
//
//        //rumput
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.5f, 0.1f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        objectLoader = new ObjectLoader("resources/rumput.fbx", "fbx");
//        objects.get(3).setVertices(objectLoader.vertices);
//        objects.get(3).setNormal(objectLoader.normals);
//        objects.get(3).setIndicies(objectLoader.indicies);
//
//        objects.get(3).scaleObject(10.f, 10.0f, 10.0f);
//        objects.get(3).translateObject(0.0f, -4.8f, 0.0f);
//
//        //cewek
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 0.0f, 0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        objectLoader = new ObjectLoader("resources/raphtalia.fbx", "fbx");
//        objects.get(4).setVertices(objectLoader.vertices);
//        objects.get(4).setNormal(objectLoader.normals);
//        objects.get(4).setIndicies(objectLoader.indicies);
//        objects.get(4).scaleObject(0.01f, 0.01f, 0.01f);
////        objects.get(280).rotateObject(1f, -1f, 0.0f,0f);
//
//        objects.get(4).translateObject(0.0f, -5.7f, 0.0f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.22f, 0.27f, 0.27f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objectLoader = new ObjectLoader("resources/sumur_rusak.fbx", "fbx");
//        objects.get(5).setVertices(objectLoader.vertices);
//        objects.get(5).setNormal(objectLoader.normals);
//        objects.get(5).setIndicies(objectLoader.indicies);
//        objects.get(5).scaleObject(0.05f, 0.05f, 0.05f);
//        objects.get(5).rotateObject((float)Math.toRadians(-90),1f,0f,0f);
//        objects.get(5).translateObject(2.0f,-7f,10f);
//
//        //batu
//        {
//            objects.add(new Sphere(
//                    Arrays.asList(
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                    ),
//                    new ArrayList<>(),
//                    new Vector4f(0.22f, 0.27f, 0.27f, 1.0f),
//                    Arrays.asList(0.0f, 1.0f, 0.0f),
//                    0.125f,
//                    0.125f,
//                    0.125f,
//                    36,
//                    18
//            ));
//            objectLoader = new ObjectLoader("resources/batu2.fbx", "fbx");
//            objects.get(6).setVertices(objectLoader.vertices);
//            objects.get(6).setNormal(objectLoader.normals);
//            objects.get(6).setIndicies(objectLoader.indicies);
//            objects.get(6).scaleObject(0.01f, 0.01f, 0.01f);
//            objects.get(6).rotateObject((float) Math.toRadians(90), 0f, 0f, 1f);
//            objects.get(6).translateObject(-20.0f, -7f, 10f);
//
//            objects.add(new Sphere(
//                    Arrays.asList(
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                    ),
//                    new ArrayList<>(),
//                    new Vector4f(0.22f, 0.27f, 0.27f, 1.0f),
//                    Arrays.asList(0.0f, 1.0f, 0.0f),
//                    0.125f,
//                    0.125f,
//                    0.125f,
//                    36,
//                    18
//            ));
//            objectLoader = new ObjectLoader("resources/batu2.fbx", "fbx");
//            objects.get(7).setVertices(objectLoader.vertices);
//            objects.get(7).setNormal(objectLoader.normals);
//            objects.get(7).setIndicies(objectLoader.indicies);
//            objects.get(7).scaleObject(0.004f, 0.005f, 0.005f);
//            objects.get(7).rotateObject((float) Math.toRadians(90), 0f, 0f, 1f);
//            objects.get(7).rotateObject((float) Math.toRadians(90), 0f, 1f, 0f);
//            objects.get(7).translateObject(-21.5f, -4.3f, 10f);
//        }
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.45f, 0.30f, 0.00f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//        objectLoader = new ObjectLoader("resources/sumur.fbx", "fbx");
//        objects.get(8).setVertices(objectLoader.vertices);
//        objects.get(8).setNormal(objectLoader.normals);
//        objects.get(8).setIndicies(objectLoader.indicies);
//        objects.get(8).scaleObject(0.05f, 0.05f, 0.05f);
//        objects.get(8).rotateObject((float) Math.toRadians(-90), 1f, 0f, 0f);
//        objects.get(8).translateObject(-4.0f, -6.3f, 7f);
//
//        //pohon
//        {
//            drawMediumTree(-2f, 0.0f, -20f);
//            drawMediumTree(-10f, 0.0f, -7f);
//            drawMediumTree(-18f, 0.0f, -15f);
//            drawMediumTree(-30f, 0.0f, -5f);
//            drawMediumTree(-25f, 0.0f, 4f);
//            drawMediumTree(10f, 0.0f, 10f);
//            drawMediumTree(10f, 0.0f, 0f);
//            drawMediumTree(3f, 0.0f, -10f);
//            drawMediumTree(-23f, 0.0f, -5.0f);
//            drawMediumTree(5f, 0.0f, -6.0f);
//            drawMediumTree(-3f, 0.0f, -12.0f);
//            drawMediumTree(-14f, 0.0f, -12.0f);
//        }
//
//
//
//        System.out.println("Jumlah : " +  countTree);
//
//    }
//    public void drawMiniTree(float x, float y, float z){
//        //batang
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.30f, 0.15f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        ObjectLoader objectLoader = new ObjectLoader("resources/batang.fbx", "fbx");
//        objects.get(countTree).setVertices(objectLoader.vertices);
//        objects.get(countTree).setNormal(objectLoader.normals);
//        objects.get(countTree).setIndicies(objectLoader.indicies);
//
//        //Edit
//        objects.get(countTree).scaleObject(0.41f, 2.0f,0.41f);
//        objects.get(countTree).translateObject(x, -6.0f, z);
//
//
//
//
//        countTree +=1;
//        //daun
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.3f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        objectLoader = new ObjectLoader("resources/daun.fbx", "fbx");
//        objects.get(countTree).setVertices(objectLoader.vertices);
//        objects.get(countTree).setNormal(objectLoader.normals);
//        objects.get(countTree).setIndicies(objectLoader.indicies);
//
//        //Edit
//        objects.get(countTree).scaleObject(0.41f, 0.5f,0.41f);
//        objects.get(countTree).translateObject(x, y, z);
//
//        countTree +=1;
//        tempCount +=3.0f;
//    }
//
//    public void drawMediumTree(float x, float y, float z){
//        //batang
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.30f, 0.15f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        ObjectLoader objectLoader = new ObjectLoader("resources/batang_v2.fbx", "fbx");
//        objects.get(countTree).setVertices(objectLoader.vertices);
//        objects.get(countTree).setNormal(objectLoader.normals);
//        objects.get(countTree).setIndicies(objectLoader.indicies);
//
//        //Edit
//        objects.get(countTree).scaleObject(0.03f, 0.04f,0.03f);
//        objects.get(countTree).translateObject(x, y-7.0f, z);
//
//
//
//
//        countTree +=1;
//        //daun
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.3f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        objectLoader = new ObjectLoader("resources/daun_v2.fbx", "fbx");
//        objects.get(countTree).setVertices(objectLoader.vertices);
//        objects.get(countTree).setNormal(objectLoader.normals);
//        objects.get(countTree).setIndicies(objectLoader.indicies);
//
//        //Edit
//        objects.get(countTree).scaleObject(0.03f, 0.03f,0.03f);
//        objects.get(countTree).translateObject(x, y-3.5f, z);
//
//        countTree +=1;
//        tempCount +=3.0f;
//    }
//
//    public void drawBigTree(float x, float z){
//        //batang
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.30f, 0.15f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        ObjectLoader objectLoader = new ObjectLoader("resources/batang.fbx", "fbx");
//        objects.get(countTree).setVertices(objectLoader.vertices);
//        objects.get(countTree).setNormal(objectLoader.normals);
//        objects.get(countTree).setIndicies(objectLoader.indicies);
//
//        //Edit
//        objects.get(countTree).scaleObject(0.41f, 5.0f,0.41f);
//        objects.get(countTree).translateObject(x, -3.0f, z);
//
//
//        countTree +=1;
//        //daun
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.3f, 0.0f, 1.0f),
//                Arrays.asList(0.0f, 1.0f, 0.0f),
//                0.125f,
//                0.125f,
//                0.125f,
//                36,
//                18
//        ));
//
//        objectLoader = new ObjectLoader("resources/daun.fbx", "fbx");
//        objects.get(countTree).setVertices(objectLoader.vertices);
//        objects.get(countTree).setNormal(objectLoader.normals);
//        objects.get(countTree).setIndicies(objectLoader.indicies);
//
//        //Edit
//        objects.get(countTree).scaleObject(0.6f, 1.8f,0.6f);
//        objects.get(countTree).translateObject(x, -5.0f, z);
//
//        countTree +=1;
//        tempCount +=3.0f;
    }



    public void input() {
        float move = 0.05f;

        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);

        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            camera.moveLeft(move);

        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
            camera.moveBackwards(move);

        }
        if (window.isKeyPressed(GLFW_KEY_D)) {
            camera.moveRight(move);

        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveUp(move);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(move);
        }
        if (window.isKeyPressed(GLFW_KEY_R)) {
            keyRditekan = true;
//            for(float i = 0f; i < 360f; i += 0.5f) {
//                List<Float> temp = new ArrayList<>(objects.get(0).getCenterPoint());
//                camera.setPosition(temp.get(0) * -1, temp.get(1) * -1, camera.getPosition().z);
//                camera.addRotation(0, (float) Math.toRadians(0.5f));
//                camera.setPosition(temp.get(0) * 1, temp.get(1) * 1, camera.getPosition().z);
//            }
        }
        if (window.isKeyPressed(GLFW_KEY_G)) {
//            float zCAM = camera.getPosition().z;
//            float xCAM = camera.getPosition().x;
//            float zOBJ = objects.get(0).getCenterPoint().get(2);
//            float xOBJ = objects.get(0).getCenterPoint().get(0);
//            float x = (float) Math.pow(xCAM-xOBJ,2);
//            float y = (float) Math.pow(zCAM-zOBJ,2);
//            float temp = (float) Math.sqrt(x+y)*0.01f;
//            camera.moveRight(move+temp);
//            camera.addRotation(0f,-move-(temp));
            camera.moveForward(1.7f);
            camera.addRotation(0, (float) Math.toRadians(1f));
            setRot(1f);
            camera.moveBackwards(1.7f);
        }

        float move2 = 0.5f;
        if (keyRditekan) {
            float posisiX = camera.getPosition().x;
            float posisiY = camera.getPosition().y;
            float posisiZ = camera.getPosition().z;
            camera.setPosition(-posisiX, -posisiY, -posisiZ);
            camera.addRotation(0.0f, (float) Math.toRadians(move2));
            camera.setPosition(posisiX, posisiY, posisiZ);
            derajatkamera += move2;
            if (derajatkamera >= 360.0f) {
                derajatkamera = 0f;
                keyRditekan = false;
            }
        }
        if (mouseInput.isLeftButtonPressed()) {
            Vector2f displayVec = window.getMouseInput().getDisplVec();
            camera.addRotation((float) Math.toRadians(displayVec.x * 0.1f),
                    (float) Math.toRadians(displayVec.y * 0.1f));
        }
        if (window.getMouseInput().getScroll().y != 0) {
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.01f));
            window.getMouseInput().setScroll(new Vector2f());
        }
    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 1.0f,
                    0.0f);
            GL.createCapabilities();

            input();

            //code
            for (Object object : objects) {
                object.draw(camera, projection);
            }
//            for(Object object: objectsRectangle){
//                object.draw();
//            }
//            for(Object object: objectsPointsControl){
//                object.drawLine();
//            }

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

    public static float getRot() {
        return rot;
    }

    public static void setRot(float rot) {
        Main.rot += rot;
    }

    public static void main(String[] args) {
        new CobaBlender().run();
    }
}