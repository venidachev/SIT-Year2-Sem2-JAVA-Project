package shapes;

public abstract class Shape {
    protected int x;
    protected int y;
    protected String fill;
    protected String name;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void translateVertical(int y) {
        this.y += y;
    }

    public void translateHorizontal(int x) {
        this.x += x;
    }
}
