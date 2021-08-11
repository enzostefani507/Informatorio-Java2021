#Requerimientos
- Java 11
- Mysql 8
- Maven 3.6
#Instrucciones de uso
Clonar el repo

    git clone https://github.com/enzostefani507/Informatorio-Java2021.git
Cambiarte de rama:
   
    git checkout spring
Dirigirte a la ruta indicada

    cd /Spring/comercio
Modifica de ser necesario el archivo application.properties, indicando datos de 
acceso a la base de datos y el nombre de la base de datos a utilizar, la cual debe ser creada previamente.

Dicho archivo se encuentra en la siguiente ruta: src/main/resources

Ejecutar
        
    mvn spring-boot:run
#Modelos
##Usuario
Esta clase representa a los clientes del comercio, y tiene los siguientes atributos. 
  
      - nombre 
      - apellido
      - fecha_creacion
      - direccion
      - carritos
Atributo    | Modificable
 ---- | ----- 
nomrbe          |Si|      
apellido        |Si|      
fecha_creacion  |no|     
direccion       |Si|    
carritos        |Si|
##Carrito
Esta clase se encarga de almacenar los productos y relacionarlos con un cliente en particular para
almacenar los mismos para comprarlos, solo hay un carrito activo a la vez por usuario, se desactiva luego
de realizar la compra o luego de crear uno nuevo.

        - estado
        - fecha_creacion
        - usuarios
        - productos
Atributo    | Modificable
 ---- | ----- 
estado          |Si|       
fecha_creacion  |no|     
usuarios       |Si|
carritos        |Si|      
##Producto
Esta clase representa los productos del comercio y tiene los siguientes atributos 

        - nombre
        - descripcion
        - precio_unitario
        - carritos
        - codigo_inventario
        - categoria
Atributo    | Modificable
 ---- | ----- 
nombre          |Si|       
descripcion  |si|     
precio_unitario       |Si|
carritos        |Si|      
codigo_inventario|Si|
categoria|SI|
#Endpoints
##Usuario
* GET                         `/usuario`
  Obtiene todos los usuarios
* GET                         `/usuario/{id}`
    Obtiene el usuario correpondiente al id indicado
* POST            `/usuario`
    Crea un usuario con los atributos que indicamos en body
* PUT            `/usuario/{id}`
    Puede modificar los atributos indicados (indicados en el body) al usuario con el id de la url. 
* DELETE            `/usuario/{id}`
    Borra el usuario correpondiente al id indicado 

##Producto
* GET                         `/producto`
  Obtiene todos los productos
* GET                         `/producto/{id}`
  Obtiene el producto correpondiente al id indicado
* GET                         `/producto/buscaN/?nombre={nombre}`
    Obtiene el producto con el nombre indicado en la url
* GET                         `/producto/buscaC/?categoria={nombre}`
  Obtiene los productos que se correponden a la categoria indicada
* POST            `/producto`
  Crea un producto con los atributos que indicamos en body
* PUT            `/producto/{id}`
  Puede modificar los atributos indicados (indicados en el body) al producto con el id de la url.
* DELETE            `/producto/{id}`
  Borra el usuario correpondiente al id indicado

#Carrito
* GET                         `/carrito`
  Obtiene todos los carrito
* GET                         `/carrito/{id}`
  Obtiene el usuario correpondiente al id indicado
* POST            `/carrito/nuevo/{id}`
  Crea un carrito nuevo y vacio para el usuario con el id indicado, si tenia un carrito anterior activo lo desactiva y deja activado el nuevo
* PUT            `/carrito/{id_carrito}/producto/{id_producto}`
  Añade al carrito con id {id_carrito} el producto con id {id_producto}
* PUT            `/carrito/{id_carrito}/producto/{id_producto}`
 Saca del carrito con id {id_carrito} el producto con id {id_producto}
* DELETE            `/carrito/{id}`
  Borra el carrito correpondiente al id indicado
