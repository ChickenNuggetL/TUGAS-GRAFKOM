#version 330

//Directional Light (kek dari matahari ke suatu arah)
struct DirLight{
    vec3 direction;
    vec3 ambient;
    vec3 diffuse;
    vec3 specular;
};

uniform DirLight dirLight;
out vec4 fragColor;
uniform vec4 uni_color;
uniform vec3 lightColor;
uniform vec3 lightPos;
uniform vec3 viewPos;

in vec3 Normal;
in vec3 FragPos;

//void main(){
//    //vec4(red,green,blue,alpha)
//    //rgba -> red 100/255
//    //fragColor = vec4(1.0,0.0,0.0,1.0);
//
//    //Ambient
//    float ambientStrength = 0.5;
//    vec3 ambient = ambientStrength * lightColor;
//
//
//    //diffuse
//    vec3 lightDir = normalize(lightPos - FragPos);
//    float diff = max(dot(Normal, lightDir),0.0f);
//    vec3 diffuse = diff * lightColor;
//
//    //specular
//    float specularStrength = 0.5;
//    vec3 viewDir = normalize(viewPos - FragPos);
//
//    //original phong
//    //vec3 reflectDir = reflect(-lightDir, Normal);
//    //float spec = pow(max(dot(viewDir,reflectDir),0.0),64);
//    vec3 specular = specularStrength * spec * lightColor;
//
//    //halfway blinn
//    vec3 halfwayDir = normalize(lightDir + viewDir);
//    float spec = pow(max(dot(Normal,halfwayDir),0.0),192);
//    vec3 specular = specularStrength * spec * lightColor;
//
//    //lighting
//    vec3 result = (ambient+diffuse) * vec3(uni_color);
//    //fragColor = ambientStrength * uni_color;
//    fragColor = vec4(result, 1.0);
//}

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

void main(){
    vec3 normal = normalize(Normal);
    vec3 viewDir = normalize(viewPos - FragPos);
    //Directional Light
    vec3 result = CalcDirLight(dirLight, normal, viewDir);
    fragColor = vec4(result * vec3(uni_color), 1.0);
}

