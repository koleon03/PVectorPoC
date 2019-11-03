int anz = 1000;
PVector[] pos = new PVector[anz];
PVector[] speed = new PVector[anz];
int [] gr = new int[anz];
int[] zz = new int[anz];

void setup() {
  fullScreen(P3D);
  for (int i = 0; i< anz; i++) {
    pos[i] = new PVector(random(width), random(height), random(25));;
    speed[i] = new PVector(random(-3, 3), random(1, 3));
    zz[i] = (int)random(5,25);
    stroke(255);
    noCursor();
  }
}

void draw() {
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

void flocke(int xPos, int yPos, int gr, int zPos) {
  line(xPos, yPos +gr,zPos, xPos, yPos-gr, zPos);
  line(xPos -gr, yPos,zPos, xPos+gr, yPos, zPos);
  line(xPos -gr, yPos +gr,zPos, xPos +gr, yPos -gr, zPos);
  line(xPos -gr, yPos -gr,zPos, xPos +gr, yPos +gr, zPos);
  line(xPos, yPos-gr,zPos, xPos, yPos+gr,zPos);
  line(xPos-gr, yPos,zPos, xPos+gr, yPos,zPos);
}
