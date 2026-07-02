class l{
    l(String name){
        ()System.out.println("Anmal "+name);
    }
}class dog extends l{
    dog(){
        super("Tommy");
        System.out.println("Dog Constructor");
    }
}public class superclass{
    public static void main(String[] args){
        dog d=new dog();
    }
}

