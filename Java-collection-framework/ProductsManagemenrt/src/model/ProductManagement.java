package model;

import sortAndSearch.Search;

import java.util.List;
import java.util.Scanner;

import static services.ProductServices.productList;
import static sortAndSearch.Sort.*;
import static sortAndSearch.Search.*;
import static views.ProductView.*;

public class ProductManagement {
    static Scanner input = new Scanner(System.in);

    public static void addProduct() {
        System.out.print("Enter an ID: ");
        long id = input.nextLong();
        System.out.print("Enter a name: ");
        String name = input.nextLine();
        System.out.print("Enter a quantity: ");
        int quantity = input.nextInt();
        System.out.println("Enter a price: ");
        double price = input.nextDouble();
        productList.add(new Product(id, name, quantity, price));
        System.out.println("Product added successfully!");
    }

    public static void editProduct() {
        showProducts();
        System.out.println("Select a product ID to edit: ");
        long id = Long.parseLong(input.nextLine());
        if (!productServices.existById(id)) {
            System.out.println("Product does not exist!");
            return;
        }
        System.out.println("Enter new name: ");
        String newName = input.nextLine();
        System.out.println("Enter new quantity: ");
        int newQuantity = Integer.parseInt(input.nextLine());
        System.out.println("Enter new price: ");
        double newPrice = Double.parseDouble(input.nextLine());
        Product newProduct = new Product(id, newName, newQuantity, newPrice);
        productServices.update(newProduct);
        System.out.println("Product edited successfully!");
    }

    public static void removeProduct() {
        showProducts();
        System.out.println("Enter product ID to delete: ");
        long id = Long.parseLong(input.nextLine());
        List<Product> productList = productServices.getProducts();
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getProductId()) {
                productList.remove(i);
                break;
            }
        }
        System.out.println("Product removed successfully.");

    }

    public static void sortProduct() {

        int choice;
        do {
            showSortMenu();
            System.out.println("Select a provided number: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    sortByIDAsc();
                    break;
                case 2:
                    sortByIDDesc();
                    break;
                case 3:
                    sortByNameAsc();
                    break;
                case 4:
                    sortByNameDesc();
                    break;
                case 5:
                    sortByQuantityAsc();
                    break;
                case 6:
                    sortByQuantityDesc();
                    break;
                case 7:
                    sortByPriceAsc();
                    break;
                case 8:
                    sortByPriceDesc();
                    break;
                case 9:
                   break;
            }
        } while (choice != 9);

    }

    public static void searchProduct(){
            Search.searchByName();
    }


}






