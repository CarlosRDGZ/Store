package store;

public class Product {
    private int idProduct;
    private String name;
    private float cost;
    private String trademark;

    public Product(int idProduct,String name,float cost,String trademark){
    this.idProduct = idProduct;
    this.name = name;
    this.cost = cost;
    this.trademark=trademark;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }
}
