public class Complexe 
{
	private double imaginaire;
	private double reel;
	
	/**
	 * Constructeur de la classe {@link Complexe}
	 * @param reel La partie réelle du nombre complexe
	 * @param imaginaire La partie imaginaire du nombre complexe
	 */
	public Complexe(double reel, double imaginaire)
	{
		this.reel = reel;
		this.imaginaire = imaginaire;
	}
	
	/**
	 * Constructeur par copie de la classe {@link Complexe}
	 * @param complexe Le nombre complexe à copier
	 */
	public Complexe(Complexe complexe)
	{
		this.imaginaire = complexe.imaginaire;
		this.reel = complexe.reel;
	}
	
	/**
	 * Cette méthode donne accès à la valeur de la partie imaginaire du nombre complexe
	 * @return La valeur de la partie imaginaire du nombre complexe
	 */
	public double getImaginaire()
	{
		return imaginaire;
	}
	
	/**
	 * Cette méthode donne accès à la valeur de la partie réelle du nombre complexe
	 * @return La valeur de la partie réelle du nombre complexe
	 */
	public double getReel()
	{
		return reel;
	}
	
	/**
	 * Cette méthode permet de calculer le module du nombre complexe
	 * @return Le module du nombre complexe
	 */
	public double getModule()
	{
		return Math.sqrt (reel * reel + imaginaire * imaginaire );
	}
	
	/**
	 * Cette méthode permet de calculer l'argument du nombre complexe
	 * @return L'argument du nombre complexe
	 */
	public double getArgument()
	{
		return Math.acos (reel / getModule());
	}
	
	/**
	 * Cette méthode permet d'additionner deux nombres complexes dont celui de l'instance appelante
	 * @param autreComplexe Le complexe à additionner avec l'instance appelante
	 * @return La somme des deux nombres complexes
	 */
	public Complexe additionner(Complexe autreComplexe)
	{
		return new Complexe(
				reel + autreComplexe.reel,
				imaginaire + autreComplexe.imaginaire
			);
	}
		
	/**
	 * Cette méthode permet de multiplier deux nombres complexes dont celui de l'instance appelante
	 * @param autreComplexe Le complexe à multiplier avec l'instance appelante
	 * @return La multiplication des deux nombres complexes
	 */
	public Complexe multiplier(Complexe autreComplexe)
	{
		return new Complexe (
				reel * autreComplexe.reel - imaginaire * autreComplexe.imaginaire,
				reel * autreComplexe .imaginaire + imaginaire * autreComplexe.reel
			);
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder ("(");
		
		if (reel != 0)
		{
			stringBuilder. append (reel);
		}
		
		if (imaginaire == 0)
		{
			stringBuilder.append (")");
			return stringBuilder.toString ();
		}
		
		if (imaginaire > 0) 
		{
			stringBuilder. append ("+");
		}
		else
		{
			stringBuilder. append ("-");
		}
		
		stringBuilder.append(imaginaire);
		stringBuilder.append("i");
		stringBuilder.append (")");
		
		return stringBuilder.toString ();
	}
	
	@Override
	public boolean equals(Object autreObjet)
	{
		if (autreObjet == null)
		{
			return false ;
		}
		if (autreObjet == this)
		{
			return true ;
		}
		if( this.getClass() != autreObjet.getClass())
		{
			return false ;
		}
		
		Complexe autreComplexe = (Complexe) autreObjet;
		
		return this.reel == autreComplexe.reel && this.imaginaire == autreComplexe.imaginaire;
	}
	
	public static void main(String[] args) 
	{
		Complexe complexe1 = new Complexe(0,7);
		Complexe complexe2 = new Complexe(0,7);
		Complexe complexe3 = new Complexe(5,7);
		Complexe complexe4 = new Complexe(0,5);
		
		// 3#2.1
		System.out.println();
		System.out.println("Question 3#2.1");
		System.out.println();
		System.out.println("Complexe1 = " + complexe1.toString());
		System.out.println("Complexe2 = " + complexe2.toString());
		System.out.println("Complexe3 = " + complexe3.toString());
		System.out.println("Complexe4 = " + complexe4.toString());
		
		// 3#5.2
		System.out.println();
		System.out.println("Question 3#5.2");
		System.out.println();
		System.out.println("Complexe1 est-il égal à Complexe2 ? " + complexe1.equals(complexe2));
		System.out.println("Complexe1 est-il égal à Complexe3 ? " + complexe1.equals(complexe3));
		System.out.println("Complexe1 est-il égal à Complexe4 ? " + complexe1.equals(complexe4));
		
	}
}