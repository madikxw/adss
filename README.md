# 📊 ADS Assignment 1  
### 🎓 Student: Bissenntayev Madiyar  
### 👥 Group: IT-2501  

---

## 📌 Project Overview  

This repository contains my **Assignment 1** for the algorithms  and data strcutures course(ADS).  

--
During this assighment i realized how important to have a enginering thinking, to split your sophicticated task to a smaller and easier one.
I spent so many times to just eloborate how this challenge should be solved.Moreover, most of my time i spent to comprenend  the algorithms, i didnt even think how i must WRITE the code.My mindset was really filled of "how i should split and do this task". However if i continue strain my brain, i will definitely  reach of enginering thinking.
 
---

## 🧠 Task 1
```java

import java.util.Scanner;
public class Main{
   public static  void separate(int n){
       if(n ==0){
           return;
        }
        separate(n/10);
        System.out.println(n%10);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number ");
        int a = scanner.nextInt();
        separate(a);

    }

}
```

in this task  i used simple recursive ,when the recursive take the last number and printed it out

## 🧠 Task 2
```java

public class Main{
     static Scanner scanner = new Scanner(System.in);

    public static void  main(String[] args){
        System.out.println("enter amount elements: ");
        int b = scanner.nextInt();
        System.out.println("enter elements: ");
        int sum = average(b);
        System.out.println((double)sum/b);

    }
    public static  int  average(int b) {
        if(b ==0){
            return 0;
        }
        int a = scanner.nextInt();
        return a + average(b-1);
}
    }
```
the second task was really hard to me .So  my task to find average number. the first thing first we need to understand how program will sumarize number one by one ,the main idea is every time we sumarize one elements  we need to decrease amonut of elements, therefore program will be stopped if b becomes 0 due to base case. and every time  this part of code " return a + average(b-1);" performs our varible "a" will take the next elements

## 🧠 Task 3
```java

public class Main{
    static Scanner scanner = new Scanner(System.in);
    public static boolean iSprime(int a, int i  ){
        if(a % i == 0){
            return  false;
        }
        if(i *i >a){
            return true;
        }
        return iSprime(a, i + 1 );
    }
    public static void main(String[] args){
        System.out.println("enter your number;");
        int a = scanner.nextInt();
        int i = 2;
        boolean d = iSprime(a,i);
        if(d == true){
            System.out.println("prime");
        }else{
            System.out.println("Composite");
        }

    }
}
```
here i do some research in the youtube to find the formula hot to find prime number  "if(i *i >a)" so  the main principle -  is take number 2 (cause its the only even prime number) and start take a square .If  square of 2 is not greater than our prime number than it will increase by 1 . It will carry on until either  square of i will be greater than prime number or the division prime  into i will be without residue 


## 🧠 Task 4
```java
public class Main{
    static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter your number: ");
        int a = scanner.nextInt();
        System.out.println(fac(a));


    }
    public static int  fac(int a ){
        if(a==0){
            return 1 ;
        }
        return a * fac(a - 1);

    }


}
```
## 🧠 Task 5
```java
public class Main{
    static  Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter your number: ");
        int a = scanner.nextInt();
        System.out.println(fib(a));
    }
    public static  int fib(int a ){
        if(a <= 1){
            return a;
        }
        return fib(a - 1)+ fib(a - 2);

    }
```
knowing formula fibonacci its enough to solve the problem. and about base case return variable a if a = 0 or a = 1;

## 🧠 Task 6

```java
public class Main{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter your first number: ");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter your second number:");
        int b = scanner.nextInt();
        System.out.println(deg(a,b));

    }
    public static int deg(int a ,int b){
        if(b ==0){
            return 1;
        }
        return a * deg(a,b-1);

    }
}
```
in the task 6 i followed one rule. just multiple a itself until b ==0. in this case b play role like counter. so if we first time multiply a b -1;
## 🧠 Task 7
```java
public class Main{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter your number:" +
                "");
        int a = scanner.nextInt();
        reverse(a);

    }
    public static void reverse(int a ){
        if(a ==0){
            return;
        }
        int x = scanner.nextInt();
        reverse(a - 1);
        System.out.println(a + " ");
    }

}

```
so the main idea is "Printing after recursion = reverse order or  Printing before recursion = normal order"

## 🧠 Task 8
```java
public class Main{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter your message: ");
        String a = scanner.nextLine();

       if (isdigit(a, 0) == true){
           System.out.println("yes");
       }else{
           System.out.println("no");
       }

    }
    public static boolean isdigit(String a , int i ){
        if(i == a.length()){
            return true;
        }
        if(!Character.isDigit(a.charAt(i))){
            return false;
        }
        return isdigit(a , i + 1 );
    }
}
```
so i use a littl bit advanced function such as length and charART. SO  the main part " if(!Character.isDigit(a.charAt(i))){" is cheking every elements is not
digit 

## 🧠 Task 9
```java
public class Main{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter your message: ");
        String a = scanner.nextLine();
        System.out.println(count(a,0));

    }
    public static  int count(String a ,int i ){
        if(i == a.length()){
            return 0;
        }
        return 1 + count(a, i + 1 );
    }
}
```
so the main idea is + 1 every time when you call recusion while

## 🧠 Task 10
```java
public class Main{
    static Scanner scanner   = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter your first number: ");
        int a = scanner.nextInt();
        System.out.println("enter your second number: ");
        int b  = scanner.nextInt();
        System.out.println(gcd(a,b));
    }
    public static int gcd(int a ,int b ){
        if(b ==0){
            return a;
        }
        return gcd(b, a % b);
    }
}
```












