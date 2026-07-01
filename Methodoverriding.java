class notification{
    void send(){
        System.out .println("Notifications sending.");
    }
}
class Email extends notification{
    @Override
    void send(){
        System.out .println("Notifications sending..");
    }
}
class sms extends notification{
    @Override
      void send(){
        System.out .println("Notifications sending...");
    }
}
class whatsapp extends notification{
    @Override
      void send(){
        System.out .println("Notifications sending....");
    }
}
public class Methodoverriding {
    public static void main(String[] args ){
    notification n;
    n=new notification();
    n.send();
    n=new Email();
        n.send();

    n=new whatsapp();
        n.send();

    n=new sms(); 
        n.send();

    }
}
