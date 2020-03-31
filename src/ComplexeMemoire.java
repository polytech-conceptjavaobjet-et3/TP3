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
	 * @param reel La partie r�elle du nombre complexe
	 * @param imaginaire La partie imaginaire du nombre complexe
	 */
	public ComplexeMemoire(double reel, double imaginaire)
	{
		super(reel, imaginaire);
	}
	
	/**
	 * Constructeur par copie de la classe {@link ComplexeMemoire}
	 * @param complexeMemoire Le nombre complexe � copier
	 */
	public ComplexeMemoire(ComplexeMemoire complexeMemoire)
	{
		super(complexeMemoire.getReel(), complexeMemoire.getImaginaire());
		memoireIndividuelle = new StringBuilder(memoireIndividuelle.toString());
	}
	
	/**
	 * Cette m�thode permet d'�crire une nouvelle op�ration dans la m�moire individuelle du nombre complexe
	 * @param operation La nouvelle op�ration � �crire dans la m�moire individuelle du nombre complexe
	 */
	private void ecrireMemoireIndividuelle(String operation)
	{
		this.memoireIndividuelle.append("\n" + operation);
	}
	
	/**
	 * Cette m�thode permet de consulter la m�moire individuelle du nombre complexe
	 * @return La m�moire individuelle du nombre complexe
	 */
	public String consulterMemoireIndividuelle()
	{
		return ("Memoire individuelle :" + memoireIndividuelle.toString());
	}
	
	/**
	 * Cette m�thode permet d'�crire une nouvelle op�ration dans la m�moire collective des nombres complexes
	 * @param operation La nouvelle op�ration � �crire dans la m�moire collective des nombres complexes
	 */
	private void ecrireMemoireCollective(String operation)
	{
		memoireCollective.append("\n" + operation);
	}
	
	/**
	 * Cette m�thode permet de consulter la m�moire collective des nombres complexes
	 * @return La m�moire collective des nombres complexes
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
				
		//On �crit l'op�ration dans la m�moire individuelle de ce nombre complexe
		String operation = toString() + " + " + autreComplexe.toString() + " = " + resultatComplexe.toString();
		ecrireMemoireIndividuelle(operation);
		
		//Si l'autre complexe est �galement du type ComplexeMemoire, on �crit �galement l'op�ration dans sa m�moire individuelle
		if(autreComplexe instanceof ComplexeMemoire)
		{
			operation = autreComplexe.toString() + " + " + toString() + " = " + resultatComplexe.toString();
			((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
		}
		
		//On �crit l'op�ration dans la m�moire collective des nombres complexes
		ecrireMemoireCollective(operation);
		
		return resultatComplexeMemoire;
	}
	
	@Override
	public ComplexeMemoire multiplier(Complexe autreComplexe)
	{
		//On multiplie les deux nombres complexes
		Complexe resultatComplexe = super.multiplier(autreComplexe);
		ComplexeMemoire resultatComplexeMemoire = new ComplexeMemoire(resultatComplexe.getReel(), resultatComplexe.getImaginaire());
		
		//On �crit l'op�ration dans la m�moire individuelle de ce nombre complexe
		String operation = toString() + " x " + autreComplexe.toString() + " = " + resultatComplexe.toString();
		ecrireMemoireIndividuelle(operation);
		
		//Si l'autre complexe est �galement du type ComplexeMemoire, on �crit �galement l'op�ration dans sa m�moire individuelle
		if(autreComplexe instanceof ComplexeMemoire)
		{
			operation = autreComplexe.toString() + " x " + toString() + " = " + resultatComplexe.toString();
			((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
		}
		
		//On �crit l'op�ration dans la m�moire collective des nombres complexes
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
		System.out.println("ComplexeMemoire1 est-il �gal � ComplexeMemoire1Bis ? " + complexeMemoire1.equals(complexeMemoire1Bis));
		System.out.println("ComplexeMemoire1 est-il �gal � Complexe1 ? " + complexeMemoire1.equals(complexe1));
	}
}
