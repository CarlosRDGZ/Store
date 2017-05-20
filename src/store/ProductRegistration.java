package store;

public class ProductRegistration {
    private File productRegistrationFile;

    public void addProduct(Product product){
        productRegistrationFile.lastRecord();

        productRegistrationFile.writeInt(product.getIdProduct());

        productRegistrationFile.writeString(setString(product.getName(),15));

        productRegistrationFile.writeString(setString(product.getTrademark(),10));

        productRegistrationFile.writeFloat(product.getCost());
    }

    public Product readProduct(int registryNum){
        productRegistrationFile.seekRecord(registryNum * 33);

        int idProduct = productRegistrationFile.readInt();

        String name = getString(productRegistrationFile.readString(15));

        String trademark = getString(productRegistrationFile.readString(10));

        float cost = productRegistrationFile.readFloat();

        return new Product(idProduct, name, cost, trademark);
    }

    public void editProductRegister(int registryNum,Product product){
        productRegistrationFile.seekRecord(registryNum * 33);

        productRegistrationFile.writeInt(product.getIdProduct());

        productRegistrationFile.writeString(setString(product.getName(),15));

        productRegistrationFile.writeString(setString(product.getTrademark(),10));

        productRegistrationFile.writeFloat(product.getCost());
    }

    private String setString(String string, int length){
        StringBuilder sb = new StringBuilder(string);
        sb.setLength(length);
        return sb.toString();
    }

    private String getString(String string){
        int position = string.indexOf('\0');
        return string.substring(0, position);
    }
}
