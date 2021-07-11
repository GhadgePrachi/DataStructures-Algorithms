package datastructures.arrays.verytough;

public class RectanglesOverlapping {
    //Assumptions : Edges are parallel to the axis and the rectangles are in first quadrant
    public int overlappingArea(Point l1, Point r1, Point l2, Point r2) {
        int area1 = Math.abs(l1.x - r1.x) * Math.abs(l1.y - r1.y);

        int area2 = Math.abs(l2.x - r2.x) * Math.abs(l2.y - r2.y);

        int areaI = (Math.min(r1.x, r2.x) - Math.max(l1.x, l2.x)) * (Math.min(r1.y, r2.y) - Math.max(l1.y, l2.y));

        return (area1 + area2 - areaI);
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
