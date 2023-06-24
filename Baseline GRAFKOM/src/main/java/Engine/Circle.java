package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Circle extends Object {

    public Float radiusX;
    public Float radiusY;

    List<Vector3f> normal;
    int nbo;

    public Circle(){

    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        createCircle();

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
        //setupVAOVBO();
    }

    public double degToRad(float degree) {
        return (degree * Math.PI / (float) 180);
    }

    public void createCircle() {
        vertices.clear();
        for (float i = 0; i < 360; i += 0.1) {
            double rad = degToRad(i);
            Float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
            Float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x, y, z));
        }
    }

    public void createRectangle() {
        vertices.clear();
        int degree = 45;
        for (float i = 0; i < 4; i++) {
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
            Float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x, y, z));
            degree += 90;
        }
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
        uniformsMap.setUniform("dirLight.direction", new Vector3f(-0.2f, -1.0f, -0.3f));
        uniformsMap.setUniform("dirLight.diffuse", new Vector3f(0.4f, 0.4f, 0.4f));
        uniformsMap.setUniform("dirLight.ambient", new Vector3f(0.5f, 0.5f, 0.5f));
        uniformsMap.setUniform("dirLight.specular", new Vector3f(0.5f, 0.5f, 0.5f));
        uniformsMap.setUniform("viewPos", camera.getPosition());
    }

    public void createTriangle() {
        vertices.clear();
        int degree = 90;
        for (float i = 0; i < 3; i++) {
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0) + Math.cos(rad) * radiusX);
            Float y = (float) (centerPoint.get(1) + Math.sin(rad) * radiusY);
            Float z = 0.0f;
            vertices.add(new Vector3f(x, y, z));
            if (degree == 90) {
                degree += 135;
            } else {
                degree += 90;
            }
        }
    }
}