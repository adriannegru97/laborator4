package ro.usv.rf;

public class MainClass {
	
	
	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in2.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length -1;
			System.out.println(String.format("The learning set has %s patterns and %s features", numberOfPatterns, numberOfFeatures));
			
			
//			//calculate Euclidian
		double[] firstPattern = learningSet[0];
			for(int i=1; i<numberOfPatterns; i++)
			{
				System.out.println("Distance between 1 and " + i + " pattern : " + DistanceUtils.calculateDistanceEuclidianGeneralized(firstPattern, learningSet[i]));
				System.out.println("Cebisev between 1 and " + i + " pattern : " + DistanceUtils.Cebisev(firstPattern, learningSet[i]));
				System.out.println("City Block between 1 and " + i + " pattern : " + DistanceUtils.CityBlock(firstPattern, learningSet[i]));
				System.out.println("Mahalanobis between 1 and " + i + " pattern : " + DistanceUtils.Mahalanobis(firstPattern, learningSet[i], numberOfPatterns));
			}
			FileUtils.writeLearningSetToFile("scaledSet.csv", DistanceUtils.EuclidianD(learningSet));
			
			System.out.println("Ultima linie apartine clasei " + DistanceUtils.calculateDistanceK_NN(learningSet));
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}
