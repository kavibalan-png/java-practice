class Animal {
    void sound() {
        System.out.println("Animal Sound");
    }
}
class innerclassanonymous {
        public static void main(String[] args) {
        Animal obj = new Animal() {
            @Override
            void sound() {
                System.out.println("Dog Barks");
            }
        };
        obj.sound();
}}
