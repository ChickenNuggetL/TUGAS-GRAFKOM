package Engine;

import org.joml.Vector3f;

import java.util.ArrayList;

public class Bezier {
    int tes = 0;
    public int factorial(int angka){
        int hasil = 1;
        for (int i=2;i<=angka;i++){
            hasil = hasil * i;
        }
        return hasil;
    }

    public int kombinasi(int n, int r){
        if (r < 0 || r > n) {
            return 0;
        }return factorial(n)/(factorial(r)*factorial(n-r));
    }

    public void berzier(ArrayList<Object> objects){

        int indexBerzier = 0;
        for (float t=0;t<=1;t+=0.01f){
            float x = 0;
            float y = 0;
            int n = objects.size()-1;
            for (int i=0;i<=n;i++){
                int koefisien = kombinasi(n, i);
                float term = koefisien * (float) Math.pow(1-t, n-i) * (float) Math.pow(t, i);
//                System.out.println("cek: " + objects.get(i).getCenterx() + " " + objects.get(i).getCentery());
                //x += term * objects.get(i).getCenterx();
                //y += term * objects.get(i).getCentery();
            }
            if (tes == 0){
                //titikBerzier.get(0).addVertices(new Vector3f(x, y, 0));
            }
            if (tes == 1){
                //titikBerzier.get(0).move(x,y,indexBerzier);
                indexBerzier += 1;
            }
        }
        if (tes == 0){
            tes = 1;
        }
    }
}
