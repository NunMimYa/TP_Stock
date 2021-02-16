package com.m2iformation.TPStock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
	static ArrayList<Article> listeArticle = new ArrayList<>(Arrays.asList(
			new Article(1, "Phone", 80,50),		
			new Article(2, "Computer", 500,100),			
			new Article(3, "Tablet", 120,200),			
			new Article(4, "Screen", 70,100)			
			));	

	public static void main(String[] args) {	
		int x=0;
		int r=0;
		int refe=0;
		String name=null;
		int price=0;
		int quantity=0;
		int cont=0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("SEARCH ARTICLE BY REFERENCE [0]");
			System.out.println("ADD ARTICLE [1]");
			System.out.println("DELETE ARTICLE BY REFERENCE [2]");
			System.out.println("MODIFY ARTICLE BY REFERENCE [3]");
			System.out.println("SEARCH ARTICLE BY NAME [4]");
			System.out.println("SEARCH ARTICLE BY PRICE'S RANGE [5]");
			System.out.println("SHOW ALL ARTICLES [6]");
			System.out.println("QUIT [7]");
			System.out.println("====================================");
			x = sc.nextInt();

			switch(x) {
			case 0:
				System.out.println("		YOU CHOOSE [0]");
				System.out.println("ENTER A REFERENCE:");
				r = sc.nextInt();

				for (Article art: listeArticle) {
					if (r == art.getReference()) {
						System.out.println("FIND: " + art.getName() + " | " + art.getReference() + " | " + art.getPrice() + " | " +art.getQuantity()+"\n");
					}
				}
				cont = 1;
				break;
			case 1:
				System.out.println("		YOU CHOOSE [1]");
				System.out.println("ADD AN ARTICLE:");
				System.out.println("	ENTER A REFERENCE:");
				refe = sc.nextInt();
				System.out.println("	ENTER A NAME:");
				name = sc.next();
				System.out.println("	ENTER A PRICE:");
				price = sc.nextInt();
				System.out.println("	ENTER A QUANTITY:");
				quantity = sc.nextInt();
				System.out.println("ADD ARTICLE: " + name + " | " +  refe + " | " + price + " | " + quantity);
				Article newArticle = new Article(refe,name, price, quantity) ;
				listeArticle.add(newArticle);
				for (Article art: listeArticle) {
					//				System.out.println("NOW IN STOCK:" + art.);
					System.out.println(art);				
				}
				cont = 1;
				break;
			case 2:
				System.out.println("		YOU CHOOSE [2]");
				System.out.println("DELETE AN ARTICLE:");
				System.out.println("	ENTER A REFERENCE:");
				refe = sc.nextInt();
				Article article = null;	
				for (Article art: listeArticle) {
					if (refe == art.getReference()) {
						System.out.println("FIND: " + art.getName() + " | " + art.getReference() + " | " +art.getPrice() + " | " +art.getQuantity());
						System.out.println("DELETE: " + art.getName() + " | " + art.getReference() + " | " +art.getPrice() + " | " +art.getQuantity() + " [Y/n]");
						sc.nextLine(); // récupérer une phrase complète en chaine de cara.
						String answer = sc.nextLine();
						//						System.out.println(answer + "...");
						//						if (answer.equals("\n") || answer.toLowerCase().equals("y")) {
						if (answer.toLowerCase().equals("y")) {
//							System.out.println("ok");
							//							art.delete();
							article = art;
						}
					}
				}
				if (article != null) {
					listeArticle.remove(article);
					System.out.println("ARTICLE REMOVED");
				}							
				cont = 1;
				break;
			case 3:
				System.out.println("		YOU CHOOSE [3]");
				System.out.println("MODIFY ARTICLE BY REFERENCE");
				System.out.println("	ENTER A REFERENCE:");
				refe = sc.nextInt();
				for (Article art: listeArticle) {
					if (refe == art.getReference()) {
						System.out.println("FIND: " + art.getName() + " | " + art.getReference() + " | " +art.getPrice() + " | " +art.getQuantity());
						System.out.println("MODIFY: " + art.getName() + " | " + art.getReference() + " | " +art.getPrice() + " | " +art.getQuantity() + " [Y/n]");
						String answer = sc.next();
						if (answer.equals("") || answer.toLowerCase().equals("y")) {
							System.out.println("MODIFY NAME");
							name = sc.next();
							System.out.println("MODIFY PRICE");
							price = sc.nextInt();
							System.out.println("MODIFY QUANTITY");
							quantity = sc.nextInt();
							art.modifier(name, price, quantity);
							System.out.println("NOW: "+ art.getName() + " | " + art.getReference() + " | " +art.getPrice() + " | " +art.getQuantity());
						}else {
							continue;
						}
					}
				}
				cont = 1;
				break;
			case 4:
				System.out.println("		YOU CHOOSE [4]");
				System.out.println("SEARCH ARTICLE BY NAME");
				System.out.println(" ENTER A NAME:");
				name = sc.next();
				for (Article art: listeArticle) {
					if (name.equals(art.getName())) {
						System.out.println("FIND: " + art.getName() + " | " + art.getReference() + " | " + art.getPrice() + " | " +art.getQuantity());
					}
				}
				cont = 1;
				break;	
			case 5:
				System.out.println("		YOU CHOOSE [5]");
				System.out.println("SEARCH ARTICLE BY PRICE'S RANGE");
				System.out.println("ENTER A MIN:");
				int min = sc.nextInt();
				System.out.println("ENTER A MAX:");
				float max = sc.nextInt();
				int size=0;
				for (Article art: listeArticle) {
					if (min <= art.getPrice() && art.getPrice() <= max) {						
						size++;
						System.out.println("#"+size+"	" + art.getName() + " | " + art.getReference() + " | " + art.getPrice() + " | " +art.getQuantity());
					}
				}
				System.out.println("\n" + size + " ARTICLES FOUND");
				cont = 1;
				break;
			case 6:
				System.out.println("		YOU CHOOSE [6]");
				System.out.println("\nSHOW ALL ARTICLES"+ " | " + listeArticle.size() +"\n");
				for (Article art: listeArticle) {
					//					System.out.println(" ALL ARTICLES();
					System.out.println(art);				
				}
				cont = 1;
				break;
			case 7:
				System.out.println("		YOU CHOOSE [7]");
				System.out.println("QUIT");
				//				System.out.println("ARE YOUSURE TO WANT TO QUIT ? [Y/n]");
				cont=0;
				break;
			default:
				System.out.println("\nNOT A CORRECT CHOICE. TRY AGAIN\n");
				cont = 1;
				continue;
			}
			if (cont == 1) {
				System.out.println("\nOTHER OPERATION ? Y -> [1]/N -> [0]");
				cont = sc.nextInt();
			}
		}while (cont == 1 );
		System.out.println("\n		THANKS YOU ! HAVE A NICE DAY !");	
	}
}