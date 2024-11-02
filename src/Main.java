import java.util.Scanner;public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {4, 6, 8, 10, 12, 14, 16, 9, 18, 20};
        System.out.print("Enter i: ");
        int i = scanner.nextInt();
        System.out.println("Sum until index " + i + ": " + exc14(arr, i));
        System.out.println("Number of even numbers until index " + i + ": " + exc15(arr, i));
        System.out.println("Index of " + i + ": " + exc16(arr, i, 0));
        System.out.println("Is sorted in ascending order: " + exc17(arr, 0));
        System.out.println("No primes in array 1: " + exc18(arr, 0));
        System.out.println("No primes in array 2: " + exc18(arr2, 0));


        System.out.print("enter n: ");
        int n = scanner.nextInt();
        System.out.println("");
        System.out.println("Sum: " + sum(n));
        System.out.println("Factorial: " + f(n));
        System.out.println("Odd Factorial: " + oddf(n));
        System.out.println("Number of digits: " + digits(n));
        System.out.println("Is prime: " + isPrime(n,3));
        System.out.println("All even or all odd digits: " + evenOrOddDigts(n));

        System.out.println("--------------------------------");
        System.out.print("Enter n1: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter n2: ");
        int n2 = scanner.nextInt();
        System.out.println("");
        System.out.println("Division: " + division(n1, n2));
        System.out.println("Remainder: " + remainder(n1, n2));
        System.out.println("Is divisible: " + isDivisible(n1, n2));

    }

    //1
    public static int sum(int n) {
        if (n<=0) {
            return 0;
        }
        return n + sum(n-1);
    }

    //2
    public static int f(int n) {
        if (n<=0) {
            return 1;
        }
        return n * f(n-1);
    }
     
    //3
    public static int oddf(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return oddf(n-1);
        }
        return n * oddf(n-1);
    }

    //4
    public static int digits(int n) {
        if (n < 10) {
            return 1;
        }
        return 1 + digits(n/10);
    }

    //5
    public static int division(int n1, int n2) {
        if (n1 < n2) {
            return 0;
        }
        return 1 + division(n1 - n2, n2);
    }

    //6
    public static int remainder(int n1, int n2) {
        if (n1 < n2) {
            return n1;
        }
        return remainder(n1 - n2, n2);
    }

    //7
    public static boolean isDivisible(int n1, int n2) {
        if (n1 == 0) {
            return true;
        }
        if (n1 < n2) {
            return false;
        }
        return isDivisible(n1 - n2, n2);
    }

    //8
public static boolean isPrime(int n, int divisor) {
    if (n <= 1) {
        return false;
    }
    if (n == 2) {
        return true;
    }
    if (n % 2 == 0) {
        return false;
    }
    if (divisor * divisor > n) {
        return true;
    }
    if (n % divisor == 0) {
        return false;
    }
    return isPrime(n, divisor + 2);
}
   
    //9
    public static boolean evenOrOddDigts(int n) {
        if (n < 10) {
            return true;
        }
        
        int lastDigit = n % 10;
        int secondLastDigit = (n / 10) % 10;
        
        if (lastDigit % 2 != secondLastDigit % 2) {
            return false;
        }
        
        return evenOrOddDigts(n / 10);
    }

    //14
    public static int exc14(int[] arr, int i) {
        if (i >= arr.length || i < 0) {
            return 0;
        }
        if (i == 0) {
            return arr[0];
        }
        return arr[i] + exc14(arr, i - 1);
    }

    //15
    public static int exc15(int[] arr, int i) {
        if (i >= arr.length || i < 0) {
            return 0;
        }
        if (i == 0) {
            if (arr[0] % 2 == 0) {
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (arr[i] % 2 == 0) {
            count = 1;
        }
        return count + exc15(arr, i - 1);
    }

    //16
    public static int exc16(int[] arr, int i, int index) {
        if (index >= arr.length) {
            return -1;
        }
        if (arr[index] == i) {
            return index;
        }
        return exc16(arr, i, index + 1);
    }

    //17
    public static boolean exc17(int[] arr, int index) {
        if (arr.length <= 1) {
            return true;
        }
        if (index >= arr.length - 1) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return exc17(arr, index + 1);
    }

    //18
    public static boolean exc18(int[] arr, int index) {
        if (index >= arr.length) {
            return true;
        }
        if (isPrime(arr[index], 3)) {
            return false;
        }
        return exc18(arr, index + 1);
    }

}