package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;

import java.util.ArrayList;

public class LinkKirby {
    public ArrayList<Object> KirbyRootBody
            = new ArrayList<>();
    public void create(){
        EasyCreateObject Body = new EasyCreateObject();
        EasyCreateObject LeftFoot = new EasyCreateObject();
        EasyCreateObject RightFoot = new EasyCreateObject();
        EasyCreateObject LeftHand = new EasyCreateObject();
        EasyCreateObject RightHand = new EasyCreateObject();
        EasyCreateObject Lefteyes = new EasyCreateObject();
        EasyCreateObject Righteyes = new EasyCreateObject();
        Body.Sphere(KirbyRootBody, 200, 200, 200, 239/255f, 182/255f,212/255f);
        LeftFoot.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 50, 50, 100, 239/255f, 18/255f,18/255f);
        RightFoot.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 50, 50, 100, 239/255f, 18/255f,18/255f);
        LeftHand.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 50, 90, 50, 239/255f, 182/255f,212/255f);
        RightHand.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 50, 90, 50, 239/255f, 182/255f,212/255f);
        Lefteyes.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 25, 50, 20, 15/255f, 15/255f,15/255f);
        Righteyes.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 25, 50, 20, 15/255f, 15/255f,15/255f);
        KirbyRootBody.get(0).getChildObject().get(0).translateObject(135/1000f, -180/1000f, 3/100f);
        KirbyRootBody.get(0).getChildObject().get(1).translateObject(-135/1000f, -180/1000f, 3/100f);
        KirbyRootBody.get(0).getChildObject().get(2).translateObject(215/1000f, -10/1000f, 0f);
        KirbyRootBody.get(0).getChildObject().get(3).translateObject(-215/1000f, 55/1000f, 0f);
        KirbyRootBody.get(0).getChildObject().get(4).translateObject(40/1000f, 55/1000f, -20/100f);
        KirbyRootBody.get(0).getChildObject().get(5).translateObject(-40/1000f, 55/1000f, -20/100f);
    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: KirbyRootBody){
            arrayList.add(object);
        }
    }

    public void draw(){
        for (Object object: KirbyRootBody){
            object.draw();
        }
    }
}
