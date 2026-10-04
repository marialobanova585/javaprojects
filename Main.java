//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(" 1Сложение матриц");
            System.out.println(" 2Умножение матриц");
            System.out.println(" 3Транспонирование матриц");
            System.out.println(" 4Нахождение определителя матриц");
            System.out.println(" 5Деление матриц");
            System.out.println("Введите операцию над матрицами:");
            int object = scan.nextInt();
            if (object == 0) {
                System.out.println("Программа завершена.");
                break;
            }
            switch (object) {
                case 1:
                    ComplexMatrix a = inputMatrix(scan, "A");
                    ComplexMatrix b = inputMatrix(scan, "B");
                    ComplexMatrix result1 = a.add(b);
                    if (result1 != null) {
                        System.out.println("Сложение матриц равно:");
                        result1.print();
                    }
                    break;
                case 2:
                    ComplexMatrix c = inputMatrix(scan, "A");
                    ComplexMatrix d = inputMatrix(scan, "B");
                    ComplexMatrix result2 = c.multiply(d);
                    if (result2 != null) {
                        System.out.println("Сложение матриц равно:");
                        result2.print();
                    }
                    break;
                case 3:
                    ComplexMatrix e = inputMatrix(scan, "A");
                    ComplexMatrix result3 = e.transpose();
                    System.out.println("Транспонирование матрицы равно: ");
                    result3.print();
                    break;
                case 4:
                    ComplexMatrix f = inputMatrix(scan, "A");
                    Complex result4 = f.determinate();
                    System.out.println("Определитель матрицы равен: " + result4);
                    break;
                case 5:
                    ComplexMatrix g = inputMatrix(scan, "A");
                    ComplexMatrix h = inputMatrix(scan, "B");
                    ComplexMatrix result5 = g.divide(h);
                    if (result5 != null) {
                        System.out.println("Сложение матриц равно:");
                        result5.print();
                    }
                    break;
                default:
                    System.out.println("Нет таких операций над матрицами");


            }
        }

    }

    public static ComplexMatrix inputMatrix(Scanner scan, String name) {
        System.out.print("Введите число строк матрицы " + name + ": ");
        int rows = scan.nextInt();
        System.out.print("Введите число столбцов матрицы " + name + ": ");
        int cols = scan.nextInt();

        ComplexMatrix matrix = new ComplexMatrix(rows, cols);
        System.out.println(" Введите реальные и мнимые части матрицы " + name + ":");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(name + "[" + i + "][" + j + "]: ");
                double real = scan.nextDouble();
                double imag = scan.nextDouble();
                matrix.data[i][j] = new Complex(real, imag);
            }
        }
        return matrix;
    }
}



