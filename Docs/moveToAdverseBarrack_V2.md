# moveToAdverseBarrack_V2

## Description

Méthode pour déplacer la reine dans la direction du bâtiment ennemi.

## Données

- `reine`

- `batimentList`

- `reine.coord_x`

- `reine.coord_y`

- `batiment.coord_x`

- `batiment.coord_y`

## Syntaxe

```java
public void moveToAdverseBarrack(List<Batiment> batimentList){
    // ...
    System.out.println("MOVE " + coord_x + " " + coord_y);
}
```

## Tests

1. Le bâtiment ennemi le plus proche et la reine ont la même coordonnée x.
   
   - Le bâtiment a une coordonnée 'y' plus grande que la coordonnée 'y' de la reine.
   
   - Le bâtiment a une coordonnée 'y' plus petite que la coordonnée 'y' de la reine.
   
   - 

2. Le bâtiment ennemi le plus proche et la reine ont la même coordonnée y.
   
   - Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine.
   
   - Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'y' de la reine.

3. Le bâtiment ennemi le plus proche et la reine ont différentes coordonnées x et y.
   
   - Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus grandes que ceux de la reine.
   
   - Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus petites que ceux de la reine.
   
   - Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine, et une coordonnée 'y' plus petite que la coordonnée 'y' de la reine.
   
   - Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'y' de la reine, et une coordonnée 'y' plus grande que la coordonnée 'y' de la reine.

## data

```java
reine.coord_x = 100
reine.coord_y = 200

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 0

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 1

-> reine.coord_x = 100
reine.coord_y = 260
```

```java
reine.coord_x = 200
reine.coord_y = 400

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = -1

batiment.coord_x = 200
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 1350
batiment.coord_y = 800
batiment.owner = 1

-> reine.coord_x = 200
reine.coord_y = 340
```

```java
reine.coord_x = 500
reine.coord_y = 700

batiment.coord_x = 550
batiment.coord_y = 700
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 1

batiment.coord_x = 1800
batiment.coord_y = 100
batiment.owner = 1

-> reine.coord_x = 560
reine.coord_y = 700
```

```java
reine.coord_x = 1800
reine.coord_y = 900

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 1780
batiment.coord_y = 900
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = -1

-> reine.coord_x = 1740
reine.coord_y = 900
```

```java
reine.coord_x = 500
reine.coord_y = 200

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 0

batiment.coord_x = 600
batiment.coord_y = 400
batiment.owner = 1

-> reine.coord_x = 560
reine.coord_y = 260
```

```java
reine.coord_x = 1000
reine.coord_y = 300

batiment.coord_x = 800
batiment.coord_y = 100
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 0

-> reine.coord_x = 940
reine.coord_y = 240
```

```java
reine.coord_x = 1700
reine.coord_y = 560

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 1800
batiment.coord_y = 400
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 1

-> reine.coord_x = 1760
reine.coord_y = 500
```

```java
reine.coord_x = 800
reine.coord_y = 200

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 0

batiment.coord_x = 600
batiment.coord_y = 300
batiment.owner = 1

-> reine.coord_x = 740
reine.coord_y = 260
```
