class AddBinary {
    public int addBinaryHelper(Character a, Character b, Character carry) {
        int m = a-'0';
        int n = b-'0';
        int l = carry-'0';
        return m + n + l;
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        if (a.length()>b.length()){
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i<(a.length()- b.length()); i++){
                bBuilder.insert(0, '0');
            }
            b = bBuilder.toString();
        }
        else {
            StringBuilder aBuilder = new StringBuilder(a);
            for (int i = 0; i<(b.length()- a.length()); i++){
                aBuilder.insert(0, '0');
            }
            a = aBuilder.toString();
        }
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        char carry = '0';
        for (int i = a.length()-1;i>=0;i--){
            if (addBinaryHelper(a.charAt(i), b.charAt(i), carry) == 0){
                result.insert(0, '0');
                carry = '0';
            }
            else if (addBinaryHelper(a.charAt(i), b.charAt(i), carry) == 1){
                result.insert(0, '1');
                carry = '0';
            }
            else if (addBinaryHelper(a.charAt(i), b.charAt(i), carry) == 2){
                result.insert(0, '0');
                carry = '1';
            }
            else if (addBinaryHelper(a.charAt(i), b.charAt(i), carry) == 3){
                result.insert(0, '1');
                carry = '1';
            }
        }
        if (carry == '1') result.insert(0, '1');
        return result.toString();
    }
}
