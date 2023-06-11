package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class Box extends Circle{

    float radiusZ;
    int stackCount;
    int sectorCount;
    List<Vector3f> normal;
    List<Integer> index;
    int nbo;
    int ibo;

    public Box() {

    }

    public Box(List<ShaderProgram.ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
               int sectorCount, int stackCount){
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createBox();
        setupVAOVBO();

    }

    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));

        normal = new ArrayList<>(Arrays.asList(
                //Belakang
                new Vector3f(0.0f,0.0f,-1.0f),
                new Vector3f(0.0f,0.0f,-1.0f),
                new Vector3f(0.0f,0.0f,-1.0f),
                new Vector3f(0.0f,0.0f,-1.0f),
                //depan
                new Vector3f(0.0f,0.0f,1.0f),
                new Vector3f(0.0f,0.0f,1.0f),
                new Vector3f(0.0f,0.0f,1.0f),
                new Vector3f(0.0f,0.0f,1.0f),
                //kiri
                new Vector3f(-1.0f,0.0f,0.0f),
                new Vector3f(-1.0f,0.0f,0.0f),
                new Vector3f(-1.0f,0.0f,0.0f),
                new Vector3f(-1.0f,0.0f,0.0f),
                //kanan
                new Vector3f(1.0f,0.0f,0.0f),
                new Vector3f(1.0f,0.0f,0.0f),
                new Vector3f(1.0f,0.0f,0.0f),
                new Vector3f(1.0f,0.0f,0.0f),
                //atas
                new Vector3f(0.0f,1.0f,0.0f),
                new Vector3f(0.0f,1.0f,0.0f),
                new Vector3f(0.0f,1.0f,0.0f),
                new Vector3f(0.0f,1.0f,0.0f),
                //bawah
                new Vector3f(0.0f,-1.0f,0.0f),
                new Vector3f(0.0f,-1.0f,0.0f),
                new Vector3f(0.0f,-1.0f,0.0f),
                new Vector3f(0.0f,-1.0f,0.0f)
        ));
    }

    public void setupVAOVBO(){
        super.setupVAOVBO();

        //set nbo
        nbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(normal),
                GL_STATIC_DRAW);

        //uniformsMap.createUniform("lightColor");
        //uniformsMap.createUniform("lightPos");
    }

    public void drawSetup(Camera camera, Projection projection){
        super.drawSetup(camera, projection);
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glVertexAttribPointer(1, 3,
                GL_FLOAT,
                false,
                0, 0);

        //uniformsMap.setUniform("lightColor", new Vector3f(1f,1f,1f));
        //uniformsMap.setUniform("lightPos", new Vector3f(1f,2f,0f));
    }

    public void setNormal(List<Vector3f> normal) {
        this.normal = normal;
        setupVAOVBO();
    }


    public List<Vector3f> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void setIndicies(List<Integer> indicies){
        this.index = indicies;
        setupVAOVBO();
        //ibo
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
    }

}


