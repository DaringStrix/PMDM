package com.example.projectalphajet

private fun calcular(valor1: Double, valor2: Double) : Double {
    when {
        txCuenta.value.indexOf("+") > 0 -> {
            valor = txCuenta.value.split("+") as MutableList<String>
            txResultado.value = (valor[0].toDouble() + valor[1].toDouble()).toString()
        }
        txCuenta.value.indexOf("-") > 0 -> {
            valor = txCuenta.value.split("-") as MutableList<String>
            txResultado.value = (valor[0].toDouble() - valor[1].toDouble()).toString()
        }
        txCuenta.value.indexOf("×") > 0 -> {
            valor = txCuenta.value.split("×") as MutableList<String>
            txResultado.value = (valor[0].toDouble() * valor[1].toDouble()).toString()
        }
        txCuenta.value.indexOf("÷") > 0 -> {
            valor = txCuenta.value.split("÷") as MutableList<String>
            txResultado.value = (valor[0].toDouble() / valor[1].toDouble()).toString()
        }
    }
}

private fun borrar(opcion: String) {
    if (opcion == "C") {
        txCuenta.value = ""
        txVerCuenta.value = ""
    } else if (opcion == "CE") {
        txCuenta.value = ""
        txVerCuenta.value = ""
        txResultado.value = ""
        txVerResultado.value = "[    ]"
    }
}

fun onClick(texto: String) {
    when {
        texto == "=" -> {
            calcular()
            txVerResultado.value = txResultado.value
        }
        txResultado.value != "" -> {
            when (texto) {
                Signos.ADD.signo -> {
                    txCuenta.value = txResultado.value + texto
                    txVerCuenta.value = txVerResultado.value + "+"
                    txResultado.value = ""
                    txVerResultado.value = "[    ]"
                }
                Signos.SUBSTRACT.signo -> {
                    txCuenta.value = txResultado.value + "-"
                    txVerCuenta.value = txVerResultado.value + "-"
                    txResultado.value = ""
                    txVerResultado.value = "[    ]"
                }
                Signos.MULTIPLY.signo -> {
                    txCuenta.value = txResultado.value + "×"
                    txVerCuenta.value = txVerResultado.value + "×"
                    txResultado.value = ""
                    txVerResultado.value = "[    ]"
                }
                Signos.DIVIDE.signo -> {
                    txCuenta.value = txResultado.value + "÷"
                    txVerCuenta.value = txVerResultado.value + "÷"
                    txResultado.value = ""
                    txVerResultado.value = "[    ]"
                }
                "C", "CE" -> {
                    borrar(texto)
                }
            }

        }
        texto == "C" || texto == "CE" -> {
            borrar(texto)

        }
        txVerCuenta.value == "0" -> {
            txVerCuenta.value = ""
            txVerCuenta.value += texto
            txCuenta.value += texto
        }
        else -> {
            txVerCuenta.value += texto
            txCuenta.value += texto
        }
    }

}
