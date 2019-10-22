/**
 * @author RWM
 * @date 2019/10/22
 */
public class FinallyReturn {

    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
            //return ++temp;
        }
    }
}
