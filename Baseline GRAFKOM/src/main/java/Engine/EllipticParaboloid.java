package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class EllipticParaboloid extends Sphere2{
    public EllipticParaboloid(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY, radiusZ, sectorCount, stackCount);
        createElipticParaboloid();
        setupVAOVBO();
    }

    public void createElipticParaboloid(){
        for (double v = -Math.PI/2; v <= Math.PI/2; v+=Math.PI/100){
            for(double u = -Math.PI; u <= Math.PI; u+=Math.PI/100){
                float x = this.radiusX * (float)((v) * Math.cos(u));
                float y = this.radiusY * (float)((v) * Math.sin(u));
                float z = this.radiusZ * (float)(Math.pow(v,2));
                vertices.add(new Vector3f(x,y,z));
            }
        }
    }
}
