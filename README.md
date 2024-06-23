# ObligatorioP2
Franco Buenahora, Santiago Coll, Lorenzo Martínez

### Creamos este repositorio ya que habiamos seguido trabajando en el mismo repositorio que usamos para la primera entrega, por lo cual tuvimos que hacer un rollback a ese repositorio y crear este nuevo repositorio como version final, por eso los commits a ultimo momento y solo por un integrante del grupo.

## IMPORTANTE 
Para que el programa funciones es necesario poner el CSV en la carpeta src. También verificar que no se haya abierto el csv con excel. Por alguna razon hacer esto cambia la estructura del CSV y pasa las separaciones pasa de ser "nombre","fecha" a ser "nombre,""fecha".

## Carga de los datos
Para cargar los datos, recorremos el archivo CSV y, por cada fila, creamos un objeto "canción". Este objeto se inserta en una estructura hash. Esta estructura hash contiene otro hash que a su vez contiene una lista. El primer hash utiliza la fecha como clave el segundo utiliza el código de país como clave y guarda una lista de canciones, la cual, debido a la estructura del CSV, ya viene ordenada por top diario.

## Tiempo promedio de las consutas:

La consulta 1 se demora 0.3579 Milisegundos

La consulta 2 se demora 26 Milisegundos 

La consulta 3 se demora 1,3 segundos  (tomando la fecha inicial como la primera y la final como la ultima)

La consulta 4 se demora 3.7332 Milisegundos

La consulta 5 se demora 600 Milisegundos (tomando la fecha inicial como la primera y la final como la ultima)   



## Uso De Memoria

![image](https://github.com/buenahora/ObligatorioP2Final/assets/134079918/db5d33e2-3ddf-46b1-a697-54532120b128)
