package lambda;

public class Q64_MountainArray {
    /*
     Bir Array'in Mountain Array olup olmadiğini kontrol eden bir kod yaziniz.
     Mountain Array: Element degerleri bir noktaya kadar surekli artip o noktadan sonra surekli azalan Array.
     arr[0] < arr[1] < arr[i] >arr[i+1] > arr[i+2] > arr[n-1]

    ----------------------------------------------------------------------------------------------------------------------*/
    public static void main(String[] args) {

        System.out.println(isMountainArray(new int[]{1, 200, 193, 143, 95, 83, 70, 63, 5}) ? "Mountain array :)" : "Mountain array DEĞİL :(");


    }//main sonu

    private static boolean isMountainArray(int[] arr) {
        boolean mountainArrayMi = true;
        if (arr.length < 3) {
            return false;
        } else {
            int maxEleman = arr[0], index = 0;
            for (int i = 0; i < arr.length; i++) {//arrayim tepe elemanı ve indexi bulundu
                if (arr[i] > maxEleman) {
                    maxEleman = arr[i];//arraydaki max elemanı verir -> 9
                    index = i;//arraydaki max elemanı veren array index'i -> 4
                }
            }
            for (int i = 0; i < index; i++) {//max elemana kadar duzenli artıyor mu kntrolu
                if (arr[i] < arr[i + 1]) {
                    continue;

                } else {
                    mountainArrayMi = false;
                    break;
                }
            }
            if (mountainArrayMi) {
                for (int i = index; i < arr.length - 1; i++) {//max elemandan son elemana  duzenli azalıyor mu kntrolu
                    if (arr[i] > arr[i + 1]) {
                        continue;
                    } else {
                        mountainArrayMi = false;
                        break;
                    }
                }
            }
        }
        return mountainArrayMi;
    }

}//Class sonu
