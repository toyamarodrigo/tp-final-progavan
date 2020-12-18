# Defensa TP Programación Avanzada

### Responder las siguientes preguntas a fin de justificar el desarrollo presentado.

1. __¿Cómo llegaste a la resolución del diseño de clases?__

> * Determinar el dominio del problema.
> * Elegir los objetos potenciales.
> * Validar los objetos potenciales.
>  1. Relevante al dominio del problema.
>  2. Existencia independiente.
>  3. Atributos y operaciones.
>  4. Encapsular los objetos.
>  5. Agrupar los objetos en clases (jerarquización).

2. __¿Qué pilares del paradigma de la POO incluiste en el diseño?__

> Abstracción, Encapsulación y Herencia

3. __¿Fue posible una jerarquización de clases? ¿Con qué criterio?__

> Si. Generar clases nuevas a partir de una clase existente, involucrando la generalización y la especialización.

4. __¿Mediante qué vínculos interaccionan las clases?__

> Herencia, Polimorfismo, Agragación, Asociación y Composición.
> 
> Asociación
Es cuando una clase contenedora usa los servicios de las referencias (clases contenidas).
ej: una cocina usa un horno.
>
> Composición
Es cuando un objeto está compuesto de otro objeto.
ej: un auto tiene un motor.
>
> Agregación
Es un intermedio entre ambos conceptos y para validar se utiliza la frase "tiene un/una".
ej: una cuenta tiene un titular.

5. __¿Cómo funcionan la herencia y el polimorfismo?__

> Polimorfismo: Permite implementar una operación heredada en una subclase.
>
> Herencia: Generar clases nuevas a partir de una clase existente, la herencia involucra la generalización y la especialización.

6. __¿De qué manera se aplica en el diseño de clases la abstracción?__

> Abstract: se utiliza principalmente para definir clases base, obligando a las clases derivadas a implementar los miembros marcados con abstract. Si en una clase se definen miembros marcados con abstract, la clase debe marcarse como abstract. Las clases marcadas con abstract no se pueden instanciar.

7. __¿Fue posible utilizar interfaces? Justificar la respuesta.__

> Si, en la denominación de los billetes únicamente interactúan las clases Retiro y Deposito pero no interviene la clase SolicitudSaldo.

> No, realmente no hubo necesidad, se podía resolver el ejercicio sin recurrir a una interface.

8. __¿Alguna de las clases del sistema puede implementar el patrón de diseño Singleton?__

> Si, la clase Transaccion.

9. __Cohesión y acoplamiento de clases. ¿De qué manera se aplican estos conceptos en las clases del proyecto?__
> Cohesión: En las clases DBBanco y Cliente se ve reflejada en los métodos depositar y retirar.
>
> Acoplamiento: Se ve reflejado en las variables de las clases ya que estas son necesarias para realizar otras acciones.
>
> Podríamos definir la cohesión como lo estrecha que es la relación entre los componentes de algo. Si hablamos de clases, una clase tendrá una cohesión alta si sus métodos están relacionados entre sí, tienen una “temática” común, trabajan con tipos similares, etc. Si pasamos a componentes de mayor tamaño, como paquetes o librerías, tendríamos una cohesión alta cuando las clases que lo forman están muy relacionadas entre sí, con un objetivo claro y focalizado.
El acoplamiento es la manera que se relacionan varios componentes entre ellos. Si existen muchas relaciones entre los componentes, con muchas dependencias entre ellos, tendremos un grado de acoplamiento alto. Si los componentes son independientes unos de otros, el acoplamiento será bajo. Al igual que con la cohesión, podemos ver el acoplamiento a distintos niveles y existe acoplamiento entre los métodos de una misma clase (o las funciones de un módulo), entre distintas clases o entre distintos paquetes. Además, existen varios tipos de acoplamiento, desde acoplamiento a través de datos comunes, acoplamiento temporal (es necesario utilizar los componentes en un orden concreto), etc.

10. __¿Cómo explicarías la siguiente afirmación en el desarrollo presentado?__
> “Cada objeto de una subclase es también un objeto de la superclase de esa clase.“

