package sortAndSearch;

import model.Product;

import java.util.Scanner;

import static services.ProductServices.productList;
import static views.ProductView.productServices;

public class Search {
    static Scanner input = new Scanner(System.in);
    public static void searchByName() {
        System.out.println("Enter name of product: ");
        String name = input.nextLine().toUpperCase();

        int count = 0;
        for(int i = 0; i < productList.size(); i++){

            if ((productList.get(i).getName().toUpperCase()).contains(name)) {
                System.out.println("------------------------------------------------------------------------------");
                System.out.printf("%1s %-20s %-20s %-20s %-20s \n", "", productList.get(i).getProductId(), productList.get(i).getName(), productList.get(i).getQuantity(), productList.get(i).getPrice());
                count ++;
            }
        }
        System.out.println("------------------------------------------------------------------------------");
        if(count == 0){
            System.out.println("Not found!");
        }

    }
}
