Programmation Java @ Et3
<br>
Polytech Paris-Saclay | 2019-20

___

# TP3

On souhaite développer des classes Java permettant de faire certaines manipulations sur des nombres complexes.

3#1. Définissez une classe Complexe comprenant deux champs de type double, représentant respectivement la partie réelle et la partie imaginaire d’un nombre complexe, puis munissez-la d’un constructeur prenant une valeur pour la partie réelle et la partie imaginaire du nouveau nombre complexe.

- 3#1.1 classe  Complexe

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

- 3#2.1 méthode toString

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

- 3#3.1 Approche pour garantir la non modification des objects Complexe

> Les données membres étant privées, leur modification ne peut se faire que via l'interface de la classe. Il nous suffit donc de ne pas fournir de méthode d'altération des champs pour garantir que les objets de la classe sont immuables.
> Le mot-clé [`final`](https://docs.oracle.com/javase/tutorial/java/IandI/final.html) signifie qu'un attribut, une méthode ou qu'une classe est immuable. Ici, on peut éventuellement l'appliquer aux attributs de la classe.

> ```Java
> private final double imaginaire;
> private final double reel;
> ```

- 3#3.2 Méthodes d'accès

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

- 3#4.1 Nouveau constructeur de Complexe

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

- 3#5.1 redéfinition de equals

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
> 	if( this.getClass() != autreObjet.getClass())
> 	{
> 		return false ;
> 	}
> 	
> 	Complexe autreComplexe = (Complexe) autreObjet;
> 	
> 	return this.reel == autreComplexe.reel && this.imaginaire == autreComplexe.imaginaire;
> }
> ``` 

- 3#5.2 tests sur plusieurs valeurs d'objets Complexe

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
<div align="center">
```
Module = sqrt(re2 + im2)
Argument = acos( re / module )
```
</div>

- 3#6.1 nouvelles méthodes

> ```Java
> ``` 

- 3#6.2 Est-il plus pertinent d'ajouter de nouveaux champs à la classe ou bien de faire des calculs de ces valeurs à la volée ?

> ```Java
> ``` 

3#7. Définissez des méthodes pour l’addition et la multiplication de deux nombres complexes. Ces
méthodes prendront un paramètre implicite et un paramètre explicite, et retourneront une nouvelle instance correspondant au résultat de l’opération. On rappelle :

— (re1 + im1 i) + (re2 + im2 i) = (re1 + re2 + (im1 + im2)i)
— (re1 + im1 i) x (re2 + im2 i) = (re1 x re2 − im1 x im2 + (re1 x im2 + im1 x re2)i)

- 3#7.1 nouvelles méthodes

> ```Java
> ``` 

3#8. On souhaite à présent bénéficier de la classe Complexe et définir une classe permettant de représenter un nombre complexe telle que l’historique des opérations dans lesquelles ce complexe aura servi d’opérande est conservé. Définissez une nouvelle classe ComplexeMemoire, dans un autre package que Complexe, permettant de réaliser cela. Pour l’historique des opérations, on veut garder la trace des opérations subies (addition ou multiplication), de la valeur des autres opérandes et des résultats obtenus (une simple chaîne de caractères pourra faire l'affaire). Proposez une implémentation appropriée, et ajoutez un constructeur prenant une partie réelle et une partie imaginaire en paramètres.

- 3#8.1 classe ComplexeMemoire

> ```Java
> ``` 

3#9. Ajoutez un constructeur par copie à la classe ComplexeMemoire.

- 3#9.1 constructeur par copie de ComplexeMemoire

> ```Java
> ``` 

3#10. Serait-il possible d’ajouter simplement un constructeur sans paramètres à la classe ComplexeMemoire ?

- 3#10.1 réponse et solution(s) possible(s)

> ```Java
> ``` 

3#11. Ajoutez à la classe ComplexeMemoire les méthodes nécessaires pour pouvoir ajouter des messages à la mémoire des opérations d’un objet de la classe et consulter cette mémoire.

- 3#11.1 nouvelles méthodes

> ```Java
> ``` 

3#12. Proposez à présent une redéfinition adaptée dans la classe ComplexeMemoire des méthodes d’addition et de multiplication de complexes définies dans la classe Complexe.

- 3#12.1 Est-il possible et utile d’adapter le type de retour (covariance) ?

> ```Java
> ``` 

- 3#12.2 redéfinition des méthodes d'addition et de multiplication dans ComplexeMemoire

> ```Java
> ``` 

3#13. On souhaite à présent mettre en place une mémoire collective où apparaı̂t une seule fois chaque opération effectuée sur des instances de ComplexeMemoire. Adaptez votre classe afin de permettre cela.

- 3#13.1 nouvelle définition de ComplexeMemoire

> ```Java
> ``` 

3#14. Sans modifier le code développé jusqu’à présent, que se passera-t-il si l’on invoque la méthode equals sur deux instances de la classe ComplexeMemoire ? Sur une instance de la classe Complexe et une instance de la classe ComplexeMemoire ?

- 3#14.1 réponse et tests

> ```Java
> ``` 
