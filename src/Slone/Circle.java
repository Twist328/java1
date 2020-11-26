package Slone;

import java.util.Objects;

class Circle {
    private double radius;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
    /*public boolean equals(Object anObject){
        if(this.area()>((Object)anObject).area()){
 return 1;
         }else if(this.area()<((Object)anObject).area()){
        return -1;
        }else{
        return 0;
        }
        }*/