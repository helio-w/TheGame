package objects;

public class Food extends Item implements Usable{

    private Food(String name, String desc, Integer id){
        super(name, desc, id);
    }

    public static Food createFood(String n, String d, Integer id) throws Exception{
        Food i = new Food(n, d, id);
        if(allItems.containsKey(id)){
            throw new Exception("Error createFood : item id already in allItems");
        }else{
            allItems.put(id, i);
            return i;
        }
    }

    public void use(){
        System.out.println("Yummy !");
    }
}
