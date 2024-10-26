package QuanLySanPham;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement implements IOperation {
    private ArrayList<Product> products = new ArrayList<Product>();

    @Override
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        do{
        Product product = new Product();
        System.out.println("Nhap ID san pham: ");
        product.setId(sc.nextInt());
        System.out.println("Nhap ten san pham: ");
        product.setName(sc.next());
        System.out.println("Nhap gia san pham: ");
        product.setPrice(sc.nextDouble());
        System.out.println("Nhap discount san pham: ");
        product.setDiscount(sc.nextInt());
        products.add(product);
        System.out.println("Ban co muon ghi them san pham hay khong (y/n):");
        }
        while(sc.next().equalsIgnoreCase("y"));
    }

    @Override
    public void outputInfo() {
        System.out.println("ID\t\tName\t\tPrice\t\tDiscount");
        for(Product product: products){
            System.out.println(product.toString());
        }
    }

    @Override
    public double calculate() {
        double total = 0;
        for(Product product: products){
           if(product.getDiscount() > 0){
               total += (product.getPrice() - (product.getPrice()*product.getDiscount())/100);
           }else{
               total += product.getPrice();
           }
        }
        return total;
    }

    @Override
    public List search() {
        ArrayList<Product> result = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui long nhap ten san pham ma ban muon tim: ");
        String tensp = sc.next().toLowerCase();
        for(Product product:products){
            if(product.getName().toLowerCase().contains(tensp)){
                result.add(product);
            }
        }
        System.out.println("Ket qua search:\nID\t\tName\t\tPrice\t\tDiscount");
        return result;
    }    
    
    public void changediscount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Vui long nhap ID san pham ban muon thay doi Discount:");
        for(Product product: products){
            System.out.println(product.toString());
            if(product.getId() == sc.nextInt()){
                System.out.println("Vui long nhap gia tri Discount moi:");
                product.setDiscount(sc.nextInt());
            }
        }
        
    }
}
