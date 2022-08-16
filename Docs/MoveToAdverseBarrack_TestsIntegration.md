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

```java
reine.coord_x = 480
reine.coord_y = 910

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

```

```

### Avec la méthode `train()`

- Quelle prioriter donner aux bâtiments adverses qui sont devenus nôtres par rapport aux autres bâtiments qu'on a `build()`?

### Avec la méthode `barracks()`

- La configuration pour l'entraînements des unités est-elle toujours respectée ?

### L'ensemble de ces méthodes avec la classe `Main`

- Obtient-t-on le résultat escompté dans un tour particulier et pour des valeurs précises ?

- Pour un certain nombre de tours avec des valeurs initiales au départ 
