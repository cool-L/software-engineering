import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 将文本转换成字符串
 */
public class TextToString {
    public static String textToString(String file) {
        File path = new File(file);
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String s;
            while ((s = br.readLine()) != null) text.append(System.lineSeparator()).append(s);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete(text.toString());
    }

    /**
     * 清除输入字符串中除了文字逗号句号外的标签、回车等
     */
    public static String delete(String s) {

        return s;
    }
}