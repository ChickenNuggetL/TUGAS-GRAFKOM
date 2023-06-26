import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class CobaBlender {
    int countTree =9;
    float tempCount = -16f;
    boolean keyRditekan = false;
    boolean playingmusic = true;
    float derajatkamera;
    private Window window =
            new Window
                    (1920, 1080, "FNAF");
    private ArrayList<Object> objects
            = new ArrayList<>();
    private ArrayList<Object> objectsRectangle
            = new ArrayList<>();

    private ArrayList<Object> objectsPointsControl
            = new ArrayList<>();

    private MouseInput mouseInput;

    static float rot = 0f;
    Music music;
    int countDegree = 0;
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    Camera camera = new Camera();
    //test abiel

    public CobaBlender() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
    }

    public void init() throws Exception {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        mouseInput = window.getMouseInput();
//        camera.setPosition(0, 1f, 1.7f);
//        camera.moveDown(0.6f);
        music = new Music(-9f);


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
        String filepath11 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_MARIONETTE.fbx";
        String filepath12 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_TABLE_PARTY.fbx";
        String filepath13 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_STAGE.fbx";
        String filepath14 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_KORDEN_CURVE.fbx";
        String filepath15 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_DOLL2.fbx";
        String filepath16 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_DOLL3.fbx";
        String filepath17 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_DOLL4.fbx";
        String filepath18 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_PIZZA.fbx";
        String filepath19 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_FOXY_PILLAR.fbx";
        String filepath20 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_FOXY_KORDEN.fbx";
        String filepath21 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_FOXY_SIGN.fbx";
        String filepath22 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_SAPU.fbx";
        String filepath23 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_RAK.fbx";
        String filepath24 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_MATAHARI.fbx";
        String filepath25 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_AWAN.fbx";
        String filepath26 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_TABLE_KAYU.fbx";
        String filepath27 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_BUTTON.fbx";
        String filepath28 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_HEAD1.fbx";
        String filepath29 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_HEAD2.fbx";
        String filepath30 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_HEAD3.fbx";
        String filepath31 = "resources\\Enviroment\\OFFICE\\ENVIRONMENT_OFFICE_SKELETON.fbx";
        String bonnie = "resources\\Character\\hwbonnie_by_rodaanimation_dd8s569.fbx";
        String foxy = "resources\\Character\\hwfoxy_by_rodaanimation_dd8pskl.fbx";
        String gregory = "resources\\Character\\FabConvert.com_gregory.fbx";
        String drone = "resources\\Character\\drone_costum.fbx";
        String chica = "resources\\Character\\FabConvert.com_ar toy chica.fbx";
        String freddy = "resources\\Character\\freddy fazbear.fbx";






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

        objects.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
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
        objects.get(0).getChildObject().get(10).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.25f);
        objects.get(0).getChildObject().get(10).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
        objects.get(0).getChildObject().get(10).getChildObject().get(0).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(0).rotateObject((float) Math.toRadians(30f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(0).translateObject(-0.7f, 0.36f, 12.5f);

        objects.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
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
        objects.get(0).getChildObject().get(10).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).getChildObject().get(1).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).getChildObject().get(1).scaleObject(0.1f, 0.1f, 0.25f);
        objects.get(0).getChildObject().get(10).getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
        objects.get(0).getChildObject().get(10).getChildObject().get(1).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(1).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(1).translateObject(0.7f, 0.36f, 12.5f);

        objects.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 0.5f, 0.1f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath24, "fbx");
        objects.get(0).getChildObject().get(10).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).getChildObject().get(2).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).getChildObject().get(2).scaleObject(0.05f, 0.05f, 0.05f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(2).translateObject(-0.5f, 1.5f, 13f);

        objects.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath25, "fbx");
        objects.get(0).getChildObject().get(10).getChildObject().get(3).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).getChildObject().get(3).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).getChildObject().get(3).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).getChildObject().get(3).scaleObject(0.05f, 0.05f, 0.05f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(3).translateObject(-0.7f, 1.3f, 13f);

        objects.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath25, "fbx");
        objects.get(0).getChildObject().get(10).getChildObject().get(4).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).getChildObject().get(4).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).getChildObject().get(4).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).getChildObject().get(4).scaleObject(0.05f, 0.05f, 0.05f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(4).translateObject(0f, 1.3f, 13f);

        objects.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath25, "fbx");
        objects.get(0).getChildObject().get(10).getChildObject().get(5).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).getChildObject().get(5).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).getChildObject().get(5).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).getChildObject().get(5).scaleObject(0.05f, 0.05f, 0.05f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(5).translateObject(1f, 1f, 13f);

        objects.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
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

        objectLoader = new ObjectLoader(filepath25, "fbx");
        objects.get(0).getChildObject().get(10).getChildObject().get(6).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(10).getChildObject().get(6).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(10).getChildObject().get(6).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(10).getChildObject().get(6).scaleObject(0.05f, 0.05f, 0.05f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(180f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        objects.get(0).getChildObject().get(10).getChildObject().get(2).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(10).getChildObject().get(6).translateObject(0.6f, 1.5f, 13f);


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

        // objek 12 full dekorasi, gak urus
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

        objectLoader = new ObjectLoader(filepath10, "fbx");
        objects.get(0).getChildObject().get(12).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).scaleObject(0.07f, 0.07f, 0.07f);
        objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).translateObject(0f, 0.15f, 9.2f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath10, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(0).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(0).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(0).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(0).scaleObject(0.07f, 0.07f, 0.07f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(0).translateObject(1f, 0.2f, 9.2f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath10, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(1).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(1).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(1).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(1).scaleObject(0.07f, 0.07f, 0.07f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(1).translateObject(-2f, 0.2f, 9.2f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath10, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(2).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(2).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(2).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(2).scaleObject(0.5f, 0.5f, 0.5f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
//        objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(2).translateObject(-2.5f, 1f, 12f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath11, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(3).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(3).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(3).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(3).scaleObject(0.006f, 0.006f, 0.006f);
        objects.get(0).getChildObject().get(12).getChildObject().get(3).rotateObject((float) Math.toRadians(90f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(3).rotateObject((float) Math.toRadians(90f), 0f, 0f, -1f);
        objects.get(0).getChildObject().get(12).getChildObject().get(3).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(3).translateObject(-3.5f, 0f, 11f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath15, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(4).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(4).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(4).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(4).scaleObject(0.5f, 0.5f, 0.5f);
        objects.get(0).getChildObject().get(12).getChildObject().get(4).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(4).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(4).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(4).rotateObject((float) Math.toRadians(30f), 0f, -1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(4).translateObject(-1.5f, 0.1f, 8.2f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath16, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(5).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(5).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(5).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(5).scaleObject(0.5f, 0.5f, 0.5f);
        objects.get(0).getChildObject().get(12).getChildObject().get(5).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(5).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(5).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(5).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(5).translateObject(1.3f, 0.1f, 7f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 1f, 0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath17, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(6).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(6).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(6).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(6).scaleObject(0.5f, 0.5f, 0.5f);
        objects.get(0).getChildObject().get(12).getChildObject().get(6).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(6).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(6).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(6).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(6).translateObject(2.5f, 0f, 7.4f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath19, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(7).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(7).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(7).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(7).scaleObject(0.7f, 0.9f, 2f);
        objects.get(0).getChildObject().get(12).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(7).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(7).translateObject(3.5f, 0f, 6.5f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath20, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(8).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(8).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(8).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(8).scaleObject(0.3f, 0.17f, 0.5f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(8).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(7).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(8).translateObject(2.7f, 0.2f, 6.5f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.7f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath21, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(9).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(9).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(9).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(9).scaleObject(0.05f, 0.6f, 0.1f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(9).translateObject(2f, 0.0f, 7f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.7f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath21, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(10).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(10).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(10).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(10).scaleObject(0.05f, 0.17f, 0.5f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(10).translateObject(2f, 0.5f, 7f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath18, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(11).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(11).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(11).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(11).scaleObject(0.05f, 0.05f, 0.001f);
        objects.get(0).getChildObject().get(12).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(11).translateObject(-2.9f, 0.9f, 8f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath18, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(12).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(12).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(12).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(12).scaleObject(0.05f, 0.05f, 0.001f);
        objects.get(0).getChildObject().get(12).getChildObject().get(12).rotateObject((float) Math.toRadians(90f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(12).translateObject(-3.9f, 0.9f, 8f);

        objects.get(0).getChildObject().get(12).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath18, "fbx");
        objects.get(0).getChildObject().get(12).getChildObject().get(13).setVertices(objectLoader.vertices);
        objects.get(0).getChildObject().get(12).getChildObject().get(13).setNormal(objectLoader.normals);
        objects.get(0).getChildObject().get(12).getChildObject().get(13).setIndicies(objectLoader.indicies);

        objects.get(0).getChildObject().get(12).getChildObject().get(13).scaleObject(0.03f, 0.03f, 0.001f);
        objects.get(0).getChildObject().get(12).getChildObject().get(13).rotateObject((float) Math.toRadians(90f), 0f, -1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        objects.get(0).getChildObject().get(12).getChildObject().get(9).rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        objects.get(0).getChildObject().get(12).getChildObject().get(13).translateObject(-3.9f, 0.9f, 9f);



        // ini dekorasi untuk ruangan head, yang diatas dekorasi apalah gatau pokoknya dekorasi
























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

        // FLOOR BAGIAN OFFICE KIRI
        objects.get(0).getChildObject().get(13).getChildObject().add(new Sphere(
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
        Object floorOfficeKiri = objects.get(0).getChildObject().get(13).getChildObject().get(0);
        floorOfficeKiri.setVertices(objectLoader.vertices);
        floorOfficeKiri.setNormal(objectLoader.normals);
        floorOfficeKiri.setIndicies(objectLoader.indicies);
        floorOfficeKiri.scaleObject(0.55f, 0.01f, 3f);
        floorOfficeKiri.translateObject(1.5f, 0f, 1.5f);

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

        // WALL PENYAMBUNG RUANGAN 1 KE KIRI
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
        Object wallKeKiri = objects.get(0).getChildObject().get(21);
        wallKeKiri.setVertices(objectLoader.vertices);
        wallKeKiri.setNormal(objectLoader.normals);
        wallKeKiri.setIndicies(objectLoader.indicies);
        wallKeKiri.scaleObject(0.5f, 1f, 0.05f);
//        wallKeKiri.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallKeKiri.translateObject(-1.5f, 0.95f, -1.5f);

        // WALL OFFICE BAGIAN KIRI
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
        Object wallOfficeBagianKiri = objects.get(0).getChildObject().get(22);
        wallOfficeBagianKiri.setVertices(objectLoader.vertices);
        wallOfficeBagianKiri.setNormal(objectLoader.normals);
        wallOfficeBagianKiri.setIndicies(objectLoader.indicies);
        wallOfficeBagianKiri.scaleObject(3.5f, 1f, 0.05f);
        wallOfficeBagianKiri.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallOfficeBagianKiri.translateObject(-2f, 0.95f, 2f);

        // FLOOR OFFICE BAGIAN KIRI
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
        Object floorOfficeKanan = objects.get(0).getChildObject().get(23);
        floorOfficeKanan.setVertices(objectLoader.vertices);
        floorOfficeKanan.setNormal(objectLoader.normals);
        floorOfficeKanan.setIndicies(objectLoader.indicies);
        floorOfficeKanan.scaleObject(0.55f, 0.01f, 3f);
        floorOfficeKanan.translateObject(-1.5f, 0f, 1.5f);

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

        // RAK OBJEK
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(150/255f, 75/255f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath23, "fbx");
        Object rak = objects.get(1).getChildObject().get(6);
        rak.setVertices(objectLoader.vertices);
        rak.setNormal(objectLoader.normals);
        rak.setIndicies(objectLoader.indicies);

        rak.scaleObject(0.9f, 0.4f, 0.05f);
        rak.rotateObject((float)Math.toRadians(90f),1f,0f,0f);
        rak.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        rak.translateObject(3.5f, 0f, 3.5f);

        // BOTOL DI RAK
        objects.get(1).getChildObject().add(new Sphere(
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
        objects.get(1).getChildObject().get(7).setVertices(objectLoader.vertices);
        objects.get(1).getChildObject().get(7).setNormal(objectLoader.normals);
        objects.get(1).getChildObject().get(7).setIndicies(objectLoader.indicies);

        objects.get(1).getChildObject().get(7).scaleObject(0.07f, 0.07f, 0.07f);
//        objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
//        objects.get(1).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        objects.get(1).getChildObject().get(7).translateObject(3.5f, 1.5f, 3f);

        // BONEKA DI RAK
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 165/255f, 0f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath16, "fbx");
        Object doll = objects.get(1).getChildObject().get(8);
        doll.setVertices(objectLoader.vertices);
        doll.setNormal(objectLoader.normals);
        doll.setIndicies(objectLoader.indicies);

        doll.scaleObject(0.5f, 0.5f, 0.5f);
        doll.rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        doll.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        doll.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        doll.rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        doll.translateObject(3.5f, 1.3f, 3.8f);

        // BONEKA DI RAK
        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 1f, 0.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath7, "fbx");
        doll = objects.get(1).getChildObject().get(9);
        doll.setVertices(objectLoader.vertices);
        doll.setNormal(objectLoader.normals);
        doll.setIndicies(objectLoader.indicies);

        doll.scaleObject(0.5f, 0.5f, 0.5f);
        doll.rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        doll.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        doll.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        doll.rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        doll.translateObject(3.5f, 0.7f, 3.8f);

        objects.get(1).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0.5f, 0.5f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath22, "fbx");
        doll = objects.get(1).getChildObject().get(10);
        doll.setVertices(objectLoader.vertices);
        doll.setNormal(objectLoader.normals);
        doll.setIndicies(objectLoader.indicies);

        doll.scaleObject(0.05f, 0.05f, 0.4f);
        doll.rotateObject((float) Math.toRadians(90f), -1f, 0f, 0f);
        doll.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        doll.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        doll.rotateObject((float) Math.toRadians(30f), 0f, 1f, 0f);
        doll.translateObject(2.5f, 0.6f, 4f);

        // RUANG GORDEN
        // WALL SISI KANAN RUANG GORDEN
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

        // WALL SISI BELAKANG RUANG GORDEN
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

        // WALL SISI KIRI RUANG GORDEN
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

        // FLOOR UNTUK RUANG GORDEN
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

        // WALL TRANSISI KE ANTARA RUANG GORDEN KE RUANGAN TOPENG BAGIAN KANAN
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

        // MEJA RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(150/255f, 75/255f, 0f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath26, "fbx");
        objects.get(3).getChildObject().get(5).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(5).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(5).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(5).scaleObject(0.3f, 0.7f, 0.01f);
        objects.get(3).getChildObject().get(5).rotateObject((float)Math.toRadians(90f),-1f, 0f, 0f);
        objects.get(3).getChildObject().get(5).translateObject(3.3f, 0.25f, 11.25f);

        // RAK 1 RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath23, "fbx");
        objects.get(3).getChildObject().get(6).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(6).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(6).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(6).scaleObject(0.3f, 0.7f, 0.01f);
        objects.get(3).getChildObject().get(6).rotateObject((float)Math.toRadians(90f),-1f, 0f, 0f);
        objects.get(3).getChildObject().get(6).translateObject(4.2f, 0.25f, 11f);

        // RAK 2 RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath23, "fbx");
        objects.get(3).getChildObject().get(7).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(7).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(7).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(7).scaleObject(0.3f, 0.7f, 0.01f);
        objects.get(3).getChildObject().get(7).rotateObject((float)Math.toRadians(90f),-1f, 0f, 0f);
        objects.get(3).getChildObject().get(7).rotateObject((float)Math.toRadians(90f),0f, 1f, 0f);
        objects.get(3).getChildObject().get(7).translateObject(3.5f, 0.25f, 12.5f);

        // BONEKA DI RUANG TOPENG
        objects.get(3).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 0f, 0f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath17, "fbx");
        objects.get(3).getChildObject().get(8).setVertices(objectLoader.vertices);
        objects.get(3).getChildObject().get(8).setNormal(objectLoader.normals);
        objects.get(3).getChildObject().get(8).setIndicies(objectLoader.indicies);
        objects.get(3).getChildObject().get(8).scaleObject(0.5f, 0.5f, 0.5f);
        objects.get(3).getChildObject().get(8).rotateObject((float)Math.toRadians(90f),-1f, 0f, 0f);
        objects.get(3).getChildObject().get(8).rotateObject((float)Math.toRadians(90f),0f, 1f, 0f);
        objects.get(3).getChildObject().get(8).rotateObject((float)Math.toRadians(90f),0f, 1f, 0f);
        objects.get(3).getChildObject().get(8).rotateObject((float)Math.toRadians(90f),0f, 1f, 0f);
        objects.get(3).getChildObject().get(8).translateObject(3.5f, 0.25f, 12.5f);

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
        objects.get(4).scaleObject(4f, 0.01f, 5.5f);
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

        // WALL TRANSISI KE RUANG PANGGUNG
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
        objects.get(5).setVertices(objectLoader.vertices);
        objects.get(5).setNormal(objectLoader.normals);
        objects.get(5).setIndicies(objectLoader.indicies);
        objects.get(5).scaleObject(0.5f, 1f, 0.05f);
//        objects.get(5).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(5).translateObject(2f, 0.95f, 12.9f);

        // RUANG PANGGUNG
        // WALL KIRI RUANG PANGGUNG
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
        objects.get(6).setVertices(objectLoader.vertices);
        objects.get(6).setNormal(objectLoader.normals);
        objects.get(6).setIndicies(objectLoader.indicies);
        objects.get(6).scaleObject(0.7f, 1f, 0.05f);
        objects.get(6).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(6).translateObject(1.5f, 0.95f, 12.5f);

        // DEKOR KORDEN WALL KIRI PANGGUNG
        objects.get(6).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(128/255f, 0f, 128/255f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath14, "fbx");
        Object kordenWallKiri = objects.get(6).getChildObject().get(0);
        kordenWallKiri.setVertices(objectLoader.vertices);
        kordenWallKiri.setNormal(objectLoader.normals);
        kordenWallKiri.setIndicies(objectLoader.indicies);
        kordenWallKiri.scaleObject(0.1f, 0.25f, 0.25f);
        kordenWallKiri.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        kordenWallKiri.translateObject(1.5f, 0.0f, 11.8f);

        objects.get(6).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(128/255f, 0f, 128/255f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath14, "fbx");
        Object kordenWallKanan = objects.get(6).getChildObject().get(0).getChildObject().get(0);
        kordenWallKanan.setVertices(objectLoader.vertices);
        kordenWallKanan.setNormal(objectLoader.normals);
        kordenWallKanan.setIndicies(objectLoader.indicies);
        kordenWallKanan.scaleObject(0.1f, 0.25f, 0.25f);
        kordenWallKanan.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        kordenWallKanan.translateObject(-1.5f, 0.0f, 11.8f);

        // WALL BELAKANG RUANG PANGGUNG
        objects.get(6).getChildObject().add(new Sphere(
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
        Object wallBelakangPanggung = objects.get(6).getChildObject().get(1);
        wallBelakangPanggung.setVertices(objectLoader.vertices);
        wallBelakangPanggung.setNormal(objectLoader.normals);
        wallBelakangPanggung.setIndicies(objectLoader.indicies);
        wallBelakangPanggung.scaleObject(0.05f, 1f, 1.5f);
        wallBelakangPanggung.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallBelakangPanggung.translateObject(0f, 0.95f, 13.2f);

        // WALL KANAN RUANG PANGGUNG
        objects.get(6).getChildObject().add(new Sphere(
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
        Object wallKananPanggung = objects.get(6).getChildObject().get(2);
        wallKananPanggung.setVertices(objectLoader.vertices);
        wallKananPanggung.setNormal(objectLoader.normals);
        wallKananPanggung.setIndicies(objectLoader.indicies);
        wallKananPanggung.scaleObject(0.7f, 1f, 0.05f);
        wallKananPanggung.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallKananPanggung.translateObject(-1.5f, 0.95f, 12.5f);

        // STAGE
        objects.get(6).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(filepath13, "fbx");
        Object Panggung = objects.get(6).getChildObject().get(3);
        Panggung.setVertices(objectLoader.vertices);
        Panggung.setNormal(objectLoader.normals);
        Panggung.setIndicies(objectLoader.indicies);
        Panggung.scaleObject(1.4f, 0.3f, 0.5f);
//        Panggung.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        Panggung.translateObject(0f, 0f, 12.5f);

        // WALL TRANSISI KE RUANG MARIONETTE
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
        objects.get(7).setVertices(objectLoader.vertices);
        objects.get(7).setNormal(objectLoader.normals);
        objects.get(7).setIndicies(objectLoader.indicies);
        objects.get(7).scaleObject(1.2f, 1f, 0.05f);
//        objects.get(7).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(7).translateObject(-2.7f, 0.95f, 12.9f);

        // WALL TRANSISI KE RUANG MARIONETTE 2



        // BILIK DI BAGIAN KIRI
        // WALL BAGIAN BELAKANG BILIK
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
        objects.get(8).setVertices(objectLoader.vertices);
        objects.get(8).setNormal(objectLoader.normals);
        objects.get(8).setIndicies(objectLoader.indicies);
        objects.get(8).scaleObject(1f, 1f, 0.05f);
        objects.get(8).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(8).translateObject(-4f, 0.95f, 4.5f);

        // WALL BAGIAN KIRI BILIK
        objects.get(8).getChildObject().add(new Sphere(
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
        Object wallKiriBilik = objects.get(8).getChildObject().get(0);
        wallKiriBilik.setVertices(objectLoader.vertices);
        wallKiriBilik.setNormal(objectLoader.normals);
        wallKiriBilik.setIndicies(objectLoader.indicies);
        wallKiriBilik.scaleObject(1f, 1f, 0.05f);
//        wallKiriBilik.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallKiriBilik.translateObject(-3f, 0.95f, 3.5f);

        // WALL BAGIAN KANAN BILIK
        objects.get(8).getChildObject().add(new Sphere(
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
        Object wallKananBilik = objects.get(8).getChildObject().get(1);
        wallKananBilik.setVertices(objectLoader.vertices);
        wallKananBilik.setNormal(objectLoader.normals);
        wallKananBilik.setIndicies(objectLoader.indicies);
        wallKananBilik.scaleObject(1f, 1f, 0.05f);
//        wallKiriBilik.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallKananBilik.translateObject(-3f, 0.95f, 5.5f);

        // WALL ENTRANCE MARRIONETTE
        objects.get(8).getChildObject().add(new Sphere(
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
        Object wallEntranceMario = objects.get(8).getChildObject().get(2);
        wallEntranceMario.setVertices(objectLoader.vertices);
        wallEntranceMario.setNormal(objectLoader.normals);
        wallEntranceMario.setIndicies(objectLoader.indicies);
        wallEntranceMario.scaleObject(2.5f, 1f, 0.05f);
        wallEntranceMario.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallEntranceMario.translateObject(-3f, 0.95f, 8f);

        // WALL PENUTUP PANJANG
        objects.get(8).getChildObject().add(new Sphere(
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
        Object wallPenutupPanjang = objects.get(8).getChildObject().get(3);
        wallPenutupPanjang.setVertices(objectLoader.vertices);
        wallPenutupPanjang.setNormal(objectLoader.normals);
        wallPenutupPanjang.setIndicies(objectLoader.indicies);
        wallPenutupPanjang.scaleObject(3.8f, 1f, 0.05f);
        wallPenutupPanjang.rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        wallPenutupPanjang.translateObject(-4f, 0.95f, 9.3f);








        // KARAKTER BONNIE
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(150/255f, 75/255f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(bonnie, "fbx");
        objects.get(9).setVertices(objectLoader.vertices);
        objects.get(9).setNormal(objectLoader.normals);
        objects.get(9).setIndicies(objectLoader.indicies);
        objects.get(9).scaleObject(0.01f, 0.01f, 0.01f);
        objects.get(9).rotateObject((float)Math.toRadians(90f),-1f,0f,0f);
        objects.get(9).rotateObject((float)Math.toRadians(180f),0f,1f,0f);
        objects.get(9).translateObject(0f, 0.3f, 12.5f);

        //FOXY
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(150/255f, 75/255f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(foxy, "fbx");
        objects.get(10).setVertices(objectLoader.vertices);
        objects.get(10).setNormal(objectLoader.normals);
        objects.get(10).setIndicies(objectLoader.indicies);
        objects.get(10).scaleObject(0.01f, 0.01f, 0.01f);
        objects.get(10).rotateObject((float)Math.toRadians(90f),-1f,0f,0f);
        objects.get(10).rotateObject((float)Math.toRadians(180f),0f,1f,0f);
        objects.get(10).rotateObject((float)Math.toRadians(90f),0f,1f,0f);
        objects.get(10).translateObject(1.5f, 0.0f, 6f);
//
        // KARAKTER GREGORY
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 1f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(gregory, "fbx");
        objects.get(11).setVertices(objectLoader.vertices);
        objects.get(11).setNormal(objectLoader.normals);
        objects.get(11).setIndicies(objectLoader.indicies);
        objects.get(11).scaleObject(0.01f, 0.01f, 0.01f);
//        objects.get(11).rotateObject((float)Math.toRadians(90f),-1f,0f,0f);
//        objects.get(11).rotateObject((float)Math.toRadians(180f),0f,1f,0f);
        objects.get(11).translateObject(0.2f, 0f, -0.5f);


//
//        // KARAKTER DRONE (STILL ERROR?)
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        //Camera control

        camera = new Camera(mouseInput, objects.get(11));

        objectLoader = new ObjectLoader(drone, "fbx");
        objects.get(12).setVertices(objectLoader.vertices);
        objects.get(12).setNormal(objectLoader.normals);
        objects.get(12).setIndicies(objectLoader.indicies);
        objects.get(12).scaleObject(0.1f, 0.1f, 0.1f);
        objects.get(12).rotateObject((float)Math.toRadians(90f),0f,0f,1f);
        objects.get(12).rotateObject((float)Math.toRadians(90f),1f,0f,0f);
//        objects.get(12).rotateObject((float)Math.toRadians(180f),0f,1f,0f);
        objects.get(12).translateObject(0.2f, 1.3f, 0.5f);

        // KARAKTER CHICA
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(chica, "fbx");
        objects.get(13).setVertices(objectLoader.vertices);
        objects.get(13).setNormal(objectLoader.normals);
        objects.get(13).setIndicies(objectLoader.indicies);
        objects.get(13).scaleObject(0.5f, 0.5f, 0.5f);
        objects.get(13).rotateObject((float)Math.toRadians(90f),1f,0f,0f);
        objects.get(13).rotateObject((float)Math.toRadians(180f),0f,0f,1f);
        objects.get(13).translateObject(1f, 0f, 11f);

        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(150/255f, 75/255f, 0f, 1.0f),
                Arrays.asList(0.0f, 1.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36,
                18
        ));

        objectLoader = new ObjectLoader(freddy, "fbx");
        objects.get(14).setVertices(objectLoader.vertices);
        objects.get(14).setNormal(objectLoader.normals);
        objects.get(14).setIndicies(objectLoader.indicies);
        objects.get(14).scaleObject(0.005f, 0.005f, 0.005f);
        objects.get(14).rotateObject((float)Math.toRadians(90f),-1f,0f,0f);
        objects.get(14).rotateObject((float)Math.toRadians(180f),0f,1f,0f);
        objects.get(14).translateObject(-0.9f, 0f, 11f);

        //Camera control

        camera = new Camera(mouseInput, objects.get(11));
        cameraMode = 0;
        mario = objects.get(11);
        camera.setPosition(-0.16087276f, 0.7192958f, -1.2125171f);
    }



    public void input() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        float move = 0.05f;

        if (window.isKeyPressed(GLFW_KEY_W)) {
            camera.moveForward(move);
            Object gregory = objects.get(11);
            gregory.translateObject(-0.1f * (float)Math.sin(Math.toRadians(camera.angleFromSource)), 0f, -0.1f * (float)Math.cos(Math.toRadians(camera.angleFromSource)));

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

        if (window.isKeyPressed(GLFW_KEY_F)) {

        }

        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            camera.moveUp(move);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveDown(move);
        }
        if (window.isKeyPressed(GLFW_KEY_M)) {
            keyRditekan = true;
//            for(float i = 0f; i < 360f; i += 0.5f) {
//                List<Float> temp = new ArrayList<>(objects.get(0).getCenterPoint());
//                camera.setPosition(temp.get(0) * -1, temp.get(1) * -1, camera.getPosition().z);
//                camera.addRotation(0, (float) Math.toRadians(0.5f));
//                camera.setPosition(temp.get(0) * 1, temp.get(1) * 1, camera.getPosition().z);
//            }
        }

        float move2 = 0.5f;
        if (keyRditekan) {
            float posisiX = camera.getPosition().x;
            float posisiY = camera.getPosition().y;
            float posisiZ = camera.getPosition().z;
            System.out.println("Camera pos = " + posisiX + " " + posisiY+ " " + posisiZ);
        }
        //FOV
        if (window.getMouseInput().getScroll().y != 0) {
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.01f));
            window.getMouseInput().setScroll(new Vector2f());
        }

        if(window.isKeyPressed(GLFW_KEY_LEFT)){
            music.setVOLUME(music.getVOLUME()-3f);
        }

        if(window.isKeyPressed(GLFW_KEY_RIGHT)){
            music.setVOLUME(music.getVOLUME()+3f);
        }

        if(window.isKeyPressed(GLFW_KEY_ESCAPE)){
            playingmusic = false;
            music.stop();
        }

    }

    public void loop() throws Exception {
        while (window.isOpen()) {
            window.update();

            //COLOR SKY
            glClearColor(0.05f,
                    0.05f, 0.05f,
                    0.3f);
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

    public void run() throws Exception {

        init();
        loop();


        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
        if (playingmusic) {
            music.playmusic();
        }

    }

    public static float getRot() {
        return rot;
    }

    public static void setRot(float rot) {
        Main.rot += rot;
    }

    public static void main(String[] args) throws Exception {
        new CobaBlender().run();
    }
}