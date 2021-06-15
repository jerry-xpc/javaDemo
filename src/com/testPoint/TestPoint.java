package com.testPoint;

public class TestPoint
{
    public static void main(String[] args)
    {
        Point p = new Point(1.0,2.0,3.0);
        Point p1 = new Point(0,0,0);
        System.out.println(p.getDistance(p1));

        p.setX(5);
        System.out.println(p.getDistance(new Point(1,1,1)));
    }
}

class  Point
{
    double x,y,z;

    public Point(double _x,double _y,double _z)
    {
        x = _x;
        y = _y;
        z = _z;
    }

    public void setX(double _x)
    {
        x = _x;
    }

    public void setY(double _y)
    {
        y = _y;
    }

    public void setZ(double _z)
    {
        z = _z;
    }

    public double getDistance(Point p)
    {
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) + (z - p.z) * (z - p.z);
    }
}