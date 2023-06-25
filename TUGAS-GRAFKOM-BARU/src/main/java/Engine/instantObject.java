package Engine;

import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class instantObject {
    Object objectnya;

    //untuk mbuat baru
    public instantObject(ArrayList<Object> objectsList, String filepath, float scalex, float scaley, float scalez, float translatex, float translatey, float translatez) throws Exception {
        ObjectLoader objectLoader = new ObjectLoader(filepath, "fbx");
        objectnya = new Sphere(
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
        );
        objectnya.setVertices(objectLoader.vertices);
        objectnya.setNormal(objectLoader.normals);
        objectnya.setIndicies(objectLoader.indicies);

        objectnya.scaleObject(scalex, scaley, scalez);
        objectnya.translateObject(translatex, translatey, translatez);

        objectnya.getChildObject().add(new Sphere(
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
        objectsList.add(objectnya);
    }

    //Untuk edit
    public void Edit(Object objects, String filepath, float scalex, float scaley, float scalez, float translatex, float translatey, float translatez) throws Exception {
        ObjectLoader objectLoader = new ObjectLoader(filepath, "fbx");
        objectnya = objects;
        objects.setVertices(objectLoader.vertices);
        objects.setNormal(objectLoader.normals);
        objects.setIndicies(objectLoader.indicies);

        objects.scaleObject(scalex, scaley, scalez);
        objects.translateObject(translatex, translatey, translatez);

        objects.getChildObject().add(new Sphere(
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
    }
}
