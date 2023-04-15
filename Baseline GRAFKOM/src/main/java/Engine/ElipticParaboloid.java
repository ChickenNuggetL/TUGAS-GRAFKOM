package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class ElipticParaboloid extends Sphere2{
    public ElipticParaboloid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY, radiusZ, sectorCount, stackCount);
        createElipticParaboloid();
        setupVAOVBO();
    }

    public void createElipticParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        double v = -7 ;
        while (v <= 0) {
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)((v) * Math.cos(u));
                float y = 0.5f * (float)((v) * Math.sin(u));
                float z = 0.5f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
            v += Math.PI / 60;
        }
        vertices = temp;
    }
}
