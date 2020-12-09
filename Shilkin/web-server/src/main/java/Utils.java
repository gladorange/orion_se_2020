import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    static String getRootFolder() throws IOException {
        String config = new String(Files.readAllBytes(Paths.get("configuration.txt")));
        List<String> lines = config.lines().collect(Collectors.toList());
        int rootFolderLine = 2;
        return lines.get(rootFolderLine);
    }
}
