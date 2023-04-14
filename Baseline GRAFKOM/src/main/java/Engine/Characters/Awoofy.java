package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;
import Engine.Sphere;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Awoofy {

    public ArrayList<Object> AwoofyRootBody
            = new ArrayList<>();
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
        EasyCreateObject Lefteyes = new EasyCreateObject();
        EasyCreateObject Righteyes = new EasyCreateObject();
        EasyCreateObject dummy = new EasyCreateObject();

        Body.Tube(AwoofyRootBody, 200, 240, 200,255/255f,165/255f,0f);

        Head.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 200, 200, 200, 255/255f,165/255f,0f);
        Nose.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 30, 20, 150/255f,75/255f,0f);
        LeftFoot1.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        LeftFoot2.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 70, 100, 255/255f, 255/255f,0f);
        LeftFoot3.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        RightFoot1.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        RightFoot2.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 70, 100, 255/255f, 255/255f,0f);
        RightFoot3.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 50, 100, 255/255f, 255/255f,0f);
        LeftHand.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 100, 60, 255/255f,165/255f,0f);
        RightHand.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 50, 100, 60, 255/255f,165/255f,0f);
        Lefteyes.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 25, 50, 20, 15/255f, 15/255f,15/255f);
        Righteyes.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 25, 50, 20, 15/255f, 15/255f,15/255f);
        WhiteHead.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 120, 80, 20, 255/255f,255/255f,255/255f);
        WhiteBody.Sphere((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 135, 150, 20, 255/255f,255/255f,255/255f);
        dummy.ElipticParaboloid((ArrayList<Object>) AwoofyRootBody.get(0).getChildObject(), 20, 20, 20, 255/255f,255/255f,255/255f);


        // head
        AwoofyRootBody.get(0).getChildObject().get(0).translateObject(0/1000f, 150/1000f, 0/100f);
        // nose
        AwoofyRootBody.get(0).getChildObject().get(1).translateObject(0/1000f, 120/1000f, -20/100f);

        // kaki done (awalnya 20 supaya lebih bagus 2dnya, 0 kalo mau bagus 3dnya)
        // left foot1 (original position)
        AwoofyRootBody.get(0).getChildObject().get(2).translateObject(110/1000f, -200/1000f, 0/100f);
        // left foot2
        AwoofyRootBody.get(0).getChildObject().get(3).translateObject(150/1000f, -180/1000f, 0/100f);
        // left foot3
        AwoofyRootBody.get(0).getChildObject().get(4).translateObject(70/1000f, -200/1000f, 0/100f);
        // right foot1 (original position)
        AwoofyRootBody.get(0).getChildObject().get(5).translateObject(-110/1000f, -200/1000f, 0/100f);
        // right foot2
        AwoofyRootBody.get(0).getChildObject().get(6).translateObject(-150/1000f, -180/1000f, 0/100f);
        // right foot3
        AwoofyRootBody.get(0).getChildObject().get(7).translateObject(-70/1000f, -200/1000f, 0/100f);


        // left hand
        AwoofyRootBody.get(0).getChildObject().get(8).translateObject(215/1000f, 20/1000f, 0f);
//        AwoofyRootBody.get(0).getChildObject().get(10).rotateObject((float)Math.toRadians(-20f),1f,0f,0f);
        // right hand
        AwoofyRootBody.get(0).getChildObject().get(9).translateObject(-215/1000f, 20/1000f, 0f);
//        AwoofyRootBody.get(0).getChildObject().get(11).rotateObject((float)Math.toRadians(1f),0f,1f,0f);


        // left eyes
        AwoofyRootBody.get(0).getChildObject().get(10).translateObject(60/1000f, 200/1000f, -20/100f);
        // right eyes
        AwoofyRootBody.get(0).getChildObject().get(11).translateObject(-60/1000f, 200/1000f, -20/100f);

        // White Head
        AwoofyRootBody.get(0).getChildObject().get(12).translateObject(0/1000f, 80/1000f, -19/100f);
        // White Body
        AwoofyRootBody.get(0).getChildObject().get(13).translateObject(0/1000f, -70/1000f, -15/100f);

        // test
        AwoofyRootBody.get(0).getChildObject().get(14).translateObject(300/1000f, 300/1000f, 0/100f);
    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: AwoofyRootBody){
            arrayList.add(object);
        }
    }

    public void draw(){
        for (Object object: AwoofyRootBody){
            object.draw();
        }
    }
}

