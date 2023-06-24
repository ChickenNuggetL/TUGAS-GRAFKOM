package Engine;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

import static org.lwjgl.glfw.GLFW.*;

public class MouseInput {

    private Vector3f currentPos;
    private Vector2f displVec;
    private Vector2f scroll;
    private boolean inWindow;
    private boolean leftButtonPressed;
    private Vector3f previousPos;
    private boolean rightButtonPressed;
    private boolean mouseMoved;

    public MouseInput(long windowHandle) {
        previousPos = new Vector3f(-1, -1,-1);
        currentPos = new Vector3f();
        scroll = new Vector2f();
        displVec = new Vector2f();
        leftButtonPressed = false;
        rightButtonPressed = false;
        inWindow = false;
        glfwSetCursorPosCallback(windowHandle, (handle, xpos, ypos) -> {
            currentPos.x = (float) xpos;
            currentPos.y = (float) ypos;
        });
        glfwSetCursorEnterCallback(windowHandle, (handle, entered) -> inWindow = entered);
        glfwSetScrollCallback(windowHandle, (handle, xoffset, yoffset)->{
            scroll.x = (float)xoffset;
            scroll.y = (float)yoffset;
        });
        glfwSetMouseButtonCallback(windowHandle, (handle, button, action, mode) -> {
            leftButtonPressed = button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS;
            rightButtonPressed = button == GLFW_MOUSE_BUTTON_2 && action == GLFW_PRESS;
            mouseMoved = action == GLFW_RAW_MOUSE_MOTION;
        });
    }

    public Vector3f getCurrentPos() {
        return currentPos;
    }

    public Vector2f getScroll() {
        return scroll;
    }
    public void setScroll(Vector2f x) {
        scroll = x;
    }

    public void forceCenterMouse(boolean xd, Window window){
        if (xd) {
            //GLFW.glfwSetCursorPos(window.window, (float)window.getWidth()/2, (float)window.getHeight()/2);4
            org.lwjgl.glfw.GLFW.glfwSetInputMode(window.window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
        }
    }


    public Vector2f getDisplVec() {
        return displVec;
    }

    public void input() {
        displVec.x = 0;
        displVec.y = 0;
        if (previousPos.x > 0 && previousPos.y > 0 && inWindow) {
            double deltax = currentPos.x - previousPos.x;
            double deltay = currentPos.y - previousPos.y;
            boolean rotateX = deltax != 0;
            boolean rotateY = deltay != 0;
            if (rotateX) {
                displVec.y = (float) deltax;
            }
            if (rotateY) {
                displVec.x = (float) deltay;
            }
        }
        previousPos.x = currentPos.x;
        previousPos.y = currentPos.y;
    }

    public boolean isLeftButtonPressed() {

        return leftButtonPressed;
    }

    public boolean isRightButtonPressed() {
        return rightButtonPressed;
    }

    public boolean isMoved(){
        return mouseMoved;
    }
    public boolean isMoved2(){
        if(GLFW_RAW_MOUSE_MOTION != 0){
            return true;
        }
        return false;
    }
}

