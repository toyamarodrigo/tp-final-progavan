# TP Final Programación Avanzada

## Documento de requerimiento

Un __banco__ local pretende instalar una nueva máquina de cajero automático __(ATM)__, para permitir a los __usuarios__ (es decir, los clientes del banco) realizar __transacciones__ financieras básicas.

Cada usuario sólo puede tener una cuenta en el banco. Los usuarios del ATM deben poder:

* __ver el saldo de su cuenta__
* __retirar efectivo__ (es decir, sacar dinero de una cuenta)
* __depositar fondos__ (es decir, agregar dinero en una cuenta).

La interfaz de usuario del cajero automático contiene los siguientes componentes:

* una __pantalla__ que muestra mensajes al usuario
* un __teclado__ que recibe datos numéricos de entrada del usuario
* un __dispensador de efectivo__ que dispensa efectivo al usuario, y
* una __ranura de depósito__ que recibe sobres para depósitos del usuario.

El __dispensador de efectivo__ comienza cada día cargado con 500 billetes de $20.

---

## Objetivo

El __banco__ desea que usted desarrolle software para realizar las transacciones financieras que inicien los clientes a través del __ATM__. Posteriormente, el __banco__ integrará el software con el hardware del ATM.

__El software debe encapsular la funcionalidad de los dispositivos de hardware__ (por ejemplo: dispensador de efectivo, ranura para depósito) dentro de los componentes de software, pero no necesita estar involucrado en la manera en que estos dispositivos ejecutan su tarea.

El hardware del ATM no se ha desarrollado aún, en vez de que usted escriba un software para ejecutarse en el ATM, deberá desarrollar una primera versión del software para que se ejecute en una computadora personal.

Esta versión debe utilizar el monitor de la computadora para simular la pantalla del ATM y el teclado de la computadora para simular el teclado numérico del ATM.

Una sesión con el ATM consiste en la __autenticación de un usuario__ (es decir, proporcionar la identidad del usuario) con base en un __número de cuenta__ y un __número de identificación personal (NIP)__, seguida de la __creación__ y la __ejecución__ de transacciones financieras.

Para autenticar un usuario y realizar transacciones, el ATM debe interactuar con la base de datos de información sobre las cuentas del banco (es decir, una colección organizada de datos almacenados en una computadora). Para cada cuenta de banco, la __base de datos__ almacena un __número de cuenta__, un __NIP__ y un __saldo__ que indica la cantidad de dinero en la cuenta.

> __Nota:__ asumiremos que el banco planea construir __sólo un ATM__, por lo que no necesitamos preocuparnos para que varios ATMs puedan acceder a esta base de datos al mismo tiempo. Lo que es más, supongamos que el banco no realizará modificaciones en la información que hay en la base de datos mientras un usuario accede al ATM. Además, cualquier sistema comercial como un ATM se topa con cuestiones de seguridad con una complejidad razonable que no contemplaremos en esta instancia. No obstante, para simplificar nuestro ejemplo supondremos que el banco confía en el ATM para que acceda a la información en la base de datos y la manipule sin necesidad de medidas de seguridad considerables.

Al acercarse al ATM (suponiendo que nadie lo está utilizando), el usuario deberá
experimentar la siguiente secuencia de eventos:

    1. La pantalla muestra un mensaje de bienvenida y pide al usuario que introduzca
    un número de cuenta.

    2. El usuario introduce un número de cuenta de cinco dígitos, mediante el uso del
    teclado.

    3. En la pantalla aparece un mensaje, en el que se pide al usuario que introduzca su
    NIP (número de identificación personal) asociado con el número de cuenta
    especificado.

    4. El usuario introduce un NIP de cinco dígitos mediante el teclado numérico.

    5. Si el usuario introduce un número de cuenta válido y el NIP correcto para esa
    cuenta, la pantalla muestra el menú principal. Si el usuario introduce un número de
    cuenta inválido o un NIP incorrecto, la pantalla muestra un mensaje apropiado y
    después el ATM regresa al paso 1 para reiniciar el proceso de autenticación.

Una vez que el __ATM autentica al usuario__, el menú principal debe contener una
opción numerada para cada uno de los tres tipos de transacciones: __solicitud de saldo
(opción 1)__, __retiro (opción 2)__ y __depósito (opción 3)__. El menú principal también debe
contener una opción para que el usuario pueda __salir del sistema (opción 4)__. Después
el usuario elegirá si desea realizar una transacción (oprimiendo 1, 2 o 3) o salir del
sistema (oprimiendo 4).

Si el usuario oprime 1 para solicitar su saldo, la pantalla __mostrará el saldo__ de esa
cuenta bancaria. Para ello, el ATM deberá obtener el __saldo de la base de datos del
banco__ (que en nuestra aplicación la representaremos mediante una estructura de
datos como por ejemplo un Array).

Una vez que el sistema ejecuta una transacción en forma exitosa, debe volver a
mostrar el menú principal para que el usuario pueda realizar transacciones adicionales. Si el usuario elije salir del sistema, la pantalla debe __mostrar un mensaje
de agradecimiento__ y después el __mensaje de bienvenida__ para el siguiente usuario.
