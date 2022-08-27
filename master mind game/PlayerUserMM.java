/**
* Author: Antria Argyrou & Nikolas Vaki 
* Written: 10/03/2020
* Last updated: 17/03/2020
*
* Compilation command: javac PlayerUserMM.java
* Execution command: java PlayerUserMM.java
*
* 
* O Ypologistis Theti to mystiko sindiasmo tessarwn dekadikwn psyfiwn
* kai o christis prospathi na ton mandepsi
* 
* 
* 
* 
*
*/
import java.util.Scanner;

public class PlayerUserMM {
	Scanner scan =new Scanner(System.in);
	private static int[][] GUESSES = new int[30][4];
	private static int GCount = 0;
	
	
	public static void Play(int tries) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\nA GAME BEGINS: The User does the guessing!!\n");
		GCount = 0;
		//System.out.println("*** THE REST IS UNDER CONSTRUCTION ***");
		
		int number[] = new int[4];
		//O Ypologistis dialegi tihea tous 4 arithmous
		for (int j = 0; j < number.length; j++) {
			number[j] = (int) (Math.random() * 10);

		}
		
		System.out.println();

		int guess[] = new int[4];
		/*enwsw oi prospathies einai ligoteres apo 30 ki oi prospathies einai ligoteres apo oses orizete
		apo tin grammi endolis kai den einai o idios arithmos me auto pou dialekse o ypologistis
		*/
		while ((GCount <tries && GCount < 30) && fullMatch(number,guess) < 4) {
			
			System.out.println("Enter your guess : ");
			//O User Pliktrologi tis prospathies
			for (int i = 0; i < guess.length; i++) {
				guess[i] = scan.nextInt();
				
			}
			//eleghoume an o arithmos ehei dokimasti ksana
			if(!yparhei(guess)) {
				Prosthese(guess);
			
			} else {
				--GCount;
				System.out.println("You have entered the SAME 4 Numbers Again");
				System.out.println("We will ingore that fault and we will not count it as a try");
				System.out.println("TRY AGAIN ! ");
			
			}
				
		//Typonoume Andistoihos ton arithmo ton psifion pou vrike o hristis
			System.out.print("Full match = " + fullMatch(number,guess) + " Partial match = " + partialMatch(number,guess) + "\n");
			//Metrame tis prospathies ++
			GCount++;

		

		}
		//elleghoume an o hristis vrike ton arithmo (entos ton epitrepomenon prospathion)
		//Stin Periptwsi tou Koinou Pehnidiou epistrefoume analogos stin PlayMasterMind an ehei kerdisi i ohi(true or false)
		if(fullMatch(number,guess)==4) {
			System.out.println("Well Done!");
			PlayMasterMind.WIN=true;
		}else {
			PlayMasterMind.WIN=false;
			System.out.println();
			System.out.println("You Have NO More Tries Left");
			System.out.println("GAME OVER ! ");
		
		}
	//scan.close();
	}


	//Sinartisi pou ypologizi posa psifia yparhoun kai vriskonde stin swsti(idia) thesi
	  public static int fullMatch(int[] conf, int guess[]) { 
	  int s = 0; 
	  for (int i= 0; i < conf.length; i++) 
	  if (conf[i] == guess[i]) 
	  s++; 
	  return s; }
	 //Sinartisi pou ypologizei posa psifia yparhoun alla den vriskonde stin idia thesi
	 //hwris na ypologizi(symperilambvani) ta psifia pou yparhoun kai vriskonde stin swsti thesi
	  public static int partialMatch (int conf[],int guess[]) {
		  int c=0;
		  boolean dcount[]= new boolean [4];
		  for(int i =0; i<dcount.length;i++) {
			  dcount[i]=true;
		  }
		  
		  for(int i = 0 ; i<conf.length; i ++) {
			  for(int j=0 ; j<conf.length; j++) {
				  if((conf[i]==guess[j])&&dcount[j]) {
					  c++;
					  dcount[j]=false;
					  j=guess.length;
				  }
				  
				  
				  
				  
			  }
		  }
		  return (c-fullMatch(conf,guess));
		  
	  }
	  //I Sinartisi elenhi an o syndiasmos arithmon ehei ksanadothi
	  //Eleghi an yparhi ston Pinaka GUESSES
	  private static boolean yparhei(int[] guess){      
			int counter=0;
			boolean symp=false;
			for (int i=0;i<GUESSES.length;i++){
				for (int j=0;j<GUESSES[0].length;j++){
					if (GUESSES[i][j]==guess[j]) { 
						counter++;
					}
				}
				if (counter==4) symp=true;
				counter=0;
			}
			return symp;
		}
	  //I Sinartisi vazi ton arithmo ston Pinaka GUESSES
	  //ekei vriskonde oles oi prospathies
	  private static void Prosthese(int guess[]) {   
			for (int j=0;j<GUESSES[0].length;j++) 
				GUESSES[GCount][j]=guess[j];
		}

	public static void main(String[] args) {

		GCount = 0;
		System.out.println("***** WELCOME TO MASTER MIND *****");
		System.out.println("\n\nThis is a standalone game where ");
		System.out.print("the User is guessing\n");
		Play(Integer.parseInt(args[0]));

	}}