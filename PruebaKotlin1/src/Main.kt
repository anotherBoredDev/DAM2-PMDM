fun main() {
    ejercicio01()
    ejercicio02()
    ejercicio03()
    ejercicio04()
    ejercicio05()
    ejercicio06()
    ejercicio07()
    ejercicio08()
    ejercicio09()
    ejercicio10()
    ejercicio11()
}

fun ejercicio01() {
    val num1 = 60;
    val num2 = 7;

    println(num1 + num2)
    println(num1 - num2)
    println(num1 * num2)
    println(num1 / num2)
    println(num1 % num2)
}

fun ejercicio02() {
    val nombre = "Alejandro"
    println("Bienvenido, $nombre")
}

fun ejercicio03() {
    print("Introduce tu nombre: ")
    val nombre = readln()
    println("Bienvenido, $nombre")
}

fun ejercicio04() {
    print("Introduce un numero: ")
    val num1 = readln().toInt();
    print("Introduce otro numero: ")
    val num2 = readln().toInt();

    if (num1 > num2) {
        println("$num1 es mayor que $num2")
    } else if (num1 < num2) {
        println("$num1 es menor que $num2")
    } else {
        println("$num1 y $num2 son iguales")
    }
}

fun ejercicio05() {
    print("Introduce un numero: ")
    val numero = readln().toInt()
    if (numero % 2 == 0) {
        println("$numero es divisible entre dos")
    } else {
        println("$numero no es divisible entre dos")
    }
}

fun ejercicio06() {
    println(
        """
        ¿Cuál es la capital de Colombia?:
        a. La Paz
        b. Buenos Aires
        c. La Habana
        d. Bogotá
    """.trimIndent()
    )

    do {
        println("Respuesta: ")
        val respuesta = readln().lowercase()

        when (respuesta) {
            "a", "b", "c" -> println("Respuesta incorrecta :c")
            "d" -> println("¡Respuesta correcta!")
            else -> println("Respuesta invalida")
        }
    } while (respuesta != "d")
}

fun ejercicio07() {
    for (i in 1..100) {
        println(i)
    }
}

fun ejercicio08() {
    var i = 1
    do {
        println(i++)
    } while (i <= 100)

}

fun ejercicio09() {
    for (i in 1..100) {
        if (i % 2 == 0 && i % 3 == 0) {
            println(i)
        }
    }
}

fun ejercicio10() {
    println("Introduce un numero mayor o igual a 0: ")
    var numero = readln().toInt()

    while (numero < 0) {
        numero = readln().toInt()
    }

    println(numero)
}

fun ejercicio11() {
    print("Introduce una contraseña: ")
    val password = readln()
    var intentos = 3
    do {
        intentos--
        print("Intenta adivinarla: ")
        val adivinacion = readln()
        if (adivinacion == password) {
            println("Enhorabuena, acertaste")
        } else {
            println("Has fallado. Te quedan $intentos intentos")
        }
    } while (!password.equals(adivinacion) && intentos > 0)
}

fun ejercicio12() {
    print("Introduce un més (del 1 al 12): ")
    val mes = readln().toInt()
    val meses = arrayOf(
        "enero",
        "febrero",
        "marzo",
        "abril",
        "mayo",
        "junio",
        "julio",
        "agosto",
        "septiembre",
        "octubre",
        "noviembre",
        "diciembre"
    )
    when (mes) {
        1, 3, 5, 7, 8, 10, 12 -> println("El mes de ${meses[mes]} tiene 31 días")
        4, 6, 9, 11 -> println("El mes de ${meses[mes]} tiene 30 días")
        2 -> println("El mes de ${meses[mes]} tiene 28/29 días")
    }
}