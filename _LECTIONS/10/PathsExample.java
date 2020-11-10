import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsExample {


    public static void main(String[] args) {
        final Path lections = Paths.get("_LECTIONS");

        System.out.println(lections.toAbsolutePath().toString());
        System.out.println(lections.toFile().exists());


        final Path resolve = lections.resolve("1222");

        System.out.println(resolve.toAbsolutePath());

        System.out.println(Files.exists(resolve));



    }
}
