package shapes;

public class Line extends Shape{

    private int x2;
    private int y2;
    private int strokeWidth;

    public Line(int x, int y, int x2, int y2, int strokeWidth, String fill) {
        super(x, y, fill);
        this.x2 = x2;
        this.y2 = y2;
        this.strokeWidth = strokeWidth;
        this.name = "line";
    }

    public static Line createLineFromSVG(String svg) {
//        Extract indexes
        int xIndex = svg.indexOf("x1=\"") + 4;
        int yIndex = svg.indexOf("y1=\"") + 4;
        int x2Index = svg.indexOf("x2=\"") + 4;
        int y2Index = svg.indexOf("y2=\"") + 4;
        int strokeWidthIndex = svg.indexOf("stroke-width=\"") + 14;
        int strokeIndex = svg.indexOf("stroke=\"") + 8;
//        Extract values
        int x = Integer.parseInt(svg.substring(xIndex, svg.indexOf("\"", xIndex)));
        int y = Integer.parseInt(svg.substring(yIndex, svg.indexOf("\"", yIndex)));
        int x2 = Integer.parseInt(svg.substring(x2Index, svg.indexOf("\"", x2Index)));
        int y2 = Integer.parseInt(svg.substring(y2Index, svg.indexOf("\"", y2Index)));
        int strokeWidth = Integer.parseInt(svg.substring(strokeWidthIndex, svg.indexOf("\"", strokeWidthIndex)));
        String fill = svg.substring(strokeIndex, svg.indexOf("\"", strokeIndex));

        return new Line(x, y, x2, y2, strokeWidth, fill);
    }


    @Override
    public String toString() {
        return String.format("    <line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke-width=\"%d\" stroke=\"%s\" />",
                x, y, x2, y2, strokeWidth, fill);
    }

    @Override
    public String toPrint() {
        return String.format("line %d %d %d %d %d %s",
                x, y, x2, y2, strokeWidth, fill);
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
