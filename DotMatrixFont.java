import fontastic.FGlyph;
import fontastic.Fontastic;
import processing.core.PApplet;
import processing.core.PVector;

@SuppressWarnings("serial")
public class DotMatrixFont extends PApplet {
  static final char quote = '"';
  static final String chars = " !"+quote+"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_ abcdefghijklmnopqrstuvwxyz |{}";
  static final byte[] bitmap = new byte[] { 0,  0,  0,  0,  0,  0,  0,
                               4,  4,  4,  4,  4,  0,  4,
                              10, 10, 10,  0,  0,  0,  0,
                              10, 10, 31, 10, 31, 10, 10,
                               4, 15, 20, 14,  5, 30,  4,
                              24, 25,  2,  4,  8, 19,  3,
                               8, 20, 20,  8, 21, 18, 13,
                               4,  4,  0,  0,  0,  0,  0,
                               4,  8, 16, 16, 16,  8,  4,
                               4,  2,  1,  1,  1,  2,  4,
                               4, 21, 10,  4, 10, 21,  4,
                               0,  4,  4, 31,  4,  4,  0,
                               0,  0,  0,  0,  6,  6, 12,
                               0,  0,  0, 31,  0,  0,  0,
                               0,  0,  0,  0,  0, 12, 12,
                               0,  1,  2,  4,  8, 16,  0,
                              14, 17, 19, 21, 25, 17, 14,
                               4, 12,  4,  4,  4,  4, 14,
                              14, 17,  1,  6,  8, 16, 31,
                              31,  1,  2,  6,  1, 17, 14,
                               2,  6, 10, 18, 31,  2,  2,
                              31, 16, 30,  1,  1, 17, 14,
                              14, 17, 16, 30, 17, 17, 14,
                              31,  1,  2,  4,  8,  8,  8,
                              14, 17, 17, 14, 17, 17, 14,
                              14, 17, 17, 15,  1, 17, 14,
                               0, 12, 12,  0, 12, 12,  0,
                               0,  0,  6,  0,  6,  6, 12,
                               2,  4,  8, 16,  8,  4,  2,
                               0,  0, 31,  0, 31,  0,  0,
                               8,  4,  2,  1,  2,  4,  8,
                              14, 17,  2,  4,  4,  0,  4,
                              14, 17,  1, 13, 22, 22, 14,
                              14, 17, 17, 17, 31, 17, 17,
                              30, 17, 17, 30, 17, 17, 30,
                              14, 17, 16, 16, 16, 17, 14,
                              30, 17, 17, 17, 17, 17, 30,
                              31, 16, 16, 30, 16, 16, 31,
                              31, 16, 16, 30, 16, 16, 16,
                              14, 17, 16, 23, 17, 17, 14,
                              17, 17, 17, 31, 17, 17, 17,
                              14,  4,  4,  4,  4,  4, 14,
                               1,  1,  1,  1, 17, 17, 14,
                              17, 18, 20, 24, 20, 18, 17,
                              16, 16, 16, 16, 16, 16, 31,
                              27, 21, 21, 17, 17, 17, 17,
                              17, 17, 25, 21, 19, 17, 17,
                              14, 17, 17, 17, 17, 17, 14,
                              30, 17, 17, 30, 16, 16, 16,
                              14, 17, 17, 17, 21, 18, 13,
                              30, 17, 17, 30, 18, 17, 17,
                              14, 17, 16, 14,  1, 17, 14,
                              31,  4,  4,  4,  4,  4,  4,
                              17, 17, 17, 17, 17, 17, 14,
                              17, 17, 17, 17, 17, 10,  4,
                              17, 17, 17, 21, 27, 17, 17,
                              17, 17, 10,  4, 10, 17, 17,
                              17, 17, 17, 14,  4,  4,  4,
                              31,  1,  2,  4,  8, 16, 31,
                              30, 24, 24, 24, 24, 24, 30,
                               0, 16,  8,  4,  2,  1,  0,
                              15,  3,  3,  3,  3,  3, 15,
                               4, 10,  0,  0,  0,  0,  0,
                               0,  0,  0,  0,  0, 31,  0,
                               0,  0,  0,  0,  0,  0,  0,
                               0, 14,  1, 15, 17, 15,  0,
                              16, 16, 30, 17, 17, 30,  0,
                               0, 14, 16, 16, 16, 14,  0,
                               1,  1, 15, 17, 17, 15,  0,
                               0, 14, 17, 30, 16, 14,  0,
                               3,  4, 14,  4,  4,  4,  0,
                               0, 14, 17, 17, 15,  1, 14,
                              16, 16, 22, 25, 17, 17,  0,
                               4,  0,  4,  4,  4,  4,  0,
                               2,  0,  2,  2,  2, 18, 12,
                              16, 18, 20, 24, 20, 18,  0,
                              12,  4,  4,  4,  4, 14,  0,
                               0, 10, 21, 21, 21, 21,  0,
                               0, 22, 25, 17, 17, 17,  0,
                               0, 14, 17, 17, 17, 14,  0,
                               0, 30, 17, 17, 30, 16, 16,
                               0, 15, 17, 17, 15,  1,  1,
                               0, 22, 25, 16, 16, 16,  0,
                               0, 14, 16, 14,  1, 14,  0,
                               8, 28,  8,  8,  9,  6,  0,
                               0, 17, 17, 17, 17, 14,  0,
                               0, 17, 17, 10, 10,  4,  0,
                               0, 21, 21, 21, 21, 10,  0,
                               0, 17, 10,  4, 10, 17,  0,
                               0, 17, 17, 17, 15,  1, 14,
                               0, 31,  2,  4,  8, 31,  0,
                               0,  0,  0,  0,  0,  0,  0,
                               4,  4,  4,  4,  4,  4,  4,
                               8,  4,  4,  2,  4,  4,  8,
                               2,  4,  4,  8,  4,  4,  2};
  
  
  
  public static void drawDot(FGlyph fg, int x, int y) {
    // x=0..4, y=0..6. Whole character = 512*1024.
    // sin(0)=0
    // cos(0)=1
    
    int res = 12;
    float step = (float)((2*Math.PI)/res);
    int cx=(x*90)+45;
    int cy=((7-y)*90)+45;
    int rd=45;
    
    PVector[] points = new PVector[res]; // Define a PVector array containing the points of the shape
    for (int i=0; i<res; i++) {
      points[i] = new PVector((float)(cx+rd*Math.sin(i*step)),(float)(cy+rd*Math.cos(i*step)));
    }
    fg.addContour(points);
  }
  
  public static void drawLine(byte b, FGlyph fg, int x, int y) {
    if ((b & 16)==16) drawDot(fg,x,y);
    if ((b & 8)==8) drawDot(fg,x+1,y);
    if ((b & 4)==4) drawDot(fg,x+2,y);
    if ((b & 2)==2) drawDot(fg,x+3,y);
    if ((b & 1)==1) drawDot(fg,x+4,y);
  }
  
  public static void main(String[] args) {
    DotMatrixFont dmf = new DotMatrixFont();
    Fontastic f = new Fontastic(dmf, "DotMatrix5x7");
    int k=0;
    for (int i=0; i<chars.length(); i++) {
      FGlyph fg = f.addGlyph(chars.charAt(i));
      for (int j=0; j<7; j++) {
        drawLine(bitmap[k++],fg,0,j);
      }
      System.out.println("AW = "+fg.getAdvanceWidth());
    }
    
    f.buildFont();
    f.cleanup();
  }
 
}
