package exceptionapp;

/**
 *
 * @author hncal
 */
public class Stock {
    
    private Products[] stocked_product;
    private static int counter;
    private int capacity;

    public Stock(int capacity) {
        this.capacity = capacity;
        this.stocked_product = new Products[capacity];
        counter = 0;
    }

    public Products[] getStocked_product() {
        return stocked_product;
    }

    public void addProduct(String name, double listPrice, double size, double weight) throws ArrayOutOfBoundsException {
        if (counter == capacity) {
            throw new ArrayOutOfBoundsException("\nStok kapasitesine ulaşılmıştır daha fazla ürün ekleyemezsiniz.");
        } else {
            stocked_product[counter++] = new Products(name, listPrice, 
                    size, weight);

        }

    }

    public void showInventory() {
        for (int i = 0; i < counter; i++) {
            stocked_product[i].printProduct();

        }
    }
    
    public void writeFile(){
        for(int i = 0; i < counter ; i++){
            stocked_product[i].printProductToFile();
        }
        System.out.println("\nDosyaya başarıyla yazıldı.");
    }

    public void calculatepricePerWeight() {
        try {
            for (int i = 0; i < capacity; i++) {

                stocked_product[i].pricePerWeight();
            }
        } catch (BadNumberException e) {
            System.out.println(e.getMessage());
        }

    }

    public void calculatepricePerSize() {
        try {
            for (int i = 0; i < capacity; i++) {

                stocked_product[i].pricePerSize();
            }
        } catch (BadNumberException e) {
            System.out.println(e.getMessage());
        }

    }
}
