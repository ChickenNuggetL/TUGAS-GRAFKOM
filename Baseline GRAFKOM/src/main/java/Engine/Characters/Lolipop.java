package Engine.Characters;

import Engine.EasyCreateObject;
import Engine.Object;

import java.util.ArrayList;

public class Lolipop {
    public ArrayList<Object> LoliRootBody = new ArrayList<>();

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
        
    }

    public void MoveContents(ArrayList<Object> arrayList){
        for (Object object: LoliRootBody){
            arrayList.add(object);
        }
    }
}
