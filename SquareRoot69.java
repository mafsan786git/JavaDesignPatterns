
public class SquareRoot69 {
    public static void main(String[] args){
        int number = 2147483647;
        System.out.println(System.currentTimeMillis());
        System.out.println(findSqrt(number));
        System.out.println(System.currentTimeMillis());
    }

    private static int findSqrt(int number){
        if(number == 0){
            return 0;
        }
        int lowestPossibleSqrt  = 2;
        int maxPossibleSqrt = number/2;
        Math.sqrt(maxPossibleSqrt);
        while(lowestPossibleSqrt <= maxPossibleSqrt){
            int midPossibleSqrt = lowestPossibleSqrt + (maxPossibleSqrt-lowestPossibleSqrt)/2;
            if(midPossibleSqrt == number/midPossibleSqrt){
                return midPossibleSqrt;
            }
            if(midPossibleSqrt < number/midPossibleSqrt){
                lowestPossibleSqrt = midPossibleSqrt + 1;
            }
            if(midPossibleSqrt > number/midPossibleSqrt){
                if((midPossibleSqrt-1) < number/(midPossibleSqrt-1))
                    return midPossibleSqrt-1;
                maxPossibleSqrt = midPossibleSqrt-1;
            }
        }
        return 1;
    }
}
