#version 330

struct DirLight{
    vec3 direction;
    vec3 ambient;
    vec3 diffuse;
    vec3 specular;
};

struct PointLight{
    vec3 colour;
    vec3 position;

    float constant;
    float linear;
    float intensity;
    float quadratic;

    vec3 ambient;
    vec3 diffuse;
    vec3 specular;
};

struct SpotLight{
    vec3 position;
    vec3 direction;
    float cutOff;
    float outerCutOff;

    vec3 ambient;
    vec3 diffuse;
    vec3 specular;

    float constant;
    float linear;
    float quadratic;
};

//UNIFORMS
uniform DirLight dirLight;
out vec4 fragColor;
out vec4 fragColor2;
uniform vec4 uni_color;
uniform vec3 lightColor;
uniform vec3 lightPos;
uniform vec3 viewPos;

in vec3 Normal;
in vec3 FragPos;
in vec3 ViewerPos;

//#define NR_POINT_LIGHTS 4
//uniform PointLight pointLights[NR_POINT_LIGHTS];
uniform PointLight pointLight;
uniform SpotLight spotLight;

//CALCULATIONS
vec3 CalcDirLight(DirLight light, vec3 normal, vec3 viewDir){
    vec3 lightDir = normalize(-light.direction);

    //diffuse
    float diff = max(dot(normal, lightDir), 0.0);

    //specular
    vec3 reflectDir = reflect(-lightDir, normal);
    float spec = pow(max(dot(viewDir,reflectDir),0.0),64.0);

    //diffuse sys
    vec3 ambient = light.ambient;
    vec3 diffuse = light.diffuse * diff;
    vec3 specular = light.specular * spec;
    return(ambient + diffuse + specular);
}
//OLD POINT LIGHT
//vec3 CalcPointLight(PointLight light, vec3 normal, vec3 fragPos, vec3 viewDir)
//{
//    vec3 lightDir = normalize(light.position - fragPos);
//    //diffuse shading
//    float diff = max(dot(normal, lightDir), 0.0);
//    //specular shading
//    vec3 reflectDir = reflect(-lightDir, normal);
//    float spec = pow(max(dot(viewDir, reflectDir), 0.0),3072);
//    //attenuation
//    float distance    = length(light.position - fragPos);
//    float attenuation = 1.0 / (light.constant + light.linear * distance +
//    light.quadratic * (distance * distance));
//    //combine results
//    vec3 ambient  = light.ambient;
//    vec3 diffuse  = light.diffuse  * diff;
//    vec3 specular = light.specular * spec;
//    ambient  *= attenuation;
//    diffuse  *= attenuation;
//    specular *= attenuation;
//    return (ambient + diffuse + specular);
//}

vec4 calcLightColour(vec3 light_color, float light_int, vec3 pos, vec3 to_light_dir, vec3 normal){
    vec4 diffuseColour = vec4(0,0,0,0);
    vec4 specColour = vec4(0,0,0,0);
    float specPower = 0.5f;
    //diffuse light
    float diffuseFactor = max(dot(normal, to_light_dir), 0.0);
    diffuseColour = vec4(light_color, 1.0) * light_int * diffuseFactor;

    //spec color
    vec3 camera_dir = normalize(-pos);
    vec3 from_light_dir = -to_light_dir;
    vec3 reflectedLight = normalize(reflect(from_light_dir, normal));
    float specFactor = max(dot(camera_dir, reflectedLight), 0.0);
    specFactor = pow(specFactor, specPower);
    specColour = light_int * specFactor * vec4(light_color, 1.0);

    return (diffuseColour * specColour);
}

//NEW POINT LIGHT
vec4 calcPointLight(PointLight light, vec3 pos, vec3 normal){
    vec3 light_dir = light.position - pos;
    vec3 to_light_dir = normalize(light_dir);
    vec4 light_Colors = calcLightColour(light.colour, light.intensity, pos, to_light_dir, normal);

    //attenuation
    float distance = length(light_dir);
    float attenuationInv = light.constant + light.linear * distance + light.quadratic * distance * distance;
    return light_Colors/attenuationInv;
}

vec3 CalcSpotLight(SpotLight light, vec3 normal, vec3 fragPos, vec3 viewDir)
{

    //diffuse shading
    vec3 lightDir = normalize(light.position - FragPos);
    float diff = max(dot(normal, lightDir), 0.0);

    //specular shading
    vec3 reflectDir = reflect(-lightDir, normal);
    float spec = pow(max(dot(viewDir, reflectDir), 0.0),3072);

    //attenuation
    float distance    = length(light.position - FragPos);
    float attenuation = 1.0 / (light.constant + light.linear * distance +
    light.quadratic * (distance * distance));

    //spotlight intensity
    float theta     = dot(lightDir, normalize(-light.direction));
    float epsilon   = light.cutOff - light.outerCutOff;
    float intensity = clamp((theta - light.outerCutOff) / epsilon, 0.0, 1.0);

    //combine results
    vec3 ambient = light.ambient;
    vec3 diffuse = light.diffuse * diff;
    vec3 specular = light.specular * spec;
    ambient  *= attenuation;
    diffuse  *= attenuation * intensity;
    specular *= attenuation * intensity;
    return (ambient + diffuse + specular);
}



//MAINS
void main()
{
    //ambientSTr
    float ambientStrength = 0.9f;//0.086f;
    vec3 ambient = ambientStrength * lightColor;


    //diffuse
    vec3 lightDir = normalize(lightPos - FragPos);
    float diff = max(dot(Normal,lightDir),0.0f);
    vec3 diffuse = diff * lightColor;

//    vec3 result = (ambient+diffuse) * vec3(uni_color);
//    fragColor = vec4(result,1.0);


    //NEW ONES
    vec3 normal = normalize(Normal);
    vec3 viewDir = normalize(viewPos - FragPos);
    //Directional Light
    vec3 result = CalcDirLight(dirLight, normal, viewDir);
    vec4 result2 = calcPointLight(pointLight, ViewerPos, normal);
    //Gelap terangnay basically
    float intensities = 0.86f;
    fragColor = vec4(result * (ambient * vec3(uni_color)), intensities) + (result2 * (ambient * vec3(uni_color), intensities));
    fragColor2 = vec4(result2 * (ambient * vec3(uni_color), intensities));

    //Point light OLD
    //for(int i = 0;i<NR_POINT_LIGHTS;i++){
    //result += CalcPointLight(pointLights[i],normal,FragPos,viewDir);
    //}

    //POINT LIGHT NEW


    //Spot Light
    result += CalcSpotLight(spotLight,normal,FragPos,viewDir);



}