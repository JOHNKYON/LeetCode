package questions.palindromeNumber;

public class PalindromeNumber {
    public boolean isPalindrome(int x){
        /*Any negative number would not be palindrome, and any number with the last digit of 0 would never
        * be palindrome except 0 itself*/
        if (0 > x || (0 != x && 0 == x%10 )) {return false;}
        int reverse = 0;
        /*Do only reverse half of the number would avoid the overflow problem*/
        while (x > reverse){
            reverse = reverse*10 + x % 10;
            x /= 10;
        }
        return (x == reverse || x == reverse/10);
    }
}
