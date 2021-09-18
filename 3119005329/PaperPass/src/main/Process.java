import java.io.File;
import java.io.FileWriter;

/**
 *  输入文件路径，调用 simhash 获取重复率，输出至答案文件路径。
 */
public class Process {
    public static void solve(String FilePath1, String FilePath2, String OutputPath) {
        String s1 = TextToString.textToString(FilePath1);
        String s2 = TextToString.textToString(FilePath2);
        if (s1.length() <= 3 || s2.length() <= 3) {
            try {
                throw new MyException("空文本");
            } catch (MyException e) {
                e.printStackTrace();
            }
        } else {
            double ans;
            ans = SimHash.getAns(s1, s2);
            // 将答案输出到文件中
            try {
                File file;
                file = new File(OutputPath);
                if (!file.exists()) {
                    boolean flag = file.createNewFile();
                    if (!flag) throw new Exception();
                }
                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
                fileWriter.write(String.format("%.2f", ans));
                fileWriter.write('\n');
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
