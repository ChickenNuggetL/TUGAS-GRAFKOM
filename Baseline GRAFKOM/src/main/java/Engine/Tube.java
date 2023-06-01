package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tube extends Sphere2{
    public Tube(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY, radiusZ, sectorCount, stackCount);
        createTube(radiusX,radiusY);
        setupVAOVBO();
    }

    public void createTube(float radius, float height){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v <= 360; v+=0.01){
            float x = radius * (float) (Math.cos(Math.toRadians(v)));
            float y = radius * (float) (Math.sin(Math.toRadians(v)));
            temp.add(new Vector3f(x,y,-(height)/2.0f));
            temp.add(new Vector3f(x,y,height/2.0f));
        }
        vertices = temp;



    }
}
