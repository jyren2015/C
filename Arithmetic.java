/**
 * Created by RJYWORK on 2019/12/15
 * Description:
 */
public class Arithmetic {
    public int add(int a, int b){
        while (b != 0){
            int sum = a ^ b;
            int pos = (a & b)<<1;
            a = sum;
            b = pos;
        }
        return a;
    }

    public int minus(int a, int b){
        b = ~ b + 1;
        while (b != 0){
            int sum = a ^ b;
            int pos = a & b;
            a = sum;
            b = pos;
        }
        return a;
    }

    public int multi(int a, int b){
        int ans = 0;
        int index = 0;
        while (b != 0){
            if ((b&1) == 1){
                ans = add(ans, a<<index);
            }
            b = b >> 1;
            index = index + 1;
        }
        return ans;
    }

    public int divide(int dividend, int divisor){
        int result = 0;
        boolean sign = (dividend > 0) ^ (divisor > 0);
        if (dividend < 0) dividend = - dividend;
        if (divisor < 0) divisor = -divisor;
        while (dividend <= divisor){
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= temp_divisor << 1){
                if (temp_divisor < Integer.MIN_VALUE >> 1) break;
                temp_divisor = temp_divisor << 1;
                temp_result = temp_result << 1;
            }
            dividend = dividend - temp_divisor;
            result = result + temp_result;
        }
        if (!sign){
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }
}
