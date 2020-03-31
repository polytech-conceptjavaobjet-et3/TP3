public class ComplexeMemoire extends Complexe
{
	private StringBuilder memoireIndividuelle;
	private static StringBuilder memoireCollective = new StringBuilder();
	
	//Dans tous les constructeurs, on rajoute la ligne suivante
	{
		memoireIndividuelle = new StringBuilder();
	}
	
	/**
	 * Constructeur de la classe {@link ComplexeMemoire}
	 * @param reel La partie réelle du nombre complexe
	 * @param imaginaire La partie imaginaire du nombre complexe
	 */
	public ComplexeMemoire(double reel, double imaginaire)
	{
		super(reel, imaginaire);
	}
	
	/**
	 * Constructeur par copie de la classe {@link ComplexeMemoire}
	 * @param complexeMemoire Le nombre complexe à copier
	 */
	public ComplexeMemoire(ComplexeMemoire complexeMemoire)
	{
		super(complexeMemoire.getReel(), complexeMemoire.getImaginaire());
		memoireIndividuelle = new StringBuilder(memoireIndividuelle.toString());
	}
	
	/**
	 * Cette méthode permet d'écrire une nouvelle opération dans la mémoire individuelle du nombre complexe
	 * @param operation La nouvelle opération à écrire dans la mémoire individuelle du nombre complexe
	 */
	private void ecrireMemoireIndividuelle(String operation)
	{
		this.memoireIndividuelle.append("\n" + operation);
	}
	
	/**
	 * Cette méthode permet de consulter la mémoire individuelle du nombre complexe
	 * @return La mémoire individuelle du nombre complexe
	 */
	public String consulterMemoireIndividuelle()
	{
		return ("Memoire individuelle :" + memoireIndividuelle.toString());
	}
	
	/**
	 * Cette méthode permet d'écrire une nouvelle opération dans la mémoire collective des nombres complexes
	 * @param operation La nouvelle opération à écrire dans la mémoire collective des nombres complexes
	 */
	private void ecrireMemoireCollective(String operation)
	{
		memoireCollective.append("\n" + operation);
	}
	
	/**
	 * Cette méthode permet de consulter la mémoire collective des nombres complexes
	 * @return La mémoire collective des nombres complexes
	 */
	public String consulterMemoireCollective()
	{
		return ("Memoire collective :" + memoireCollective.toString());
	}
	
	@Override
	public ComplexeMemoire additionner(Complexe autreComplexe)
	{
		//On additionne les deux nombres complexes
		Complexe resultatComplexe = super.additionner(autreComplexe);
		ComplexeMemoire resultatComplexeMemoire = new ComplexeMemoire(resultatComplexe.getReel(), resultatComplexe.getImaginaire());
				
		//On écrit l'opération dans la mémoire individuelle de ce nombre complexe
		String operation = toString() + " + " + autreComplexe.toString() + " = " + resultatComplexe.toString();
		ecrireMemoireIndividuelle(operation);
		
		//Si l'autre complexe est également du type ComplexeMemoire, on écrit également l'opération dans sa mémoire individuelle
		if(autreComplexe instanceof ComplexeMemoire)
		{
			operation = autreComplexe.toString() + " + " + toString() + " = " + resultatComplexe.toString();
			((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
		}
		
		//On écrit l'opération dans la mémoire collective des nombres complexes
		ecrireMemoireCollective(operation);
		
		return resultatComplexeMemoire;
	}
	
	@Override
	public ComplexeMemoire multiplier(Complexe autreComplexe)
	{
		//On multiplie les deux nombres complexes
		Complexe resultatComplexe = super.multiplier(autreComplexe);
		ComplexeMemoire resultatComplexeMemoire = new ComplexeMemoire(resultatComplexe.getReel(), resultatComplexe.getImaginaire());
		
		//On écrit l'opération dans la mémoire individuelle de ce nombre complexe
		String operation = toString() + " x " + autreComplexe.toString() + " = " + resultatComplexe.toString();
		ecrireMemoireIndividuelle(operation);
		
		//Si l'autre complexe est également du type ComplexeMemoire, on écrit également l'opération dans sa mémoire individuelle
		if(autreComplexe instanceof ComplexeMemoire)
		{
			operation = autreComplexe.toString() + " x " + toString() + " = " + resultatComplexe.toString();
			((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
		}
		
		//On écrit l'opération dans la mémoire collective des nombres complexes
		ecrireMemoireCollective(operation);
		
		return resultatComplexeMemoire;
	}
	
	public static void main(String[] args)
	{
		ComplexeMemoire complexeMemoire1 = new ComplexeMemoire(7,2);
		ComplexeMemoire complexeMemoire1Bis = new ComplexeMemoire(7,2);
		ComplexeMemoire complexeMemoire2 = new ComplexeMemoire(9,11);
		Complexe complexe1 = new Complexe(7,2);
		
		// 3#14.1
		System.out.println();
		System.out.println("Question 3#14.1");
		System.out.println();
		System.out.println("ComplexeMemoire1 = " + complexeMemoire1.toString());
		System.out.println("ComplexeMemoire1Bis = " + complexeMemoire1Bis.toString());
		System.out.println("Complexe1 = " + complexe1.toString());
		System.out.println("ComplexeMemoire1 est-il égal à ComplexeMemoire1Bis ? " + complexeMemoire1.equals(complexeMemoire1Bis));
		System.out.println("ComplexeMemoire1 est-il égal à Complexe1 ? " + complexeMemoire1.equals(complexe1));
	}
}
