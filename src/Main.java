import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Bucket bucket1 = new Bucket(7,2);
        Bucket bucket2 = new Bucket(5,5);
        Bucket bucket3 = new Bucket(6,3);
        Bucket [] buckets = new Bucket[]{bucket1,bucket2,bucket3}; //2 + 3 +1
        System.out.println(Arrays.toString(fillExactAmount(buckets,8)));
        System.out.println(reduceAmountInBuckets(buckets,50));
        while (bucket1.percent()<85){
            bucket2.fill();
            bucket1.fill(bucket2);
            if (bucket1.isFull()){
                bucket1.spill();
                bucket1.fill(bucket2);
            }
        }
        System.out.println(bucket1);
    }
   public static Bucket reduceAmountInBuckets (Bucket[] buckets, float max){
    int capacity = 0;
    for (int i=0;i<buckets.length;i++){
        capacity+=buckets[i].getCurrent();
    }
    Bucket bucket = new Bucket(capacity);
    for (int i=0;i<buckets.length;i++){
        System.out.println("Befor: "+buckets[i].percent());
        if (buckets[i].percent()>=max){
          bucket.addLiters(buckets[i].subPercent(max));
        }
        System.out.println("After: "+buckets[i].percent());
    }

return bucket;
    }


    public static int[] fillExactAmount(Bucket[] buckets, int amount){
int sumOfLiters = 0;
String indexStr="";
        for (int i=0;i< buckets.length;i++){
            if (buckets[i].percent()>=50){
                sumOfLiters+=buckets[i].getCurrent();
                indexStr+=i; //"145"
            }
        }
        System.out.println(indexStr);
        if (sumOfLiters==amount){
           int [] array = new int[indexStr.length()];
           for (int i=0;i<indexStr.length();i++){
               array[i]=Character.getNumericValue(indexStr.charAt(i)) ;
           }
           return array;
        }else {
            return null ;
        }
    }

}