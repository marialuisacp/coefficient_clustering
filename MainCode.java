package projeto_data_mining;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import static org.graphstream.algorithm.Toolkit.*;

public class MainCode {
	
	/*
	 * main Chama a funcao que le o arquivo de entrada e cria a estrutura do grafo 
	 *
	 */
	public static void main(String[] args){
		String clusterHeader = "Clustering coeficients";
		String averageClusterHeader = "Average clustering coeficients";

		Graph graph = new MultiGraph("W2vec");
		IOFiles io = new IOFiles("input.txt", "output.txt");
		io.defineGraph(graph);
		graph = io.getGraph();
		
		System.out.println(clusterHeader);
		io.printOutput(clusterHeader, "output.txt");
		
		double[] clusterArray = clusteringCoefficients(graph);
		double averageCoeficientCluster = averageClusteringCoefficient(graph);
		
		for(int i=0; i < clusterArray.length; i++){
			System.out.println(clusterArray[i]);
			io.printOutput(String.valueOf(clusterArray[i]), "output.txt");
		}
		System.out.println("--");
		io.printOutput("--", "output.txt");
		System.out.println(averageClusterHeader);
		System.out.println(averageCoeficientCluster);
		io.printOutput(averageClusterHeader, "output.txt");
		io.printOutput(String.valueOf(averageCoeficientCluster), "output.txt");
		
	}
		
}
