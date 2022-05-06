package views;

import model.Product;
import services.ProductServices;
import model.ProductManagement;

import java.util.Scanner;

public class ProductView {
    public static ProductServices productServices = new ProductServices();
    static Scanner input = new Scanner(System.in);
    public static void showMenu() {
        System.out.println("-----------Product-Management-----------");
        System.out.println("          1. Add product.              ");
        System.out.println("          2. Edit product.             ");
        System.out.println("          3. Remove product.           ");
        System.out.println("          4. Show products.            ");
        System.out.println("          5. Sort products.            ");
        System.out.println("          6. Search products.          ");
        System.out.println("          0. Quit.                     ");
        System.out.println("---------------------------------------");
    }

    public static void showProducts(){
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%1s %-20s %-20s %-20s %-20s \n", "", "ID", "Product name", "Quantity", "Price");
        System.out.println("------------------------------------------------------------------------------");
        for (Product p : productServices.getProducts()) {
            System.out.printf("%1s %-20s %-20s %-20s %-20s \n", "", p.getProductId(), p.getName(), p.getQuantity(), p.getPrice());
        }
        System.out.println("------------------------------------------------------------------------------");
    }

    public static void showSortMenu(){
        System.out.println("1. Sort by ID (Ascending).");
        System.out.println("2. Sort by ID (Descending)");
        System.out.println("3. Sort by Name (Ascending).");
        System.out.println("4. Sort by Name (Descending)");
        System.out.println("5. Sort by Quantity (Ascending).");
        System.out.println("6. Sort by Quantity (Descending)");
        System.out.println("7. Sort by Price (Ascending).");
        System.out.println("8. Sort by Price (Descending)");
        System.out.println("9. Return.");
    }
    public static void run(){
        int choice;
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    ProductManagement.addProduct();
                    break;
                case 2:
                    ProductManagement.editProduct();
                    break;
                case 3:
                    ProductManagement.removeProduct();
                    break;
                case 4:
                    showProducts();
                    break;
                case 5:
                    ProductManagement.sortProduct();
                    break;
                case 6: ProductManagement.searchProduct();
                break;
                case 0:
                    System.exit(0);

            }
        }while (choice !=0);
    }


}
