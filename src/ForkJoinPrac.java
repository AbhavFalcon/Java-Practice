import java.util.concurrent.RecursiveTask;

public class ForkJoinPrac extends RecursiveTask<Long> {
//    private int arr;
    private int start, end;

    public ForkJoinPrac(int start, int end) {
//        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if(end - start <= 3) {
            long factorial=1;
            for(int i = start;i <= end;i++){
                factorial=factorial*i;
            }
            return factorial;
        }
        else {
            int mid = (start + end)/2;
            ForkJoinPrac left = new ForkJoinPrac(start,mid);
            ForkJoinPrac right = new ForkJoinPrac(mid+1,end);

            left.fork();
            long rightResult=right.compute();
            long leftResult=left.join();
            return rightResult*leftResult;

        }
    }
}
