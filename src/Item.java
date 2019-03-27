public class Item {

    private int productNumber;
    private String name;
    private Double cost;
    private String type;
    private String img;
    private Boolean sale;

    public Item(int productNumber, String name, Double cost, String type, String img, Boolean sale) {
        this.productNumber = productNumber;
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.img = img;
        this.sale = sale;
    }

    public int getProductNumber() { return productNumber; }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public String getImg() {
        return img;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }
}