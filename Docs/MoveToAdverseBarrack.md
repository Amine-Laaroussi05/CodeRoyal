# MoveToAdverseBarrack

### Description de la méthode :

La reine se déplace vers les bâtiments adverses. Pour cela, on enregistre dans une liste les `siteId` qui ont pour `owner` = 1.

Quand un bâtiment est détruit par la reine, on remet le `owner` en 0.

> Dans le coding game, c'est remis selon les explications données en bas, à savoir, à chacun des tours, le owner est mis à jour.

S'il n'y pas de bâtiment adverse, on utilisera la méthode `Move()`.

Cette liste enregistrera en plus tous les identifiants des bâtiments suivis de leur coordonnée.

S'il y a plusieurs valeurs (owner = 1), alors la reine se déplace vers le bâtiment le plus proche.

### Méthode intermédiaire I :

Une méthode `generateSiteId` permettra de générer une liste d'identifiants avec leur coordonnée x et y et le owner de ce site.

> En ce qui concerne le coding game, cette liste sera obtenu en stockant le siteId, la coordonnée x,y et le owner (qui sera mis à jour après chaque tour dans sa ligne correspondante).

### Méthode intermédiaire II :

Une méthode `calculateMinimumDistance()` pour calculer le point le plus proche en prenant compte la position actuelle de la reine et la liste des points disponibles.

### Syntaxe de la méthode :

- Méthode principale :

```java
public void moveToAdverseBarrack(){
    // met à jour les coordonnées x et y de la reine
}
```

- Méthode intermédiaire I :

```java
public void generateSiteId(int numberOfOnes){
    // génère une liste de liste d'entiers
}
```

- Méthode intermédiaire II :

```java
public int calculateMinimumDistance(int coord_x, int coord_y,
List<Batiment> batimentList){
    // le point minimal parmi la liste de points saisie
}
```

### Données :

- `coord_x`

- `coord_y`

- `numberOfOnes` : le nombre d'identfiants qui auront pour valeur 1.

- `listOfBarracks` : une liste de listes où chacune contiendra le `siteId`, les coordonnées `coord_x` et `coord_y`, et le `owner`.

### Tests de la méthode intermédiaire I :

```java
random(siteID)
random(coord_x)
random(coord_y)
random(owner) // valeur compris entre -1,0 et 1
numberOfOnes = 1;

-> la liste ne doit contenir qu'un seul owner 1.
```

```java
random(siteID)
random(coord_x)
random(coord_y)
random(owner) // valeur compris entre -1,0 et 1
numberOfOnes = 2;

-> la liste doit contenir 2 owner 1.
```

```java
random(siteID)
random(coord_x)
random(coord_y)
random(owner) // valeur compris entre -1,0 et 1
numberOfOnes = 12;

-> la liste doit contenir 12 owner 1.
```

```java
random(siteID)
random(coord_x)
random(coord_y)
random(owner) // valeur compris entre -1,0 et 1
numberOfOnes = 0;

-> la liste doit contenir 0 owner 1.
```

```java
random(siteID)
random(coord_x)
random(coord_y)
random(owner) // valeur compris entre -1,0 et 1
numberOfOnes = -1;

-> Exception;
```

```

```

### Tests de la méthode principale :

- One value

```java
siteId = 1;
coord_x = 300;
coord_y = 300;
owner = 1

-> coord_x = 300 & coord_y = 300;
```

- Zero Value

```java
reine.coord_x = 300;
reine.coord_y = 800;

siteId = 5;
coord_x = 400;
coord_y = 300;
owner = 0

-> coord_x = 300 & coord_y = 800
```

- Two values

```java
siteId = 4;
coord_x = 1500;
coord_y = 600;
owner = 1
// 1216

siteId = 8;
coord_x = 300;
coord_y = 900;
owner = 1
// 100

-> coord_x = 300  & coord_y = 900
```

- First value from two values

```java
siteId = 46;
coord_x = 1200;
coord_y = 400;
owner = 1

siteId = 2;
coord_x = 400;
coord_y = 400;
owner = 0

-> coord_x = 1200 & coord_y = 400;
```

- Second value from two values

```java
siteId = 6;
coord_x = 200;
coord_y = 500;
owner = 0

siteId = 56;
coord_x = 600;
coord_y = 900;
owner = 1

-> coord_x = 600 & coord_y = 900;
```

- One value from multiple values

```java
siteId = 1;
coord_x = 200;
coord_y = 300;
owner = 0

siteId = 4;
coord_x = 500;
coord_y = 600;
owner = 0

siteId = 7;
coord_x = 800;
coord_y = 900;
owner = 0

siteId = 10;
coord_x = 1100;
coord_y = 100;
owner = 0

siteId = 13;
coord_x = 1400;
coord_y = 200;
owner = 1

siteId = 17;
coord_x = 1300;
coord_y = 900;
owner = 0

siteId = 88;
coord_x = 800;
coord_y = 800;
owner = 0

siteId = 77;
coord_x = 1100;
coord_y = 900;
owner = 0

siteId = 66;
coord_x = 200;
coord_y = 700;
owner = 0

siteId = 5;
coord_x = 500;
coord_y = 500;
owner = 0

-> coord_x = 1400 & coord_y = 200;
```

- Lot of values from multiple values :

```java
reine.coord_x = 900;
reine.coord_y = 900;


siteId = 1;
coord_x = 200;
coord_y = 300;
owner = 0

siteId = 4;
coord_x = 500;
coord_y = 600;
owner = 0

siteId = 7;
coord_x = 800;
coord_y = 900;
owner = 0

siteId = 10;
coord_x = 1100;
coord_y = 100;
owner = 1
// 824

siteId = 13;
coord_x = 1400;
coord_y = 200;
owner = 1
// 860

siteId = 17;
coord_x = 1300;
coord_y = 900;
owner = 1
// 400

siteId = 88;
coord_x = 800;
coord_y = 800;
owner = 0

siteId = 77;
coord_x = 1100;
coord_y = 900;
owner = 0

siteId = 66;
coord_x = 200;
coord_y = 700;
owner = 1
// 728

siteId = 5;
coord_x = 500;
coord_y = 500;
owner = 0

-> coord_x = 1300 & coord_y = 900;
```

### Tests de la méthode intermédiaire II :

- One value different and higher:

```java
reine.coord_x = 200;
reine.coord_y = 200;


coord_x = 300;
coord_y = 300;

-> [300,300];
```

- One value same :

```java
reine.coord_x = 500;
reine.coord_y = 700;


coord_x = 500;
coord_y = 700;

-> [500,700];
```

- One value different and lower :

```java
reine.coord_x = 600;
reine.coord_y = 700;


coord_x = 400;
coord_y = 200;

-> [400,200];
```

- Two values different and higher :

```java
reine.coord_x = 500;
reine.coord_y = 200;


coord_x = 500;
coord_y = 600;

coord_x = 900;
coord_y = 300;

-> [500,600];
```

- Two values different and lower : 

```java
reine.coord_x = 1200;
reine.coord_y = 600;


coord_x = 900;
coord_y = 600;

coord_x = 400;
coord_y = 900;

-> [900,600];
```

- Two values with one same :

```java
reine.coord_x = 1800;
reine.coord_y = 900;


coord_x = 300;
coord_y = 100;

coord_x = 1800;
coord_y = 900;

-> [1800,900];
```

- Three values :

```java
reine.coord_x = 800;
reine.coord_y = 400;


coord_x = 400;
coord_y = 700;
// 500

coord_x = 1300;
coord_y = 800;
// 640

coord_x = 500;
coord_y = 700;
// 424

-> [500,700];
```

- Four values and two with same distance :

```java
reine.coord_x = 1200;
reine.coord_y = 600;

coord_x = 300;
coord_y = 100;
// 1029

coord_x = 900;
coord_y = 600;
// 300

coord_x = 1200;
coord_y = 200;
// 400

coord_x = 1200;
coord_y = 300;
// 300

-> [900,600];
```

- Multiple values:

```java
reine.coord_x = 100;
reine.coord_y = 200;


coord_x = 1900;
coord_y = 800;
// 1897

coord_x = 800;
coord_y = 500;
// 761

coord_x = 1800;
coord_y = 300;
// 1702

coord_x = 1400;
coord_y = 500;
// 1334

coord_x = 400;
coord_y = 900;
// 761

coord_x = 800;
coord_y = 100;
// 707

coord_x = 900;
coord_y = 600;
// 894

coord_x = 1700;
coord_y = 100;
// 1603

coord_x = 1400;
coord_y = 100;
// 1303

coord_x = 1200;
coord_y = 200;
// 1100

-> [800,100];
```

- Wrong coordinate : 

```java
reine.coord_x = 900;
reine.coord_y = 100;

coord_x = 2000;
coord_y = 600;

-> Exception;
```

```java
reine.coord_x = 800;
reine.coord_y = 400;


coord_x = 400;
coord_y = 700;
// 500

coord_x = 1300;
coord_y = 1800;
// 640

coord_x = 500;
coord_y = 700;
// 424

-> Exception;
```
