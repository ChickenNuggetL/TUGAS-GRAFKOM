package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Awoofy {
    // Deklarasi objek untuk menjadi root
    public ArrayList<Object> AwoofyRootBody
            = new ArrayList<>();

    //Animation duration SETUPS
    float animDuration = 32.0f;
    float animStepsDuration = 1.0f;
    float frameTime = animDuration/animStepsDuration;
    float currentAnimTime = 0f;
    float animspeed = 0.5f;
    float rightfootrot = 70.0f;
    float leftfootrot = 20.0f;
    float righthandrot = 80.0f;
    float lefthandrot = 50.0f;
    public void create(){
        EasyCreateObject Head = new EasyCreateObject();
        EasyCreateObject Nose = new EasyCreateObject();
        EasyCreateObject Body = new EasyCreateObject();
        EasyCreateObject WhiteHead = new EasyCreateObject();
        EasyCreateObject WhiteBody = new EasyCreateObject();
        EasyCreateObject LeftFoot1 = new EasyCreateObject();
        EasyCreateObject LeftFoot2 = new EasyCreateObject();
        EasyCreateObject LeftFoot3 = new EasyCreateObject();
        EasyCreateObject RightFoot1 = new EasyCreateObject();
        EasyCreateObject RightFoot2 = new EasyCreateObject();
        EasyCreateObject RightFoot3 = new EasyCreateObject();
        EasyCreateObject LeftHand = new EasyCreateObject();
        EasyCreateObject RightHand = new EasyCreateObject();
        EasyCreateObject LeftEyes = new EasyCreateObject();
        EasyCreateObject LeftEyesWhite = new EasyCreateObject();
        EasyCreateObject RightEyes = new EasyCreateObject();
        EasyCreateObject RightEyesWhite = new EasyCreateObject();
        EasyCreateObject LeftEar = new EasyCreateObject();
        EasyCreateObject RightEar = new EasyCreateObject();
        EasyCreateObject dummy = new EasyCreateObject();

        // Body sebagai parent
        Body.Tube(AwoofyRootBody, 200, 240, 200,255/255f,165/255f,0f);

        // head sebagai child dari body dan mempunyai child seperti dibawah
        Head.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 200, 200, 200, 255/255f,165/255f,0f);
        // Nose -> Child dari Head
        Nose.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 50, 30, 20, 150/255f,75/255f,0f);
        // left foot 1 sebagai child dari body dan mempunyai child lf2-lf3
        LeftFoot1.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        LeftFoot2.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(1).getChildObject(), 50, 70, 100, 255/255f, 255/255f,0f);
        LeftFoot3.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(1).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        // right foot 1 sebagai child dari body dan punya child rf2-rf3
        RightFoot1.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        RightFoot2.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(2).getChildObject(), 50, 70, 100, 255/255f, 255/255f,0f);
        RightFoot3.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(2).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        LeftHand.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 100, 60, 255/255f,165/255f,0f);
        RightHand.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 100, 60, 255/255f,165/255f,0f);
        // eyes black -> child dari head
        LeftEyes.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 25, 50, 20, 15/255f,15/255f,15/255f);
        RightEyes.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 25, 50, 20, 15/255f,15/255f,15/255f);
        // white head -> child dari head
        WhiteHead.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 120, 80, 60, 255/255f,255/255f,255/255f);
        WhiteBody.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 135, 150, 80, 255/255f,255/255f,255/255f);
        // eyes white -> child dari head
        LeftEyesWhite.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 12, 20, 20, 255/255f, 255/255f,255/255f);
        RightEyesWhite.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 12, 20, 20, 255/255f, 255/255f,255/255f);
        // ears -> child dari head
        LeftEar.EllipticParaboloid((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 30, 30, 90, 255/255f,165/255f,0f);
        RightEar.EllipticParaboloid((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject().get(0).getChildObject(), 30, 30, 90, 255/255f,165/255f,0f);
        dummy.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 100, 100, 100, 255/255f,165/255f,0f);

        // get pertama -> index arraylist body (parent)
        // get kedua ->  itu niru child parentnya
        // get ketiga itu array list dari child parent jadi mulai lagi dari 0

        // head
        AwoofyRootBody.get(0).getChildObject().get(0).translateObject(0/1000f, 150/1000f, 0/100f);
        // nose index 0 -> child dari head ke 0
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0/1000f, -25/1000f, -25/100f);

        // kaki (awalnya 20 supaya lebih bagus 2dnya, 0 kalo mau bagus 3dnya)
        // left foot1 (oleftfootrotition)
        AwoofyRootBody.get(0).getChildObject().get(1).translateObject(110/1000f, -200/1000f, 0/100f);
        // left foot2 index 1 -> child dari left foot1 ke 0 (oval)
        AwoofyRootBody.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(45/1000f, 20/1000f, 0/100f);
        // left foot3 index 1 -> child dari left foot1 ke 1 (bulat)
        AwoofyRootBody.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(-45/1000f, 0/1000f, 0/100f);
        // right foot1 (oleftfootrotition)
        AwoofyRootBody.get(0).getChildObject().get(2).translateObject(-110/1000f, -200/1000f, 0/100f);
        // right foot2 index 2 -> child dari right foot1 ke 0
        AwoofyRootBody.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-45/1000f, 20/1000f, 0/100f);
        // right foot3 index 2 -> child dari right foot1 ke 1
        AwoofyRootBody.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(45/1000f, 0/1000f, 0/100f);

        // left hand (215 x awal, 220x awal 2, )
        AwoofyRootBody.get(0).getChildObject().get(3).translateObject(180/1000f, -130/1000f, 0f);
        AwoofyRootBody.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(30f),0f,0f,1f);
        // right hand
        AwoofyRootBody.get(0).getChildObject().get(4).translateObject(-180/1000f, -130/1000f, 0f);
        AwoofyRootBody.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(30f),0f,0f,-1f);

        // left eyes index 0 -> child dari head ke-1
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(60/1000f, 50/1000f, -20/100f);
        // right eyes index 0 -> child dari head ke 2
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-60/1000f, 50/1000f, -20/100f);

        // White Head index 0 -> child dari head ke 3
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(0/1000f, -70/1000f, -20/100f);
        // White Body
        AwoofyRootBody.get(0).getChildObject().get(5).translateObject(0/1000f, -70/1000f, -15/100f);

        // left eyes white index 0 -> child dari head ke 4
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(4).translateObject(65/1000f, 75/1000f, -21/100f);
        // right eyes white index 0 -> child dari head ke 5
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(5).translateObject(-65/1000f, 75/1000f, -21/100f);

        // left ear index 0 -> child dari head ke 6
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(6).translateObject(100/1000f, -150/1000f, -50/100f);
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(90f),1f,0f,0f);
        // right ear index 0 -> child dari head ke 7
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(7).translateObject(-100/1000f, -150/1000f, -50/100f);
        AwoofyRootBody.get(0).getChildObject().get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(90f),1f,0f,0f);

        // test
//        AwoofyRootBody.get(0).getChildObject().get(6).addVerticesForCurve(new Vector3f(-0.5f, -0.2f, -0.1f));
//        AwoofyRootBody.get(0).getChildObject().get(6).addVerticesForCurve(new Vector3f(-0.25f, -0.5f, 0));
//        AwoofyRootBody.get(0).getChildObject().get(6).addVerticesForCurve(new Vector3f(0.25f, -0.5f, 0));
//        AwoofyRootBody.get(0).getChildObject().get(6).addVerticesForCurve(new Vector3f(0.5f, -0.15f, -0.1f));
//        AwoofyRootBody.get(0).getChildObject().get(6).createCurve();
//        AwoofyRootBody.get(0).getChildObject().get(6).translateObject(300/1000f, 300/1000f, -20/100f);
    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: AwoofyRootBody){
            arrayList.add(object);
        }
    }
    float leftFootFrameTime = (float) Math.toRadians(leftfootrot/frameTime);
    float rightFootFrameTime = (float) Math.toRadians(rightfootrot/frameTime) ;
    public void walkAnim(boolean isStopped){
        //STEP DARI PERFECT LOOP WALKING ANIM: Oleftfootrot(ORI), 1leftfootrotITION, ORI, REVERleftfootrotITION
        //STEP DARI ONE TIME MOVEMENT ANIM(SEPERTI MENYERANG DSBGNYA): Oleftfootrot(ORIleftfootrotITION, ORI

        //Animation processes
        if(!isStopped) {
            if (currentAnimTime <= animDuration / 4f && isStopped == false) {
                // 1leftfootrot
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(1).rotationObject((leftFootFrameTime), 0f, -1f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(2).rotationObject((rightFootFrameTime), 1f, 0f, 0f);
            } else if (currentAnimTime > animDuration / 4f && currentAnimTime <= animDuration * (2f / 4f)) {
                // 1leftfootrot - BACK TO ORI
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(1).rotationObject((leftFootFrameTime), 0f, 1f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(2).rotationObject((rightFootFrameTime), -1f, 0f, 0f);
            } else if (currentAnimTime > animDuration * 2f / 4f && currentAnimTime <= animDuration * (3f / 4f)) {
                // Rleftfootrot
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(1).rotationObject((rightFootFrameTime), 1f, 0f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(2).rotationObject((leftFootFrameTime), 0f, -1f, 0f);
            } else if (currentAnimTime > animDuration * 3f / 4f && currentAnimTime <= animDuration) {
                // Rleftfootrot - Back to ori
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(1).rotationObject((rightFootFrameTime), -1f, 0f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(2).rotationObject((leftFootFrameTime), 0f, 1f, 0f);
            } else if (currentAnimTime > animDuration) {
                AwoofyRootBody.get(0).getChildObject().get(1).setRotate(0f, 0f, 0f);
                AwoofyRootBody.get(0).getChildObject().get(2).setRotate(0f, 0f, 0f);
                currentAnimTime = 0f;
            }
            currentAnimTime += animspeed;
        }
    }

    float leftHandFrameTime = (float) Math.toRadians(lefthandrot/frameTime);
    float rightHandFrameTime = (float) Math.toRadians(righthandrot/frameTime) ;
    public void handAnim(boolean isStopped){
        //STEP DARI PERFECT LOOP WALKING ANIM: Oleftfootrot(ORI), 1leftfootrotITION, ORI, REVERleftfootrotITION
        //STEP DARI ONE TIME MOVEMENT ANIM(SEPERTI MENYERANG DSBGNYA): Oleftfootrot(ORIleftfootrotITION, ORI

        //Animation processes
        if(!isStopped) {
            if (currentAnimTime <= animDuration / 4f) {
                // 1leftfootrot
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(3).rotationObject((leftHandFrameTime), 0f, -1f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(4).rotationObject((rightHandFrameTime), 1f, 0f, 0f);
            } else if (currentAnimTime > animDuration / 4f && currentAnimTime <= animDuration * (2f / 4f)) {
                // 1leftfootrot - BACK TO ORI
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(3).rotationObject((leftHandFrameTime), 0f, 1f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(4).rotationObject((rightHandFrameTime), -1f, 0f, 0f);
            } else if (currentAnimTime > animDuration * 2f / 4f && currentAnimTime <= animDuration * (3f / 4f)) {
                // Rleftfootrot
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(3).rotationObject((rightHandFrameTime), 1f, 0f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(4).rotationObject((leftHandFrameTime), 0f, -1f, 0f);
            } else if (currentAnimTime > animDuration * 3f / 4f && currentAnimTime <= animDuration) {
                // Rleftfootrot - Back to ori
                //Awoofy leftfoot
                AwoofyRootBody.get(0).getChildObject().get(3).rotationObject((rightHandFrameTime), -1f, 0f, 0f);
                //Awoofy rightfoot
                AwoofyRootBody.get(0).getChildObject().get(4).rotationObject((leftHandFrameTime), 0f, 1f, 0f);
            } else if (currentAnimTime > animDuration) {
               // AwoofyRootBody.get(0).getChildObject().get(3).setRotate(0f, 0f, 0f);
               // AwoofyRootBody.get(0).getChildObject().get(4).setRotate(0f, 0f, 0f);
                currentAnimTime = 0f;
            }
            else {
                currentAnimTime = 0f;
            }
            currentAnimTime += animspeed;
        }
    }

    public void upDownAnim(boolean isStopped){

        float speed = 0.025f/frameTime;
        if(!isStopped) {
            if (currentAnimTime <= animDuration / 4f) {
                AwoofyRootBody.get(0).translateObject(0f, speed, 0f);
            } else if (currentAnimTime > animDuration / 4f && currentAnimTime <= animDuration * (2f / 4f)) {
                AwoofyRootBody.get(0).translateObject(0f, -speed, 0f);
            } else if (currentAnimTime > animDuration * 2f / 4f && currentAnimTime <= animDuration * (3f / 4f)) {
                AwoofyRootBody.get(0).translateObject(0f, speed, 0f);
            } else if (currentAnimTime > animDuration * 3f / 4f && currentAnimTime <= animDuration) {
                AwoofyRootBody.get(0).translateObject(0f, -speed, 0f);
            } else if (currentAnimTime >= animDuration) {
                currentAnimTime = 0f;
            }
            currentAnimTime += animspeed;
        }
    }

    public void eaten(boolean isStopped) {
        if(!isStopped){
            AwoofyRootBody.get(0).scaleObject(0.996f,0.996f,0.996f);
        }
    }

    public void run(boolean isStopped){
//        float speed = 0.005f/frameTime;
//        if(!isStopped) {
//            if (currentAnimTime <= animDuration / 4f) {
//                AwoofyRootBody.get(0).translateObject(0f, 0f, -speed);
//            } else if (currentAnimTime > animDuration / 4f && currentAnimTime <= animDuration * (2f / 4f)) {
//                AwoofyRootBody.get(0).translateObject(0f, 0f, speed);
//            } else if (currentAnimTime > animDuration * 2f / 4f && currentAnimTime <= animDuration * (3f / 4f)) {
//                AwoofyRootBody.get(0).translateObject(0f, 0f, -speed);
//            } else if (currentAnimTime > animDuration * 3f / 4f && currentAnimTime <= animDuration) {
//                AwoofyRootBody.get(0).translateObject(0f, 0f, speed);
//            } else if (currentAnimTime >= animDuration) {
//                currentAnimTime = 0f;
//            }
//            currentAnimTime += animspeed;
//        }
        AwoofyRootBody.get(0).translateObject(0f,0f,-0.005f);
    }

    public void splat(boolean isStopped) {
        AwoofyRootBody.get(0).scaleObject(0.999f,0.999f,0.999f);
//        AwoofyRootBody.get(0).translateObject(5/1000f,5/1000f,0f);
    }

    public void draw(){
        for (Object object: AwoofyRootBody){
            object.draw();
        }
    }
}

