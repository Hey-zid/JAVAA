public class HybridAnimal implements Dog, Cat {
    @Override
    public void sleep(){
        System.out.println("Ei tui baica asos?");
    }

    @Override
    public void eat(){
        System.out.println("Emnee kedaa khay !! ");
    }

    @Override
    public void sound(){
        System.out.println("Chup kor Cillaish na !!");
    }


}
