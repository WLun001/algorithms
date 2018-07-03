package collection;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

public class SortedPoint {
    public static void main(String[] args) {
        Point[] points = new Point[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(Math.random() * 100, Math.random() * 100);

            System.out.println("Sort on x-coordinates:");
            Arrays.sort(points);
            for (Point e : points) System.out.println(e);

            System.out.println("Sort on y-coordinates:");
            Arrays.sort(points, new Point.CompareY());
            for (Point e : points) System.out.println(e);
        }
    }

    static class Point implements Comparable<Point> {
        double x, y;

        Point() {
            this.x = this.y = 0.0;
        }

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(@NotNull Point p2) {
            if (this.x < p2.x) return -1;
            else if (this.x > p2.x) return 1;
            else if (this.y < p2.y) return -1;
            else if (this.y > p2.y) return 1;
            else return 0;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        static class CompareY implements Comparator<Point> {
            @Override
            public int compare(Point p1, Point p2) {
                if (p2.y < p2.y) return -1;
                else if (p1.y > p2.y) return 1;
                else if (p1.x < p2.x) return -1;
                else if (p1.x > p2.x) return 1;
                else return 0;
            }
        }
    }
}
