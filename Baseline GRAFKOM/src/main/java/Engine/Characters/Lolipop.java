package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;

import java.util.ArrayList;

public class Lolipop {
    public ArrayList<Object> LoliRootBody = new ArrayList<>();

    //Animation duration SETUPS
    float animDuration = 32.0f;
    float animStepsDuration = 1.0f;
    float frameTime = animDuration/animStepsDuration;
    float currentAnimTime = 0f;

    float animspeed = 0.5f;
    //Final position
    float lefthandrot = 40.0f;

    public void create(){
        EasyCreateObject Batang =  new EasyCreateObject();
        EasyCreateObject LoliWhiteMain = new EasyCreateObject();
        EasyCreateObject LoliPink = new EasyCreateObject();
        EasyCreateObject LoliWhiteSub = new EasyCreateObject();

        // Batang sebagai parent
        Batang.Box(LoliRootBody, 20, 50, 20, 175/255f,216/255f,230/255f);
        // Loli white main sebagai child dari Batang
        LoliWhiteMain.Sphere((ArrayList<Object>) LoliRootBody.get(0).getChildObject(), 60, 60, 20, 255/255f,255/255f,255/255f);
        // Loli Pink sebagai child dari Loli white main
        LoliPink.Sphere((ArrayList<Object>) LoliRootBody.get(0).getChildObject().get(0).getChildObject(), 45, 45, 30, 255/255f,192/255f,203/255f);
        // Loli white sub sebagai child dari loli white main
        LoliWhiteSub.Sphere((ArrayList<Object>) LoliRootBody.get(0).getChildObject().get(0).getChildObject(), 25, 25, 35, 255/255f,255/255f,255/255f);

        // Loli white main
        LoliRootBody.get(0).getChildObject().get(0).translateObject(0/1000f, 80/1000f, 0/100f);
        // Loli Pink index 0 -> child dari white main ke 0
        LoliRootBody.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0/1000f, 0/1000f, 0/100f);
        // Loli white sub index 0 -> child dari white main ke 1
        LoliRootBody.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0/1000f, 0/1000f, 0/100f);

        LoliRootBody.get(0).translateObject(-600/1000f,-250/1000f,100/1000f);
        LoliRootBody.get(0).rotateObject((float)Math.toRadians(-90f),1f,0f,0f);

    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: LoliRootBody){
            arrayList.add(object);
        }
    }

    float leftHandFrameTime = (float) Math.toRadians(lefthandrot/frameTime);
    public void loliHandAnim(boolean isStopped){
        if(!isStopped) {
            if (currentAnimTime <= animDuration / 4f) {
                LoliRootBody.get(0).rotateObject((leftHandFrameTime), 0f, -1f, 0f);
            } else if (currentAnimTime > animDuration / 4f && currentAnimTime <= animDuration * (2f / 4f)) {
                LoliRootBody.get(0).rotateObject((leftHandFrameTime), 0f, 1f, 0f);
            } else if (currentAnimTime > animDuration * 2f / 4f && currentAnimTime <= animDuration * (3f / 4f)) {
                LoliRootBody.get(0).rotateObject((leftHandFrameTime), 0f, -1f, 0f);
            } else if (currentAnimTime > animDuration * 3f / 4f && currentAnimTime <= animDuration) {
                LoliRootBody.get(0).rotateObject((leftHandFrameTime), 0f, 1f, 0f);
            } else if (currentAnimTime > animDuration) {
                LoliRootBody.get(0).setRotate(0f, 0f, 0f);
                currentAnimTime = 0f;
            }
            currentAnimTime += animspeed;
        }
    }

    public void upDownAnim(boolean isStopped){

        float speed = 0.025f/frameTime;
        if(!isStopped) {
            if (currentAnimTime <= animDuration / 4f) {
                LoliRootBody.get(0).translateObject(0f, speed, 0f);
            } else if (currentAnimTime > animDuration / 4f && currentAnimTime <= animDuration * (2f / 4f)) {
                LoliRootBody.get(0).translateObject(0f, -speed, 0f);
            } else if (currentAnimTime > animDuration * 2f / 4f && currentAnimTime <= animDuration * (3f / 4f)) {
                LoliRootBody.get(0).translateObject(0f, speed, 0f);
            } else if (currentAnimTime > animDuration * 3f / 4f && currentAnimTime <= animDuration) {
                LoliRootBody.get(0).translateObject(0f, -speed, 0f);
            } else if (currentAnimTime >= animDuration) {
                currentAnimTime = 0f;
            }
            currentAnimTime += animspeed;
        }
    }
}
