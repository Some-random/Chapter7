import java.util.HashMap;

/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem6 {
    public static class Point {
        int x;
        int y;
        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public static class Line {
        double slope;
        double yintercept;
        Line(double _s, double _y) {
            slope = _s;
            yintercept = _y;
        }
    }

    public static int maxPoints(Point[] points) {
        if(points.length <= 2) {
            return points.length;
        }
        int i, j;
        int vert, normal, result = Integer.MIN_VALUE, dup;
        for(i = 0; i < points.length; i++) {
            HashMap<Double, Integer> HDI = new HashMap<>();
            normal = dup = 0;
            vert = 1;
            for(j = i + 1; j < points.length; j++) {
                if(points[i].x != points[j].x) {
                    double slope = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(slope == -0.0) {
                        slope = 0.0;
                    }
                    if(HDI.containsKey(slope)) {
                        HDI.put(slope, HDI.get(slope) + 1);
                    }
                    else {
                        HDI.put(slope, 2);
                    }
                }
                else {
                    if(points[i].y == points[j].y) {
                        dup++;
                    }
                    else {
                        if(vert == 0) {
                            vert = 2;
                        }
                        else {
                            vert++;
                        }
                    }
                }
            }
            for(int k : HDI.values()) {
                normal = Integer.max(normal, k);
            }
            int tempmax = Integer.max(normal + dup, vert + dup);
            result = Integer.max(result, tempmax);
        }
        return result;
    }

    //Interesting question. Notice the construction of hashmap based on each of the new points and the use of dup/ vert
    //Also keep an eye on the weird behavior of -0.0 when using double.
    public static void main(String[] args) {
        Point A = new Point(0, 0);
        Point B = new Point(-1 , -1);
        Point C = new Point(2, 2);
        Point[] ABC = {A, B, C};
        System.out.println(maxPoints(ABC));
    }

}
