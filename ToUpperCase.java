import java.util.Scanner;

class ToUpperCase {
    public static void main(String[] args) {
        Scanner numSc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Integer number = numSc.nextInt();
        String val = new String(sc.nextLine());
        if(val.length() > number){
            System.out.println(val.toUpperCase());
        } else {
            System.out.println("Please Input more than " + number + " charactaer");
        }
    }
}
