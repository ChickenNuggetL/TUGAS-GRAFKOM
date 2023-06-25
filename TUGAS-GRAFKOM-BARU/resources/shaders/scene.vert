#version 330
layout (location=0) in vec3 position;
layout (location=1) in vec3 normal;

uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;

out vec3 Normal;
out vec3 FragPos;
out vec3 ViewerPos;
void main()
{
    //vec4(position,alpha)
    gl_Position = projection * view * model * vec4(position, 1.0);
    FragPos = vec3(model * vec4(position, 1.0));
    ViewerPos = vec3(projection*view*model * vec4(position, 1.0));
    Normal = normalize(model * vec4(normal, 0.0)).xyz;
}