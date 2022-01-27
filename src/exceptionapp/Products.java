
package exceptionapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author hncal
 */
public class Products {
    private int id;
    private static int counter = 1;
    private String name;
    private double listPrice;
    private double size;
    private double weight;

    public Products(String name, double listPrice, double size, double weight) {
        this.id = counter++;
        this.name = name;
        this.listPrice = listPrice;
        this.size = size;
        this.weight = weight;

    }

    public void printProductToFile() {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt",true));
            writer.newLine();
            String product = "Id:"+this.id+"  Name:"+this.name+"  Price:"+this.listPrice+"  Weight:"+this.weight+"  Size:"+this.size;
            writer.write(product);
            writer.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }

    public double pricePerSize() throws BadNumberException {
        if (size == 0) {
            throw new BadNumberException("Boyut 0 olamaz 0'a bölme hatası");
        }
        return listPrice / size;
    }

    public double pricePerWeight() throws BadNumberException {
        if (weight == 0) {
            throw new BadNumberException("Ağırlık 0 olamaz 0' bölme hatasi");
        }
        return listPrice / weight;
    }

    public void printProduct() {
        System.out.println("\nProduct Id = "+this.id);
        System.out.println("Name = "+this.name);
        System.out.println("List Price = "+this.listPrice);
        System.out.println("Weight = "+this.weight);
        System.out.println("Size = "+this.size);

    }
}
