# updateBuilded

## Description

La méthode `updateBuilded` permet de mettre à jour le statut (attribut) `recentlyBuilded` d'un bâtiment en `false`. Le besoin d'une telle méthode réside dans le fait de prendre en compte l'état d'un bâtiment (récemment builded ou non) pour éviter de et `Build` le bâtiment et `Train` une armée du bâtiment dans le même tour du jeu.

## Syntaxe

```java
public void updateBuilded(List<Batiment> batiments){
    //
}
```

## Données

- `recentlyBuilded : boolean`

- `batiments : List<Batiment>`

- `owner`

## Tests

1. Un bâtiment allié dans la liste qui a été tout juste bâti 

```java
id = 1
coord_x = 100
coord_y = 200
owner = -1
recentlyBuilded = false


id = 2
coord_x = 300
coord_y = 400
owner = 0
recentlyBuilded = true

id = 3
coord_x = 500
coord_y = 600
owner = 1
recentlyBuilded = false

-> 
batiments[0].recentlyBuilded = false
batiments[1].recentlyBuilded = false
batiments[2].recentlyBuilded = false
```

2. Aucun bâtiment n'a été récemment bâti

```java
id = 1
coord_x = 100
coord_y = 200
owner = -1
recentlyBuilded = false


id = 2
coord_x = 300
coord_y = 400
owner = 0
recentlyBuilded = false

id = 3
coord_x = 500
coord_y = 600
owner = 1
recentlyBuilded = false

-> 
batiments[0].recentlyBuilded = false
batiments[1].recentlyBuilded = false
batiments[2].recentlyBuilded = false
```

3. Un bâtiment ennemi dans la liste avec le statut récemment bâti

```java
id = 1
coord_x = 100
coord_y = 200
owner = -1
recentlyBuilded = false


id = 2
coord_x = 300
coord_y = 400
owner = 0
recentlyBuilded = false

id = 3
coord_x = 500
coord_y = 600
owner = 1
recentlyBuilded = true

->  
batiments[0].recentlyBuilded = false
batiments[1].recentlyBuilded = false
batiments[2].recentlyBuilded = true
```
