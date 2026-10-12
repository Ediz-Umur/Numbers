import java.util.Scanner;
public class Numbers
{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        //min 4 max 8 hane
        //tek / çift rakam sayısı
        //tek ve çift sayıların toplamı:
        //teklerin toplamı 10 > ve tek saysı 2'den büyükse jackpot, aksi taktirde "no luck"
        //Adım 1: En büyük rakamı bul maxDigit()
        //Adım 2: Tek rakam mı fazla çift rakam mı fazla
        //Adım 3: Sayıyı ters çevir
        //Adım 4: Palindrome mu
        //Adm 5: Rakam toplama, tek haneye kadar
        //Adım 6: Rakamlar soldan sağa kadar artarsa increasing
        //Adım 7: Çift rakamları çıkart
        //Adım 8: Armstrong sayısı mı?
        Cycle();
    }
    public static void Cycle(){
        System.out.println("Enter a 4-8 digit number: ");
        int number = scanner.nextInt();
        int digitCount = DigitCount(number);
        if(4 > digitCount || digitCount > 8){
            System.out.println("Write a number that has 4-8 digits!");
            Cycle();
        }
        int digits = EvenOrOdd(digitCount, number);
        System.out.println(digits);
        int oddSum = AddEODigits(number, digits, 1, digitCount);
        if(oddSum > 10){
            System.out.println("Jackpot!");
        } else {
            System.out.println("No luck");
        }
        System.out.println("Odd sum: " +AddEODigits(number, digits, 1, digitCount));
        System.out.println("Even sum: " +AddEODigits(number, digits, 0, digitCount));
        System.out.println("Max digit: "+MaxDigit(number, digitCount));
        System.out.println(MoreEvenOrOdd(digits, digitCount));
        System.out.println(ReverseNumber(number, digitCount));
        if(isPalindrome(number, digitCount)){
            System.out.println("The number is a palindrome!");
        } else {
            System.out.println("The number is not a palindrome");
        }
        if(isIncreasing(number)){
            System.out.println("The number is increasing");
        } else {
            System.out.println("The number is not increasing");
        }
        if(isArmstrong(number, digitCount)){
            System.out.println("The number is an Armstrong number");
        } else {
            System.out.println("The number is not an Armstrong number");
        }
        System.out.println();
        Cycle();
    }
    public static int DigitCount(int number){
        int digitCount = 0;
        boolean cont = true;
        while(number != 0){
            digitCount++;
            number /= 10;
        }
        return digitCount;
    }
    public static int EvenOrOdd(int digitCount, int number){
        String digits = "";
        int checker = 0;
        while(number >= 0){
            if(number % 2 == 0){
                digits = digits + "0";
            } else {
                digits = digits + "1";
            }
            if(number == 0){
                number -= 1000;
            }
            number /= 10;
        }
        return Integer.parseInt(digits);
    }
    public static int AddEODigits(int number, int digits, int checked, int digitCount){
        int sum = 0;
        int checker = 0;
        while(number != 0){
            if (digits % 10 == checked){
                sum += number % 10;
            }
            number /= 10;
            digits /= 10;
            checker++;
        }
        return sum;
    }
    public static int MaxDigit(int number, int digitCount){
        int maxDigit = 0;
        while(number != 0){
            if(number % 10 > maxDigit){
                maxDigit = number % 10;
            }
            number /= 10;
        }
        return maxDigit;
    }
    public static String MoreEvenOrOdd(int digits, int digitCount){
        int oddCount = 0;
        int evenCount = 0;
        while(digits != 0){
            if(digits % 10 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
            digits /= 10;
        }
        if(evenCount > oddCount){
            return "More even numbers";
        } else if (oddCount > evenCount){
            return "More odd numbers";
        } else {
            return "Balanced";
        }
    }
    public static int ReverseNumber(int number, int digitCount){
        String reversedDigit = "";
        while(number != 0){
            reversedDigit = reversedDigit + number % 10;
            number /= 10;
        }
        return Integer.parseInt(reversedDigit);
    }
    public static boolean isPalindrome(int number, int digitCount){
        if(number == ReverseNumber(number, digitCount)){
            return true;
        } else {
            return false;
        }
    }
    public static boolean isIncreasing(int number){
        while(number > 10){
            if(number % 10 <= (number / 10)%10){
                return false;
            }
            number /= 10;
        }
        return true;
    }
    public static boolean isArmstrong(int number, int digitCount){
        int sum = 0;
        int finalNumber = number;
        while (number != 0){
            sum += (int)Math.pow(number % 10, digitCount);
            number /= 10;
        }
        if(sum == finalNumber){
            return true;
        } else {
            return false;
        }
    }
}