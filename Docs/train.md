# train

## Données

- `batimentList`

- `id`

- `gold`

- `armyType`

## Tests

1. Au moins un bâtiment allié, pas assez d'or : **TRAIN**

2. Aucun bâtiment allié : **TRAIN**

3. Au moins un bâtiment allié, or compris entre 80 et 99, armyType = K : **TRAIN id**

4. Au moins un bâtiment allié, or compris entre 80 et 99, armyType = A : **TRAIN**

5. Au moins un bâtiment allié, or supérieur à 100 : **TRAIN id** 
