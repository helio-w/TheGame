package objects;

public class Food extends Item implements Usable{

    private Food(String name, String desc, Integer id){
        super(name, desc, id);
    }

    public void use(){
        System.out.println("Yummy !");
    }
}
