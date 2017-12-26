package DataStructure;

public class RMB {
    private final static char[] data = new char[]{'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private final static char[] units = new char[]{'元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿'};

    public static void main(String[] args) {
        System.out.println(convert(101548784));
    }

    public static String convert(int money) {
        StringBuilder sb = new StringBuilder();
        int unit = 0;
        while (money != 0) {
            sb.insert(0, units[unit++]);
            int number = money % 10;
            sb.insert(0, data[number]);
            money/=10;
        }
        return sb.toString();
    }
}
