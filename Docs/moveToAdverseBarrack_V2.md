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

2. Le bâtiment ennemi le plus proche et la reine ont la même coordonnée y.
   
   - Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine.
   
   - Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'x' de la reine.

3. Le bâtiment ennemi le plus proche et la reine ont différentes coordonnées x et y.
   
   - Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus grandes que ceux de la reine :
     
     - `batiment.coord_x - reine.coord_x > 60 AND batiment.coord_y - reine.coord_y > 60`
     
     - `batiment.coord_x - reine.coord_x < 60 AND batiment.coord_y - reine.coord_y > 60`
     
     - `batiment.coord_x - reine.coord_x > 60 AND batiment.coord_y - reine.coord_y < 60`
     
     - `batiment.coord_x - reine.coord_x < 60 AND batiment.coord_y - reine.coord_y < 60`
   
   - Le bâtiment a une coordonnée 'x' et une coordonnée 'y' plus petites que ceux de la reine.
     
     - `reine.coord_x - batiment.coord_x > 60 AND reine.coord_y - batiment.coord_y > 60`
     
     - `reine.coord_x - batiment.coord_x < 60 AND reine.coord_y - batiment.coord_y > 60`
     
     - `reine.coord_x - batiment.coord_x > 60 AND reine.coord_y - batiment.coord_y < 60`
     
     - `reine.coord_x - batiment.coord_x < 60 AND reine.coord_y - batiment.coord_y < 60`
   
   - Le bâtiment a une coordonnée 'x' plus grande que la coordonnée 'x' de la reine, et une coordonnée 'y' plus petite que la coordonnée 'y' de la reine.
     
     - `batiment.coord_x - reine.coord_x > 60 AND reine.coord_y - batiment.coord_y > 60`
     
     - `batiment.coord_x - reine.coord_x < 60 AND reine.coord_y - batiment.coord_y > 60`
     
     - `batiment.coord_x - reine.coord_x > 60 AND reine.coord_y - batiment.coord_y < 60`
     
     - `batiment.coord_x - reine.coord_x < 60 AND reine.coord_y - batiment.coord_y < 60`
   
   - Le bâtiment a une coordonnée 'x' plus petite que la coordonnée 'y' de la reine, et une coordonnée 'y' plus grande que la coordonnée 'y' de la reine.
     
     - `reine.coord_x - batiment.coord_x > 60 AND batiment.coord_y - reine.coord_y > 60`
     
     - `reine.coord_x - batiment.coord_x < 60 AND batiment.coord_y - reine.coord_y > 60`
     
     - `reine.coord_x - batiment.coord_x > 60 AND batiment.coord_y - reine.coord_y < 60`
     
     - `reine.coord_x - batiment.coord_x < 60 AND batiment.coord_y - reine.coord_y < 60`

## data

#### 1.

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

---

#### 2.

```java
reine.coord_x = 500
reine.coord_y = 700


batiment.coord_x = 600
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

batiment.coord_x = 1700
batiment.coord_y = 900
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = -1

-> reine.coord_x = 1740
reine.coord_y = 900
```

---

3. A

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
reine.coord_x = 580
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

-> reine.coord_x = 600
reine.coord_y = 260
```

```java
reine.coord_x = 500
reine.coord_y = 370

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
reine.coord_y = 400
```

```java
reine.coord_x = 590
reine.coord_y = 399

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 0

batiment.coord_x = 600
batiment.coord_y = 400
batiment.owner = 1

-> reine.coord_x = 600
reine.coord_y = 400
```

---

3. B

```java
reine.coord_x = 700
reine.coord_y = 30

batiment.coord_x = 800
batiment.coord_y = 100
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 0

-> reine.coord_x = 760
reine.coord_y = 90
```

```java
reine.coord_x = 1780
reine.coord_y = 300

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 1800
batiment.coord_y = 400
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 1

-> reine.coord_x = 1800
reine.coord_y = 360
```

```java
reine.coord_x = 500
reine.coord_y = 260

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 0

batiment.coord_x = 600
batiment.coord_y = 300
batiment.owner = 1

-> reine.coord_x = 560
reine.coord_y = 300
```

```java
reine.coord_x = 790
reine.coord_y = 60

batiment.coord_x = 800
batiment.coord_y = 100
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 0

-> reine.coord_x = 800
reine.coord_y = 100
```

---

3. C

```java
reine.coord_x = 1900
reine.coord_y = 300

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 1800
batiment.coord_y = 400
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 1

-> reine.coord_x = 1840
reine.coord_y = 360
```

```java
reine.coord_x = 620
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

-> reine.coord_x = 600
reine.coord_y = 260
```

```java
reine.coord_x = 1000
reine.coord_y = 60

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
reine.coord_y = 100
```

```java
reine.coord_x = 1810
reine.coord_y = 350

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 1800
batiment.coord_y = 400
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 1

-> reine.coord_x = 1800
reine.coord_y = 400
```

---

3. D

```java
reine.coord_x = 500
reine.coord_y = 400

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 0

batiment.coord_x = 600
batiment.coord_y = 300
batiment.owner = 1

-> reine.coord_x = 560
reine.coord_y = 340
```

```java
reine.coord_x = 780
reine.coord_y = 200

batiment.coord_x = 800
batiment.coord_y = 100
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 1

batiment.coord_x = 1050
batiment.coord_y = 600
batiment.owner = 0

-> reine.coord_x = 800
reine.coord_y = 140
```

```java
reine.coord_x = 1700
reine.coord_y = 420

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
reine.coord_y = 400
```

```java
reine.coord_x = 570
reine.coord_y = 330

batiment.coord_x = 100
batiment.coord_y = 300
batiment.owner = 1

batiment.coord_x = 900
batiment.coord_y = 700
batiment.owner = 0

batiment.coord_x = 600
batiment.coord_y = 300
batiment.owner = 1

-> reine.coord_x = 600
reine.coord_y = 300
```
