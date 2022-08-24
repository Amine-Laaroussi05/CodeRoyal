# MoveToAdverseBarrack_TestsIntegration

### Avec la méthode `move()`

- Quand utiliser `moveToAdverseBarrack()` au lieu de `move()`?

Méthode `kindOfMove()` :

1. Liste avec un seul owner = 1

2. Liste de trois avec deux owner = 1

3. Liste de quatre avec deux owner = 1 et même distance

4. Liste avec plusieurs owner = 1

5. Liste avec zéro owner = 1

6. Liste vide

7. Reine au même endroit que le point avec owner = 1

```java
reine.coord_x = 200;
reine.coord_y = 300;


siteId = 13;
coord_x = 1100;
coord_y = 500;
owner = 1

-> moveToAdverseBarrack()
```

```java
reine.coord_x = 200;
reine.coord_y = 300;


siteId = 10;
coord_x = 700;
coord_y = 800;
owner = 1

siteId = 1;
coord_x = 300;
coord_y = 400;
owner = 0

siteId = 2;
coord_x = 100;
coord_y = 600;
owner = 1

-> moveToAdverseBarrack()
```

```java
reine.coord_x = 200;
reine.coord_y = 300;


siteId = 62;
coord_x = 300;
coord_y = 500;
owner = 1

siteId = 51;
coord_x = 1000;
coord_y = 100;
owner = 0

siteId = 99;
coord_x = 300;
coord_y = 800;
owner = 0

siteId = 41;
coord_x = 100;
coord_y = 500;
owner = 1

-> moveToAdverseBarrack()
```

```java
reine.coord_x = 200;
reine.coord_y = 300;


siteId = 19;
coord_x = 1700;
coord_y = 500;
owner = 0

siteId = 17;
coord_x = 1500;
coord_y = 800;
owner = 1


siteId = 15;
coord_x = 1800;
coord_y = 100;
owner = 0

siteId = 10;
coord_x = 1100;
coord_y = 500;
owner = 0

siteId = 12;
coord_x = 800;
coord_y = 100;
owner = 0

siteId = 13;
coord_x = 100;
coord_y = 800;
owner = 0

siteId = 1;
coord_x = 1100;
coord_y = 300;
owner = 0

siteId = 5;
coord_x = 1300;
coord_y = 300;
owner = 1

siteId = 16;
coord_x = 700;
coord_y = 600;
owner = 0

siteId = 9;
coord_x = 500;
coord_y = 600;
owner = 1

siteId = 2;
coord_x = 400;
coord_y = 800;
owner = 0

-> moveToAdverseBarrack()
```

```java
reine.coord_x = 200;
reine.coord_y = 300;


siteId = 10;
coord_x = 200;
coord_y = 400;
owner = 0

siteId = 1;
coord_x = 900;
coord_y = 100;
owner = 0

siteId = 2;
coord_x = 1100;
coord_y = 600;
owner = 0

-> move()
```

```java
reine.coord_x = 200;
reine.coord_y = 300;

-> move()
```

```java
reine.coord_x = 700;
reine.coord_y = 500;


siteId = 10;
coord_x = 200;
coord_y = 300;
owner = 0

siteId = 1;
coord_x = 700;
coord_y = 500;
owner = 1

siteId = 2;
coord_x = 1500;
coord_y = 400;
owner = 0

-> move()
```

### Avec la méthode `build()`

- Quand utiliser `moveToAdverseBarrack()` au lieu de `build()` ou de `move()`?

Méthode `moveOrBuild()`

1. Aucun bâtiment n'est proche de la reine, avec un bâtiment ennemi existant.

2. Aucun bâtiment n'est proche de la reine, et aucun bâtiment ennemi de construit.

3. Reine en contact d'un bâtiment non construit, et aucun bâtiment ennemi de construit.

4. Reine en contact d'un bâtiment non construit, et au moins un bâtiment ennemi de construit.

5. Reine en contact d'un bâtiment allié, et aucun bâtiment ennemi de construit.

6. Reine en contact d'un bâtiment allié, et au moins un bâtiment ennemi de construit.

7. Reine en contact d'un bâtiment ennemi, et c'est le seul bâtiment ennemi construit.

8. Reine en contact d'un bâtiment ennemi, et d'autres bâtiments ennemis existants.

```java
reine.coord_x = 100
reine.coord_y = 200

siteId = 28
coord_x = 500
coord_y = 900
owner = 1

siteId = 28
coord_x = 500
coord_y = 900
owner = 1

siteId = 28
coord_x = 500
coord_y = 900
owner = 1

siteId = 28
coord_x = 500
coord_y = 900
owner = 1

siteId = 28
coord_x = 500
coord_y = 900
owner = 1

moveOrBuild()

-> build()
```

```java
reine.coord_x = 490
reine.coord_y = 880

siteId = 9
coord_x = 600;
coord_y = 300;
owner = 0

moveOrBuild()

-> kindOfMove()
```

- Le bâtiment adverse détruit a-t-il été ajouté dans la liste de nos bâtiments alliés ? A-t-il été `build()` ?

Attribut `sitesId` :

```java
reine.coord_x = 480
reine.coord_y = 910

siteId = 28
coord_x = 500
coord_y = 900
owner = 1

moveOrBuild()

-> owner = 0

siteId = 28
coord_x = 500
coord_y = 900
owner = 0
```

```java
reine.coord_x = 490
reine.coord_y = 880

siteId = 9
coord_x = 600;
coord_y = 300;
owner = 1

siteId = 56
coord_x = 500;
coord_y = 900;
owner = 1

moveOrBuild()

-> owner = 0

siteId = 56
coord_x = 500;
coord_y = 900;
owner = 0
```

```java
reine.coord_x = 490
reine.coord_y = 880

siteId = 9
coord_x = 600;
coord_y = 300;
owner = 0

siteId = 56
coord_x = 500;
coord_y = 900;
owner = 1

moveOrBuild()

-> owner = 0

siteId = 56
coord_x = 500;
coord_y = 900;
owner = 0
```

```java
reine.coord_x = 1700
reine.coord_y = 800

siteId = 92;
coord_x = 500;
coord_y = 300;
owner = 0

siteId = 77;
coord_x = 1400;
coord_y = 500;
owner = 0

siteId = 81;
coord_x = 1500;
coord_y = 100;
owner = 1

siteId = 47;
coord_x = 1000;
coord_y = 100;
owner = 0

siteId = 46;
coord_x = 100;
coord_y = 200;
owner = 0

siteId = 43;
coord_x = 1200;
coord_y = 700;
owner = 1

siteId = 61;
coord_x = 1700;
coord_y = 800;
owner = 1

siteId = 40;
coord_x = 300;
coord_y = 600;
owner = 0

siteId = 50;
coord_x = 900;
coord_y = 300;
owner = 0

siteId = 66;
coord_x = 600;
coord_y = 500;
owner = 0

moveOrBuild()

-> owner = 0

siteId = 61;
coord_x = 1700;
coord_y = 800;
owner = 0
```

- Après qu'il ait été `build()`, la reine se déplace-t-elle après ?

```java
reine.coord_x = 360
reine.coord_y = 540

siteId = 40;
coord_x = 300;
coord_y = 600;
owner = 1

moveOrBuild()

moveOrBuild()

-> kindOfMove()
```

```java
reine.coord_x = 690
reine.coord_y = 320

siteId = 32;
coord_x = 700;
coord_y = 300;
owner = 1

siteId = 27;
coord_x = 600;
coord_y = 100;
owner = 1

moveOrBuild()

moveOrBuild()

-> kindOfMove()
```

```java
reine.coord_x = 1700
reine.coord_y = 800

siteId = 92;
coord_x = 500;
coord_y = 300;
owner = 0

siteId = 77;
coord_x = 1400;
coord_y = 500;
owner = 0

siteId = 81;
coord_x = 1500;
coord_y = 100;
owner = 1

siteId = 47;
coord_x = 1000;
coord_y = 100;
owner = 0

siteId = 46;
coord_x = 100;
coord_y = 200;
owner = 0

siteId = 43;
coord_x = 1200;
coord_y = 700;
owner = 1

siteId = 61;
coord_x = 1700;
coord_y = 800;
owner = 1

siteId = 40;
coord_x = 300;
coord_y = 600;
owner = 0

siteId = 50;
coord_x = 900;
coord_y = 300;
owner = 0

siteId = 66;
coord_x = 600;
coord_y = 500;
owner = 0

moveOrBuild()

moveOrBuild()

-> kindOfMove()
```

### Avec la méthode `train()`

- Quelle prioriter donner aux bâtiments adverses qui sont devenus nôtres par rapport aux autres bâtiments qu'on a `build()`?
  
  - La méthode `train()` suivra la même configuration que celle appliquée, à savoir `5 KNIGHT` et `4 ARCHER`. 
  - La méthode `train()` n'a pas de relation directe avec la méthode `moveToAdverseBarrack()` même si elle en dépend. Cependant, on peut toujours vérifier s'il y a un update après que la méthode `moveToAdverseBarrack()` ait été utilisée.
1. Avant l'arrivé au site

2. Juste après l'arrivé au site

3. Départ du site

4. One value and after `build()`

5. Two values (2-none, 1-1, none-2)

```java
reine.coord_x = 1700
reine.coord_y = 800
gold = 100

siteId = 92;
coord_x = 500;
coord_y = 300;
owner = 1
armyTrained = 0 // valeur de 0 à 10 

siteId = 77;
coord_x = 1400;
coord_y = 500;
owner = 0
armyTrained = 0 // valeur de 0 à 10 

siteId = 81;
coord_x = 1500;
coord_y = 100;
owner = 1
armyTrained = 0 // valeur de 0 à 10 

moveOrBuild()

train()

-> "TRAIN 77"
```

```java
reine.coord_x = 1190
reine.coord_y = 700
gold = 100

siteId = 47;
coord_x = 1000;
coord_y = 100;
owner = 0
armyTrained = 5 // valeur de 0 à 10 

siteId = 46;
coord_x = 100;
coord_y = 200;
owner = 0
armyTrained = 0 // valeur de 0 à 10 

siteId = 43;
coord_x = 1200;
coord_y = 700;
owner = 1
armyTrained = 0 // valeur de 0 à 10 

moveOrBuild()

train()

-> "TRAIN 46"
```

```java
reine.coord_x = 1700
reine.coord_y = 800
gold = 100

siteId = 61;
coord_x = 1700;
coord_y = 800;
owner = 1
armyTrained = 0 // valeur de 0 à 10

siteId = 40;
coord_x = 300;
coord_y = 600;
owner = 0
armyTrained = 0 // valeur de 0 à 10

siteId = 50;
coord_x = 900;
coord_y = 300;
owner = 0
armyTrained = 0 // valeur de 0 à 10

moveOrBuild()

moveOrBuild()

train()

-> "TRAIN 61"
```

### L'ensemble de ces méthodes avec la classe `Main`

- Obtient-t-on le résultat escompté dans un tour particulier et pour des valeurs précises ?

```java
reine.coord_x = 700
reine.coord_y = 900
gold = 40
compteurKnight = 1


siteId = 2
coord_x = 600
coord_y = 100
owner = -1
armyTrained = 0
builded = false

siteId = 89
coord_x = 500
coord_y = 700
owner = 0
armyTrained = 0
builded = true

siteId = 13
coord_x = 1400
coord_y = 300
owner = -1
armyTrained = 0
builded = false

moveOrBuild()

train()

-> move()
gold = 50
compteurKnight = 1

siteId = 2
coord_x = 600
coord_y = 100
owner = -1
armyTrained = 0
builded = false

siteId = 89
coord_x = 500
coord_y = 700
owner = 0
armyTrained = 0
builded = true

siteId = 13
coord_x = 1400
coord_y = 300
owner = -1
armyTrained = 0
builded = false
```

```java
reine.coord_x = 1100
reine.coord_y = 500
gold = 70
compteurKnight = 1


siteId = 2
coord_x = 300
coord_y = 400
owner = 1
armyTrained = 0
builded = false

siteId = 89
coord_x = 500
coord_y = 700
owner = 0
armyTrained = 0
builded = true

siteId = 13
coord_x = 1400
coord_y = 300
owner = -1
armyTrained = 0
builded = false

moveOrBuild()

train()

-> moveToAdverseKnight()
gold = 70
compteurKnight = 1

siteId = 2
coord_x = 300
coord_y = 400
owner = 1
armyTrained = 0
builded = false

siteId = 89
coord_x = 500
coord_y = 700
owner = 0
armyTrained = 0
builded = true

siteId = 13
coord_x = 1400
coord_y = 300
owner = -1
armyTrained = 0
builded = false
```

- Même pour chose pour un certain nombre de tours avec des valeurs initiales au départ 
