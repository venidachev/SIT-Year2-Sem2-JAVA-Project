package shapes;

public abstract class Shape {
    protected int x;
    protected int y;
    protected String fill;


    abstract public String toPrint();

    public Shape(int x, int y, String fill) {
        this.x = x;
        this.y = y;
        this.fill = fill;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
}
