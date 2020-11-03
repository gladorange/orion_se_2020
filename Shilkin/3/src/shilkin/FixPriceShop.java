package shilkin;

public class FixPriceShop {

    public static final int price = 49;
    private String[] items;
    private final int discount;

    FixPriceShop(String[] items, int discount){
        this.items = items;
        this.discount = discount;
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
        if (isExist){
            for (int i = 0, k = 0; i < this.items.length; i++) {
                if (i == index) {
                    continue;
                }
                temporaryArray[k++] = this.items[i];
            }
            this.items = temporaryArray;
            System.out.println("Товар "+ item + " продан по цене: " + getDiscountPrice(hour));
        }
        else {
            System.out.println("Товар "+ item + " не найден :(");
        }
    }

    private int getDiscountPrice(int hour){
        int happyHour = 10;
        if (happyHour == hour) {
            return (int) ((float) price - (float) price / 100 * this.discount);
        }
        return price;
    }

    public String[] getItems(){
        return this.items;
    }
}
