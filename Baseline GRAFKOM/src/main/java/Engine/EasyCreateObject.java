package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

public class EasyCreateObject {
    Object Objectnya;

    //////////////////////////////////////////////////////////////////////////////////////////
    // CARA PAKENYA CONTOH Sphere(ArrayObject, radius X, radius Y, radius Z)                //
    // KALO MAU DEFAULTNYA CUMAN PERLU Sphere(ArrayObject)                                  //
    // Contoh kalo mau ngewarna Sphere(ArrayObject, radius X, radius Y, radius Z, r, g, b)  //
    // CEK YG ADA DI INIT di main                                                           //
    //////////////////////////////////////////////////////////////////////////////////////////



    //ELIPSE DAN SPHERE
    public void Sphere(ArrayList<Object> object){
        Objectnya = new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(), //Verticces
                new Vector4f(255/255,215/255, 0.0f, 1.0f), //Warna
                Arrays.asList(0.0f, 0.0f, 0.0f), //Coord center point
                0.055f,
                0.055f,
                0.055f,
                36,
                18
        );
        object.add(Objectnya);
    }
    public void Sphere(ArrayList<Object> object, float radx, float rady, float radz){
        Objectnya = new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(), //Verticces
                new Vector4f(255/255f,215/255f, 0.0f, 1.0f), //Warna
                Arrays.asList(0.0f, 0.0f, 0.0f), //Coord center point
                radx/1000f,
                rady/1000f,
                radz/1000f,
                36,
                18
        );
        object.add(Objectnya);
    }

    public void Sphere(ArrayList<Object> object, float radx, float rady, float radz, float red, float green, float blue){
        Objectnya = new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(), //Verticces
                new Vector4f(red, green, blue, 1.0f), //Warna
                Arrays.asList(0.0f, 0.0f, 0.0f), //Coord center point
                radx/1000f,
                rady/1000f,
                radz/1000f,
                36,
                18
        );
        object.add(Objectnya);
    }

    public void Tube(ArrayList<Object> object, float radx, float rady, float radz, float red, float green, float blue ){
        Objectnya = new Tube(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(red, green, blue, 1.0f), //Warna
                Arrays.asList(0.0f, 0.0f, 0.0f), //Coord center point
                radx/1000f,
                rady/1000f,
                radz/1000f,
                36,
                18
        );
        object.add(Objectnya);
    }

    public void ElipticParaboloid(ArrayList<Object> object, float radx, float rady, float radz, float red, float green, float blue ){
        Objectnya = new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(red, green, blue, 1.0f), //Warna
                Arrays.asList(0.0f, 0.0f, 0.0f), //Coord center point
                radx/1000f,
                rady/1000f,
                radz/1000f,
                36,
                18
        );
        object.add(Objectnya);
    }

    public void Cone(ArrayList<Object> object, float radx, float rady, float radz, int sides, float red, float green, float blue){
        Objectnya = new Cone(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(red, green, blue, 1.0f), //Warna
                Arrays.asList(0.0f, 0.0f, 0.0f), //Coord center point
                radx/1000f,
                rady/1000f,
                radz/1000f,
                36,
                18,
                sides
        );
        object.add(Objectnya);
    }


    public void AddChild(Object X){
        Objectnya.addChild(X);
    }

}
