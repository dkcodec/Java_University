package Assignment_2.Assignment_1;

public class Circle implements Shape{

    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int calculateArea(int radius){
        return (int)(Math.PI*radius*radius);
    }
    @Override
    public int calculatePerimetr(int radius){
        return (int)(2*Math.PI*radius);
    }
}
