import random

#Adivinar 2.0 por Carlos Sánchez
def generar_pista(numero_random, numero_usuario, seleccion_pista):
    if seleccion_pista == 1:
        return "El número es menor al que acabas de adivinar: " + str(
            numero_usuario) if numero_usuario > numero_random else "El número es mayor al que acabas de adivinar: " + str(
            numero_usuario)
    elif seleccion_pista == 2:
        return "El número es par" if numero_random % 2 == 0 else "El número es impar"
    elif seleccion_pista == 3:
        return "El número es divisible por 10" if numero_random % 10 == 0 else "El número no es divisible por 10"
    elif seleccion_pista == 4:
        return "El número es mayor a 50" if numero_random > 50 else "El número es menor/igual a 50"
    elif seleccion_pista == 5:
        return "El número es un cubo perfecto" if numero_random in [1, 8, 27,
                                                                    64] else "El número no es un cubo perfecto"
    else:
        return "El número es mayor a 10" if numero_random > 10 else "El número es menor a 10"


intentos = 15
jugar_nuevamente = True

while jugar_nuevamente:
    intentos = 15
    mostrar_opciones = True
    usuario_gano = False
    numero_random = random.randint(1, 100)
    print("Adivina un número del 1 al 100")

    while intentos > 0:
        print("Te quedan", intentos, "intentos")
        user_number = int(input())

        if user_number == numero_random:
            usuario_gano = True
            break
        else:
            if intentos > 0:
                print("Número incorrecto. Elige una pista. (Escribir número para seleccionar)")

                if mostrar_opciones:
                    print("----------------------------")
                    print("Cada pista tiene un costo de 1 intento extra")
                    print("0.- NO USAR PISTAS. (Costo: 0 intentos)")
                    print("1.- El número es mayor o menor al que escribiste")
                    print("2.- El número es par o impar")
                    print("3.- El número es divisible para 10.")
                    print("4.- El número es mayor o menor a 50")
                    print("5.- El número es/no es un cubo perfecto")
                    print("OTRO.- El número es mayor/menor a 10")
                    print("----------------------------")
                    mostrar_opciones = False

                seleccion_pista = int(input())

                if seleccion_pista != 0:
                    intentos -= 1
                    print(generar_pista(numero_random, user_number, seleccion_pista))

        intentos -= 1

    if usuario_gano:
        print("Felicidades, lograste adivinar el número")
    else:
        print("Te has quedado sin intentos. El número que pensé es:", numero_random)

    print("Jugar otra vez? 1 = SI. 2 = NO")
    jugar_nuevamente = True if int(input()) == 1 else False

print("Muchas gracias por jugar")



