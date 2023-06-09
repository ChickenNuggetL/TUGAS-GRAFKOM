package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;

import java.util.ArrayList;

public class BroomHatter {
    float animDuration = 32f;
    float animStepsDuration = 1f;
    float frameTime = animDuration/animStepsDuration;
    float currentAnimTime = 0f;

    float animspeed = 0.5f;
    //Final position
    float rightfootrot = 40.0f;
    float leftfootrot = 10.0f;
    public ArrayList<Object> BroomHatter
            = new ArrayList<>();

    public void create(){
        EasyCreateObject Body = new EasyCreateObject();
        EasyCreateObject LeftFoot = new EasyCreateObject();
        EasyCreateObject RightFoot = new EasyCreateObject();
        EasyCreateObject LeftHand = new EasyCreateObject();
        EasyCreateObject RightHand = new EasyCreateObject();
        EasyCreateObject Hatbase = new EasyCreateObject();
        EasyCreateObject hat = new EasyCreateObject();
        EasyCreateObject hatTail = new EasyCreateObject();
        EasyCreateObject stick = new EasyCreateObject();



        Body.Sphere(BroomHatter, 120, 200, 120, 255/255f, 255/255f,0/255f);
        LeftFoot.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 50, 100, 210/255f, 105/255f,30/255f);
        RightFoot.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 50, 100, 210/255f, 105/255f,30/255f);
        LeftHand.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 90, 50, 200/255f, 200/255f,0/255f);
        RightHand.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 90, 50, 200/255f, 200/255f,0/255f);
        Hatbase.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(),300, 50f, 300, 0/255f, 0/255f,255/255f);
        hat.EllipticParaboloid((ArrayList<Object>) BroomHatter.get(0).getChildObject(),70, 70, 70, 0/255f, 0/255f,255/255f);
        hatTail.EllipticParaboloid((ArrayList<Object>) BroomHatter.get(0).getChildObject(),20, 20, 100, 0/255f, 0/255f,255/255f);
        stick.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject().get(2).getChildObject(),20, 150f, 20, 181/255f, 101/255f,29/255f);



        BroomHatter.get(0).getChildObject().get(0).translateObject(100/1000f, -180/1000f, -3/100f);
        BroomHatter.get(0).getChildObject().get(1).translateObject(-100/1000f, -170/1000f, -3/100f);

        BroomHatter.get(0).getChildObject().get(2).rotateObject(1.57f,0.5f,1f,-0f);//radian(float)derajat,x,y,z)
        BroomHatter.get(0).getChildObject().get(2).translateObject(60/1000f, -55/1000f, -10/100f);//tangan kanan

        BroomHatter.get(0).getChildObject().get(3).rotateObject(-1.57f,-0.5f,1f,0f);
        BroomHatter.get(0).getChildObject().get(3).translateObject(-60/1000f, -55/1000f, -10/100f);//tangan kiri


        BroomHatter.get(0).getChildObject().get(4).translateObject(0f, 100/1000f, 0f);

        BroomHatter.get(0).getChildObject().get(5).translateObject(0f, 9/1000f, -1/4f);
        BroomHatter.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(90f),1f,0f,0f);

        BroomHatter.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(180),0f,0.5f,0f);
        BroomHatter.get(0).getChildObject().get(6).translateObject(1/1000f, 1/4.3f, 1/4f);

        BroomHatter.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0f, 0/1000f, -1/100f);
    }


    public void basicAnim(boolean isStopped){

        float speed = 0.025f/frameTime;
        if(!isStopped) {
            if (currentAnimTime <= animDuration / 4f) {
                BroomHatter.get(0).translateObject(0f, speed, 0f);
            } else if (currentAnimTime > animDuration / 4f && currentAnimTime <= animDuration * (2f / 4f)) {
                BroomHatter.get(0).translateObject(0f, -speed, 0f);
            } else if (currentAnimTime > animDuration * 2f / 4f && currentAnimTime <= animDuration * (3f / 4f)) {
                BroomHatter.get(0).translateObject(0f, speed, 0f);
            } else if (currentAnimTime > animDuration * 3f / 4f && currentAnimTime <= animDuration) {
                BroomHatter.get(0).translateObject(0f, -speed, 0f);
            } else if (currentAnimTime >= animDuration) {
                currentAnimTime = 0f;
            }
            currentAnimTime += animspeed;
        }
    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: BroomHatter){
            arrayList.add(object);
        }
    }

    public void mengecildimakan(boolean isStopped)
    {
        BroomHatter.get(0).scaleObject(0.996f,0.996f,0.996f);
    }

    public void run(boolean isStopped){
        BroomHatter.get(0).translateObject(0f,0f,-0.005f);
    }

    public void splat(boolean isStopped)
    {
        BroomHatter.get(0).scaleObject(0.999f,0.999f,0.999f);
    }



    public void draw(){
        for (Object object: BroomHatter){
            object.draw();
        }
    }
}
