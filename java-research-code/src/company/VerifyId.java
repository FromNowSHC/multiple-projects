package company;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单的校验还需要完善
 * 校验身份证信息
 * todo
 *
 * @author shc
 * @date 2018-07-28
 **/
public class VerifyId {

    private static Map<Integer, String> verifyTable = new HashMap<>(11);


    static {
        verifyTable.put(0, "1");
        verifyTable.put(1, "0");
        verifyTable.put(2, "X");
        verifyTable.put(3, "9");
        verifyTable.put(4, "8");
        verifyTable.put(5, "7");
        verifyTable.put(6, "6");
        verifyTable.put(7, "5");
        verifyTable.put(8, "4");
        verifyTable.put(9, "3");
        verifyTable.put(10, "2");
    }

    public static boolean verify(String idNumber) {
        String[] split = idNumber.split("");
        if (split.length != 18) {
            System.out.println("身份证号码位数不对！");
            return false;
        }
        int[] wa = new int[17];
        // 计算出w*a的结果放入数组
        for (int i = 0; i < split.length - 1; i++) {
            // 得到a
            int aInt = Integer.parseInt(split[i]);
            // 得到w
            int exponent = 18 - i;
            double pow = Math.pow(2, exponent - 1);
            double wPow = pow % 11;
            int wInt = (int) wPow;
            // 放入数组
            wa[i] = wInt * aInt;
        }
        int sInt = 0;
        for (int i = 0; i < wa.length; i++) {
            sInt = sInt + wa[i];
        }
        int result = sInt % 11;
        String s = verifyTable.get(result);
        if (s.equals(split[split.length - 1])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        verify("0");
    }

}
