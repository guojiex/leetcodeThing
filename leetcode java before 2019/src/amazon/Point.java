package amazon;

public class Point {
    double x;
    double y;
    public Point(double x,double y){
        this.x=x;
        this.y=y;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("(%f,%f)", this.x,this.y);
    }
    
}
