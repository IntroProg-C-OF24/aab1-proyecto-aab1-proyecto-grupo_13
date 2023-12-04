import random
from datetime import date
import datetime
sesiones = random.randint(1, 7)
name = input("Coloque su nombre: ")
date = random.randint(1924, 2015)
today = datetime.date.today()
currentYear = today.year
age = currentYear - date
print("Estimado " + name + ", usted tiene: " + str(age) + " años")

output = [["Nombre", "Edad", "Sesion", "Frecuencia", "Max.Frecuencia", "Frec. Ideal", "Max. Tiempo HIIT"]]
for nSesion in range(1, sesiones + 1):
    PulseRate = random.uniform(60, 220)
    maxPulseRate = 220 - age
    idealPulseRateLow = maxPulseRate * 0.5
    idealPulseRateHigh = maxPulseRate * 0.8
    hiit = random.uniform(1, 40)

    idealPulseRange = str(idealPulseRateLow) + "-" + str(idealPulseRateHigh)

    output.append([name, str(age), str(nSesion), str(PulseRate), str(maxPulseRate), idealPulseRange, str(hiit)])

for row in output:
    print("\t".join(row))

print("Trabajazaso de MRodz ('😉' emoji wink)")
