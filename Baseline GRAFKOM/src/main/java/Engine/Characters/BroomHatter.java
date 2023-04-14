package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;

import java.util.ArrayList;

public class BroomHatter {
    public ArrayList<Object> BroomHatter
            = new ArrayList<>();

    public void create(){
        EasyCreateObject Body = new EasyCreateObject();
        EasyCreateObject LeftFoot = new EasyCreateObject();
        EasyCreateObject RightFoot = new EasyCreateObject();
        EasyCreateObject LeftHand = new EasyCreateObject();
        EasyCreateObject RightHand = new EasyCreateObject();
        EasyCreateObject Hat = new EasyCreateObject();


        Body.Sphere(BroomHatter, 120, 200, 120, 255/255f, 255/255f,0/255f);
        LeftFoot.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 50, 100, 210/255f, 105/255f,30/255f);
        RightFoot.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 50, 100, 210/255f, 105/255f,30/255f);
        LeftHand.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 90, 50, 200/255f, 200/255f,0/255f);
        RightHand.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(), 50, 90, 50, 200/255f, 200/255f,0/255f);
        Hat.Sphere((ArrayList<Object>) BroomHatter.get(0).getChildObject(),300, 50f, 300, 0/255f, 0/255f,255/255f);

        BroomHatter.get(0).getChildObject().get(0).translateObject(100/1000f, -180/1000f, -3/100f);
        BroomHatter.get(0).getChildObject().get(1).translateObject(-100/1000f, -180/1000f, -3/100f);
        BroomHatter.get(0).getChildObject().get(2).rotateObject(1.57f,0.8f,0.7f,-0.25f);//radian(float)derajat,x,y,z)
        BroomHatter.get(0).getChildObject().get(2).translateObject(60/1000f, -55/1000f, -10/100f);//tangan kanan

        BroomHatter.get(0).getChildObject().get(3).rotateObject(1.57f,0.8f,0.7f,0.25f);
        BroomHatter.get(0).getChildObject().get(3).translateObject(-60/1000f, -55/1000f, -10/100f);//tangan kiri
        BroomHatter.get(0).getChildObject().get(4).translateObject(0f, 100/1000f, 0f);

    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: BroomHatter){
            arrayList.add(object);
        }
    }

    public void draw(){
        for (Object object: BroomHatter){
            object.draw();
        }
    }
}
