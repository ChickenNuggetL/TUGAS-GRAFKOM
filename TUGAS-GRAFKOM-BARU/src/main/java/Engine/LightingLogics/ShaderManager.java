package Engine.LightingLogics;

import org.lwjgl.opengl.GL30;

import java.util.*;

import static org.lwjgl.opengl.GL30.*;

import Engine.UniformsMap;

public class ShaderManager {

    public ShaderManager() {}
    public void createPointLights(String uniformName, UniformsMap uniformsMap) throws Exception{
        uniformsMap.createUniform(uniformName + ".colour");
        uniformsMap.createUniform(uniformName + ".position");
        uniformsMap.createUniform(uniformName + ".intensity");
        uniformsMap.createUniform(uniformName + ".constant");
        uniformsMap.createUniform(uniformName + ".linear");
        uniformsMap.createUniform(uniformName + ".quadratic");
    }

    public void setPointLights(String uniformName, UniformsMap uniformsMap, PointLight pointLight){
        uniformsMap.setUniform(uniformName + ".colour", pointLight.getColour());
        uniformsMap.setUniform(uniformName + ".position", pointLight.getPosition());
        uniformsMap.setUniform(uniformName + ".intensity", pointLight.getIntensity());
        uniformsMap.setUniform(uniformName + ".constant", pointLight.getConstant());
        uniformsMap.setUniform(uniformName + ".linear", pointLight.getLinear());
        uniformsMap.setUniform(uniformName + ".quadratic", pointLight.getExponent());
    }
}
