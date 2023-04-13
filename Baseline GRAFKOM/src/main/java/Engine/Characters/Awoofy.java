package Engine.Characters;

import Engine.Sphere;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Awoofy extends Sphere {

    public Awoofy(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY, radiusZ, sectorCount, stackCount);
    }

    public void draw(){
        //drawSetup();
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glDrawArrays(GL_POLYGON,
                0,
                vertices.size());
    }

    public void createSphere(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        // Elipsoid
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            double u = -Math.PI;
            while (u <= Math.PI) {
                float x = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
                u += Math.PI / 60;
            }
        }
        vertices = temp;
    }

}
