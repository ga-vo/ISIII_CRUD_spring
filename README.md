## Andrés Felipe Cabeza Serrano - 2162106 
## Gabriel Felipe Vega Ochoa - 2170122 

# demo-spring
Application demo usando Spring boot y maven como herramienta de build

### Intrucciones

__Para compilar:__
_mvn compile_

__Para ejecutar Tests:__
_mvn test_

__Para crear artefacto de despliegue (.jar)__
_mvn package_

__Para ejecutar usando spring pluging__ _mvn spring-boot:run_ y luego acceder a [http://localhost:8090/greeting](http://localhost:8090/greeting)

__Para ejecutar usando el artefacto generado__ _java -jar target/demo-spring-0.0.1-SNAPSHOT.jar_ y luego acceder a [http://localhost:8090/greeting](http://localhost:8090/greeting)




__Create:__
_POST [http://localhost:8090/register?name=nombre](http://localhost:8090/register?name=nombre)_

__Read:__
_GET [http://localhost:8090/view/id](http://localhost:8090/view/id)_

__Read:__
_GET [http://localhost:8090/viewall](http://localhost:8090/viewall)_

__Update:__
_PATCH [http://localhost:8090/user/id?nombre=nuevo_nombre](http://localhost:8090/user/id?nombre=nuevo_nombre)_

__Delete:__
_DELETE [http://localhost:8090/delete/id](http://localhost:8090/delete/id)_