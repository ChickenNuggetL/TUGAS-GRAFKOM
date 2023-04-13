package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class EasyCreateObject {
    public void Sphere(ArrayList<Object> object){
        object.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(), //Verticces
                new Vector4f(1.0f, 0.3f, 1.0f, 1.0f), //Warna
                Arrays.asList(0.0f, 0.0f, 0.0f), //Coord center point
                0.12f,
                0.12f,
                0.12f,
                36,
                18
        ));
    }
    public void Rectangle(ArrayList<Object> object){
        object.add(new Rectangle(
            Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                ("resources/shaders/scene.vert"
                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                ("resources/shaders/scene.frag"
                , GL_FRAGMENT_SHADER)
            ),
            new ArrayList<>(
                List.of(
                    new Vector3f(0.0f,0.0f,0.0f),
                    new Vector3f(0.5f,0.0f,0.0f),
                    new Vector3f(0.0f,0.5f,0.0f),
                    new Vector3f( 0.5f,0.5f,0.0f)
                )
            ),
            new Vector4f(0.0f,1.0f,1.0f,1.0f),
            Arrays.asList(0,1,2,1,2,3)
        ));
    }

    public void SphereModify(ArrayList<Object> object, float radx, float rady, float radz){
        object.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),//Verticces
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),//Warna
                Arrays.asList(0.0f, 0.0f, 0.0f),//Coord center point
                radx,
                rady,
                radz,
                36,
                18
        ));
    }

}
