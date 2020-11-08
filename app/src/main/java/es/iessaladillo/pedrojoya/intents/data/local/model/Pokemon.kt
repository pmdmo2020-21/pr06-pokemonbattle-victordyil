package es.iessaladillo.pedrojoya.intents.data.local.model

import kotlin.random.Random

// TODO: Define las propiedades de un pokemon
class Pokemon(
    var id:Long, var nombre: String, var tipo: Tipos, var fotoId: Any,
) {

    enum class Tipos {
        AGUA,
        FUEGO,
        ROCA,
        PLANTA,
        HIELO,
        DRAGON,
        NORMAL;

        fun ganador(tipoAtaque: Tipos, tipoDefensa: Tipos): Int {
            val rnd = Random(System.currentTimeMillis() / 1000)

            // 1 gana el atacante 2 el defensor
            return when (tipoAtaque) {
                AGUA -> {
                    when (tipoDefensa) {
                        AGUA -> rnd.nextInt(2) + 1
                        FUEGO -> 1
                        ROCA -> 1
                        PLANTA -> 2
                        HIELO -> rnd.nextInt(2) + 1
                        DRAGON -> rnd.nextInt(2) + 1
                        NORMAL -> rnd.nextInt(2) + 1
                    }
                }
                FUEGO -> {
                    when (tipoDefensa) {
                        AGUA -> 2
                        FUEGO -> rnd.nextInt(2) + 1
                        ROCA -> 1
                        PLANTA -> 1
                        HIELO -> 1
                        DRAGON -> 2
                        NORMAL -> rnd.nextInt(2) + 1
                    }
                }
                ROCA -> {
                    when (tipoDefensa) {
                        AGUA -> 2
                        FUEGO -> rnd.nextInt(2) + 1
                        ROCA -> 1
                        PLANTA -> 1
                        HIELO -> 1
                        DRAGON -> 2
                        NORMAL -> rnd.nextInt(2) + 1
                    }
                }
                PLANTA -> {
                    when (tipoDefensa) {
                        AGUA -> 2
                        FUEGO -> rnd.nextInt(2) + 1
                        ROCA -> 1
                        PLANTA -> 1
                        HIELO -> 1
                        DRAGON -> 2
                        NORMAL -> rnd.nextInt(2) + 1
                    }
                }
                HIELO -> {
                    when (tipoDefensa) {
                        AGUA -> 2
                        FUEGO -> rnd.nextInt(2) + 1
                        ROCA -> 1
                        PLANTA -> 1
                        HIELO -> 1
                        DRAGON -> 2
                        NORMAL -> rnd.nextInt(2) + 1
                    }
                }
                DRAGON -> {
                    when (tipoDefensa) {
                        AGUA -> 2
                        FUEGO -> rnd.nextInt(2) + 1
                        ROCA -> 1
                        PLANTA -> 1
                        HIELO -> 1
                        DRAGON -> 2
                        NORMAL -> rnd.nextInt(2) + 1
                    }
                }
                NORMAL -> {
                    when (tipoDefensa) {
                        AGUA -> 2
                        FUEGO -> rnd.nextInt(2) + 1
                        ROCA -> 1
                        PLANTA -> 1
                        HIELO -> 1
                        DRAGON -> 2
                        NORMAL -> rnd.nextInt(2) + 1
                    }
                }
            }
        }
    }
}