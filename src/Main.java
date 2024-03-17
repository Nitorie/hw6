import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {0, -5, 6},
                {0, 8, -9}
        };

        Main main = new Main();
        main.printResults(array);
    }

    public void printResults(int[][] array) {
        boolean isDiagonalsSumEqual = this.isDiagonalsSumEqual(array);
        System.out.printf("Сумма левой и правой диагоналей массива одинаковая: %b%n", isDiagonalsSumEqual);
        int leftDiagonalSum = this.leftDiagonalSum(array);
        int targetNumber = 5;
        int countLessThanTarget = this.countElementsLessThan(array, targetNumber);
        boolean areElementsUnique = this.areElementsUnique(array);
        System.out.printf("Все элементы массива уникальны: %b%n", areElementsUnique);
        System.out.printf("Количество элементов меньше %d: %d%n", targetNumber, countLessThanTarget);
        System.out.printf("Сума элементов на левой диагонали: %d%n", leftDiagonalSum);
        System.out.printf("Сума всіх елементів: %d%n", findSum(array));
        System.out.printf("Середнє арифметичне: %.2f%n", findAverage(array));
        System.out.println("Суми елементів в кожному рядку:");
        printArray(findSumOfRows(array));
        System.out.println("Найбільші елементи в кожному рядку:");
        printArray(findMaxInRows(array));
        System.out.println("Найменші елементи в кожному стовпці:");
        printArray(findMinInColumns(array));
        System.out.printf("Сума елементів у рядках з від'ємним числом: %d%n", findSumOfRowsWithNegative(array));
        System.out.printf("Кількість парних чисел: %d%n", countEvenNumbers(array));
        System.out.printf("Кількість від'ємних чисел: %d%n", countNegativeNumbers(array));
        System.out.println("Масив після заміни нулів:");
        printArray(replaceZeros(array));
        System.out.printf("Усі елементи головної діагоналі є додатніми: %b%n", isAllPositiveDiagonal(array));
        System.out.println("Масив після обміну рядків:");
        printArray(swapRows(array, 0, 2));
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    public int findSum(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }

    public double findAverage(int[][] array) {
        int sum = findSum(array);
        int count = array.length * array[0].length;
        return (double) sum / count;
    }

    public int[] findMaxInRows(int[][] array) {
        int[] maxInRows = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int max = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
            maxInRows[i] = max;
        }
        return maxInRows;
    }

    public int[] findMinInColumns(int[][] array) {
        int[] minInColumns = new int[array[0].length];
        for (int j = 0; j < array[0].length; j++) {
            int min = array[0][j];
            for (int i = 1; i < array.length; i++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
            minInColumns[j] = min;
        }
        return minInColumns;
    }

    public int[] findSumOfRows(int[][] array) {
        int[] sumOfRows = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            sumOfRows[i] = sum;
        }
        return sumOfRows;
    }

    public boolean isAllPositiveDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public int[][] swapRows(int[][] array, int row1, int row2) {
        int[] temp = array[row1];
        array[row1] = array[row2];
        array[row2] = temp;
        return array;
    }

    public int findSumOfRowsWithNegative(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            boolean hasNegative = false;
            for (int element : row) {
                if (element < 0) {
                    hasNegative = true;
                    break;
                }
            }
            if (hasNegative) {
                for (int element : row) {
                    sum += element;
                }
            }
        }
        return sum;
    }

    public int countEvenNumbers(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            for (int element : row) {
                if (element % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countNegativeNumbers(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            for (int element : row) {
                if (element < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int[][] replaceZeros(int[][] array) {
        int nextNumber = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = nextNumber++;
                }
            }
        }
        return array;
    }

    public boolean isDiagonalsSumEqual(int[][] array) {
        int leftDiagonalSum = leftDiagonalSum(array);
        int rightDiagonalSum = rightDiagonalSum(array);
        return leftDiagonalSum == rightDiagonalSum;
    }

    public int leftDiagonalSum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    public int rightDiagonalSum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][array.length - 1 - i];
        }
        return sum;
    }

    public int countElementsLessThan(int[][] array, int target) {
        int count = 0;
        for (int[] row : array) {
            for (int element : row) {
                if (element < target) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean areElementsUnique(int[][] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int[] row : array) {
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    return false;
                }
            }
        }
        return true;
    }
}