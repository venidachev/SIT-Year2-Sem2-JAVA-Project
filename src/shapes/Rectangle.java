package shapes;

public class Rectangle extends Shape{
    private int width;
    private int height;


    public Rectangle(int x, int y, int width, int height, String fill) {
        super(x, y, fill);
        this.width = width;
        this.height = height;
        this.name = "rectangle";
    }

    public static Rectangle createRectangleFromSVG(String svg) {
//        Extract indexes
        int xIndex = svg.indexOf("x=\"") + 3;
        int yIndex = svg.indexOf("y=\"") + 3;
        int widthIndex = svg.indexOf("width=\"") + 7;
        int heightIndex = svg.indexOf("height=\"") + 8;
        int fillIndex = svg.indexOf("fill=\"") + 6;
//        Extract values
        int x = Integer.parseInt(svg.substring(xIndex, svg.indexOf("\"", xIndex)));
        int y = Integer.parseInt(svg.substring(yIndex, svg.indexOf("\"", yIndex)));
        int width = Integer.parseInt(svg.substring(widthIndex, svg.indexOf("\"", widthIndex)));
        int height = Integer.parseInt(svg.substring(heightIndex, svg.indexOf("\"", heightIndex)));
        String fill = svg.substring(fillIndex, svg.indexOf("\"", fillIndex));

        return new Rectangle(x, y, width, height, fill);
    }

    @Override
    public String toString() {
        return String.format("    <rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />",
                x, y, width, height, fill);
    }

    @Override
    public String toPrint() {
        return String.format("rectangle %d %d %d %d %s",
                x, y, width, height, fill);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
