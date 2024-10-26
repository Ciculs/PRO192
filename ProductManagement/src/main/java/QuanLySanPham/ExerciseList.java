package QuanLySanPham;


import QuanLySanPham.ProductManagement;
import java.util.Scanner;

public class ExerciseList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagement product = new ProductManagement();
        System.out.println("Vui long nhap TC: ");
        int tc = sc.nextInt();
        switch(tc){
            case 1:
                product.inputInfo();
                product.outputInfo();
                System.out.println("Tong gia tri san pham:");
                System.out.print(product.calculate());
            case 2:
                product.inputInfo();
                product.outputInfo();
                product.changediscount();
                System.out.println("Tong gia tri san pham:");
                System.out.print(product.calculate());
            case 3:
               product.inputInfo();
               for(Object products: product.search()){
                   System.out.println(products.toString());   
               }
        }
    }
}
