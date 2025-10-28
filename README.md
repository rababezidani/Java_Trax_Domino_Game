Parfait 🌸 voici le **texte complet et prêt à coller directement** dans ton README GitHub — sans code ni lignes de commande, juste le contenu clair et professionnel 👇

---

# 🎮 Projet Java — Jeux de Tuiles : Domino & Trax

Ce projet a été réalisé dans le cadre du module **Programmation 2 (Java)** à l’École d’Ingénieurs Denis Diderot – **Université Paris Cité**.
Il avait pour objectif de concevoir deux jeux de tuiles proches dans leur logique : un **Jeu de Domino numérique** et un **Trax Game**, afin de mettre en pratique la **programmation orientée objet** et la conception d’interfaces graphiques en **Java Swing**.

---

## 🎯 Objectifs du projet

L’objectif principal est de créer deux jeux différents reposant sur une base commune et réutilisable, démontrant la maîtrise des principes de **factorisation du code**, **héritage** et **architecture MVC (Modèle-Vue-Contrôleur)**.

Le projet visait à :

* Développer la **logique métier** des jeux (modèle).
* Créer une **interface graphique interactive** avec Swing.
* Gérer les **événements utilisateurs** (clics, rotations, sélections).
* Définir les **règles de compatibilité** entre tuiles et les conditions de victoire.
* Réutiliser la structure du premier jeu (Domino) pour construire le second (Trax).

---

## 🧱 Structure du projet

* **src/** : contient les classes Java principales (`Tuile.java`, `Plateau.java`, `TuileInterface.java`, `Main.java`).
* **images/** : contient les images des tuiles (recto et verso).
* **Projet_programmation.pdf** : rapport détaillant la conception et les fonctionnalités.
* **README.md** : fichier de présentation du projet.

---

## 🧩 Jeu 1 — Domino numérique

Le premier jeu reprend le principe du **domino**, adapté à des tuiles carrées comportant trois chiffres par côté.
Les règles de compatibilité définissent si deux tuiles peuvent être placées côte à côte selon la correspondance des chiffres.

* Le jeu peut être joué en **mode texte (console)**.
* Le joueur pioche une tuile, la fait pivoter, puis tente de la placer sur le plateau.
* Les points sont attribués selon la **somme des chiffres adjacents compatibles**.
* Une interface simple permet la **rotation des tuiles** et la vérification de compatibilité.

---

## 🌀 Jeu 2 — Trax Game

Le second jeu, **Trax**, met en scène deux joueurs (rouge et blanc) plaçant des tuiles imprimées **recto-verso** sur un plateau 8x8.

* Chaque face de tuile contient des **lignes de trajectoire** rouges ou blanches.
* Les joueurs alternent pour **placer et faire pivoter** les tuiles.
* Une victoire est déclarée lorsqu’un joueur :

  * forme une **boucle fermée** complète,
  * ou relie **deux bords opposés** du plateau.

L’interface graphique réalisée avec **Swing** permet :

* la **pioche aléatoire** de tuiles,
* la **rotation** des images,
* le **placement par clic** sur le plateau,
* et un **rafraîchissement automatique** de la vue.

---

## 🧠 Architecture MVC

### Modèle (Model)

Contient la logique du jeu :

* structures de données,
* règles de compatibilité,
* conditions de victoire.

### Vue (View)

Composée d’éléments Swing :

* `JFrame`, `JPanel`, `JButton`,
* dessins des tuiles avec `Graphics2D`,
* affichage dynamique du plateau.

### Contrôleur (Controller)

Gère la communication entre la vue et le modèle :

* interprète les actions (clics, rotations, pioches),
* met à jour le plateau et l’interface en conséquence.

---

## ⚙️ Fonctionnalités principales

* Mode **texte** pour tester la logique du domino.
* Mode **graphique** complet pour Trax.
* **Rotation des tuiles** à 90°, 180°, 270°.
* **Pioche aléatoire** de tuiles.
* **Affichage dynamique** via Swing.
* **Détection de victoire** (boucle ou chemin complet).
* **Gestion des scores** et des tours de jeu.

---

## 💡 Fonctionnalités avancées (non obligatoires mais envisagées)

* Sauvegarde et chargement de parties (sérialisation Java).
* IA basique pour un joueur automatisé.
* Interface graphique également pour le domino.
* Détection automatique des “coups forcés” du jeu Trax.

---

## 🧰 Technologies utilisées

* **Java (JDK 17+)** — Langage principal du projet.
* **Swing / AWT** — Interface graphique.
* **Java Collections Framework** — Gestion du plateau et des tuiles.
* **Serializable** — Sauvegarde des objets.
* **GitHub** — Versionnement et hébergement du code.
---

## 🏁 Conclusion

Ce projet a permis d’approfondir la **programmation orientée objet** en Java et la **conception d’interfaces graphiques interactives**.
La structure modulaire et réutilisable entre les deux jeux illustre l’importance de la **factorisation du code** et du respect du modèle **MVC**.


---

## ⭐️ *Projet réalisé dans le cadre du module “Programmation 2” — 2A Systèmes Informatiques Embarqués, Université Paris Cité (EIDD).*

