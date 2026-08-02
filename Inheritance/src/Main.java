public void main (String[] args){
    Cat c = new Cat();
    c.Name = "Beluga";
    System.out.println(c.Name);
    c.eat();
    c.sound();

    Dog d = new Dog();
    d.Name = "KalaKutta";
    System.out.println(d.Name);
    d.eat();
    d.Bark();

    Pappi p = new Pappi();
    p.Name = "CutePappi";
  }