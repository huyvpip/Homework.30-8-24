package chuongtrinh.java;

import java.util.Scanner;
import java.util.ArrayList;

public class ChuongtrinhJava {

  
        public static float[] importData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so loung phan tu trong mang:");
        int n = scanner.nextInt();
        float[] arrays = new float[n];
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            arrays[i] = scanner.nextFloat();
        }
        return arrays;
    }

    public static void printData(float[] arrays) {
        System.out.println("Mang so thuc:");
        for (float num : arrays) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static float findMax2(float[] arrays) {
        if (arrays.length < 2) {
            throw new IllegalArgumentException("Mang phai co it nhat hai phan tu.");
        }

        float max1 = Float.NEGATIVE_INFINITY;
        float max2 = Float.NEGATIVE_INFINITY;

        for (float num : arrays) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num < max1) {
                max2 = num;
            }
        }

        if (max2 == Float.NEGATIVE_INFINITY) {
            throw new RuntimeException("Khong tim thay gia tri lon thu hai trong mang.");
        }

        return max2;
    }

    public static void deleteOddNumber(float[] arrays) {
        ArrayList<Float> list = new ArrayList<>();
        for (float num : arrays) {

            if (Math.floor(num) != num || num % 2 == 0) {
                list.add(num);
            }
        }

        for (int i = 0; i < arrays.length; i++) {
            if (i < list.size()) {
                arrays[i] = list.get(i);
            } else {
                arrays[i] = 0;
            }
        }
    }

    public static void main(String[] args) {

        float[] arrays = importData();

        System.out.println("Mang ban dau:");
        printData(arrays);

        try {
            float max2 = findMax2(arrays);
            System.out.println("Gia tri lon thu hai trong mang: " + max2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        deleteOddNumber(arrays);
        System.out.println("Mang sau khi xoa cac phan tu le:");
        printData(arrays);
    }

}
