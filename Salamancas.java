public class Salamancas
{
    /**
     * n - alphabet length (if we know that n=26, every case would be O(1) )
     * Best case: "a" -> 1+n steps
     * Worst case: "zzzzzzzzzz" -> 10*(n-1)+n = 11n-10 steps
     * Both cases: O(n)
     */
    public static String Convert(String message)
    {
        String returnValue = "";
        for (char x : (message+' ').toLowerCase().toCharArray()) {
            if( (x<'a' || x>'z') && x!=' ' ) continue;

            int misses = x == ' ' ? 26 : x-97;

            for (int i = 0; i < misses; i++)
                returnValue += '-';
            if(x != ' ')
               returnValue += 'r';
        }
        return returnValue;
    }

    /**
     * n - alphabet length (if we know that n=26, every case would be O(1) )
     * Best case: "a" -> 2+sqrt(n)+1 = 3+sqrt(n) steps
     * Worst case: "zzzzzzzzzz" -> 10*2sqrt(n)+sqrt(n)+1 = 21sqrt(n)+1 steps
     * Both cases: O(√n)
     */
    public static String TableConvert(String message)
    {
        String returnValue = "";
        for (char x : message.toLowerCase().toCharArray())
        {
            if( (x<'a' || x>'z') && x!=' ' ) return null;

            int misses = x-97;

            if(x != ' ')
            {
                for (int i = 0; i < misses / 5; i++)
                    returnValue += '-';
                returnValue += 'r';

                for (int i = 0; i < misses % 5; i++)
                    returnValue += '-';
                returnValue += 'r';
            }
            for (int i = 0; i < 5; i++)
                returnValue += '-';
        }
        return returnValue;
    }

    public static String Lalo(String message)
    {
        return Lalo(message, message.length());
    }

    // This method "Speaks" with Lalo using binary search to find the letters
    /*
     * n - alphabet length; N word length
     * Best case: "m" -> 1 step
     * Worst case: "zzz..zzz" Nlog(n) steps
     */
    public static String Lalo(String message, int length)
    {
        String returnValue = "";
        for(char c: message.toLowerCase().toCharArray())
        {
            int low= 0, high = 25, x = c-97;
            while (low <= high)
            {
                int mid = low + (high - low) / 2;

                if (mid == x)
                {
                    returnValue += '0';
                    break;
                }

                if (mid < x)
                {
                    returnValue += '-';
                    low = mid + 1;
                }
                else
                {
                    returnValue += '+';
                    high = mid - 1;
                }
            }
        }

        return returnValue;
    }

    public static void main(String[] args) {
        String message = "Hello";
        System.out.println(Convert(message).length()); // 78
        System.out.println(TableConvert(message).length()); // 54
        System.out.println(Lalo(message).length()); // 25, most effective
    }
}
