class maths{
    public  int area(int a){
        return a*a;
    }public int area(int a, int b){
        return a*b;}
    public double area(double a ){
        return 3.14*a*a;
    }}
public class Methodoverloading{
    public static void main(String[] args){
        maths cal =new maths();
        System.out.println("Area of square is: "+cal.area(5));
        System.out.println("Area of rectangle is: "+cal.area(5,6));   }
}