## Empleado
Tiene
 - nombre
 - apellido
 - sueldo
 - fecha_nacimietno
Cada atributo es privado, se los puede acceder y modificar por setter y getter, dispone además de un constructor.

Dispone de su propio toString y calculo de edad.

## Folder Structure
- `src`: Contiene las clases utilizada
- `data`: Contiene los empleados de ejemlo

## Considerar
Como varios usuarios podrian tener los mismos valoers respecto lo solicitado se hicieron metodo para calcular el maximo, y minimo valor respecto de sueldo y edad -que podrian ser de utilidad para otros metodos-, se los utilizo para listar todos los empleados con el mismo sueldo minimo-maximo y empleados con la misma edad minima-maxima.