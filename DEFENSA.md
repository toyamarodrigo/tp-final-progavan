# Defensa TP Programación Avanzada

### Responder las siguientes preguntas a fin de justificar el desarrollo presentado.

1. __¿Cómo llegaste a la resolución del diseño de clases?__

> __a. Determinar el dominio del problema.__
>
> El banco necesita que desarrollemos un software para realizar transacciones financieras a través de un Cajero (ATM) con algunos requisitos específicos.
>
> * Desarrollar una primera versión del software para que se pueda ejecutar en una PC y que esta versión utilice el monitor para simular la pantalla del cajero y teclado de la PC para simular el teclado del cajero.
> * Crear una sesión por usuario (autentificación) con número de cuenta y PIN.
> * Crear transacciones financieras (retiro, solicitud, depósito)
> * Una Base de datos del Banco, que contenga información de las cuentas (números de cuenta, PIN, saldos)
 
> __b. Elegir los objetos potenciales.__
> 
> * Cajero(ATM), Base de Datos Banco, Cuenta, Transacción, Teclado, Pantalla, Dispensador de efectivo, Ranura de depósito (sobres), Retiro Solicitud y Depósito de saldo.

> __c. Validar los objetos potenciales.__
> 
> * Relevante al dominio del problema.
>   * ATM, BDBanco, Cuenta, Transaccion, DispensadorEfectivo, RanuraDeposito, Retiro, SolicitudSaldo, Deposito.
>
> * Existencia independiente.
>   * TestATM. Teclado, Pantalla.
> 
> * Atributos y operaciones.
> 
>   * ATM
>       * Atributos encapsulados
>           * boolean usuarioAutenticado
>           * int usuarioActual
>           * BDBanco
>           * Teclado
>           * Pantalla
>           * RanuraDeposito
>           * DispensadorEfectivo
>       * Operaciones
>           * iniciar()
>           * mostarMenu()
>           * autenticarUsuario()
>   * BDBanco
>       * Atributos encapsulados
>   * ArrayList<Cuenta>
>       * Operaciones:
>           * autenticarUsuario()
>           * getCuenta()
>           * getSaldoDisponible()
>           * getTotalBalance()
>           * depositar()
>           * retirar()
>   * Cuenta
>       * Atributos encapsulados
>           * int numCuenta, pin
>           * double saldoDisponible, totalBalance
>       * Operaciones
>           * validarPIN(usuarioPIN : int)
>           * getNumCuenta()
>           * getSaldoDisponible()
>           * getTotalBalance()
>           * depositar(monto : double)
>           * retirar(monto : double)
>   * Transaccion
>       * Atributos encapsulados
>           * double montoSaldo, montoBalance
>           * int numCuenta
>           * Pantalla
>           * BDBanco
>       * Operaciones
>           * getNumCuenta()
>           * getPantalla()
>           * getBDBanco()
>           * abstract iniciar()
>   * Deposito
>       * Atributos encapsulados
>           * double montoIngresado
>           * RanuraDeposito
>           * Teclado
>       * Operaciones
>           * iniciar()
>   * Retiro
>       * Atributos encapsulados
>           * int montoIngresado
>           * DispensadorEfectivo
>   * Teclado
>       * Operaciones
>           * iniciar()
>   * SolicitudSaldo
>       * Operaciones
>           * iniciar()
>   * DispensadorEfectivo
>       * Atributos encapsulados
>           * int count
>       * Operaciones
>           * dispensarEfectivo(cantidad: int)
>           * efectivoDisponible(cantidad: int)
>   * RanuraDeposito
>       * Operaciones
>           * recibeSobres()
>   * Pantalla
>       * Operaciones
>           * mostrarMensaje(mensaje : String)
>   * Teclado
>       * Atributos encapsulados
>           * Scanner
>       * Operaciones
>           * getEntrada()

> d. Agrupar los objetos en clases (jerarquización).
> * BDBanco
>   * Cuenta
>   * ATM
>       * RanuraDeposito
>   * Transaccion
>       * Deposito
>       * SolicitudSaldo
>       * Retiro
>           * DispensadorEfectivo
> * Teclado
> * Pantalla


2. __¿Qué pilares del paradigma de la POO incluiste en el diseño?__

> En este trabajo pudimos aplicar Abstracción, Encapsulación, Herencia y Polimorfismo.

3. __¿Fue posible una jerarquización de clases? ¿Con qué criterio?__

> Fue necesario realizar la jerarquización en la clase Transaccion, ya que esta clase es una generalización de las clases Depósito, Retiro y Solicitud Saldo(especializaciones de la clase Transaccion). Sabemos que estas clases tienen como atributo en común el “número de cuenta” y una operación “iniciar” por lo tanto podemos hacer una factorización de estos y colocarlos en la superclase Transacción donde estas 3 subclases heredaran este atributo y operación que luego el Cajero podría usar por medio de polimorfismo a la versión sobreescrita de ese método “iniciar” en cada subclase.

4. __¿Mediante qué vínculos interaccionan las clases?__

> Las clases interaccionan mediante agregación, composición y asociación.

5. __¿Cómo funcionan la herencia y el polimorfismo?__

> Polimorfismo: Permite implementar una operación heredada en una subclase.
> Para tener un comportamiento polimórfico necesitamos
> * métodos declarados o implementados en la clase base.
> * métodos redefinidos en las clases derivadas.
> * objetos manipulados utilizando referencias a la clase base.

> Herencia: Extender una funcionalidad existente definiendo una nueva clase que hereda funcionalidad de una clase existente que involucra la generalización y la especialización.


6. __¿De qué manera se aplica en el diseño de clases la abstracción?__

> Abstract: se utiliza principalmente para definir clases base, obligando a las clases derivadas a implementar los miembros marcados con abstract. Si en una clase definen miembros marcados con abstract, la clase debe marcarse como abstract no se pueden instanciar.
> 
> En este caso creamos una clase abstracta Transaccion, a partir de la cual puedan heredar otras clases y, por ende, compartir un diseño común.


7. __¿Fue posible utilizar interfaces? Justificar la respuesta.__

> En nuestro caso no. Realmente no había necesidad y se podía resolver el ejercicio sin recurrir a una interfaz. Preferimos hacer uso de una clase abstracta en “Transacción” para definir una jerarquía de clases.
> 
> Una Interfaz en si no pertenece a una jerarquía de clases y se podría implementar en clases super diferentes semánticamente.


8. __¿Cómo explicarías la siguiente afirmación en el desarrollo presentado?__
“Cada objeto de una subclase es también un objeto de la superclase de esa clase.“

> Esto se puede explicar mediante la Generalización y
> Especialización.La generalización es la propiedad que permite compartir
> información entre dos entidades evitando la redundancia.

> En el comportamiento de objetos existen con frecuencia propiedades
> que son comunes en diferentes objetos y esta propiedad se denomina
> generalización.

> El proceso inverso de la generalización por el cual se definen
> nuevas clases a partir de otras ya existentes se denomina
> especialización.

> La herencia permite definir nuevas clases a partir de otras clases
> ya existentes, de modo que presentan las mismas características y
> comportamiento de estas, así como otras adicionales.