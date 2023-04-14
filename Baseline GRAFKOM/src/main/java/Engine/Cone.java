package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Cone extends Sphere2{
    int sides;
    public Cone(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount,int sides) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY, radiusZ, sectorCount, stackCount);
        this.sides = sides;
        createCone(radiusX, radiusY, sides);
    }

    public void createCone(float radius, float height, int sides){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<Vector3f>();

        for (int i = 0; i <= sides; i++) {
            float angle = (float) (i * 2.0f * Math.PI / sides);
            float x = radius * (float) Math.cos(angle);
            float z = radius * (float) Math.sin(angle);
            temp.add(new Vector3f(x,0.0f,z));
            temp.add(new Vector3f(0.0f,height,0.0f));
        }
        vertices = temp;
    }
}
