package Comparator;

import model.Product;
import java.util.Comparator;

public class ComparatorNameASC {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
