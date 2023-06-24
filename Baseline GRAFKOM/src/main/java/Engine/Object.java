package Engine;

import org.joml.*;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Arrays;


import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object extends ShaderProgram{

    public List<Vector3f> vertices;
    int vao;
    int vbo;
    UniformsMap uniformsMap;
    Vector4f color;
    Matrix4f model;
    Matrix4f modelz;
    int vboColor;
    List<Vector3f> verticesColor;
    List<Object> childObject;
    public List<Float> centerPoint;
    //public Vector3f centerpoint;
    List<Vector3f> curve = new ArrayList<>();
    Vector3f position = new Vector3f(0,0,0);
    Vector3f rotationWorld = new Vector3f(0,0,0);
    Vector3f rotationLocal = new Vector3f(0,0,0);
    float degree;
    boolean isCurve;
    float radiusX;
    float radiusY;
    float radiusZ;

    public Object(){

    }
    public Object(List<ShaderModuleData> shaderModuleDataList
            , List<Vector3f> vertices
            , Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.color = color;
        this.isCurve = false;

        //setupVAOVBO();


        uniformsMap = new UniformsMap(getProgramId());
//        uniformsMap.createUniform(
//                "uni_color");
//        uniformsMap.createUniform(
//                "model");
//        uniformsMap.createUniform(
//                "view");
//        uniformsMap.createUniform(
//                "projection");

//        model = new Matrix4f().identity();
        modelz = new Matrix4f().scale(1,1,1);
        model = new Matrix4f().identity();
        childObject = new ArrayList<>();
        centerPoint = Arrays.asList(0f,0f,0f);
    }

//    public Object(List<ShaderModuleData> shaderModuleDataList,
//                    List<Vector3f> vertices, Vector4f color, Vector3f centerpoint,
//                    float radiusX, float radiusY, float radiusZ) {
//        super(shaderModuleDataList);
//        this.centerpoint = centerpoint;
//        this.radiusX = radiusX;
//        this.radiusY = radiusY;
//        this.radiusZ = radiusZ;
//        this.vertices = vertices;
//        this.color = color;
//        uniformsMap = new UniformsMap(getProgramId());
//        uniformsMap.createUniform(
//                "uni_color");
//        uniformsMap.createUniform(
//                "model");
//        this.isCurve = false;
//        model = new Matrix4f().scale(1,1,1);
//        childObject = new ArrayList<>();
//        centerPoint = Arrays.asList(0f,0f,0f);
//
////        setupVAOVBOWithVerticesColor();
//    }


    public void updatePosition(float Xx, float Yy, float Zz) {
        this.position.x += Xx;
        this.position.y += Yy;
        this.position.z += Zz;
    }

    public void updateRotWorld(float Xx, float Yy, float Zz) {
        this.rotationWorld.x += Xx;
        this.rotationWorld.y += Yy;
        this.rotationWorld.z += Zz;
    }

    public void updateRotPos(float Xx, float Yy, float Zz) {
        this.rotationLocal.x += Xx;
        this.rotationLocal.y += Yy;
        this.rotationLocal.z += Zz;
    }

    public void addVerticesForCurve(Vector3f newVector) {
        vertices.add(newVector);
    }

    static int factorial(int n)
    {
        if (n == 0)
            return 1;

        return n*factorial(n-1);
    }
    private int combinations(int n, int r){
        return factorial(n) / factorial(r) / factorial(n - r);
    }
    public void createCurve(){
        curve.clear();
        for(double i = 0; i <= 1.01; i += 0.01){
            curve.add(bezierCurve(i));
        }
        this.vertices = curve;
        setupVAOVBO();
        this.isCurve = true;
    }

    private Vector3f bezierCurve(double t){
        int i = 0;
        int size = vertices.size() - 1;
        Vector3f result = new Vector3f(0.0f, 0.0f, 0.0f);
        for(Vector3f vertice : vertices){
            result.x += combinations(size, i) * Math.pow((1-t), size - i) * vertice.x * Math.pow(t, i);
            result.y += combinations(size, i) * Math.pow((1-t), size - i) * vertice.y * Math.pow(t, i);
            result.z += combinations(size, i) * Math.pow((1-t), size - i) * vertice.z * Math.pow(t, i);
            i += 1;
        }
        return result;
    }

    public List<Object> getChildObject(){
        return childObject;
    }


    public void updateCenterPoint(){
        //model.identity();
        Vector3f destTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,destTemp);
        centerPoint.set(0,destTemp.x);
        centerPoint.set(1,destTemp.y);
        centerPoint.set(2,destTemp.z);
    }
    public void rotateObject(Float Degree, Float x, Float y, Float z){
//        model = new Matrix4f().rotation(Degree, x, y, z).mul(new Matrix4f(model));
        //model = new Matrix4f().rotation((float) Math.toRadians(Degree), x, y, z).mul(new Matrix4f(model));
        model = new Matrix4f().rotate(Degree,x,y,z).mul(new Matrix4f(model));
        updateRotWorld(x, y, z);
        degree = Degree;
        updateCenterPoint();
        for (Object child:childObject) {
            child.rotateObject(Degree, x, y, z);
        }
    }

    public void rotationObject(Float Degree, Float x, Float y, Float z){
//        model = new Matrix4f().rotation(Degree, x, y, z).mul(new Matrix4f(model));
        //model = new Matrix4f().rotation((float) Math.toRadians(Degree), x, y, z).mul(new Matrix4f(model));
        model = new Matrix4f().rotation(Degree,x,y,z).mulLocal(new Matrix4f(model));
        updateRotPos(x, y, z);
        degree = Degree;
        updateCenterPoint();
        for (Object child:childObject) {
            child.rotationObject(Degree, x, y, z);
        }
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().translate(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));
        updatePosition(offsetX, offsetY, offsetZ);
        updateCenterPoint();
        for (Object child:childObject){
            child.translateObject(offsetX,offsetY,offsetZ);
        }
    }
    public void setRotate(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().setRotationXYZ(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));
        updateCenterPoint();
        for (Object child:childObject){
            child.setRotate(offsetX,offsetY,offsetZ);
        }
    }

    public void scaleObject(Float scaleX, Float scaleY, Float scaleZ){
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mul(new Matrix4f(model));
        for (Object child:childObject){
            child.scaleObject(scaleX,scaleY,scaleZ);
        }
    }
    public void scaleObject2(Float scaleX, Float scaleY, Float scaleZ){
        model = new Matrix4f().scale(scaleX, scaleY, scaleZ).mulLocal(new Matrix4f(model));
        for (Object child:childObject){
            child.scaleObject2(scaleX,scaleY,scaleZ);
        }
    }

    public List<Float> getCenterPoint() {
        updateCenterPoint();
        return centerPoint;
    }

    public void addChild(Object x) {
        childObject.add(x);
    }

    public void setCenterPoint(List<Float> centerPoint){
        this.centerPoint = centerPoint;
    }

    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
    }
    public void setupVAOVBOWithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);

        //set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesColor),
                GL_STATIC_DRAW);
    }
    public void drawSetup(Camera camera, Projection projection){
        bind();
        uniformsMap.setUniform(
                "uni_color", color);
        uniformsMap.setUniform(
                "model", model);
        uniformsMap.setUniform(
                "view", camera.getViewMatrix());
        uniformsMap.setUniform(
                "projection", projection.getProjMatrix());
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void drawSetup(){
        bind();
        uniformsMap.setUniform(
                "uni_color", color);
        uniformsMap.setUniform(
                "model", model);

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void drawSetupWithVerticesColor(){
        bind();
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);

        // Bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3,
                GL_FLOAT,
                false,
                0, 0);
    }
    public void draw(Camera camera, Projection projection){
        drawSetup(camera, projection);
        // Draw the vertices
        //optional
        glLineWidth(0.5f); //ketebalan garis
        glPointSize(0.5f); //besar kecil vertex
        //wajib
        //GL_LINES //GL_LINE_STRIP//GL_LINE_LOOP
        //GL_TRIANGLES//GL_TRIANGLE_FAN//GL_POINT
        glDrawArrays(GL_POLYGON,
                0,
                vertices.size());
        for(Object child:childObject) {
            child.draw(camera, projection);
        }
    }

    public void draw(){
        // Draw the vertices
        //optional
        drawSetup();
        glLineWidth(0.5f); //ketebalan garis
        glPointSize(0.5f); //besar kecil vertex
        //wajib
        //GL_LINES //GL_LINE_STRIP//GL_LINE_LOOP
        //GL_TRIANGLES//GL_TRIANGLE_FAN//GL_POINT

        glDrawArrays(GL_POLYGON,
                0,
                vertices.size());
        for(Object child:childObject) {
            child.draw();
        }
    }

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_POLYGON,
                0,
                vertices.size());
    }
    public void drawLine(Camera camera, Projection projection){
        drawSetup(camera, projection);
        // Draw the vertices
        //optional
        glLineWidth(1); //ketebalan garis
        glPointSize(1); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }
    public void addVertices(Vector3f newVertices){
        vertices.add(newVertices);
        setupVAOVBO();
    }
}
