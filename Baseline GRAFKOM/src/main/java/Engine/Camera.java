package Engine;

import org.joml.*;

import java.lang.Math;

public class Camera {

    float distanceFromSource = -1f;
    float camrotation = 0.25f;
    float angleFromSource = 0;
    float pitch = 5f;
    float yaw = 0f;
    private Vector3f direction;
    private Vector3f position;
    private Vector3f right;
    private Vector2f rotation;
    private Vector3f up;
    private Matrix4f viewMatrix;
    private Object player;

    MouseInput mouse;


    public Camera(MouseInput mouseInput) {
        direction = new Vector3f();
        right = new Vector3f();
        up = new Vector3f();
        position = new Vector3f();
        viewMatrix = new Matrix4f();
        rotation = new Vector2f();
        mouse = mouseInput;
    }

    public Camera(MouseInput mouseInput, Object A) {
        direction = new Vector3f();
        right = new Vector3f();
        up = new Vector3f();
        position = new Vector3f();
        viewMatrix = new Matrix4f();
        rotation = new Vector2f();
        mouse = mouseInput;
        player = A;
    }

    public void addRotation(float x, float y) {
        rotation.add(x, y);
        recalculate();
    }

    public Vector3f getPosition() {
        return position;
    }

    public Matrix4f getViewMatrix() {
        return viewMatrix;
    }

    public void moveBackwards(float inc) {
        viewMatrix.positiveZ(direction).negate().mul(inc);
        position.sub(direction);
        recalculate();
    }

    public void moveDown(float inc) {
        viewMatrix.positiveY(up).mul(inc);
        position.sub(up);
        recalculate();
    }

    public void moveForward(float inc) {
        viewMatrix.positiveZ(direction).negate().mul(inc);
        position.add(direction);
        recalculate();
    }

    public void moveLeft(float inc) {
        viewMatrix.positiveX(right).mul(inc);
        position.sub(right);
        recalculate();
    }

    public void moveRight(float inc) {
        viewMatrix.positiveX(right).mul(inc);
        position.add(right);
        recalculate();
    }

    public void moveUp(float inc) {
        viewMatrix.positiveY(up).mul(inc);
        position.add(up);
        recalculate();
    }

    private void recalculate() {
        viewMatrix.identity();
        viewMatrix.rotateX(rotation.x);
        viewMatrix.rotateY(rotation.y);
        viewMatrix.translate(-position.x, -position.y, -position.z);
    }

    public void setPosition(float x, float y, float z) {
        position.set(x, y, z);
        recalculate();
    }

    public void setRotation(float x, float y) {
        rotation.set(x, y);
        recalculate();
    }

    public void move(){
        calcZoom();
        calcPitchAngle();
        calcAngleAroundPlayer();
        float horizDistance = calcHorizontalDistance();
        float vertDistance = calcVerticalDistance();
        calcCameraPosition(horizDistance, vertDistance);
        recalculate();
    }

    public void calcZoom() {
        if(mouse.getScroll().y != 0) {
            float zoomlevel = mouse.getScroll().y * 0.01f;
            distanceFromSource -= zoomlevel;
        }
    }

    public void calcPitch() {
        if(mouse.isLeftButtonPressed()) {
            float pitchchange = mouse.getDisplVec().x * 0.1f;
            pitch -= pitchchange;
        }
    }

    public void calcAngleAroundPlayer(){
        if(mouse.isRightButtonPressed()){
            float angleChange = mouse.getDisplVec().y * 0.2f;
            angleFromSource += angleChange;
        }
    }

    public void calcPitchAngle() {
        if(mouse.isLeftButtonPressed()) {
            float pitchchange = mouse.getDisplVec().x * camrotation;
            float angleChange = mouse.getDisplVec().y * camrotation;
            angleFromSource -= angleChange;
            pitch -= pitchchange;
            Vector2f displayvec = mouse.getDisplVec();
            addRotation((float) Math.toRadians((displayvec.x) * camrotation), (float) Math.toRadians((displayvec.y) * camrotation));
        }
    }

    public void calcCameraPosition(float horizDist, float vertDist) {
        float theta = player.rotationWorld.y + angleFromSource;
        float offsetX = (float) (horizDist * Math.sin(Math.toRadians(theta)));
        float offsetZ = (float) (horizDist * Math.cos(Math.toRadians(theta)));
        position.x = player.position.x - offsetX;
        position.z = player.position.z - offsetZ;
        position.y = player.position.y + vertDist;
    }

    public float calcHorizontalDistance() {
        return (float) (distanceFromSource * Math.cos(Math.toRadians(pitch)));
    }

    public float calcVerticalDistance() {
        return (float) (distanceFromSource * Math.sin(Math.toRadians(pitch)));
    }
    public Vector3f getDirection() {
        return direction;
    }

}