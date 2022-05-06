package sortAndSearch;

import java.util.Collections;
import java.util.Comparator;

import model.Product;

import static services.ProductServices.productList;

public class Sort {
    public static void sortByIDAsc() {
      Collections.sort(productList, new Comparator<Product>() {
          @Override
          public int compare(Product o1, Product o2) {
              return Long.compare(o1.getProductId(), o2.getProductId());
          }
      });
    }

    public static void sortByIDDesc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Long.compare(o2.getProductId(), o1.getProductId());
            }
        });
    }

    public static void sortByNameAsc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void sortByNameDesc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
    }

    public static void sortByQuantityAsc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getQuantity(),o2.getQuantity());
            }
        });
    }

    public static void sortByQuantityDesc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o2.getQuantity(), o1.getQuantity());
            }
        });
    }

    public static void sortByPriceAsc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }

    public static void sortByPriceDesc() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
    }


}
