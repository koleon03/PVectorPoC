import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Schneehintergrund_v2_0 extends PApplet {

int anz = 1000;
PVector[] pos = new PVector[anz];
PVector[] speed = new PVector[anz];
int [] gr = new int[anz];
int[] zz = new int[anz];

public void setup() {
  
  for (int i = 0; i< anz; i++) {
    pos[i] = new PVector(random(width), random(height), random(25));;
    speed[i] = new PVector(random(-3, 3), random(1, 3));
    zz[i] = (int)random(5,25);
    stroke(255);
    noCursor();
  }
}

public void draw() {
  background(0);
  for (int i =0; i<anz; i++) {
    stroke(150 + zz[i] * 5);
    flocke((int)pos[i].x, (int)pos[i].y, (int)pos[i].z, (int)pos[i].z);
    pos[i].add(speed[i]);
    if (pos[i].y >= height) {
      pos[i].y = 0;
    }
    if (pos[i].x >= width) {
      pos[i].x = 0;
    }
  }
}

public void flocke(int xPos, int yPos, int gr, int zPos) {
  line(xPos, yPos +gr,zPos, xPos, yPos-gr, zPos);
  line(xPos -gr, yPos,zPos, xPos+gr, yPos, zPos);
  line(xPos -gr, yPos +gr,zPos, xPos +gr, yPos -gr, zPos);
  line(xPos -gr, yPos -gr,zPos, xPos +gr, yPos +gr, zPos);
  line(xPos, yPos-gr,zPos, xPos, yPos+gr,zPos);
  line(xPos-gr, yPos,zPos, xPos+gr, yPos,zPos);
}
  public void settings() {  fullScreen(P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "Schneehintergrund_v2_0" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
