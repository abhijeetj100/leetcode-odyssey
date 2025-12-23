class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5) return false;

        int b5 = 0, b10 = 0, b20 = 0;

        for(int i : bills){
            switch(i){
                case 5:
                    b5++;
                    break;
                case 10:
                    if(b5 == 0) return false;
                    b5--;
                    b10++;
                    break;
                case 20:
                    if(b10>0 && b5>0){
                        b10--;
                        b5--;
                    }
                    else if(b10 == 0 && b5>2){
                        b5-=3;
                    }
                    else{
                        return false;
                    }
                    b20++;
                    break;
                default:
                    return false;
            }
        }

        return true;
    }
}