import java.util.Random;
import java.util.Scanner;

public class Dragon extends Monster {
    private String image = "\uD83D\uDC09";

    Dragon(int sizeBoard) {
        super(sizeBoard);
    }
    //    @Override
    public String getImage() {
        return image;
    }
    //    @Override
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public boolean taskMonster(int difficultGame) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int maxAttemts;
        int maxNumber;
        switch (difficultGame) {
            case (1):
                maxAttemts = 15;
                maxNumber = 50;
                break;
            case (2):
                maxAttemts = 12;
                maxNumber = 75;
                break;
            case (3):
                maxAttemts = 10;
                maxNumber = 85;
                break;
            case (4):
                maxAttemts = 8;
                maxNumber = 90;
                break;
            default:
                maxNumber = 100;
                maxAttemts = 5;
        }
        int number = r.nextInt(maxNumber) + 1;
        System.out.println("Дракон загадал число от 1 до " + maxNumber + ". У тебя " + maxAttemts + " попыток!");
        int guess = sc.nextInt();
        boolean b = false;

        for (int attempt = 1; attempt <= maxAttemts; attempt++) {
            System.out.println("Попытка " + attempt + ": ");
            int n = number / 10 * 10;
            int m = r.nextInt(10) + 10;

            if (guess == number) {
                System.out.println("Верно! Дракон пропускает тебя.");
                return true;
            } else if (r.nextInt(5) == 0 && b == false) {
                if (n + m > maxNumber){
                    System.out.println("*Подсказка*: Твое число от " + n + " до " + maxNumber);
                } else {
                    System.out.println("*Подсказка*: Твое число от " + n + " до " + (m + n));
                }
                b = true;
            } else if (guess > number) {
                System.out.println("Дракон рычит: 'Мое число меньше!'");
            } else if (guess < number) {
                System.out.println(("Дракон фыркает: 'Мое число больше!'"));
            }
            guess = sc.nextInt();


        }
        return false;
    }
}