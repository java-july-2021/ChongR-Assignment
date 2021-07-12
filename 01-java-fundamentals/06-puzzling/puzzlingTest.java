import java.security.DrbgParameters.Reseed;
import java.util.Arrays;

public class puzzlingTest {
    public static void main(String[] args) {
        puzzling test = new puzzling();

        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        System.out.println(test.Sum(arr));

        System.out.println(test.GreaterThan10(arr));

        System.out.println(test.NameBook());

        System.out.println(test.Alphabet());

        System.out.println(test.TenRandNum());

        System.out.println(test.SortTenNum());

        System.out.println(test.RandomStr());

        System.out.println(Arrays.toString(test.TenRandomStr()));
        
    }
    
}
