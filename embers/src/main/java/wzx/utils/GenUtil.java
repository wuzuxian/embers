package wzx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenUtil {

    public static String generateUniqueString() {
        // 生成六位随机字母
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char letter = (char) (random.nextInt(26) + 'A');
            sb.append(letter);
        }

        // 获取当前时间戳
        long timestamp = System.currentTimeMillis();

        // 格式化时间戳为字符串
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestampStr = dateFormat.format(new Date(timestamp));

        // 拼接六位字母和时间戳
        String uniqueString = sb.toString() + timestampStr;

        return uniqueString;
    }
}
