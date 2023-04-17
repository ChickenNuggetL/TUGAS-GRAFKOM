package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;

import java.util.ArrayList;

public class Lolipop {
    public ArrayList<Object> LoliRootBody = new ArrayList<>();

    public void create(){
        EasyCreateObject Batang =  new EasyCreateObject();
        EasyCreateObject LoliWhite = new EasyCreateObject();
        EasyCreateObject LoliPink = new EasyCreateObject();

        Batang.Box(LoliRootBody, 20, 50, 20, 175/255f,216/255f,230/255f);
        LoliWhite.Sphere((ArrayList<Object>) LoliRootBody.get(0).getChildObject(), 60, 60, 20, 255/255f,255/255f,255/255f);
        LoliPink.Sphere((ArrayList<Object>) LoliRootBody.get(0).getChildObject().get(0).getChildObject(), 45, 45, 30, 255/255f,192/255f,203/255f);


        LoliRootBody.get(0).getChildObject().get(0).translateObject(0/1000f, 80/1000f, 0/100f);


    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: LoliRootBody){
            arrayList.add(object);
        }
    }
}
