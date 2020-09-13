import java.time.ZonedDateTime;

/**
 * @author XuYang
 * @date 2020/9/6 16:50
 */
public class Test {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();  // 默认时区
        System.out.println(zonedDateTime);
    }
}
