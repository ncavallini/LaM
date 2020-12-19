#RSA
import random
import math
# Inizializzazione variabili
p = 0
q = 0
n = 0
phi = 0
e = 0
d = 0
candidates = []

def genNum():
    p = random.randint(2, 2**32)
    q = random.randint(2, 2**32)
    candidates.append(p)
    candidates.append(q)
    return candidates

def isPrime(n):
    if (n == 1):
        return False
    for i in range(2, int((n**0.5 + 1))):
       if(n % i == 0):
           return False
    else:
            return True

#1. Scelta (casuale) di p e q.

print("Attendere mentre vengono generati i numeri p e q...\n")
genNum()
while(isPrime(candidates[0]) == False or isPrime(candidates[1]) == False or candidates[0] == candidates[1]):
    candidates = []
    genNum()
print("I numeri p, q sono: " + str(candidates))

#2. Calcolo di n = pq
p = candidates[0]
q = candidates[1]
n = p*q

#3. Calcolo di phi(n) = (p-1)(q-1)
phi = (p-1)*(q-1)
print("phi(n) = " + str(phi))

#4 Scelta di e
#e è compreso tra 3 e 2^16 -1, così da contenere il tempo di esecuzione.
while(math.gcd(e,phi)!=1):
    e = random.randint(3,2**16-1)    
print("e = " + str(e))


#5. Cifratura
m = input("\nInserire il messaggio in chiaro da cifrare.\n")
#m = m.upper() # Uso solo lettere maiuscole per semplicità
caratteri_m = []

for i in range(0, len(m)):
  caratteri_m.append(m[i])

M = [] #Contiene i codici ASCII del corrispettivo carattere di m
for i in range(0, len(m)):
  M.append(ord(m[i]))

C = [] #Contiene i codici ASCII del corrispettivo carattere criptato di m
def cifratura():
  for i in range(0, len(m)):
    c = (M[i]**e) % n
    C.append(c)
 
cifratura()

print("\n\n Il messaggio cifrato è: ")
print(C)


