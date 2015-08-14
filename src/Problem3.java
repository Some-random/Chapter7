/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem3 {
    public static class Line {
        double epsilon = 0.000001;
        public double slope;
        public double yintercept;

        public Line(double s, double y) {
            slope = s;
            yintercept = y;
        }

        public void print() {
            System.out.print("y = " + slope + "x + " + yintercept);
        }

        public boolean intersect(Line line2) {
            return Math.abs(slope - line2.slope) > epsilon ||
                    Math.abs(yintercept - line2.yintercept) < epsilon;
        }
    };

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    //The line representation is given in the form of slope and yintercept, which makes things a lot easier
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Line line1 = new Line(randomInt(5), randomInt(1));
            Line line2 = new Line(randomInt(5), randomInt(2));
            line1.print();
            System.out.print(", ");
            line2.print();
            if (line1.intersect(line2)) {
                System.out.println("  YES");
            } else {
                System.out.println("  NO");
            }
        }
    }
}
