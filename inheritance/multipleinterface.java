interface Father {
    void show();
}
interface Coach {
    void play();
}
class Student implements Father, Coach {

    public void show() {
        System.out.println("Father Method");
    }

    public void play() {
        System.out.println("Coach Method");
    }
}

