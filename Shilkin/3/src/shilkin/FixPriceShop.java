package shilkin;

public class FixPriceShop {

    public static final int price = 49;
    private String[] items;
    private final int happyHour;

    FixPriceShop(String[] items, int happyHour){
        this.items = items;
        this.happyHour = happyHour;
    }

    public int checkItemPrice(String item, int hour){
        for (String s : this.items) {
            if (item.equals(s)) {
                return getDiscountPrice(hour);
            }
        }
        return -1;
    }

    public void buyItem(String item, int hour){
        boolean isExist = false;
        String[] temporaryArray = new String[this.items.length - 1];
        int index = 0;

        for (int i = 0;i< this.items.length; i++) {
            if (item.equals(this.items[i])) {
                isExist = true;
                index = i;
                break;
            }
        }
        if (!isExist){
            System.out.println("Товар "+ item + " не найден :(");
        }
        else {
            for (int i = 0, k = 0; i < this.items.length; i++) {
                if (i == index) {
                    continue;
                }
                temporaryArray[k++] = this.items[i];
            }
            this.items = temporaryArray;
            System.out.println("Товар "+ item + " продан по цене: " + getDiscountPrice(hour));
        }
    }

    private int getDiscountPrice(int hour){
        if (happyHour == hour) {
            return  price / 2;
        }
        return price;
    }

    public String[] getItems(){
        return this.items;
    }
}
