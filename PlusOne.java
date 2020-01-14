class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = (digits[digits.length-1] + 1)/10;
        if (carry == 0){
            digits[digits.length-1]++;
            return digits;
        }
        for (int i = digits.length-1;i>=0;i--){
            carry = (digits[i]+1)/10;
            digits[i] = (digits[i]+1)%10;
            if (carry == 0) break;
        }
        if (carry > 0){
            int[] res = new int[digits.length+1];
            res[0] = carry;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }
}
