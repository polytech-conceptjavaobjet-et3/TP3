Programmation Java @ Et3
<br>
Polytech Paris-Saclay | 2019-20

___

# TP3

On souhaite développer des classes Java permettant de faire certaines manipulations sur des nombres complexes.

3#1. Définissez une classe Complexe comprenant deux champs de type double, représentant respectivement la partie réelle et la partie imaginaire d’un nombre complexe, puis munissez-la d’un constructeur prenant une valeur pour la partie réelle et la partie imaginaire du nouveau nombre complexe.

- 3#1.1 Classe `Complexe` :

> ```Java
> public class Complexe 
> {
> 	private double imaginaire;
> 	private double reel;
> 	
> 	/**
> 	 * Constructeur de la classe {@link Complexe}
> 	 * @param reel La partie réelle du nombre complexe
> 	 * @param imaginaire La partie imaginaire du nombre complexe
> 	 */
> 	public Complexe(double reel, double imaginaire)
> 	{
> 		this.reel = reel;
> 		this.imaginaire = imaginaire;
> 	}
> }
> ``` 

3#2. Ajoutez à la classe Complexe le code nécessaire pour permettre un affichage approprié pour des objets de cette classe en redéfinissant la méthode toString() de la classe Object.

- 3#2.1 Méthode `toString()` :

> ```Java
> @Override
> public String toString()
> {
> 	StringBuilder stringBuilder = new StringBuilder ("(");
> 	
> 	if (reel != 0)
> 	{
> 		stringBuilder. append (reel);
> 	}
> 	
> 	if (imaginaire == 0)
> 	{
> 		stringBuilder.append (")");
> 		return stringBuilder.toString ();
> 	}
> 	
> 	if (imaginaire > 0) 
> 	{
> 		stringBuilder. append ("+");
> 	}
> 	else
> 	{
> 		stringBuilder. append ("-");
> 	}
> 	
> 	stringBuilder.append(imaginaire);
> 	stringBuilder.append("i");
> 	stringBuilder.append (")");
> 	
> 	return stringBuilder.toString ();
> }
> ``` 

3#3. On ne souhaite pas que les objets de la classe Complexe puissent être modifiés une fois créés (on les qualifiera donc d’immuables (immutable)). Comment peut-on garantir cela ? Implémentez la partie pertinente des méthodes d’accès.

- 3#3.1 Approche pour garantir la non modification des objects `Complexe` :

> Les données membres étant privées, leur modification ne peut se faire que via l'interface de la classe. Il nous suffit donc de ne pas fournir de méthode d'altération des champs pour garantir que les objets de la classe sont immuables.
> Le mot-clé [`final`](https://docs.oracle.com/javase/tutorial/java/IandI/final.html) signifie qu'un attribut, une méthode ou qu'une classe est immuable. Ici, on peut éventuellement l'appliquer aux attributs de la classe.

> ```Java
> private final double imaginaire;
> private final double reel;
> ```

- 3#3.2 Méthodes d'accès :

> ```Java
> /**
>  * Cette méthode donne accès à la valeur de la partie imaginaire du nombre complexe
>  * @return La valeur de la partie imaginaire du nombre complexe
>  */
> public double getImaginaire()
> {
> 	return imaginaire;
> }
> 
> /**
>  * Cette méthode donne accès à la valeur de la partie réelle du nombre complexe
>  * @return La valeur de la partie réelle du nombre complexe
>  */
> public double getReel()
> {
> 	return reel;
> }
> ``` 

3#4. Ajoutez un constructeur de copie à votre classe prenant en unique paramètre une instance de la classe Complexe. Quelle peut être dans ce contexte l’utilité d’un tel constructeur ?

- 3#4.1 Nouveau constructeur de `Complexe` :

> ```Java
> /**
>  * Constructeur par copie de la classe {@link Complexe}
>  * @param complexe Le nombre complexe à copier
>  */
> public Complexe(Complexe complexe)
> {
> 	this.imaginaire = complexe.imaginaire;
> 	this.reel = complexe.reel;
> }
> ``` 

- 3#4.2 Quelle est l'utilité d'un tel constructeur ?

> Dans notre cas, les objets de la classe `Complexe` sont immuables. Cloner un objet `Complexe` n'a donc pas réellement d'intérêt. Si on souhaite vraiment "copier" un objet `Complexe`, on peut simplement créer deux références vers un même objet immuable.

3#5. Ajoutez le code nécessaire à votre classe pour tester l’égalité d’état de deux objets de la classe
Complexe par redéfinition de la méthode equals de la classe Object.

- 3#5.1 Méthode `equals` :

> ```Java
> @Override
> public boolean equals(Object autreObjet)
> {
> 	if (autreObjet == null)
> 	{
> 		return false ;
> 	}
> 	if (autreObjet == this)
> 	{
> 		return true ;
> 	}
> 	if(this.getClass() != autreObjet.getClass())
> 	{
> 		return false ;
> 	}
> 	
> 	Complexe autreComplexe = (Complexe) autreObjet;
> 	
> 	return this.reel == autreComplexe.reel && this.imaginaire == autreComplexe.imaginaire;
> }
> ``` 

- 3#5.2 Tests sur plusieurs valeurs d'objets `Complexe` :

> ```Java
> public static void main(String[] args) 
> {
> 	Complexe complexe1 = new Complexe(0,7);
> 	Complexe complexe2 = new Complexe(0,7);
> 	Complexe complexe3 = new Complexe(5,7);
> 	Complexe complexe4 = new Complexe(0,5);
> 
> 	// 3#5.2
> 	System.out.println();
> 	System.out.println("Question 3#5.2");
> 	System.out.println();
> 	System.out.println("Complexe1 est-il égal à Complexe2 ? " + complexe1.equals(complexe2));
> 	System.out.println("Complexe1 est-il égal à Complexe3 ? " + complexe1.equals(complexe3));
> 	System.out.println("Complexe1 est-il égal à Complexe4 ? " + complexe1.equals(complexe4));
> }
> ``` 

3#6. Ajoutez des méthodes d’instance pour le calcul du module et de l’argument d’un complexe. On rappelle :
```
Module = Sqrt(R * R + I * I)
Argument = Acos(R / Module)

Avec :
- R : La partie réelle du nombre complexe
- I : La partie imaginaire du nombre complexe
```

- 3#6.1 Nouvelles méthodes :

> ```Java
> /**
>  * Cette méthode permet de calculer le module du nombre complexe
>  * @return Le module du nombre complexe
>  */
> public double getModule()
> {
> 	return Math.sqrt (reel * reel + imaginaire * imaginaire );
> }
> 
> /**
>  * Cette méthode permet de calculer l'argument du nombre complexe
>  * @return L'argument du nombre complexe
>  */
> public double getArgument()
> {
> 	return Math.acos (reel / getModule());
> }
> ``` 

- 3#6.2 Est-il plus pertinent d'ajouter de nouveaux champs à la classe ou bien de faire des calculs de ces valeurs à la volée ?

> Les objets de la classe `Complexe` étant immuables, l'utilisation des méthodes de calcul est discutable. En effet, si on rajoute deux champs pour conserver le module et l'argument du nombre complexe, on évite les recalculer à chaque fois. Il suffit alors d'implémenter deux méthodes d'accès.

3#7. Définissez des méthodes pour l’addition et la multiplication de deux nombres complexes. Ces
méthodes prendront un paramètre implicite et un paramètre explicite, et retourneront une nouvelle instance correspondant au résultat de l’opération. On rappelle :
```
Addition : (R1 + I1 * i) + (R2 + I2 * i) = (R1 + R2 + (I1 + I2) * i)
Multiplication : (R1 + I1 * i) * (R2 + I2 * i) = (R1 * R2 − I1 * I2 + (R1 * I2 + I1 * R2) * i)

Avec :
- R1 : La partie réelle du nombre complexe1
- I1 : La partie imaginaire du nombre complexe1
- R2 : La partie réelle du nombre complexe2
- I2 : La partie imaginaire du nombre complexe2
```

- 3#7.1 Nouvelles méthodes :

> ```Java
> /**
>  * Cette méthode permet d'additionner deux nombres complexes dont celui de l'instance appelante
>  * @param autreComplexe Le complexe à additionner avec l'instance appelante
>  * @return La somme des deux nombres complexes
>  */
> public Complexe additionner(Complexe autreComplexe)
> {
> 	return new Complexe(
> 			reel + autreComplexe.reel,
> 			imaginaire + autreComplexe.imaginaire
> 		);
> }
> 	
> /**
>  * Cette méthode permet de multiplier deux nombres complexes dont celui de l'instance appelante
>  * @param autreComplexe Le complexe à multiplier avec l'instance appelante
>  * @return La multiplication des deux nombres complexes
>  */
> public Complexe multiplier(Complexe autreComplexe)
> {
> 	return new Complexe (
> 			reel * autreComplexe.reel - imaginaire * autreComplexe.imaginaire,
> 			reel * autreComplexe .imaginaire + imaginaire * autreComplexe.reel
> 		);
> }
> ``` 

3#8. On souhaite à présent bénéficier de la classe Complexe et définir une classe permettant de représenter un nombre complexe telle que l’historique des opérations dans lesquelles ce complexe aura servi d’opérande est conservé. Définissez une nouvelle classe ComplexeMemoire, dans un autre package que Complexe, permettant de réaliser cela. Pour l’historique des opérations, on veut garder la trace des opérations subies (addition ou multiplication), de la valeur des autres opérandes et des résultats obtenus (une simple chaîne de caractères pourra faire l'affaire). Proposez une implémentation appropriée, et ajoutez un constructeur prenant une partie réelle et une partie imaginaire en paramètres.

- 3#8.1 Classe `ComplexeMemoire` :

> ```Java
> public class ComplexeMemoire extends Complexe
> {
> 	private StringBuilder memoireIndividuelle;
> 	
> 	//Bloc d'initialisation d'instance
> 	{
> 		memoireIndividuelle = new StringBuilder();
> 	}
> 	
> 	/**
> 	 * Constructeur de la classe {@link ComplexeMemoire}
> 	 * @param reel La partie réelle du nombre complexe
> 	 * @param imaginaire La partie imaginaire du nombre complexe
> 	 */
> 	public ComplexeMemoire(double reel, double imaginaire)
> 	{
> 		super(reel, imaginaire);
> 	}
> }
> ``` 

3#9. Ajoutez un constructeur par copie à la classe `ComplexeMemoire`.

- 3#9.1 Constructeur par copie de `ComplexeMemoire` :

> ```Java
> /**
>  * Constructeur par copie de la classe {@link ComplexeMemoire}
>  * @param complexeMemoire Le nombre complexe à copier
>  */
> public ComplexeMemoire(ComplexeMemoire complexeMemoire)
> {
> 	super(complexeMemoire.getReel(), complexeMemoire.getImaginaire());
> 	memoireIndividuelle = new StringBuilder(memoireIndividuelle.toString());
> }
> ``` 

3#10. Serait-il possible d’ajouter simplement un constructeur sans paramètres à la classe `ComplexeMemoire` ?

- 3#10.1 Réponse et solution(s) possible(s) :

> Si on choisit d'avoir un constructeur sans paramètres, une erreur peut apparaître :
> ```
> Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
> 	Implicit super constructor Complexe() is undefined. Must explicitly invoke another constructor
> ```
> Ici, le problème soulevé est lié à l'héritage : la classe `ComplexeMemoire` héritant de la classe `Complexe`, tout constructeur de la classe `ComplexeMemoire` doit faire appel (implicitement ou explicitement) à un constructeur de la classe `Complexe`. Par défaut, le constructeur appelé est `Complexe()`. Cependant, ce constructeur n'a pas été défini précedemment. Nous avons donc plusieurs solution possible à ce problème.
> - Il est possible de définir le constructeur `Complexe()` dans la classe `Complexe` en donnant des valeurs par défaut aux attributs :
> ```Java
> public Complexe()
> {
> 	reel = 0;
> 	imaginaire = 0;
> }
> ```
> - On peut faire un appel explicite à un autre constructeur de la classe `Complexe` en donnant des valeurs par défaut à un constructeur éxistant :
> ```Java
> public ComplexeMemoire()
> {
> 	super(0, 0);
> }
> ```

3#11. Ajoutez à la classe `ComplexeMemoire` les méthodes nécessaires pour pouvoir ajouter des messages à la mémoire des opérations d’un objet de la classe et consulter cette mémoire.

- 3#11.1 Nouvelles méthodes :

> ```Java
> /**
>  * Cette méthode permet d'écrire une nouvelle opération dans la mémoire individuelle du nombre complexe
>  * @param operation La nouvelle opération à écrire dans la mémoire individuelle du nombre complexe
>  */
> private void ecrireMemoireIndividuelle(String operation)
> {
> 	this.memoireIndividuelle.append("\n" + operation);
> }
> 
> /**
>  * Cette méthode permet de consulter la mémoire individuelle du nombre complexe
>  * @return La mémoire individuelle du nombre complexe
>  */
> public String consulterMemoireIndividuelle()
> {
> 	return ("Memoire individuelle :" + memoireIndividuelle.toString());
> }
> ``` 

3#12. Proposez à présent une redéfinition adaptée dans la classe `ComplexeMemoire` des méthodes d’addition et de multiplication de complexes définies dans la classe `Complexe`.

- 3#12.1 Est-il possible et utile d’adapter le type de retour (covariance) ?

> La [covariance](https://www.eclipse.org/aspectj/doc/released/adk15notebook/covariance.html) est le fait de permettre le changement du type de retour d'une méthode lors de sa redéfinition. Le nouveau type doit être une sous-classe du type prédéfini.
> `ComplexeMemoire` étant la classe fille de `Complexe`, le changement de type ne pose pas de problème.

pour les méthodes. Il est donc permis de modifier le type de retour d'une méthode pour une sous-classe du type prédéfini

On appelle
covariance
le fait de modifier le type de retour d’une
méthode lors de sa redéfinition. En Java, elle a été introduite dans
la version : Java 1.

- 3#12.2 Méthodes d'addition et de multiplication dans `ComplexeMemoire` :

> ```Java
> @Override
> public ComplexeMemoire additionner(Complexe autreComplexe)
> {
> 	//On additionne les deux nombres complexes
> 	Complexe resultatComplexe = super.additionner(autreComplexe);
> 	ComplexeMemoire resultatComplexeMemoire = new ComplexeMemoire(resultatComplexe.getReel(), resultatComplexe.getImaginaire());
> 			
> 	//On écrit l'opération dans la mémoire individuelle de ce nombre complexe
> 	String operation = toString() + " + " + autreComplexe.toString() + " = " + resultatComplexe.toString();
> 	ecrireMemoireIndividuelle(operation);
> 	
> 	//Si l'autre complexe est également du type ComplexeMemoire, on écrit également l'opération dans sa mémoire individuelle
> 	if(autreComplexe instanceof ComplexeMemoire)
> 	{
> 		operation = autreComplexe.toString() + " + " + toString() + " = " + resultatComplexe.toString();
> 		((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
> 	}
> 	
> 	return resultatComplexeMemoire;
> }
> 
> @Override
> public ComplexeMemoire multiplier(Complexe autreComplexe)
> {
> 	//On multiplie les deux nombres complexes
> 	Complexe resultatComplexe = super.multiplier(autreComplexe);
> 	ComplexeMemoire resultatComplexeMemoire = new ComplexeMemoire(resultatComplexe.getReel(), resultatComplexe.getImaginaire());
> 	
> 	//On écrit l'opération dans la mémoire individuelle de ce nombre complexe
> 	String operation = toString() + " x " + autreComplexe.toString() + " = " + resultatComplexe.toString();
> 	ecrireMemoireIndividuelle(operation);
> 	
> 	//Si l'autre complexe est également du type ComplexeMemoire, on écrit également l'opération dans sa mémoire individuelle
> 	if(autreComplexe instanceof ComplexeMemoire)
> 	{
> 		operation = autreComplexe.toString() + " x " + toString() + " = " + resultatComplexe.toString();
> 		((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
> 	}
> 	
> 	return resultatComplexeMemoire;
> }
> ``` 

3#13. On souhaite à présent mettre en place une mémoire collective où apparaı̂t une seule fois chaque opération effectuée sur des instances de `ComplexeMemoire`. Adaptez votre classe afin de permettre cela.

- 3#13.1 Nouvelle définition de `ComplexeMemoire` :

> ```Java
> public class ComplexeMemoire extends Complexe
> {
> 	private StringBuilder memoireIndividuelle;
> 	private static StringBuilder memoireCollective = new StringBuilder();
> 	
> 	//Bloc d'initialisation d'instance
> 	{
> 		memoireIndividuelle = new StringBuilder();
> 	}
> 	
> 	/**
> 	 * Constructeur de la classe {@link ComplexeMemoire}
> 	 * @param reel La partie réelle du nombre complexe
> 	 * @param imaginaire La partie imaginaire du nombre complexe
> 	 */
> 	public ComplexeMemoire(double reel, double imaginaire)
> 	{
> 		super(reel, imaginaire);
> 	}
> 	
> 	/**
> 	 * Constructeur par copie de la classe {@link ComplexeMemoire}
> 	 * @param complexeMemoire Le nombre complexe à copier
> 	 */
> 	public ComplexeMemoire(ComplexeMemoire complexeMemoire)
> 	{
> 		super(complexeMemoire.getReel(), complexeMemoire.getImaginaire());
> 		memoireIndividuelle = new StringBuilder(memoireIndividuelle.toString());
> 	}
> 	
> 	/**
> 	 * Cette méthode permet d'écrire une nouvelle opération dans la mémoire individuelle du nombre complexe
> 	 * @param operation La nouvelle opération à écrire dans la mémoire individuelle du nombre complexe
> 	 */
> 	private void ecrireMemoireIndividuelle(String operation)
> 	{
> 		this.memoireIndividuelle.append("\n" + operation);
> 	}
> 	
> 	/**
> 	 * Cette méthode permet de consulter la mémoire individuelle du nombre complexe
> 	 * @return La mémoire individuelle du nombre complexe
> 	 */
> 	public String consulterMemoireIndividuelle()
> 	{
> 		return ("Memoire individuelle :" + memoireIndividuelle.toString());
> 	}
> 	
> /**
>  * Cette méthode permet d'écrire une nouvelle opération dans la mémoire collective des nombres complexes
>  * @param operation La nouvelle opération à écrire dans la mémoire collective des nombres complexes
>  */
> private static void ecrireMemoireCollective(String operation)
> {
> 	memoireCollective.append("\n" + operation);
> }
> 
> /**
>  * Cette méthode permet de consulter la mémoire collective des nombres complexes
>  * @return La mémoire collective des nombres complexes
>  */
> public static String consulterMemoireCollective()
> {
> 	return ("Memoire collective :" + memoireCollective.toString());
> }
> 	
> 	@Override
> 	public ComplexeMemoire additionner(Complexe autreComplexe)
> 	{
> 		//On additionne les deux nombres complexes
> 		Complexe resultatComplexe = super.additionner(autreComplexe);
> 		ComplexeMemoire resultatComplexeMemoire = new ComplexeMemoire(resultatComplexe.getReel(), resultatComplexe.getImaginaire());
> 				
> 		//On écrit l'opération dans la mémoire individuelle de ce nombre complexe
> 		String operation = toString() + " + " + autreComplexe.toString() + " = " + resultatComplexe.toString();
> 		ecrireMemoireIndividuelle(operation);
> 		
> 		//Si l'autre complexe est également du type ComplexeMemoire, on écrit également l'opération dans sa mémoire individuelle
> 		if(autreComplexe instanceof ComplexeMemoire)
> 		{
> 			operation = autreComplexe.toString() + " + " + toString() + " = " + resultatComplexe.toString();
> 			((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
> 		}
> 		
> 		//On écrit l'opération dans la mémoire collective des nombres complexes
> 		ecrireMemoireCollective(operation);
> 		
> 		return resultatComplexeMemoire;
> 	}
> 	
> 	@Override
> 	public ComplexeMemoire multiplier(Complexe autreComplexe)
> 	{
> 		//On multiplie les deux nombres complexes
> 		Complexe resultatComplexe = super.multiplier(autreComplexe);
> 		ComplexeMemoire resultatComplexeMemoire = new ComplexeMemoire(resultatComplexe.getReel(), resultatComplexe.getImaginaire());
> 		
> 		//On écrit l'opération dans la mémoire individuelle de ce nombre complexe
> 		String operation = toString() + " x " + autreComplexe.toString() + " = " + resultatComplexe.toString();
> 		ecrireMemoireIndividuelle(operation);
> 		
> 		//Si l'autre complexe est également du type ComplexeMemoire, on écrit également l'opération dans sa mémoire individuelle
> 		if(autreComplexe instanceof ComplexeMemoire)
> 		{
> 			operation = autreComplexe.toString() + " x " + toString() + " = " + resultatComplexe.toString();
> 			((ComplexeMemoire) autreComplexe).ecrireMemoireIndividuelle(operation);
> 		}
> 		
> 		//On écrit l'opération dans la mémoire collective des nombres complexes
> 		ecrireMemoireCollective(operation);
> 		
> 		return resultatComplexeMemoire;
> 	}
> }
> ```

3#14. Sans modifier le code développé jusqu’à présent, que se passera-t-il si l’on invoque la méthode `equals` sur deux instances de la classe `ComplexeMemoire` ? Sur une instance de la classe `Complexe` et une instance de la classe `ComplexeMemoire` ?

- 3#14.1 Réponse et tests :

> Si on ne modifie pas le code précedent, il sera toujours possible de comparer deux instances de même classe. En effet, les classes des deux objets sont comparées entre elles :
> ```Java
> this.getClass() != autreObjet.getClass()
> ```
> En revanche, dans la méthode `equals(Complexe autreComplexe)`, il n'est pas question de mémoire individuelle. Les deux objets seront donc comparés sans tenir compte de leur mémoire.
> En ce qui concerne la deuxième question, la méthode `equals(Complexe autreComplexe)` renverra toujours `false` puisque que les deux objets sont de classes différentes (`Complexe` et `ComplexeMemoire`). 
> 
> En testant les hypothèses, on tombe bien sur ce résultat :
> 
> ```Java
> public static void main(String[] args)
> {
> 	ComplexeMemoire complexeMemoire1 = new ComplexeMemoire(7,2);
> 	ComplexeMemoire complexeMemoire1Bis = new ComplexeMemoire(7,2);
> 	Complexe complexe1 = new Complexe(7,2);
> 	
> 	System.out.println("ComplexeMemoire1 = " + complexeMemoire1.toString());
> 	System.out.println("ComplexeMemoire1Bis = " + complexeMemoire1Bis.toString());
> 	System.out.println("Complexe1 = " + complexe1.toString());
> 	
> 	// 3#14.1
> 	System.out.println();
> 	System.out.println("Question 3#14.1");
> 	System.out.println();
> 	System.out.println("ComplexeMemoire1 est-il égal à ComplexeMemoire1Bis ? " + complexeMemoire1.equals(complexeMemoire1Bis));
> 	System.out.println("ComplexeMemoire1 est-il égal à Complexe1 ? " + complexeMemoire1.equals(complexe1));
> }
> ``` 
> 
> On obtient l'affichage suivant :
> 
> ```
> ComplexeMemoire1 = (7.0+2.0i)
> ComplexeMemoire1Bis = (7.0+2.0i)
> Complexe1 = (7.0+2.0i)
> 
> Question 3#14.1
> 
> ComplexeMemoire1 est-il égal à ComplexeMemoire1Bis ? true
> ComplexeMemoire1 est-il égal à Complexe1 ? false
> ```
