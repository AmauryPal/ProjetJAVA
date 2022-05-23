package kvoisins;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
			String file = "dataSet.csv";
			BufferedReader reader = null;
			String line = "";
			int acc = 0;
			ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();//on instancie la liste de liste data
			ArrayList<String> l = new ArrayList<String>();//on instancie la sous liste l
			ArrayList<String> head = new ArrayList<String>();//on instancie la liste qui contiendra les noms des colonnes
			
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				if (acc != 0) {//toutes les lignes sauf le premiere qui sont les titres des colonnes
					for(String i : row) {
						l.add(i);
						
					}
					data.add(acc-1,new ArrayList<String>(l));
					l.clear();
				
				}
				else {
					for(String i : row) {
						head.add(i);
					}
				}
				acc += 1;//accumulateur pour indiquer un index à la liste de liste data
			}
			reader.close();//on ferme la lecture du fichier
		}
		catch(Exception e) {
			   e.printStackTrace();
		}
		
			afficher(data, head);//on affiche

			eliminer(data, head);//on élimine les colonnes Date et Numero qui ne sont pas utiles
			
			afficher(data, head);
			
			encoder(data, head);//on encode les colonnes QI, Victoire et Obstacle_mobile

			afficher(data, head);
			
			ArraylistShuffle(data, head);//il faut mélanger car certaine colonne ne le sont pas et cela rend le modèle beaucoup moins performant
			
			ArrayList<ArrayList<Double>> dataDouble = new ArrayList<ArrayList<Double>>();//on va y stocker la copie en double de data
			ArrayList<Double> initArray = new ArrayList<Double>();
			
			toDouble(data, dataDouble, initArray);//on copie data dans dataDouble en convertissant toutes les valeurs en double
			
			afficherDouble(dataDouble, head);//on affiche dataDouble avec une autre méthode car la liste de double est autorisée
			
			ArrayList<ArrayList<Double>> df_train = new ArrayList<ArrayList<Double>>();//on instancie la liste de liste df_train
			ArrayList<ArrayList<Double>> df_test = new ArrayList<ArrayList<Double>>();//on instancie la liste de liste df_test
			train_test_split(dataDouble, df_train, df_test);//on sépare le train et le test set
			
			
			ArrayList<Double> moyenneArray = new ArrayList<Double>();
			calculMoyenne(df_train, moyenneArray);//calcul des moyennes de chaque colonne du train set
			
			ArrayList<Double> ecartTypeArray = new ArrayList<Double>();
			calculEcartType(df_train, moyenneArray, ecartTypeArray);//calcul des ecarts types de chaque colonne du train set
			
			ArrayList<Double> standardiserArray = new ArrayList<Double>();
			standardiser(df_train, moyenneArray, ecartTypeArray);//standardiser df_train avec la moyenne/ecart type du train set
			standardiser(df_test, moyenneArray, ecartTypeArray);//standardiser df_test avec la moyenne/ecart type du train set, important
			
			afficherDouble(df_train, head);//on affiche le train et le test set standardisés
			afficherDouble(df_test, head);
			
			
			ArrayList<ArrayList<Integer>> finalIndexArray = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> indexArray = new ArrayList<Integer>();
			ArrayList<Double> distanceEuclidienneArray = new ArrayList<Double>();
			for (int i = 0; i < df_test.size(); i++) {
				calculDistanceEuclidienne(df_train, df_test.get(i), distanceEuclidienneArray);//calcul distance euclidienne entre la ligne rentrée et le train set
				minimums(distanceEuclidienneArray, indexArray);
				finalIndexArray.add(i, (ArrayList<Integer>) indexArray.clone());
			}
			
			prediction(finalIndexArray, df_train, df_test);
			
	}
	
	

	public static void eliminer(ArrayList<ArrayList<String>> data, ArrayList<String> head) {
		for (int i = 0; i < data.size(); i++) {//supprimer colonne inutile (date et numéro : indice 0 et 1)
			data.get(i).remove(0);
			data.get(i).remove(0);//ici l'indice est encore 0 car la liste a supprimé son ancien premier élément Numéro. On supprime donc son nouveau premier indice qui est date.
		}
		head.remove(0);
		head.remove(0);
	}
	
	public static void afficher(ArrayList<ArrayList<String>> data, ArrayList<String> head) {
		for (String i : head) {//on affiche les titres
			System.out.printf("%-15s", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < data.size(); i++) {// afficher le tableau de données
			for (int j = 0; j < data.get(i).size(); j++) {
				System.out.printf("%-15s", data.get(i).get(j));
			}
			System.out.println();
		}
		System.out.println("\n\n");//sauter ligne
	}
	
	public static void afficherDouble(ArrayList<ArrayList<Double>> data, ArrayList<String> head) {
		System.out.println();
		for (String i : head) {//on affiche les titres
			System.out.printf("%-23s", i);
		}
		
		System.out.println();
		
		for (int i = 0; i < data.size(); i++) {// afficher le tableau de données
			for (int j = 0; j < data.get(i).size(); j++) {
				System.out.printf("%-23s", data.get(i).get(j));
			}
			System.out.println();
		}
		System.out.println("\n\n");//sauter ligne
	}
	
	public static void encoder(ArrayList<ArrayList<String>> data, ArrayList<String> head) {
		for (int i = 0; i < data.size(); i++) {//nous encodons nos valeur : si no alors on remplace par 0, si yes on remplace par 1.
			if(data.get(i).get(5).equals("no"))
				data.get(i).set(5,"0");
			else
				data.get(i).set(5,"1");
		}
		for (int i = 0; i < data.size(); i++) {//nous encodons nos valeur : si no alors on remplace par 0, si yes on remplace par 1.
			if(data.get(i).get(7).equals("no"))
				data.get(i).set(7,"0");
			else
				data.get(i).set(7,"1");
		}
		for (int i = 0; i < data.size(); i++) {//nous encodons nos valeur : si high alors on remplace par 0, si low on remplace par 1, sinon par 2.
			if(data.get(i).get(6).equals("high"))
				data.get(i).set(6,"2");
			else if(data.get(i).get(6).equals("low"))
				data.get(i).set(6,"0");
			else
				data.get(i).set(6,"1");
		}
	}
	
	public static void ArraylistShuffle(ArrayList<ArrayList<String>> data, ArrayList<String> head) {
  
        System.out.println("Avant le shuffling de l'Arraylist:");
  
        Iterator itr = data.iterator();//on prend l'itérateur
  
        afficher(data, head);
  
        System.out.println("");
  
        Random r1 = new Random();
  
        for (int i = data.size() - 1; i >= 1; i--) {
            // On échange, du dernier element et en décrémentant, avec un index prit au hasard chaque liste de data
            Collections.swap(data, i, r1.nextInt(i + 1));
        }
  
        System.out.println("Après le shuffling de l'Arraylist:");
  
        itr = data.iterator();
  
        afficher(data, head);
    }
	
	public static void train_test_split(ArrayList<ArrayList<Double>> dataDouble, ArrayList<ArrayList<Double>> df_train, ArrayList<ArrayList<Double>> df_test) {
		

		
		int nbrTrain = (int) (0.8*dataDouble.size());
		
		for (int i = 0; i < nbrTrain; i++)
			df_train.add(dataDouble.get(i));
		for (int i = nbrTrain+1; i < dataDouble.size(); i++)
			df_test.add(dataDouble.get(i));
		
		System.out.println("taille de notre train set : " + df_train.size());
		System.out.println("taille de notre test set : " + df_test.size());
	}
	
	public static void toDouble(ArrayList<ArrayList<String>> data, ArrayList<ArrayList<Double>> dataDouble, ArrayList<Double> initArray) {
		for (int i = 0; i < data.get(i).size(); i++) {
			initArray.add(i,0.0);
		}
		
		for (int i = 0; i < data.size(); i++) {
			dataDouble.add(i, (ArrayList<Double>) initArray.clone());
			
		}
		
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < data.get(j).size(); j++) {
				dataDouble.get(i).set(j, Double.parseDouble((data.get(i).get(j))));
			}
		}
	}
	
	public static void calculMoyenne(ArrayList<ArrayList<Double>> df, ArrayList<Double> moyenneArray) {
		double accMoy = 0;
	
		for (int i = 0; i < df.get(i).size(); i++) {
			for (int j = 0; j < df.size(); j++) {
				accMoy += df.get(j).get(i);
			}
			
			moyenneArray.add(accMoy/df.size());
			accMoy = 0;
		}
		System.out.print("Voici les moyennes de notre train set: [");
		for (int i = 0; i < moyenneArray.size(); i++) {
			System.out.print(moyenneArray.get(i)+ " ,");
		}
		System.out.println("]");
	}
	
	public static void calculEcartType(ArrayList<ArrayList<Double>> df, ArrayList<Double> moyenneArray, ArrayList<Double> ecartTypeArray) {
		
		double ecartType = 0.0;
		
		for (int j = 0; j < df.get(j).size(); j++) {		
			for (int i = 0; i < df.size(); i++) {
	            ecartType += Math.pow(df.get(i).get(j) - moyenneArray.get(j), 2);
	        }
			ecartType = Math.sqrt(ecartType/df.size());
			ecartTypeArray.add(ecartType);
			ecartType = 0;
		}

		System.out.print("\nVoici les ecarts types de notre train set: [");
		for (int i = 0; i < ecartTypeArray.size(); i++) {
			System.out.print(ecartTypeArray.get(i)+ " ,");
		}
		System.out.println("]");
	}
	
	public static void standardiser(ArrayList<ArrayList<Double>> df, ArrayList<Double> moyenneArray, ArrayList<Double> ecartTypeArray) {
		
		for (int j = 0; j < df.get(j).size()-1; j++) {//tout normaliser sauf la colonne victoire
			for (int i = 0; i < df.size(); i++) {
				df.get(i).set(j, (df.get(i).get(j) - moyenneArray.get(j))/ecartTypeArray.get(j));
			}
		}
	}
	
	private static void calculDistanceEuclidienne(ArrayList<ArrayList<Double>> df, ArrayList<Double> aPredire, ArrayList<Double> distanceEuclidienneArray) {
		double distanceEuclidienne = 0;
		distanceEuclidienneArray.clear();
		
		for (int i = 0; i < df.size(); i++) {
			for (int j = 0; j < df.get(j).size()-1; j++) {//calcul des distances euclidiennes, sauf pour Victoire
				distanceEuclidienne += Math.pow(df.get(i).get(j) - aPredire.get(j), 2);
			}
			distanceEuclidienne = Math.sqrt(distanceEuclidienne);
			distanceEuclidienneArray.add(distanceEuclidienne);
			distanceEuclidienne = 0;
		}
		
		System.out.print("\nLes distances euclidiennes : [");
		for (int j = 0; j < df.size()-1; j++) {
			System.out.print(distanceEuclidienneArray.get(j) + ",");
		}
		System.out.println("]"  );
			System.out.print("avec :");
	}
		
	private static void minimums(ArrayList<Double> distanceEuclidienneArray, ArrayList<Integer> indexArray) {
		ArrayList<Double> distanceEuclidienneArrayClone = new ArrayList<Double>();
		indexArray.clear();
		
		distanceEuclidienneArrayClone = (ArrayList<Double>) distanceEuclidienneArray.clone();
		Collections.sort(distanceEuclidienneArrayClone);
		
		System.out.println();
		for (int i = 0; i < 3; i++) {
			
			indexArray.add(distanceEuclidienneArray.indexOf(distanceEuclidienneArrayClone.get(i)));//on ajoute au tableau intermediaire les 3 index des minimums de la distance euclidienne
			System.out.println("Le "+ (i+1) +" minimum est : " + distanceEuclidienneArrayClone.get(i) + " à l'index " + indexArray.get(i));
			
		}
	}

	private static void prediction(ArrayList<ArrayList<Integer>> finalIndexArray, ArrayList<ArrayList<Double>> df_train, ArrayList<ArrayList<Double>> df_test) {
		int acc = 0;
		double nbrBonnePred = 0;
		
		System.out.println("\n\nVoici maintenant les prédictions et vrais résultats de mon test set :\n");
		for (int i = 0; i < df_test.size(); i++) {
			System.out.print("Prédictions : [");
			for (int j = 0; j < finalIndexArray.get(j).size(); j++) {
				System.out.print(df_train.get(finalIndexArray.get(i).get(j)).get(7)+",");
				acc += df_train.get(finalIndexArray.get(i).get(j)).get(7);
			}
			System.out.println("] avec le vrai résultat : " + df_test.get(i).get(7));
			if (acc > 1) {
				System.out.println("--> Prédiction : Victoire");
				
			}else {
				System.out.println("--> Prédiction : Défaite");
			}
			
			if (df_test.get(i).get(7) == 0) {
				System.out.println("--> Vrai résultat : Défaite\n");
			}else {
				System.out.println("--> Vrai résultat : Victoire\n");
			}
			
			if ((acc > 1 && df_test.get(i).get(7) == 1) || (acc < 2 && df_test.get(i).get(7) == 0)) {
				nbrBonnePred += 1;
			}
			acc = 0;
		}
		
		double pourcentageBonnePred = (nbrBonnePred/df_test.size())*100;
		System.out.println("\nEn fin de compte, nous avons " + nbrBonnePred + " de bonne prédictions pour " + df_test.size() + " entrées dans le test set,");
		System.out.println("d'où un taux de précision de "+ pourcentageBonnePred + " pourcents !");
		
		System.out.println("\nPour conclure, nous pouvons voir que la fiabilité du modèle varie entre 40 et 90 pourcents.");
		System.out.println("Cela s'explique par le très petit nombre de données disponible, le mélange des données (donc un test set différent à chaque fois) et le manque de d'optimisation du modèle (faire varier les paramètres, problème d'overfitting ...).");
		
	
	}
	
	
}

