public class Bucket {
    private int capacity;
    private int current;

    public int getCurrent() {
        return current;
    }

    public Bucket(int capacity){
       this.capacity = capacity;
       this.current = 0;
    }
    public Bucket(int capacity,int current){
        this.capacity = capacity;
        this.current = current;
    }

   public boolean isEmpty(){
        if (this.current==0){
            return true;
        }else {
            return false;
        }
   }
public boolean isFull(){
        if (this.current==this.capacity){
            return true;
        }else {
            return false;
        }
}

public float percent(){
        return ((float) this.current/this.capacity)*100;
}

public boolean addLiter(){
        if (isFull()){
            return false;
        }else {
            this.current++;
            return true;
        }
}


public int addLiters(int amount){
        int literRemain = 0;  // 7 , 0
        if (this.capacity-this.current>=amount){
            this.current+=amount;
        }else {
          int sub = this.capacity  - this.current; //9-5 //4
            this.current+=sub;
            literRemain = amount-sub; //7-4

        }
return literRemain;
}


public boolean spill(){
     if (isEmpty()){
         return false;
     }else {
         this.current = 0;
         return true;
     }
}


public boolean spill(int amount){
        if (amount<=this.current){
            this.current-=amount;
            return true;
        }else {
            return false;
        }
}
public void fill(Bucket other){
int subLiter = addLiters(other.current); //3
other.spill(other.current-subLiter);
}
public void setCapacity(int capacity){
        this.capacity = capacity;
}



    public void fill(){
        this.current = this.capacity;
}

public int subPercent(float max){
   float subLiterP = (percent()-max)+1;
   int subLiter = (int) ((subLiterP*this.capacity)/100);
   subLiter++;
   spill(subLiter);
   return subLiter;

}


public String toString(){
    return "The current state of the bucket: "+ this.current +" of " + this.capacity+" liters";
}
}
