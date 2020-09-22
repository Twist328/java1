package Tvist328;

class Point2D {
    int x;
    int y;


    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "" + x + "," + y;
    }
}

class Point3D extends Point2D {
    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "" + x + "," + y + "," + z;
    }
}



























