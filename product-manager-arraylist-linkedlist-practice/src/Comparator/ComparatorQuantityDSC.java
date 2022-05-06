package Comparator;

import model.Product;
import java.util.Comparator;

public class ComparatorQuantityDSC {
    @Override
    public int compare(Product o1, Product o2) {
        return Integer.compare(o2.getQuantity() - o1.getQuantity(), 0);
    }
}
