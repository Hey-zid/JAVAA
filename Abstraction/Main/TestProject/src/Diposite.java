public class Diposite extends Bank {
    public Diposite (int balance){
        super();
    }

    @Override
    public void withdraw ()
    {
        System.out.println("The Balance is " + balance);
    }


}
