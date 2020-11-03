import java.lang.annotation.Repeatable;

public class Metaannotations {



    @interface Categories {
        Category[] value();
    }

    @Repeatable(Categories.class)
    @interface Category {
        String name();
    }
    public static void main(String[] args) {

    }
}
