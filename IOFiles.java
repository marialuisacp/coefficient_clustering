package projeto_data_mining;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;

/**
 * 
 * IOFiles Class para ler e escrever nos arquivos de entrada e saida
 * 
 * @author Maria Luisa
 * @version  1.0
 * 
 */

public class IOFiles{
	public String inputFileName;
	public String outputFileName;
	public Graph G;
	public Edge[] E;
	public long n;

	/**
	 * 
	 * IOFiles metodo construtor da classe, apenas inicializa o nome dos arquivos de entrada e saida
	 * 
	 * @param inputFile nome do arquivo de entrada
	 * @param oututFile nome do arquivo de saida
	 * @author Maria Luisa
	 * @version  1.0
	 * 
	 */
	public IOFiles(String inputFile, String outputFile){
		this.inputFileName = inputFile;
		this.outputFileName = outputFileName;
	}
	
	public void defineGraph(Graph g){
		this.G = g;
		this.G.addNode("A");
		this.readFiles();
	}
	/**
	 * 
	 * readFiles metodo que constroi o grafo a partir da leitura do arquivo de entrada
	 * 
	 * @author Maria Luisa
	 * @version  1.0
	 * 
	 */
	public void readFiles(){
		try {
			long l = 0, sizeNodes = 0;
			String v;
			String p1 = "", p2 = "";
			Scanner scanner = new Scanner(new FileReader(this.inputFileName)).useDelimiter("\\s");
			
			while(scanner.hasNext()) {
				v = scanner.next();				
				if(l == 0){
					sizeNodes = Long.parseLong(v);
					this.n = sizeNodes;
				}else if(l < (sizeNodes+1)){
					this.G.addNode(v);
				}else{
					if(((l-sizeNodes)%2) == 1){
						p1 = v;
					}else{
						p2 = v;
						String p = "";
						p = p1 + "-" + p2;
							this.G.addEdge(p, p1, p2);
					}
				}
				l++;
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
	}
	
	public Graph getGraph(){
		return this.G;
	}
	
	public long getNodes(){
		return this.n;
	}
	
	public void printOutput(String result, String outputFile){
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter(outputFile, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(result);
			out.close();
		} catch (IOException e) {

		}
	}

}


