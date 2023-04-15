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
        EasyCreateObject Mouth = new EasyCreateObject();
        EasyCreateObject Hat = new EasyCreateObject(), HatOuter= new EasyCreateObject(), HatPeak = new EasyCreateObject();

        EasyCreateObject SwordHandle = new EasyCreateObject(), SwordGuard = new EasyCreateObject(),
                SwordBlade = new EasyCreateObject();

        Body.Sphere(KirbyRootBody, 200f, 200f, 200f, 239/255f, 182/255f,212/255f);

        LeftFoot.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 90, 60, 130, 239/255f, 18/255f,18/255f);
        RightFoot.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 90, 60, 130, 239/255f, 18/255f,18/255f);
        LeftHand.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 50, 90, 50, 239/255f, 182/255f,212/255f);
        RightHand.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 50, 90, 50, 239/255f, 182/255f,212/255f);
        Lefteyes.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 25, 50, 20, 15/255f, 15/255f,15/255f);
        Righteyes.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 25, 50, 20, 15/255f, 15/255f,15/255f);
        Mouth.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 100, 80, 19, 75/255f, 15/255f,15/255f);
        Hat.EllipticParaboloid((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 100f, 100f, 110f, 19/255f, 182/255f,22/255f);
        HatOuter.EllipticParaboloid((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 125f, 125f, 35f, 220/255f, 220/255f,200/255f);
        HatPeak.Sphere((ArrayList<Object>) KirbyRootBody.get(0).getChildObject(), 40,40,40, 255/255f, 255/255f,210/255f);
        //Sword creation
        SwordHandle.Tube((ArrayList<Object>) KirbyRootBody.get(0).getChildObject().get(3).getChildObject(),20, 80, 20);
        SwordGuard.Box((ArrayList<Object>) KirbyRootBody.get(0).getChildObject().get(3).getChildObject(),40, 100, 20);

        //TRANSLATES
        //FOOTS
        KirbyRootBody.get(0).getChildObject().get(0).translateObject(135/1000f, -180/1000f, 3/100f);
        KirbyRootBody.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(-15f), 0f, 1f ,0f); //UNTUK ROTATE MAININ SUMBU ROTATENYA AJA SESUAI DERAJAT KYK ini 55derajat
        KirbyRootBody.get(0).getChildObject().get(1).translateObject(-135/1000f, -180/1000f, 3/100f);
        KirbyRootBody.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(45f), 1f, 0f ,0f);//UNTUK ROTATE MAININ SUMBU ROTATENYA AJA SESUAI DERAJAT KYK ini 45derajat
        //HANDS
        KirbyRootBody.get(0).getChildObject().get(2).translateObject(215/1000f, -10/1000f, 0f);
        KirbyRootBody.get(0).getChildObject().get(3).translateObject(-215/1000f, 55/1000f, 0f);
        KirbyRootBody.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(-45f), 1f, 0f ,0f);
        //SWORD IN RIGHT HAND: handle, guard, blade
        KirbyRootBody.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(20/1000f, 100/1000f, 0f);
        KirbyRootBody.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(15/1000f, 130/1000f, 25/1000f);
        //EYES AND MOUTH
        KirbyRootBody.get(0).getChildObject().get(4).translateObject(40/1000f, 55/1000f, -20/100f);
        KirbyRootBody.get(0).getChildObject().get(5).translateObject(-40/1000f, 55/1000f, -20/100f);
        KirbyRootBody.get(0).getChildObject().get(6).translateObject(0/1000f, -45/1000f, -195/1000f);
        KirbyRootBody.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(10f), -1f, 0f ,0f);
        //HAT
        KirbyRootBody.get(0).getChildObject().get(7).translateObject(0/1000f, 5/1000f, -420/1000f);
        KirbyRootBody.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(120f), 1f, 0f ,0f);
        KirbyRootBody.get(0).getChildObject().get(8).translateObject(0/1000f, 5/1000f, -190/1000f);
        KirbyRootBody.get(0).getChildObject().get(8).rotateObject((float)Math.toRadians(120f), 1f, 0f ,0f);
        KirbyRootBody.get(0).getChildObject().get(9).translateObject(40/1000f, 295/1000f, 265/1000f);
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
