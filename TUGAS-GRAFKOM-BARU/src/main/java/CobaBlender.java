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
//        camera.setPosition(0, 1f, 1.7f);
//        camera.moveDown(0.6f);

        //KUMPULAN FILEPATH
        //--------------------------------------------------------------------------------------

        String filepath1 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_FLOOR.fbx";
        String filepath2 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_WALL_NOWINDOW.fbx";
        String filepath3 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_POSTER.fbx";
        String filepath4 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_KABEL.fbx";
        String filepath5 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_TABLE.fbx";
        String filepath6 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_TV.fbx";
        String filepath7 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_DOLL1.fbx";
        String filepath8 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_BOTOL.fbx";
        String filepath9 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_SPEAKER.fbx";
        String filepath10 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_BOTOL2.fbx";
        String filepath11 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_BALIHO.fbx";

        String filepath12 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_TABLE_PARTY.fbx";








        // OFFICE
        // floor
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        //Camera control
        camera = new Camera(mouseInput, objects.get(0));

        ObjectLoader objectLoader = new ObjectLoader(filepath1, "fbx");
        objects.get(0).setVertices(objectLoader.vertices);
        objects.get(0).setNormal(objectLoader.normals);
        objects.get(0).setIndicies(objectLoader.indicies);

        objects.get(0).scaleObject(1f, 0.01f, 1.5f);
        objects.get(0).translateObject(0f, 0f, 0f);


        //wall depan
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(0).scaleObject(1f, 1f, 0.05f);
        objects.get(0).getChildObject().get(0).translateObject(0f, 0.95f, -1.5f);

        // wall belakang
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(1).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(1).scaleObject(1f, 1f, 0.05f);
        objects.get(0).getChildObject().get(1).translateObject(0f, 0.95f, 1.5f);

        // wall kiri
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(2).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(2).scaleObject(0.05f, 1f, 1f);
        objects.get(0).getChildObject().get(2).translateObject(1f, 0.95f, 0.6f);

        // wall kiri window
        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(2).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.01f, 0.5f, 0.7f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0.95f, 1f, 0.8f);

        // wall kiri pintu
        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(2).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(2).getChildObject().get(1).scaleObject(0.05f, 0.2f, 0.7f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(1f, 1.75f, -1f);

        // wall kanan
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.7f, 0.7f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(3).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(3).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(3).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(3).scaleObject(0.05f, 1f, 1f);
        objects.get(0).getChildObject().get(3).translateObject(-1f, 0.95f, 0.6f);

        // wall kanan window
        objects.get(0).getChildObject().get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(3).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(0.01f, 0.5f, 0.7f);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.95f, 1f, 0.8f);

        // wall kanan pintu
        objects.get(0).getChildObject().get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(3).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(3).getChildObject().get(1).scaleObject(0.05f, 0.2f, 0.7f);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(-1f, 1.75f, -1f);

        // poster
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath3, "fbx");
        objects.get(0).getChildObject().get(4).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(4).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(4).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(4).scaleObject(0.3f, 1f, 0f);
        objects.get(0).getChildObject().get(4).translateObject(0.7f, 1.2f, 1.4f);

        objects.get(0).getChildObject().get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 1f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath3, "fbx");
        objects.get(0).getChildObject().get(4).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.2f, 0.4f, 0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.2f, 0.9f, 1.4f);

        objects.get(0).getChildObject().get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath3, "fbx");
        objects.get(0).getChildObject().get(4).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.2f, 0.4f, 0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(-0.4f, 1f, 1.4f);

        objects.get(0).getChildObject().get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 1f, 1.0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath3, "fbx");
        objects.get(0).getChildObject().get(4).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(4).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(4).getChildObject().get(2).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(4).getChildObject().get(2).scaleObject(0.2f, 0.4f, 0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(2).translateObject(-0.6f, 1.2f, 1.4f);

        // kabel
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0.0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath4, "fbx");
        objects.get(0).getChildObject().get(5).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(5).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(5).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(5).scaleObject(0.006f, 0.3f, 0.03f);
        objects.get(0).getChildObject().get(5).translateObject(0.7f, 1f, 1.2f);

        // table
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0.5f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath5, "fbx");
        objects.get(0).getChildObject().get(6).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(6).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(6).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(6).scaleObject(0.7f, 0.5f, 0.025f);
        objects.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(0).getChildObject().get(6).translateObject(0f, 0.5f, 0.4f);


        // tv
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0.5f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath6, "fbx");
        objects.get(0).getChildObject().get(7).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(7).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(7).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(7).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(7).translateObject(0.4f, 0.65f, 0.4f);

        objects.get(0).getChildObject().get(7).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0.5f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath6, "fbx");
        objects.get(0).getChildObject().get(7).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(7).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(7).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(7).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(7).getChildObject().get(0).translateObject(0.1f, 0.65f, 0.4f);

        objects.get(0).getChildObject().get(7).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0.5f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath6, "fbx");
        objects.get(0).getChildObject().get(7).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(7).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(7).getChildObject().get(1).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(7).getChildObject().get(1).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(7).getChildObject().get(1).translateObject(0.23f, 0.9f, 0.4f);

        // doll
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath7, "fbx");
        objects.get(0).getChildObject().get(8).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(8).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(8).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(8).scaleObject(0.5f, 0.5f, 0.5f);
        objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(30f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(8).translateObject(-0.5f, 0.53f, 0.4f);

        // cup
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 0f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath8, "fbx");
        objects.get(0).getChildObject().get(9).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(9).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(9).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(9).scaleObject(0.07f, 0.07f, 0.12f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(9).translateObject(0.0f, 0.64f, 0.2f);

        //  Speaker
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.1f, 0.1f, 0.1f, 0.1f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath9, "fbx");
        objects.get(0).getChildObject().get(10).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).scaleObject(0.1f, 0.1f, 0.25f);
        objects.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
        objects.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(30f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(10).translateObject(-0.4f, 0.26f, 0.25f);

        // botol1
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath10, "fbx");
        objects.get(0).getChildObject().get(11).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(11).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(11).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(11).scaleObject(0.07f, 0.07f, 0.07f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(11).translateObject(0.25f, 0.64f, 0.20f);

        // roof
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0f, 0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath11, "fbx");
        objects.get(0).getChildObject().get(12).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).scaleObject(0.01f, 0.01f, 0.01f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).translateObject(0f, 3f, 0f);

        // OFFICE RUANGAN KEDUA
        // WALL PENYAMBUNG DEPAN KIRI
        objects.get(0).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(13).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(13).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(13).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(13).scaleObject(1f, 1f, 0.05f);
        objects.get(0).getChildObject().get(13).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(0).getChildObject().get(13).translateObject(-1f, 0.95f, 2.5f);

        // WALL PENYAMBUNG DEPAN KANAN
        objects.get(0).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(14).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(14).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(14).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(14).scaleObject(1f, 1f, 0.05f);
        objects.get(0).getChildObject().get(14).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(0).getChildObject().get(14).translateObject(1f, 0.95f, 2.5f);

        // WALL PENUTUP RUANG TENGAH
        objects.get(0).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(15).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(15).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(15).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(15).scaleObject(1f, 1f, 0.05f);
//        objects.get(0).getChildObject().get(15).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(0).getChildObject().get(15).translateObject(0f, 0.95f, 3.5f);

        // FLOOR UNTUK RUANG DEPANNYA OFFICE (RUANG KE 2)
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath1, "fbx");
        objects.get(0).getChildObject().get(16).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(16).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(16).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(16).scaleObject(1f, 0.01f, 1f);
        objects.get(0).getChildObject().get(16).translateObject(0f, 0f, 2.5f);

        // OFFICE RUANGAN KETIGA
        // WALL PENYAMBUNG DEPAN KIRI
        objects.get(0).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(17).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(17).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(17).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(17).scaleObject(1f, 1f, 0.05f);
        objects.get(0).getChildObject().get(17).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(0).getChildObject().get(17).translateObject(-1f, 0.95f, 4.5f);

        // WALL PENYAMBUNG DEPAN KANAN
        objects.get(0).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(18).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(18).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(18).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(18).scaleObject(1f, 1f, 0.05f);
        objects.get(0).getChildObject().get(18).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(0).getChildObject().get(18).translateObject(1f, 0.95f, 4.5f);

        // WALL PENUTUP RUANG TENGAH
        objects.get(0).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(0).getChildObject().get(19).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(19).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(19).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(19).scaleObject(1f, 1f, 0.05f);
//        objects.get(0).getChildObject().get(19).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(0).getChildObject().get(19).translateObject(0f, 0.95f, 5.5f);

        // FLOOR UNTUK RUANG DEPANNYA OFFICE (RUANG KE 2)
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath1, "fbx");
        objects.get(0).getChildObject().get(20).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(20).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(20).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(20).scaleObject(1f, 0.01f, 1f);
        objects.get(0).getChildObject().get(20).translateObject(0f, 0f, 4.5f);

        // WALL PENYAMBUNG RUANGAN 1 KE KANAN
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(1).setVertices(objectLoader.vertices);
        objects.get(1).setNormal(objectLoader.normals);
        objects.get(1).setIndicies(objectLoader.indicies);

        objects.get(1).scaleObject(0.5f, 1f, 0.05f);
//        objects.get(1).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(1).translateObject(1.5f, 0.95f, -1.5f);

        // SAMBUNGAN KE KANAN
        objects.get(1).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(1).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(1).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(1).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(1).getChildObject().get(0).scaleObject(2f, 1f, 0.05f);
        objects.get(1).getChildObject().get(0).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(1).getChildObject().get(0).translateObject(2f, 0.95f, 0.5f);

        // RUANG YANG ADA RAK
        // WALL SISI KANAN RUANG RAK
        objects.get(1).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(1).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(1).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(1).getChildObject().get(1).setIndicies(objectLoader.indicies);
        objects.get(1).getChildObject().get(1).scaleObject(1f, 1f, 0.05f);
//        objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(1).getChildObject().get(1).translateObject(3f, 0.95f, 2.5f);

        // WALL BELAKANG RUANG RAK
        objects.get(1).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(1).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(1).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(1).getChildObject().get(2).setIndicies(objectLoader.indicies);
        objects.get(1).getChildObject().get(2).scaleObject(1f, 1f, 0.05f);
        objects.get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(1).getChildObject().get(2).translateObject(4f, 0.95f, 3.5f);

        // WALL SISI KIRI RUANG RAK
        objects.get(1).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(1).getChildObject().get(3).setVertices(objectLoader.vertices);
        objects.get(1).getChildObject().get(3).setNormal(objectLoader.normals);
        objects.get(1).getChildObject().get(3).setIndicies(objectLoader.indicies);
        objects.get(1).getChildObject().get(3).scaleObject(1f, 1f, 0.05f);
//        objects.get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(1).getChildObject().get(3).translateObject(3f, 0.95f, 4.5f);

        // FLOOR RUANG RAK
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath1, "fbx");
        objects.get(1).getChildObject().get(4).setVertices(objectLoader.vertices);
        objects.get(1).getChildObject().get(4).setNormal(objectLoader.normals);
        objects.get(1).getChildObject().get(4).setIndicies(objectLoader.indicies);
        objects.get(1).getChildObject().get(4).scaleObject(1f, 0.01f, 1f);
        objects.get(1).getChildObject().get(4).translateObject(3f, 0f, 3.5f);

        // WALL PENYAMBUNG RUANGAN RAK KE RUANGAN TENGAH
        objects.get(1).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(1).getChildObject().get(5).setVertices(objectLoader.vertices);
        objects.get(1).getChildObject().get(5).setNormal(objectLoader.normals);
        objects.get(1).getChildObject().get(5).setIndicies(objectLoader.indicies);

        objects.get(1).getChildObject().get(5).scaleObject(1.3f, 1f, 0.05f);
        objects.get(1).getChildObject().get(5).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(1).getChildObject().get(5).translateObject(2f, 0.95f, 4.6f);

        // RUANG MARIONETTE
        // WALL SISI KANAN RUANG MARIONETTE
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(2).setVertices(objectLoader.vertices);
        objects.get(2).setNormal(objectLoader.normals);
        objects.get(2).setIndicies(objectLoader.indicies);

        objects.get(2).scaleObject(1.3f, 1f, 0.05f);
//        objects.get(2).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(2).translateObject(3.3f, 0.95f, 5.5f);

        // WALL SISI BELAKANG RUANG MARIONETTE
        objects.get(2).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(2).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(2).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(2).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(2).getChildObject().get(0).scaleObject(1f, 1f, 0.05f);
        objects.get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(2).getChildObject().get(0).translateObject(4.5f, 0.95f, 6.5f);

        // WALL SISI KIRI RUANG MARIONETTE
        objects.get(2).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(2).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(2).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(2).getChildObject().get(1).setIndicies(objectLoader.indicies);
        objects.get(2).getChildObject().get(1).scaleObject(1f, 1f, 0.05f);
//        objects.get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(2).getChildObject().get(1).translateObject(3.5f, 0.95f, 7.5f);

        // FLOOR UNTUK RUANG MARIONETTE
        objects.get(2).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath1, "fbx");
        objects.get(2).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(2).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(2).getChildObject().get(2).setIndicies(objectLoader.indicies);

        objects.get(2).getChildObject().get(2).scaleObject(1.3f, 0.01f, 1f);
        objects.get(2).getChildObject().get(2).translateObject(3.3f, 0f, 6.5f);

        // WALL TRANSISI KE ANTARA RUANG MARIONETTE KE RUANGAN TOPENG BAGIAN KANAN
        objects.get(2).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(2).getChildObject().get(3).setVertices(objectLoader.vertices);
        objects.get(2).getChildObject().get(3).setNormal(objectLoader.normals);
        objects.get(2).getChildObject().get(3).setIndicies(objectLoader.indicies);
        objects.get(2).getChildObject().get(3).scaleObject(1f, 1f, 0.05f);
        objects.get(2).getChildObject().get(3).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(2).getChildObject().get(3).translateObject(2.5f, 0.95f, 8.5f);

        // RUANG TOPENG
        // WALL SISI KIRI RUANG TOPENG
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(3).setVertices(objectLoader.vertices);
        objects.get(3).setNormal(objectLoader.normals);
        objects.get(3).setIndicies(objectLoader.indicies);
        objects.get(3).scaleObject(1f, 1f, 0.05f);
        objects.get(3).translateObject(3.5f, 0.95f, 9.5f);

        // WALL SISI BELAKANG RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(3).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(0).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(0).scaleObject(1.7f, 1f, 0.05f);
        objects.get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(3).getChildObject().get(0).translateObject(4.5f, 0.95f, 11.2f);

        // WALL SISI KANAN RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(3).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(1).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(1).scaleObject(1f, 1f, 0.05f);
//        objects.get(3).getChildObject().get(1).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(3).getChildObject().get(1).translateObject(3.5f, 0.95f, 12.9f);

        // WALL SISI DEPAN RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(3).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(2).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(2).scaleObject(1f, 1f, 0.05f);
        objects.get(3).getChildObject().get(2).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(3).getChildObject().get(2).translateObject(2.5f, 0.95f, 10.5f);

        // ATASAN PINTU RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(3).getChildObject().get(3).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(3).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(3).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(3).scaleObject(0.05f, 0.2f, 0.7f);
//        objects.get(3).getChildObject().get(3).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(3).getChildObject().get(3).translateObject(2.5f, 1.75f, 12.2f);

        // FLOOR RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath1, "fbx");
        objects.get(3).getChildObject().get(4).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(4).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(4).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(4).scaleObject(1f, 0.01f, 1.7f);
        objects.get(3).getChildObject().get(4).translateObject(3.5f, 0f, 11.25f);

        //PARTY
        //floor
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        objectLoader = new ObjectLoader(filepath1, "fbx");
        objects.get(4).setVertices(objectLoader.vertices);
        objects.get(4).setNormal(objectLoader.normals);
        objects.get(4).setIndicies(objectLoader.indicies);
        objects.get(4).scaleObject(3f, 0.01f, 5f);
        objects.get(4).translateObject(-0.5f, 0f, 9f);

        // PARTY
        // TABLE PARTY 1
        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));
        objectLoader = new ObjectLoader(filepath12, "fbx");
        objects.get(4).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(4).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(4).getChildObject().get(0).setIndicies(objectLoader.indicies);
        objects.get(4).getChildObject().get(0).scaleObject(0.02f, 0.02f, 0.02f);
        objects.get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(4).getChildObject().get(0).translateObject(1.3f, 0.05f, 7f);



        // TABLE PARTY 2
        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath12, "fbx");
        objects.get(4).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(4).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(4).getChildObject().get(1).setIndicies(objectLoader.indicies);
        objects.get(4).getChildObject().get(1).scaleObject(0.02f, 0.02f, 0.02f);
        objects.get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(4).getChildObject().get(1).translateObject(-1.7f, 0.05f, 7f);

        // TABLE PARTY 3
        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath12, "fbx");
        objects.get(4).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(4).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(4).getChildObject().get(2).setIndicies(objectLoader.indicies);
        objects.get(4).getChildObject().get(2).scaleObject(0.02f, 0.02f, 0.02f);
        objects.get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(4).getChildObject().get(2).translateObject(-0.7f, 0.05f, 8f);


        // TABLE PARTY 4
        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath12, "fbx");
        objects.get(4).getChildObject().get(3).setVertices(objectLoader.vertices);
        objects.get(4).getChildObject().get(3).setNormal(objectLoader.normals);
        objects.get(4).getChildObject().get(3).setIndicies(objectLoader.indicies);
        objects.get(4).getChildObject().get(3).scaleObject(0.02f, 0.02f, 0.02f);
        objects.get(4).getChildObject().get(3).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(4).getChildObject().get(3).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(4).getChildObject().get(3).translateObject(-0.7f, 0.05f, 9f);

        // TABLE PARTY 5
        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath12, "fbx");
        Object tableparty = objects.get(4).getChildObject().get(4);
        tableparty.setVertices(objectLoader.vertices);
        tableparty.setNormal(objectLoader.normals);
        tableparty.setIndicies(objectLoader.indicies);
        tableparty.scaleObject(0.02f, 0.02f, 0.02f);
        tableparty.rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        tableparty.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        tableparty.translateObject(1f, 0.05f, 8f);

        // WALL TRANSISI KE RUANG PANGGUNG
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 1f, 1f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath2, "fbx");
        objects.get(5).setVertices(objectLoader.vertices);
        objects.get(5).setNormal(objectLoader.normals);
        objects.get(5).setIndicies(objectLoader.indicies);
        objects.get(5).scaleObject(1f, 1f, 0.05f);
//        objects.get(5).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(5).translateObject(2.5f, 0.95f, 10.5f);




        // TABLE PARTY 6
        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath12, "fbx");
        Object tableparty2 = objects.get(4).getChildObject().get(5);
        tableparty2.setVertices(objectLoader.vertices);
        tableparty2.setNormal(objectLoader.normals);
        tableparty2.setIndicies(objectLoader.indicies);
        tableparty2.scaleObject(0.02f, 0.02f, 0.02f);
        tableparty2.rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        tableparty2.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        tableparty2.translateObject(1f, 0.05f, 9f);



        //table 7
        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath12, "fbx");
        Object tableparty3 = objects.get(4).getChildObject().get(6);
        tableparty3.setVertices(objectLoader.vertices);
        tableparty3.setNormal(objectLoader.normals);
        tableparty3.setIndicies(objectLoader.indicies);
        tableparty3.scaleObject(0.02f, 0.02f, 0.02f);
        tableparty3.rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        tableparty3.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        tableparty3.translateObject(-2f, 0.05f, 9f);



        objects.get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath12, "fbx");
        Object tableparty4 = objects.get(4).getChildObject().get(7);
        tableparty4.setVertices(objectLoader.vertices);
        tableparty4.setNormal(objectLoader.normals);
        tableparty4.setIndicies(objectLoader.indicies);
        tableparty4.scaleObject(0.02f, 0.02f, 0.02f);
        tableparty4.rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        tableparty4.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        tableparty4.translateObject(-2f, 0.05f, 8f);

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
            //Camera control
            camera.move(window);

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