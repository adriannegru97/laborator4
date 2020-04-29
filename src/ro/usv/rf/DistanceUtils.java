package ro.usv.rf;

public class DistanceUtils {
	
	public static double calculateDistanceK_NN(double[][] learning_set)
	{
		double minim = calculateDistanceEuclidianGeneralized(learning_set[0], learning_set[learning_set.length -1 ]);
		int positie = 0;
		double temp;
		for(int i=0;i<learning_set.length;i++)
		{
			temp = calculateDistanceEuclidianGeneralized(learning_set[learning_set.length-1],learning_set[i]);
			if(temp<minim && temp!=0) { minim = temp; positie = i; }
		}
		return learning_set[positie][learning_set[positie].length-1];
	}
	
	
	
	
	
	public static double[][] EuclidianD(double[][] learning_set)
	{
		double[][] output = new double[learning_set.length][];
		for(int i=0;i<learning_set.length;i++)
		{
			output[i] = new double[learning_set.length];
		}
		int k =0;
		for(int i=0;i<learning_set.length ;i++)
		{
			for(int j=i+1;j<learning_set.length;j++)
			{
				output[i][j] = Math.floor(calculateDistanceEuclidianGeneralized(learning_set[i], learning_set[j])* 100)/ 100;
				output[j][i]= output[i][j] ;
				k++;
			}
		}
		System.out.println(k+" K");
		
		return output;
	}
	
	
	public static double calculateDistanceEuclidianGeneralized(double[] pattern1, double[] pattern2)
	{
		double sum = 0D;
		for(int i=0;i<pattern1.length-1;i++)
		{
			sum+=(Math.pow(pattern1[i]-pattern2[i],2));
		}
		return Math.sqrt(sum);
		//return Math.sqrt(Math.pow(pattern1[0]-pattern2[0],2) + Math.pow(pattern1[1]- pattern2[1], 2));
	}
	
	
	public static double Cebisev(double[] pattern1, double[] pattern2)
	{
		double[] minime = new double[pattern1.length];
		for(int i=0;i<pattern1.length;i++)
		{
			minime[i] = Math.abs(pattern1[i] - pattern2[i]);
		}
		
		double max = -9999;
		
		for(int i=0;i<minime.length;i++)
		{
			if(minime[i] > max)
				max = minime[i];
		}
		
		return max;
	}
	
	public static double CityBlock(double[] pattern1, double[] pattern2)
	{
		double sum = 0;
		for(int i=0;i<pattern1.length;i++)
		{
			sum+= Math.abs(pattern1[i] - pattern2[i]);
		}
		
		return sum;
	}
	
	
	public static double Mahalanobis(double[] pattern1, double[] pattern2, double nr)
	{
		double sum = 0;
		for(int i=0;i<pattern1.length;i++)
		{
			sum+= Math.pow(pattern1[i] - pattern2[i], nr);
		}
		return Math.pow(sum, 1/nr);
	}

	
}
