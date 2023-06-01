package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EllipticParaboloid extends Circle{

    float radiusZ;
    int stackCount;
    int sectorCount;
    public EllipticParaboloid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                              int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createElipticParaboloid();
        setupVAOVBO();
    }

    public void createElipticParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        // ini dimasukkan ke arraylist bukan ke vertices makanya surface nya hilang
        for (double v = -Math.PI/2; v <= Math.PI/2; v += Math.PI/100) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI/100) {
                float x = this.radiusX * (float)(v * Math.cos(u));
                float y = this.radiusY * (float)(v * Math.sin(u));
                float z = this.radiusZ * (float)(v*v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }
}
