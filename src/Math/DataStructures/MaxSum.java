package Java.Math.DataStructures;
//最大字段和
public class MaxSum {
	public argsOfMaxSum theMaxSum(int arr[],int length){
		int sum=0,begin=0,end=0;
		for(int i=0;i<length;i++){
			int thissum=0;
			for(int j=i;j<length;j++){
				thissum=thissum+arr[j];
				if(thissum>sum){
					sum=thissum;
					begin=i;
					end=j;
				}
			}
		}
		return new argsOfMaxSum(sum, begin, end);
	}
	
	public class argsOfMaxSum{
		public argsOfMaxSum(int theMaxSum, int numBegin, int nunEnd) {
			super();
			this.theMaxSum = theMaxSum;
			this.numBegin = numBegin;
			this.nunEnd = nunEnd;
		}
		public int theMaxSum;
		public int numBegin;
		public int nunEnd;
	}
	
	public static void main(String[] args) {
		int[] a={10, -9,-2, 5, 3, 7, 101, 1, 18 };
		argsOfMaxSum maxsum=new MaxSum().theMaxSum(a,a.length);
		System.out.println("最大字段和："+maxsum.theMaxSum+"\n"+"从"+maxsum.numBegin+"到"+maxsum.nunEnd);
	}
}