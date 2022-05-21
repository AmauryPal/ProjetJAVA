import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

class node {
	public int x, y;
	
	node() {
	}

	node(int a, int b) {
		x = a;
		y = b;
	}
	
	void set(int a, int b) {
		x = a;
		y = b;
	}
}
	
public class Game4J extends Application {
	public int size = 15; // Taille carte utilisée par algo Prim;
	public static final int range = 30; // Longueur côté cellule;
	public int vsize = (size * 2 + 1) * range; // Taille réelle;
	public int maze[][] = new int[vsize][vsize]; // Accès carte;
	public int vis[][] = new int[vsize][vsize]; // Chemin passé;
	public node f[][] = new node[vsize][vsize];
	public int[][] dir = { { -range, 0 }, { range, 0 }, { 0, -range }, { 0, range } }; // Déplacer côté;
	public CreateMap c = new CreateMap(size, size);
	Rectangle rec = new Rectangle(range, range, range, range);
	private int recX = 30, recY = 30;
	private boolean autoPath = false; // Activer ou non la solution automatique;
	
	public void start(Stage stage) throws Exception {
		
		CreateMap();
		Pane pane = Init(); // Générer la plateforme labyrinthe;
		Scene scene = new Scene(pane, vsize, vsize);
		
		scene.setOnKeyPressed(k -> {
			KeyCode code = k.getCode();
			int tx = recX, ty = recY;
			if (code.equals(KeyCode.LEFT) && autoPath == false) { // Touche Gauche;
				tx -= range;
			} else if (code.equals(KeyCode.RIGHT) && autoPath == false) { // Touche Droite;
				tx += range;
			} else if (code.equals(KeyCode.UP) && autoPath == false) { // Touche Haut;
				ty -= range;
			} else if (code.equals(KeyCode.DOWN) && autoPath == false) { // Touche Bas;
				ty += range;
			} else if (code.equals(KeyCode.SPACE)) { // Touche Espace;
				if (autoPath == false) {
					autoPath = true;
					node e =new node();
					e.set(recX,  recY);
					autoMove(e);
				}
			}
			if (inside(tx, ty) && maze[tx][ty] == 1 && autoPath == false) {
				// sysout(recX + " " + recY + " " + tx + " " + ty);
				move(tx, ty);
				recX = tx;
				recY = ty;
			} else if (recX == vsize - range * 2 && recY == vsize - range * 2 ) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.titleProperty().set("Information");
				alert.headerTextProperty().set("Vous avez gagné !");
				alert.showAndWait();
				try {
					start(stage);
				} catch (Exception e) {
					// Bloc généré automatiquement;
					e.printStackTrace();
				}
				move(range, range);
				recX = range;
				recY = range;
			}			
		});
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setTitle("Game4J");
		stage.show();
	}
	
	public void move(int tx, int ty) {
		SequentialTransition link = new SequentialTransition(); // Liste des animations;
		link.setNode(rec);
		TranslateTransition tt = new TranslateTransition();
		
		tt.setFromX(recX - 30);
		tt.setToX(tx - 30);
		tt.setFromY(recY - 30);
		tt.setToY(ty - 30);
		
		// sysout(recX + " " + recY + " " + tx + " " + ty);
		link.getChildren().add(tt);
		link.play();
	}
	
	public void CreateMap() {
		c.Init(); // Générer Map;
		for (int i = 0; i < vsize; i += range) {
			for (int j = 0; j < vsize; j += range) {
				maze[i][j] = c.map[i / range][ j / range];
			}
		} // Map du Labyrinthe;
	}
	
	public Pane Init() {
		
		Pane pane = new Pane();
		for (int i = 0; i < vsize; i += range) {
			for (int j = 0; j < vsize; j += range) {
				Rectangle r = new Rectangle(i, j, range, range);
				if (maze[i][j] == 0) {
					r.setFill(Color.PINK);
				} else if (maze[i][j] == 1) {
					r.setFill(Color.YELLOW);
				}
				if (i == vsize - range && j == vsize - range * 2) {
					r.setFill(Color.RED);
				}
				pane.getChildren().add(r);
			}
		}
		rec.setFill(Color.BLACK);
		pane.getChildren().add(rec); // Afficher le bloc cible;
		return pane;
	}

	public void autoMove(node e) {
		SequentialTransition link = new SequentialTransition(); // liste des animations
		link.setNode(rec);
		Queue<node> queue = new ArrayBlockingQueue<node>(1000);
		int flag = 0;
		System.out.println(e.x + " " + e.y);
		queue.add(e);
		vis[e.x][e.y] = 1; // a visité;
		while (flag == 0) { // parcours en largeur;
			node now = queue.remove();
			for (int i = 0; i < 4; i++) {
				int fx = now.x + dir[i][0];
				int fy = now.y + dir[i][1];
				if ((inside(fx, fy) && (vis[fx][fy] == 0) && maze[fx][fy] == 1 )) {
					vis[fx][fy] = 1;
					f[fx][fy] = new node(now.x, now.y);
					queue.add(new node(fx, fy));
				}
				if (fx == vsize - range * 2 && fy == vsize - range * 2) { // Commencer à revenir en arrière lorsqu'il n'y a plus qu'un chemin vers la fin;
					node ans[] = new node[1000];
					int cnt = 0;
					int t1, t2;
					ans[cnt] = new node(fx, fy);
					while (f[fx][fy].x != e.x || f[fx][fy].y != e.y) { // Le chemin le plus court vers le point peut etre obtenu en revenant en arriere selon les coordonées du point précédent enregistrées par le point;
						t1 = fx;
						t2 = fy;
						cnt++;
						ans[cnt] = new node(f[fx][fy].x, f[fx][fy].y);
						fx = f[t1][t2].x;
						fy = f[t1][t2].y;
					}
					
					ans[++cnt] = new node(0, 0);
					
					for (int l = cnt - 1; l > 0; l--) {
						// move(ans[l].x, ans[l].y;
						// sysout(recX + " " + recY + " " + ans[l].x + " " + ans[l].y);
						// recX = ans[l].x;
						// recY = ans[l].y;
						TranslateTransition tt = new TranslateTransition();
						tt.setFromX(ans[l].x - 30);
						tt.setToX(ans[l - 1].x - 30);
						tt.setFromY(ans[l].y - 30);
						tt.setToY(ans[l - 1].y - 30);
						link.getChildren().add(tt);
					}
					flag = 1;
					break;
				
				}
			}
		}
		link.play();
		
	}

	boolean inside(int fx, int fy) {
		return (fx >= range && fx <= vsize - range && fy >= range && fy <= vsize - range);
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}

