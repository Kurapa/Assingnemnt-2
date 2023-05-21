import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Streamapi {

    List<Product> ps = new ArrayList<>();

    public void addProduct(Product p){
        ps.add(p);
    }

    public List<Product> getAllProducts(){
        return ps;
    }

    public List<Product> getProduct(String name){
       
    List<Product> p1=ps.stream()
       .filter( p -> p.getName().equals(name)).collect(Collectors.toList());
       return p1;
       
    }
    

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> prods = ps.stream()
       .filter( p -> p.getName().toLowerCase().contains(str)|| p.getType().toLowerCase().contains(str)|| p.getPlace().toLowerCase().contains(str))
       .collect(Collectors.toList());
        return prods;

    }

    public List<Product> getProductWithPlace(String place){
        String s=place.toLowerCase();
        List<Product> prods = ps.stream().filter( p -> p.getPlace().toLowerCase().equals(s))
        .collect(Collectors.toList());
       return prods;
    }
    
    public List<Product> checkWarranty(int wr){
      List<Product> prods =ps.stream().filter( p -> p.getWarranty()>=wr)
      .collect(Collectors.toList());
     
      return prods;
    }
}
