Du code top-moumoute pour [CodeStory 2013](http://code-story.net/2013/01/04/concours-2013.html)

Quel est le but
==================

Dans CodeStory 2013, vous exposez un serveur, et un robot vient de chez Amazon pour
l'interroger, inlassablement, jusqu'à obtenir satisfaction. Ce code est le résultat
à l'issu des interrogations formant le premier tour.

Comment rentrer dedans
===================

C'est assez, étant une bête application Web au sens de Servlet 2.5, il suffit d'aller voir 
le web.xml dans WebContent/WEB-INF et vous aurez à la fois l'initialisation et les points 
d'entrée statiques. Pas encore satisfaits ? Plutôt que de céder au fléau YAML, [fournisseur
de trous de sécurités depuis 2004] (http://www.kalzumeus.com/2013/01/31/what-the-rails-security-issue-means-for-your-startup/), 
ou *pire*, de code envoyé en clair (JSON), le routage des requêtes est assuré par Drools.
Drools oui. Drools. Comme... Drools quoi. Toutes les règles de routage sont dans 
src/nk/chemin/routes.drl . Et après ? Si ça ne vous suffit pas comme points d'entrée, il est
temps de vous éloigner de JavaEE :-)

Comment le construire
===================

ant

Comment visualiser le travail sur le graphe
===================

Installer [Graphviz](http://graphviz.org/), et utiliser gvedit, c'est ce qu'il y a de plus rapide ; 
nk.enonces.jajascript.DarkPlannerTest::produitDot() est votre ami.

Comment tester en local le serveur à la main
====================

  curl -i --data-urlencode @donnees_test.fic http://ma/cible


Comment
====================

Oui mais pourquoi ?


