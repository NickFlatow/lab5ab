import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {
    private List<Item> itemCatalog = new ArrayList<>();
    private int nextProductNumber;

    public ItemCatalog() {
        nextProductNumber = 1;
        itemCatalog.add(new Item(nextProductNumber++,"Arrow Shacket",19.99,"green","images/mine/arrowShacket.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Arrow Shacket - Indigo",19.99,"blue","images/mine/arrowShacket1.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Bomber Jacket",19.99,"camo","images/mine/bomberJacker.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Denim Jacket",19.99,"camo","images/mine/denimJacket.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Gulf Jacket",19.99,"green","images/mine/gulfJacket.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Parka Jacket",19.99,"black","images/mine/parkaJacket.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Pullover Jacket",19.99,"blue","images/mine/pulloverJacket.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Storm Jacket",19.99,"green","images/mine/Stormjacket.jpg",true));
        itemCatalog.add(new Item(nextProductNumber++,"Wolf Pack",19.99,"black","images/mine/wolfPack.jpg",true));
    }



    public List<Item> getItemCatalog() {
        return itemCatalog;
    }

    public Item getSingleItem(int itemNum) {
        Item item = new Item(57,"",0.0,"","",true);

        for(Item p: itemCatalog) {
            if (p.getProductNumber() == itemNum) {
                return p;
            }
        }
        return item;
    }
}