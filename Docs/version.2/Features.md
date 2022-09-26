# Features

## Ce qu'on va ajouter/modifier dans la version 2 :

- Déplacement de la reine et construction des bâtiments :
  
  La reine se déplacera désormais dans sa moitié de terrain. Elle commencera par déterminer le nombre de bâtiments dans sa moitié de terrain, puis construira des tours avec les bâtiments se trouvant au milieu du terrain et des batiments avec des unités de guerriers (KNIGHTS) dans les bâtiments se trouvant à l'extrémité du terrain. 

- Si tous les bâtiments ont été construit, la reine attendra dans sa position initiale. Si un des bâtiments a été détruit, elle se déplacera pour le reconstruire.

## Méthodes & attributs :

- moveHalf :
  
  Méthode pour déplacer la reine vers le bâtiment à construire.

- listOfTowersOrdered :
  
  Liste des sites sur notre moitié de terrain ordonné par le site le plus proche et qui seront construits en tours.

- listOfBarracksOrdered :
  
  Liste des sites sur notre moitié de terrain ordonné par le site le plus proche et qui seront construits en casernes de guerriers. 

- barrackOrTower :
  
  Méthode pour déterminer si un des sites sur notre moitité de terrain sera construit en une tour ou en caserne de guerriers.
  
  


