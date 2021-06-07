import java.util.regex.Pattern;

/**
 * @author gsd
 * @date 2021/6/2 8:51 上午
 * @Email:mrguosir@qq.com
 **/
public class Test {
    public static void main(String[] args) {
        String str1 = "01\\02\\33";
        Pattern pattern1 = Pattern.compile("^\\d+(\\\\\\d+)*$");
        System.out.println(pattern1.matcher(str1).matches());

    }
}
